package com.example.myandroidkotlin.databinding.util

import android.widget.ImageView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

/**
 * `app:srcCompat` is an attribute used by the support library to integrate vector drawables. This
 * BindingMethod binds the attribute to the setImageDrawable method in the ImageView class.
 *
 * Binding methods have to be applied to any class in your project. Even an empty one.
 *
 * This is equivalent to:
 * ```
 *
 *   @BindingAdapter("app:srcCompat")
 *   @JvmStatic fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
 *       view.setImageResource(drawable)
 *   }
 * ```
 */
@BindingMethods(
    BindingMethod(
        type = ImageView::class,
        attribute = "app:srcCompat",
        method = "setImageResource"
    )
)
class MyBindingMethods
