package com.example.pradeshadvkotlin.ui.order.detailsorders

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.transaction.Data
import com.example.pradeshadvkotlin.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.fragment_orders_detail.*

class OrdersDetailFragment : Fragment(), OrdersDetailContract.View {

    var progressDialog: Dialog? = null
    lateinit var presenter : OrdersDetailPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as OrdersDetailActivity).toolbarPayment()


//    arguments?.let {
//         OrdersDetailFragmentArgs.fromBundle(it).data.let {
//            initView(it)
//        }
//   }

        var datas = requireActivity().intent.getParcelableExtra<Data>("data")
        initView(datas)
//       initView()
        presenter = OrdersDetailPresenter(this)

    }

    private fun initView(data: Data?) {

        tvTitle.text = data?.produk?.name
        tvPrice.formatPrice(data?.produk?.price.toString())
        Glide.with(requireContext())
            .load(data?.produk?.picturePath)
            .into(ivPoster)

        tvNameItem.text = data?.produk?.name
        tvHarga.formatPrice(data?.produk?.price.toString())

        if (!data?.produk?.price.toString().isNullOrEmpty()) {
            var totalTax = data?.produk?.price?.div(10)
            tvTax.formatPrice(totalTax.toString())

            var total = data?.produk?.price!! + totalTax!! + 15000
            tvTotal.formatPrice(total.toString())
        } else {
            tvPrice.text = "IDR. 0"
            tvTax.text = "IDR. 0"
            tvTotal.text = "IDR. 0"
        }

        tvNama.text = data?.user?.name
        tvPhone.text = data?.user?.phoneNumber
        tvAddress.text = data?.user?.address
        tvHouseNo.text = data?.user?.houseNumber
        tvCity.text = data?.user?.city

        tvOrderStatus.text = data?.id.toString()

        if (data?.status.equals("ON_DELIVERY", true)) {
            btnCancelled.visibility = View.VISIBLE
            constraintLayout3.visibility = View.VISIBLE
            tvPending.text = "Paid"
        } else if (data?.status.equals("SUCCESS", true)) {
            btnCancelled.visibility = View.INVISIBLE
            constraintLayout3.visibility = View.VISIBLE
            tvPending.text = "Paid"
        } else if (data?.status.equals("PENDING", true)) {
            btnCancelled.visibility = View.VISIBLE
            btnCancelled.text = "Pay Now"
            constraintLayout3.visibility = View.VISIBLE
            tvPending.text = "Pending"
        }
        btnCancelled.setOnClickListener {
            if (btnCancelled.text.equals("Pay Now")) {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(data?.paymentUrl)
                startActivity(i)
            } else {
                presenter.getUpdateTransaction(data?.id.toString(), "CANCELLED")
            }
        }
    }

    override fun onUpdateTransactionSuccess(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        requireActivity().finish()
    }

    override fun onUpdateTransactionFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}