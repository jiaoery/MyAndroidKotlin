package com.example.myandroidkotlin.databinding.viewmodel

import androidx.lifecycle.ViewModel

/**
 * ClassName: SimpleViewModel<br/>
 * Description: TODO Description. <br/>
 * date: 2021/6/10 15:59<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
/**
 * A simple VM
 */
class SimpleViewModel : ViewModel() {
    val name = "Grace"
    val lastName = "Hopper"
    var likes = 0
        private set // This is to prevent external modification of the variable.

    /**
     * Increments the number of likes.
     */
    fun onLike() {
        likes++
    }

    /**
     * Returns popularity in buckets: [Popularity.NORMAL], [Popularity.POPULAR] or [Popularity.STAR]
     */
    val popularity: Popularity
        get() {
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