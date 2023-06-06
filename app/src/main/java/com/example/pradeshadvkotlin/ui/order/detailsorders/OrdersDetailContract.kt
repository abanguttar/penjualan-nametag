package com.example.pradeshadvkotlin.ui.order.detailsorders

import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView

interface OrdersDetailContract {

    interface View : BaseView {
        fun onUpdateTransactionSuccess(message: String)
        fun onUpdateTransactionFailed(message: String)
    }

    interface Presenter : OrdersDetailContract, BasePresenter {
        fun getUpdateTransaction(id:String, status:String)
    }
}
