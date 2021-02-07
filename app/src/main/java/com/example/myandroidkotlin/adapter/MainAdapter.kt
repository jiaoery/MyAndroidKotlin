package com.example.myandroidkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myandroidkotlin.R

/**
 * Created by Administrator on 2016/7/5.
 */
class MainAdapter(private val titles: Array<String>?, context: Context?) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    //适配器有多少个数据
    override fun getCount(): Int {
        return titles?.size ?: 0
    }

    //根据指定的位置,返回当前的项
    override fun getItem(position: Int): Any? {
        return if (position >= 0 && position < titles!!.size) {
            titles[position]
        } else null
    }

    //根据指定的位置,返回当前位置项的id
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //根据指定的position绑定数据
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: Holder
        if (convertView == null) {
            holder = Holder()
            convertView = inflater.inflate(R.layout.top_list_item, null)
            holder.textView = convertView.findViewById(R.id.title)
            convertView.tag = holder
        } else {
            holder = convertView.tag as Holder
        }
        if (position < titles!!.size) {
            //绑定数据
            holder.textView!!.text = titles[position]
        }
        return convertView
    }

    internal inner class Holder {
        var textView: TextView? = null
    }

}