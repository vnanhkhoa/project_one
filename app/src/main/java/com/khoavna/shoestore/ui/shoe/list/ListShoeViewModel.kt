package com.khoavna.shoestore.ui.shoe.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.khoavna.shoestore.data.datasource.shoe.ShoeDataSourceIml
import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.data.repositores.shoe.ShoeRepositoryIml
import com.khoavna.shoestore.domain.usercase.ShoeUseCaseIml

class ListShoeViewModel : ViewModel() {
    private val shoeUseCase = ShoeUseCaseIml(ShoeRepositoryIml(ShoeDataSourceIml()))

    val shoes = shoeUseCase.getListShoe().asLiveData()

    fun addShoe(shoe: Shoe) {
        shoeUseCase.createShoe(shoe)
    }
}