package com.example.jetpackcomponents.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {


     private  val _firstName =MutableLiveData("Suriya")
    private val _lastName  =MutableLiveData("Sultana")
    private val _likes = MutableLiveData(0)

    val firstName :LiveData<String> = _firstName
    val lastName :LiveData<String> = _lastName
    val likes : MutableLiveData<Int> = _likes

    val popularity: LiveData<Popularity> = Transformations.map(likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        likes.value = (likes.value ?: 0) + 1
    }



}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}