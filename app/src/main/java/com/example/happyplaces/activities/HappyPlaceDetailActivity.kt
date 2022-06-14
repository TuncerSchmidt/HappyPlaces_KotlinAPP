package com.example.happyplaces.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.happyplaces.R
import com.example.happyplaces.models.HappyPlaceModel

class HappyPlaceDetailActivity : AppCompatActivity() {
    var toolbar_happy_place_detail: Toolbar ?= null
    var iv_place_image: ImageView ?= null
    var tv_description: TextView ?= null
    var tv_location: TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_detail)
        toolbar_happy_place_detail = findViewById(R.id.toolbar_happy_place_detail)
        iv_place_image = findViewById(R.id.iv_place_image)
        tv_description = findViewById(R.id.tv_description)
        tv_location = findViewById(R.id.tv_location)


        var happyPlaceDetailModel : HappyPlaceModel? = null
        if(intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)){
            happyPlaceDetailModel = intent.getSerializableExtra(MainActivity.EXTRA_PLACE_DETAILS) as HappyPlaceModel

        }
        if(happyPlaceDetailModel != null){
            setSupportActionBar(toolbar_happy_place_detail)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = happyPlaceDetailModel.title

            toolbar_happy_place_detail?.setOnClickListener { onBackPressed() }
            iv_place_image?.setImageURI(Uri.parse(happyPlaceDetailModel.image))
            tv_description?.text = happyPlaceDetailModel.description
            tv_location?.text = happyPlaceDetailModel.location

        }

    }
}