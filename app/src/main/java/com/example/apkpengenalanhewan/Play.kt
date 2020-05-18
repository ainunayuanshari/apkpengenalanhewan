package com.example.apkpengenalanhewan

import android.app.Activity
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class Play : AppCompatActivity() {

    lateinit var pager: ViewPager
    internal var nama = arrayOf(
        "Ayam",
        "Sapi",
        "Gajah",
        "bebek",
        "babi",
        "kucing",
        "kambing",
        "anjing")
    internal var gambar = intArrayOf(R.drawable.ayam, R.drawable.sapi, R.drawable.gajah,R.drawable.bebek,R.drawable.babi,
        R.drawable.kucing,R.drawable.kambing,R.drawable.anjing)
    internal var suara = intArrayOf(R.raw.ayam, R.raw.sapi, R.raw.gajah,R.raw.bebek,R.raw.babi,R.raw.kucing,
        R.raw.kambing,R.raw.anjing)
    lateinit var adapter: PagerAdapter
    internal var mp: MediaPlayer? = null

    var onPage: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {
        }

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
        }

        override fun onPageSelected(p0: Int) {
            if (mp != null) {
                mp!!.reset()
                mp!!.release()
            }
            mp = MediaPlayer.create(this@Play, suara[p0])
            mp!!.start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        pager = findViewById(R.id.viewpager) as ViewPager
//        pager = findViewById(R.id.viewpager) as ViewPager
        adapter = GambarAdapter(this, gambar,nama)

        pager.adapter = adapter
        pager.setOnPageChangeListener(onPage)
    }
    class GambarAdapter(play: Play, internal var gambar: IntArray,
                        internal var nama: Array<String>) : PagerAdapter() {
        lateinit var inflater: LayoutInflater
        internal var activity: Activity

        init {
            this.activity = play
        }

        override fun getCount(): Int {
            return gambar.size
        }

        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0 === p1 as ScrollView
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            inflater = activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val tampil = inflater.inflate(R.layout.item_view_pager, container, false)
            val img = tampil.findViewById(R.id.imgbinatang) as ImageView
            val text = tampil.findViewById(R.id.textbinatang) as TextView
            img.setImageResource(gambar[position])
            text.text = nama[position]
            (container as ViewPager).addView(tampil)
            return tampil
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any){
            (container as ViewPager).removeView(`object` as ScrollView)
        }
    }
}

