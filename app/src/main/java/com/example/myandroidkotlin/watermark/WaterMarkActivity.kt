package com.example.myandroidkotlin.watermark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myandroidkotlin.BaseActivity
import com.example.myandroidkotlin.R

public class WaterMarkActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_water_mark)
        Watermark.show(this@WaterMarkActivity,"jiaoery")
    }

}