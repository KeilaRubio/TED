package com.example.ted.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.Interfaces.ViewPagerPosition
import com.example.ted.R
import de.hdodenhof.circleimageview.CircleImageView

class SliderAdapterDos:PagerAdapter {
    private var context: Context
    private var images_dos:Array<Int>
    lateinit var inflater: LayoutInflater
    private var listener : ViewPagerPosition


    constructor(context: Context, images_dos:Array<Int>, position_viewpager : ViewPagerPosition):super(){
        this.context=context
        this.images_dos=images_dos
        this.listener=position_viewpager
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as RelativeLayout

    override fun getCount(): Int= images_dos.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var image: CircleImageView
        inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var view: View =inflater.inflate(R.layout.slider_image_circle,container, false)
        image =view.findViewById(R.id.ivFotoSlider)
        image.setBackgroundResource(images_dos[position])
//        Toast.makeText(context, "position" + images[position], Toast.LENGTH_LONG).show()
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as RelativeLayout)
    }



}