package com.example.pradeshadvkotlin.ui.auth.signin

import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView
import com.example.pradeshadvkotlin.model.response.login.LoginResponse

interface SigninContract {

    interface View: BaseView{
        fun onLoginSuccess(LoginResponse : LoginResponse)
        fun onLoginFailed(message: String)

    }

    interface Presenter : SigninContract, BasePresenter{

        fun subimtLogin(email:String, password:String)

    }
}