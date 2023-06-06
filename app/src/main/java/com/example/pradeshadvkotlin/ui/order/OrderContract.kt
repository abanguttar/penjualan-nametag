package com.example.pradeshadvkotlin.ui.order

import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView
import com.example.pradeshadvkotlin.model.response.home.HomeResponse
import com.example.pradeshadvkotlin.model.response.transaction.TransactionResponse

interface OrderContract {

    interface View: BaseView{
        fun onTransactionSuccess(transactionResponse: TransactionResponse)
        fun onTransactionFailed(message: String)

    }

    interface Presenter : OrderContract, BasePresenter{

        fun getTransaction()

    }
}