package com.github.josersi.pokedex.network

sealed class Resource<out T>(val data: T? = null) {

    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(val message: String?) : Resource<T>()
    class Loading<T> : Resource<T>()
}