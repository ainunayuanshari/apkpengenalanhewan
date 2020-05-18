package com.example.apkpengenalanhewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var  a: Button
    lateinit var b: Button
    lateinit var c: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = findViewById(R.id.bu_play)
        b = findViewById(R.id.bu_about)
        c = findViewById(R.id.bu_close)

        a.setOnClickListener(this)
        b.setOnClickListener(this)
        c.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.bu_play -> {
                val pindah = Intent(this@MainActivity, Play::class.java)
                startActivity(pindah)
            }
            R.id.bu_about -> {
            }
            R.id.bu_close -> finish()
        }
    }

    }

