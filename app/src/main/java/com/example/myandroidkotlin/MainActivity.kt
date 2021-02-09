package com.example.myandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.LifecycleService
import com.example.myandroidkotlin.adapter.MainAdapter
import com.example.myandroidkotlin.databinding.ActivityMainBinding
import com.example.myandroidkotlin.watermark.Watermark
import java.util.*

class MainActivity : BaseActivity() {

    private val map:HashMap<String, String> = HashMap<String, String>()

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }



    private fun init() {
        //获取标题和对应的class信息
        val titles = resources.getStringArray(R.array.main_titles)
        val mainclasses = resources.getStringArray(R.array.main_classes)
        for (i in titles.indices) {
            map[titles[i]] = mainclasses[i]
        }
        val arrayAdapter = ArrayAdapter(this, R.layout.only_textview, titles)
        binding.listview.adapter = arrayAdapter
        val adapter = MainAdapter(titles, this)
        binding.listview.adapter = adapter
        binding.listview.onItemClickListener = MyOnItemClickListener()
        binding.autoCompletedtextview.onItemClickListener = MyOnItemClickListener()
    }


    inner  class MyOnItemClickListener : OnItemClickListener {
        override fun onItemClick(
            parent: AdapterView<*>, view: View, position: Int,
            id: Long
        ) {
            if (parent.adapter is MainAdapter) {
                val toclass = parent.getItemAtPosition(position).toString()
                jump(toclass)
            } else if (parent.adapter is ArrayAdapter<*>) {
                val toclass = parent.getItemAtPosition(position).toString()
                jump(toclass)
            }
        }
    }

    /**
     * 跳转到指定的activity
     *
     */
    fun jump(name: String){
        val toclass = map[name]
        if (toclass!!.isNotEmpty()) {
            val cls: Class<*>
            try {
                //反射
                cls = Class.forName(toclass)
                val intent = Intent(this, cls)
                startActivity(intent)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this, "控件未找到!请重新搜索", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "控件未找到!请重新搜索", Toast.LENGTH_SHORT).show()
        }
    }




}