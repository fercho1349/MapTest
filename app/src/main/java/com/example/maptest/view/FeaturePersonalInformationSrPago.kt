package com.example.maptest.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.maptest.R
import kotlinx.android.synthetic.main.activity_feature_personal_information_srpago.*

class FeaturePersonalInformationSrPago: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_personal_information_srpago)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)

        buttonPersonalInformation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == buttonPersonalInformation.id){
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }

}