package com.example.pradeshadvkotlin.ui.home

import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView
import com.example.pradeshadvkotlin.model.response.home.HomeResponse
import com.example.pradeshadvkotlin.model.response.login.LoginResponse

interface HomeContract {

    interface View: BaseView{
        fun onHomeSuccess(homeResponse: HomeResponse)
        fun onHomeFailed(message: String)

    }

    interface Presenter : HomeContract, BasePresenter{

        fun getHome()

    }
}