package com.example.myandroidkotlin.rooms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myandroidkotlin.R

class RoomsActivity : AppCompatActivity() {
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)
        textView = findViewById(R.id.textView2)

        lifecycleScope.launchWhenCreated {
            AppDatabase.getRooms().userDao().insertAll(User(177,"吉","祥"))
            AppDatabase.getRooms().userDao().insertAll(User(178,"李","娇娇"))
            val all = AppDatabase.getRooms().userDao().getAll()
            if (all.isNotEmpty()){
              textView.text = all[0].firstName+all[0].lastName
            }
        }



    }
}