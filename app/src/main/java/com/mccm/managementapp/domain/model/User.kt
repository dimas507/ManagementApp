package com.mccm.managementapp.domain.model

import java.util.Date

data class User (
    var name: String = "",
    var lastname: String ="",
    var username: String = "${name.toLowerCase()}_${lastname.toLowerCase()}",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var nif: String ="",
    var gender: String = "",
    var date: String = "",
    var address: String ="",
    var perfil: String =""
    )