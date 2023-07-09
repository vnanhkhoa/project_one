package com.khoavna.shoestore.utils

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2

@BindingAdapter("currentPage")
fun setCurrentPage(viewPager2: ViewPager2, page: Int) {
    viewPager2.currentItem = page
}