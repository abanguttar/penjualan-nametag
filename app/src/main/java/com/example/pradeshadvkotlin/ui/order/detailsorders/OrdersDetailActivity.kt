package com.example.pradeshadvkotlin.ui.order.detailsorders

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.navigation.Navigation
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.databinding.ActivityDetailOrdersBinding
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrdersDetailActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityDetailOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_detail_orders)
//   binding = ActivityDetailOrdersBinding.inflate(layoutInflater)
  //      val view = binding.root
   //     setContentView(view)

        intent.extras?.let {
            val navController = Navigation.findNavController(findViewById(R.id.detailOrdersHostFragment))
            val bundle = Bundle()
            bundle.putParcelable("data", it.get("data") as Parcelable?)
            navController.setGraph(navController.graph, bundle)
        }
    }



    fun toolbarPayment() {
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Payment"
        toolbar.subtitle = "You deserve better meal"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}