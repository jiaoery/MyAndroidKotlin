package com.example.myandroidkotlin.customview

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityHencoder2Binding

class Hencoder2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHencoder2Binding

    var pageModels: ArrayList<PageModel> = ArrayList()

    init {
        pageModels.add(
            PageModel(
                R.layout.sample_linear_gradient,
                R.string.title_linear_gradient,
                R.layout.practice_linear_gradient
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_radial_gradient,
                R.string.title_radial_gradient,
                R.layout.practice_radial_gradient
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_sweep_gradient,
                R.string.title_sweep_gradient,
                R.layout.practice_sweep_gradient
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_bitmap_shader,
                R.string.title_bitmap_shader,
                R.layout.practice_bitmap_shader
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_compose_shader,
                R.string.title_compose_shader,
                R.layout.practice_compose_shader
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_lighting_color_filter,
                R.string.title_lighting_color_filter,
                R.layout.practice_lighting_color_filter
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_color_mask_color_filter,
                R.string.title_color_matrix_color_filter,
                R.layout.practice_color_matrix_color_filter
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_xfermode,
                R.string.title_xfermode,
                R.layout.practice_xfermode
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_stroke_cap,
                R.string.title_stroke_cap,
                R.layout.practice_stroke_cap
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_stroke_join,
                R.string.title_stroke_join,
                R.layout.practice_stroke_join
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_stroke_miter,
                R.string.title_stroke_miter,
                R.layout.practice_stroke_miter
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_path_effect,
                R.string.title_path_effect,
                R.layout.practice_path_effect
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_shadow_layer,
                R.string.title_shader_layer,
                R.layout.practice_shadow_layer
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_mask_filter,
                R.string.title_mask_filter,
                R.layout.practice_mask_filter
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_fill_path,
                R.string.title_fill_path,
                R.layout.practice_fill_path
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_text_path,
                R.string.title_text_path,
                R.layout.practice_text_path
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hencoder2)
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