package com.khoavna.shoestore.domain.usercase

import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.data.repositores.shoe.ShoeRepository
import kotlinx.coroutines.flow.Flow

class ShoeUseCaseIml(private val shoeRepository: ShoeRepository) : ShoeUseCase {

    override fun getListShoe(): Flow<List<Shoe>> = shoeRepository.getShoes()

    override fun getShoe(id: Int): Flow<Shoe?> = shoeRepository.getShoe(id = id)

    override fun deleteShoe(shoe: Shoe) {
        shoeRepository.delete(shoe = shoe)
    }

    override fun newShoe(shoe: Shoe) {
        shoeRepository.insert(shoe = shoe)
    }

    override fun updateShoe(shoe: Shoe) {
        shoeRepository.update(shoe = shoe)
    }
}