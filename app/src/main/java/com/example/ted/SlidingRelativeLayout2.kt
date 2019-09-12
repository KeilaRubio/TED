package com.example.ted

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class SlidingRelativeLayout2(context: Context?) : RelativeLayout(context) {

    fun SlidingRelativeLayout(context: Context){
//        super(context)
    }
    fun SlidingRelativeLayout(context: Context, attrs: AttributeSet) {
//        super(context, attrs)
    }
    fun SlidingRelativeLayout(context: Context, attrs: AttributeSet, defStyle: Int) {
//        super(context, attrs, defStyle)
    }
    fun setYFraction(fraction: Float) {
        val translationY = height * fraction
        setTranslationY(translationY)
    }
    fun getYFraction(): Float {
        return if (height == 0) {
            0f
        } else translationY / height
    }
}