package com.example.smssend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.smssend.databinding.ActivityMainBinding
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val Header: Header = Header( "SMS Send is a demo app that calls a private API to send short messages from the 0726697455 Vodafone phone number to an arbitrary destination.")

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main)
        binding.header=Header

    }
}



