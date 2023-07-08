package com.khoavna.shoestore.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _toolbarVisibility = MutableLiveData(View.GONE)
    val toolbarVisibility: LiveData<Int>
        get() = _toolbarVisibility

    fun showToolBar() {
        _toolbarVisibility.value = View.VISIBLE
    }

    fun hideToolbar() {
        _toolbarVisibility.value = View.GONE
    }
}