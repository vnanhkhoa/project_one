package com.khoavna.shoestore.domain.usercase

import com.khoavna.shoestore.data.model.Shoe
import kotlinx.coroutines.flow.Flow

interface ShoeUseCase {
    fun getListShoe(): Flow<List<Shoe>>
    fun getShoe(id: Int): Flow<Shoe?>
    fun deleteShoe(shoe: Shoe)
    fun newShoe(shoe: Shoe)
    fun updateShoe(shoe: Shoe)
}