package com.example.ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.Interfaces.ViewPagerPosition
import com.example.ejemplo_slider.SliderAdapter
import com.example.ted.adapter.SliderAdapterDos
import kotlinx.android.synthetic.main.activity_inicio.*
import android.util.Log
import android.widget.*
import com.example.ted.activity.preferencias.SharedApp
import com.example.ted.modelo.Video


class InicioActivity : AppCompatActivity(), ViewPagerPosition{

    private lateinit var titulo_servicio:TextView
    private lateinit var descripcion_servicio:TextView
    private lateinit var inicio:CoordinatorLayout
    private lateinit var viewpager2:SwipeLockableViewPager
    lateinit var images:MutableList<Video>

    fun getVideo(): MutableList<Video> {
        images= ArrayList()
        images.add(
            Video(
                "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                "https://image.flaticon.com/icons/svg/145/145802.svg",
                "https://img.ecartelera.com/noticias/fotos/53700/53731/1.jpg"
            )
        )
        images.add(
            Video(
                "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                "https://image.flaticon.com/icons/svg/145/145812.svg",
                "http://img2.rtve.es/i/?w=1600&i=1555344442012.jpg"
            )
        )
        images.add(
            Video(
                "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                "https://image.flaticon.com/icons/svg/145/145805.svg",
                "https://images5.alphacoders.com/342/342987.jpg"
            )
        )
        images.add(
            Video(
                "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
                "https://image.flaticon.com/icons/svg/145/145804.svg",
                "https://d13ezvd6yrslxm.cloudfront.net/wp/wp-content/images/Kikis-Delivery-Service.jpg"
            )
        )
        images.add(
            Video(
                "http://techslides.com/demos/sample-videos/small.mp4",
                "https://image.flaticon.com/icons/svg/145/145810.svg",
                "https://4.bp.blogspot.com/-F3f63YUu4zg/WAcHrtbo07I/AAAAAAAACDk/-FZaxJsNd3kyl-BkZddIXSyWYFYWXcqTACLcB/s1600/MONONOKE%2Bsoanime.jpg"
            )
        )
        return images
    }




//    var images:Array<String> = arrayOf(
//        "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
//        "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
//        "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
//        "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4",
//        "http://techslides.com/demos/sample-videos/small.mp4"
//        )
    var images_icono:Array<Int> = arrayOf(R.drawable.intro3, R.drawable.intro4,R.drawable.intro5, R.drawable.intro6, R.drawable.intro7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        getVideo()
        titulo_servicio=findViewById(R.id.texto1)
        descripcion_servicio=findViewById(R.id.texto2)
        inicio= findViewById(R.id.inicio)
        viewpager2 = findViewById(R.id.viewpager2)


        //        setSupportActionBar(findViewById(R.id.toolbar_slider))
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var adapter:PagerAdapter = SliderAdapter(applicationContext,images, this)
        var adater2:PagerAdapter = SliderAdapterDos(applicationContext,images_icono,this)
        //var mAdapter:PagerAdapter =SliderAdapter(applicationContext, )


        viewpager.adapter=adapter
        viewpager2.adapter=adater2
        viewpager2.setSwipePagingEnabled(false) //desabilitar el viewpager2

//        viewpager2.setPagingEnabled(false)

        viewpager.offscreenPageLimit = 5 //carga 5 paginas del Viewpager
        viewpager2.offscreenPageLimit = 5 //carga 5 paginas del Viewpager

        viewpager.pageMargin = resources.displayMetrics.widthPixels /-5 //muestra las imagenes laterales anterior y siguiente
        viewpager2.pageMargin = resources.displayMetrics.widthPixels /-2 //muestra las imagenes laterales anterior y siguiente
        viewpager.postDelayed({ viewpager.setCurrentItem(2, true) }, 50) //empezar en el viewpager2(en la página2)

        viewpager2.setPageTransformer(true, ZoomOutPageTransformer())
        viewpager.setPageTransformer(true, ZoomOutPageTransformer2())

        //view pager 1
        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {


            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
//
                SharedApp.prefs.positionView = viewpager.currentItem.toString() //set
                Log.e("GETCURRENT", ""+(SharedApp.prefs.positionView))


                viewpager2.currentItem =position

                when (position) {
                    0 -> {titulo_servicio.text="Titulo1"
                        descripcion_servicio.text="Descripción acerca del titulo1"
                        // inicio.setBackgroundColor(Color.parseColor("#F5F51D"))

                        val viewAdapter : View = viewpager.findViewWithTag<View>("pos" + (position+1))
                        val viewVideo : VideoView = viewAdapter.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()
                    }
                    1 -> {titulo_servicio.text="TITULO2"
                        descripcion_servicio.text="Descripción acerca del titulo2"
                        // inicio.setBackgroundColor(Color.parseColor("#4FD34D"))

                        val viewAdapterAnterior : View = viewpager.findViewWithTag<View>("pos" + (position-1))
                        val viewAdapterSiguiente : View = viewpager.findViewWithTag<View>("pos" + (position+1))

                        var viewVideo : VideoView
//                        var imagenPrevia:ImageView

                        viewVideo = viewAdapterAnterior.findViewById(R.id.slider_image) as VideoView
//                        imagenPrevia = viewAdapterAnterior.findViewById(R.id.image_previa) as ImageView
//                        if(viewVideo.isPlaying){
                        viewVideo.pause()
//                            viewVideo.visibility=View.INVISIBLE
//                            imagenPrevia.visibility=View.VISIBLE
//                        }

                        viewVideo = viewAdapterSiguiente.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()
                    }
                    2 -> {titulo_servicio.text="TITULO3"
                        descripcion_servicio.text="Descripción acerca del titulo3"
                        // inicio.setBackgroundColor(Color.parseColor("#9581E5"))

                        val viewAdapterAnterior : View = viewpager.findViewWithTag<View>("pos" + (position-1))
                        val viewAdapterSiguiente : View = viewpager.findViewWithTag<View>("pos" + (position+1))

                        var viewVideo : VideoView

                        viewVideo = viewAdapterAnterior.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()

                        viewVideo = viewAdapterSiguiente.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()

                    }
                    3 -> {titulo_servicio.text="TITULO4"
                        descripcion_servicio.text="Descripción acerca del titulo4"
                        //inicio.setBackgroundColor(Color.parseColor("#3EBFED"))

                        val viewAdapterAnterior : View = viewpager.findViewWithTag<View>("pos" + (position-1))
                        val viewAdapterSiguiente : View = viewpager.findViewWithTag<View>("pos" + (position+1))

                        var viewVideo : VideoView

                        viewVideo = viewAdapterAnterior.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()

                        viewVideo = viewAdapterSiguiente.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()

                    }
                    4 -> {titulo_servicio.text="TITULO5"
                        descripcion_servicio.text="Descripción acerca del titulo5"
//                        inicio.setBackgroundColor(Color.parseColor("#f7b733")                        )
                        val viewAdapter : View = viewpager.findViewWithTag<View>("pos" + (position-1))
                        val viewVideo : VideoView = viewAdapter.findViewById(R.id.slider_image) as VideoView
                        viewVideo.pause()
                    }
                    else -> Toast.makeText(this@InicioActivity, "HUBO UN ERROR", Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Infla el menú; esto agrega elementos a la barra de acción si está presente.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onGetCurrentItem(): Int {
        return viewpager.currentItem
    }


    class ZoomOutPageTransformer : ViewPager.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            var image = view.findViewById(R.id.ivFotoSlider) as ImageView
            val pageWidth = view.width
            if (position < -1) {
                view.alpha = MIN_FADE2
            } else if (position < 0) {
                view.alpha = 1 + position * (1 - MIN_FADE2)
                //view.translationX = -pageWidth * MAX_SCALE2 * position
                //ViewCompat.setTranslationZ(view, position)
                val scaleFactor = MIN_SCALE2 + (MAX_SCALE2 - MIN_SCALE2) * (1 - Math.abs(position))
                //image.setBackgroundColor(Color.parseColor("#B3000000"))
                //image.background.alpha = 110

                view.scaleX = scaleFactor
                view.scaleY = scaleFactor
            }
            else if (position === 0F){
//                    view.alpha = 1F
//                    view.translationX = 0F
//                    view.scaleX = MAX_SCALE2
//                    //ViewCompat.setTranslationZ(view, 0f)
//                    view.scaleY = MAX_SCALE2
            } else if (position <= 1) {

//                if (position.toString().equals("0.1601467")){
//                 image.background.alpha = 250
//
//                    // image.setBackgroundColor(Color.parseColor("#B3000000"))
//                }

                    //ViewCompat.setTranslationZ(view, -position)
                    view.alpha = 1 - position * (1 - MIN_FADE2)
                    //view.translationX = pageWidth * MAX_SCALE2 * -position

                    val scaleFactor = MIN_SCALE2 + (MAX_SCALE2 - MIN_SCALE2) * (1 - Math.abs(position))
                view.scaleX = scaleFactor
                    view.scaleY = scaleFactor
            } else {
                    view.alpha = MIN_FADE2
                //image.background.alpha = 110

            }
        }

    }

    class ZoomOutPageTransformer2 : ViewPager.PageTransformer {
        override fun transformPage(view: View, position: Float) {

            if (position < -1) {
                view.alpha = 0F

            }
            else if (position <= 1) {
                view.scaleX = Math.max(MIN_SCALE,1-Math.abs(position))
                view.scaleY = Math.max(MIN_SCALE,1-Math.abs(position))
                view.alpha = Math.max(MIN_ALPHA,1-Math.abs(position))
            } else {
                view.alpha = 0F
            }

        }

    }


    companion object {

        //ZoomOutPageTransformer2
        private const val MIN_SCALE:Float = 0.75f
        private const val MAX_SCALE:Float = 0.8f
        private const val MIN_ALPHA:Float = 0.2f
        //ZoomOutPageTransformer1
        private const val MIN_SCALE2:Float = 0.8f
        private const val MAX_SCALE2:Float = 0.99f
        private const val MIN_FADE2:Float = 0.1f

    }

}


