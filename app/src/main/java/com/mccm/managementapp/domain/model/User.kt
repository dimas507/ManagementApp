package com.mccm.managementapp.domain.model

import com.google.gson.Gson

data class User(
    var id: String = "",
    var name: String = "",
    var lastname: String = "",
    var username: String = "${name} ${lastname}",
    var nif: String = "",
    var address: String = "",
    var birthday: String = "",
    var accesType: String = "",
    var gender: String = "",
    var schoolName: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var image: String = ""
    ) {
    fun toJson(): String = Gson().toJson(this)
    companion object{
        fun fromJson(data: String): User = Gson().fromJson(data,User::class.java)
    }
}