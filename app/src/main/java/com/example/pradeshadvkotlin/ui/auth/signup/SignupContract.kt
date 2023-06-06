package com.example.pradeshadvkotlin.ui.auth.signup

import android.net.Uri
import com.example.pradeshadvkotlin.base.BasePresenter
import com.example.pradeshadvkotlin.base.BaseView
import com.example.pradeshadvkotlin.model.request.RegisterRequest
import com.example.pradeshadvkotlin.model.response.login.LoginResponse
import com.example.pradeshadvkotlin.model.response.register.RegisterResponse

interface SignupContract {

    interface View: BaseView {
        fun onRegisterSuccess(loginResponse: LoginResponse, view:android.view.View)
        fun onRegisterPhotoSuccess(view:android.view.View)
        fun onRegisterFailed(message:String)

    }

    interface Presenter : SignupContract, BasePresenter {
        fun submitRegister(registerRequest: RegisterRequest, view:android.view.View)
        fun submitPhotoRegister(filePath: Uri, view:android.view.View)
    }
}