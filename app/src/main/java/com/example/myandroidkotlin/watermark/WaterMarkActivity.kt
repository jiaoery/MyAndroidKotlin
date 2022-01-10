package com.example.myandroidkotlin.watermark

import android.os.Bundle
import com.example.myandroidkotlin.BaseActivity
import com.example.myandroidkotlin.R

class WaterMarkActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_water_mark)
        WaterMarkUtils.drawWaterMark(this, "jiaoery-500382199307045335-20210804")
    }

}