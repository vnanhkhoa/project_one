package com.khoavna.shoestore.ui.shoe.modal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateShoeViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val description = MutableLiveData<String>()
}