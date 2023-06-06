package com.example.pradeshadvkotlin.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.home.Data
import com.example.pradeshadvkotlin.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

   var bundle:Bundle ?= null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as DetailActivity).toolbarDetail()

  //      arguments?.let {
       //     DetailFragmentArgs.fromBundle(it).data.let{
     //           initView(it)
     //       }

        var data = requireActivity().intent.getParcelableExtra<Data>("data")
        initView(data)

        btnCheckout.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_payment, bundle)

        }
    }

    private fun initView(data : Data?) {

        data?.let {
            bundle = bundleOf("data" to data)
            Glide.with(requireContext())
                .load(data?.picturePath)
                .into(ivPoster)
            ratingBar.rating = data.rate?.toFloat() ?: 0f
            tvTitle.text = data?.name
            tvDesc.text = data?.description
            tvIngredients.text = data?.ingredients

            tvTotal.formatPrice(data?.price.toString())
        }

            }


}