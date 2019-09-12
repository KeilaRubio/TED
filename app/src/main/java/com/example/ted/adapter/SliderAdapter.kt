package com.example.ejemplo_slider

import android.content.Context
import android.util.Log
import android.view.*
import android.widget.*
import androidx.viewpager.widget.PagerAdapter
import com.example.Interfaces.ViewPagerPosition
import com.example.ted.R
import com.example.ted.modelo.Video
import com.squareup.picasso.Picasso


class SliderAdapter: PagerAdapter {
    private var context:Context
    private var images:MutableList<Video>
    lateinit var inflater:LayoutInflater
    private var listener :ViewPagerPosition
//    lateinit var image:VideoView


    constructor(context:Context, images:MutableList<Video>, position_viewpager :ViewPagerPosition):super(){
        this.context=context
        this.images=images
        this.listener=position_viewpager
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as RelativeLayout

    override fun getCount(): Int= images.size

//    override fun getItemPosition(`object`: Any): Int {
//        return PagerAdapter.POSITION_NONE
//    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var image:VideoView
        var play:ImageView
        var pause:ImageView
        var vista_previa:ImageView


        inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var view:View=inflater.inflate(R.layout.slider_video,container, false)
        //val list: ArrayList<VideoView> = ArrayList()
        image =view.findViewById(R.id.slider_image)

        play = view.findViewById(R.id.play)
        pause = view.findViewById(R.id.pause)
        vista_previa=view.findViewById(R.id.image_previa)
        view.tag = "pos$position"


        image.setVideoPath(images[position].url_video) //Asigna el video a cada Posisción
        vista_previa.loadUrl(images[position].image_prevista)


        // Pausa y Play del Video
        image.setOnPreparedListener{
            vista_previa.visibility=View.VISIBLE
//            image.setBackgroundResource(R.drawable.imgvideo)
//            Log.e("posicion",""+ position)

            play.setOnClickListener {
//                var viewpager_posicion = SharedApp.prefs.positionView   //get (obtiene)
                Log.e("POSIC",""+ position)
                            if (image.isPlaying) {
                                image.pause()
                                val toast = Toast(context)
                                pause = ImageView(context)
                                pause.setBackgroundResource(R.drawable.pausa)
                                toast.view = pause
                                toast.duration = Toast.LENGTH_SHORT
                                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 200)
                                toast.show()
                            } else {
                                image.start()
                                vista_previa.visibility = View.INVISIBLE
                                image.visibility = View.VISIBLE
                                Toast.makeText(context, "entro1" + image.isPlaying, Toast.LENGTH_SHORT).show()
                            }

                        }

        }

        image.setOnCompletionListener {
                Toast.makeText(context,"end",Toast.LENGTH_SHORT).show()   //saber cuando finaliza el video
            vista_previa.visibility=View.VISIBLE
            image.visibility =View.INVISIBLE
        }

        image.setZOrderOnTop(true) //visibilidad del video
        container!!.addView(view)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as RelativeLayout)
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }



}