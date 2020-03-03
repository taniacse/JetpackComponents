package com.example.jetpackcomponents.data

import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {


    val firstName ="Suriya"
    val lastName  ="Sultana"
    var likes = 0
            private set

    fun onLike (){

        likes++
    }

    val popularity:Popularity
        get (){
            return when {
                likes > 9 -> Popularity.STAR
                likes > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }



}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}