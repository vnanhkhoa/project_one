package com.khoavna.shoestore.ui.shoe.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khoavna.shoestore.data.model.Shoe

class ShoeDetailViewModel : ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    fun setShoe(shoe: Shoe) = shoe.let { _shoe.value = it }
}