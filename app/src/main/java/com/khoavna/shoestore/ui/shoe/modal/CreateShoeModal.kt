package com.khoavna.shoestore.ui.shoe.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.databinding.FragmentAddShoeBinding
import com.khoavna.shoestore.ui.shoe.list.ListShoeViewModel

class CreateShoeModal : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: ListShoeViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnAdd.setOnClickListener {
                val name = edtName.text.toString()
                val price = edtPrice.text.toString().toInt()
                val description = edtDescription.text.toString()

                viewModel.addShoe(
                    Shoe(
                        name = name,
                        price = price,
                        description = description
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