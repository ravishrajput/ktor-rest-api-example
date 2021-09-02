package com.ravishrajput.restapi.model

data class User(val id: Int, val name: String, val username: String, var email: String, var imageUrl: String)

data class Failure(val errorCode: Int, val errorMessage: String)