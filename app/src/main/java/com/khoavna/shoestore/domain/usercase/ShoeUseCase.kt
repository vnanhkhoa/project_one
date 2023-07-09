package com.khoavna.shoestore.domain.usercase

import com.khoavna.shoestore.data.model.Shoe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ShoeUseCase {
    fun getListShoe(): StateFlow<List<Shoe>>
    fun getShoe(id: Int): Flow<Shoe?>
    fun deleteShoe(shoe: Shoe)
    fun createShoe(shoe: Shoe)
    fun updateShoe(shoe: Shoe)
}