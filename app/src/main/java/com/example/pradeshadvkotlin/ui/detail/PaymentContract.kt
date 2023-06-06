package com.example.pradeshadvkotlin.ui.detail

import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView
import com.example.pradeshadvkotlin.model.response.checkout.CheckoutResponse

interface PaymentContract {

    interface View: BaseView{
        fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: android.view.View)
        fun onCheckoutFailed(message: String)

    }

    interface Presenter : PaymentContract, BasePresenter{

        fun getCheckout(foodId:String, userId:String, quantity:String, total:String, view: android.view.View)

    }
}