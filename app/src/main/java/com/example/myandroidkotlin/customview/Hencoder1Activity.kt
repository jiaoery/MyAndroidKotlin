package com.example.myandroidkotlin.customview

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityHencoder1Binding
import java.util.*
import kotlin.collections.ArrayList

class Hencoder1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHencoder1Binding

    var pageModels: ArrayList<PageModel> = ArrayList()

    init {
        pageModels.add(
            PageModel(
                R.layout.sample_color,
                R.string.title_draw_color,
                R.layout.practice_color
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_circle,
                R.string.title_draw_circle,
                R.layout.practice_circle
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_rect,
                R.string.title_draw_rect,
                R.layout.practice_rect
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_point,
                R.string.title_draw_point,
                R.layout.practice_point
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_oval,
                R.string.title_draw_oval,
                R.layout.practice_oval
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_line,
                R.string.title_draw_line,
                R.layout.practice_line
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_round_rect,
                R.string.title_draw_round_rect,
                R.layout.practice_round_rect
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_arc,
                R.string.title_draw_arc,
                R.layout.practice_arc
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_path,
                R.string.title_draw_path,
                R.layout.practice_path
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_histogram,
                R.string.title_draw_histogram,
                R.layout.practice_histogram
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_pie_chart,
                R.string.title_draw_pie_chart,
                R.layout.practice_pie_chart
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hencoder1)
        binding.pager.adapter = object : FragmentPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(
                    pageModel.sampleLayoutRes,
                    pageModel.practiceLayoutRes
                )
            }

            override fun getCount(): Int = pageModels.size

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].titleRes)
            }
        }
        binding.tabLayout.setupWithViewPager(binding.pager)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    class PageModel internal constructor(
        @field:LayoutRes @param:LayoutRes var sampleLayoutRes: Int,
        @field:StringRes @param:StringRes var titleRes: Int,
        @field:LayoutRes @param:LayoutRes var practiceLayoutRes: Int
    )
}