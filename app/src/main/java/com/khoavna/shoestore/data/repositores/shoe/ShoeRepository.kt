package com.khoavna.shoestore.data.repositores.shoe

import com.khoavna.shoestore.data.model.Shoe
import kotlinx.coroutines.flow.Flow

interface ShoeRepository {
    fun getShoes(): Flow<List<Shoe>>
    fun getShoe(id: Int): Flow<Shoe?>
    fun delete(shoe: Shoe)
    fun insert(shoe: Shoe)
    fun update(shoe: Shoe)
}