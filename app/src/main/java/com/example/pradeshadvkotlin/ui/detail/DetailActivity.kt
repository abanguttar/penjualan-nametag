package com.example.pradeshadvkotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.navigation.Navigation
import com.example.pradeshadvkotlin.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.extras?.let {
            val navController = Navigation.findNavController(findViewById(R.id.detailHostFragment))
            val bundle = Bundle()
            bundle.putParcelable("data", it.get("data") as Parcelable?)
            navController.setGraph(navController.graph, bundle)
        }

    }

    fun toolbarPayment(){
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Payment"
        toolbar.subtitle = "Thankyou for order!"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000,null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

     fun toolbarDetail(){
        toolbar.visibility = View.GONE
        // toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000,null)
        // toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}