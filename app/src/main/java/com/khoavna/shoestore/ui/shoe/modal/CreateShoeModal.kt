package com.khoavna.shoestore.ui.shoe.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.khoavna.shoestore.R
import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.databinding.FragmentAddShoeBinding
import com.khoavna.shoestore.ui.shoe.list.ListShoeViewModel

class CreateShoeModal : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddShoeBinding
    private val listShoeViewModel: ListShoeViewModel by viewModels({ requireParentFragment() })
    private val viewModel: CreateShoeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        binding.also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.also {
            it.btnAdd.setOnClickListener {
                listShoeViewModel.addShoe(
                    Shoe(
                        name = viewModel.name.value.toString(),
                        price = viewModel.price.value.toString().toInt(),
                        description = viewModel.description.value.toString()
                    )
                )

                dismissNow()
            }
        }
    }

    companion object {

        fun getInstance(): CreateShoeModal {
            return CreateShoeModal()
        }
    }
}