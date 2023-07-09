package com.khoavna.shoestore.ui.shoe.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.khoavna.shoestore.R
import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.databinding.FragmentListShoeBinding
import com.khoavna.shoestore.databinding.ItemShoeBinding
import com.khoavna.shoestore.ui.shoe.modal.CreateShoeModal

class ListShoeFragment : Fragment() {
    private lateinit var binding: FragmentListShoeBinding
    private val viewModel: ListShoeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListShoeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bitAdd.setOnClickListener {
                CreateShoeModal.getInstance().show(childFragmentManager, null)
            }
        }

        initObserver()

    }

    private fun initObserver() {
        viewModel.shoes.observe(viewLifecycleOwner) {
            addViewShoes(it)
        }
    }

    private fun addViewShoes(shoes: List<Shoe>) {
        binding.lnShoes.apply {
            removeAllViews()
            shoes.forEach {
                addView(createShoeItem(this, it).rootView)
            }
        }
    }

    private fun createShoeItem(viewGroup: ViewGroup, shoe: Shoe): ShoeViewHolder {
        return DataBindingUtil.inflate<ItemShoeBinding>(
            layoutInflater, R.layout.item_shoe, viewGroup, false
        ).let { itemBinding ->
            ShoeViewHolder(itemBinding).apply {
                setListener {
                    ListShoeFragmentDirections.actionListShoeFragmentToShoeDetailFragment(it)
                        .let { action ->
                            findNavController().navigate(action)
                        }
                }
                onBind(shoe = shoe)
            }
        }
    }

    class ShoeViewHolder(private val binding: ItemShoeBinding) {
        val rootView = binding.root
        private lateinit var shoeListener: ShoeListener
        fun onBind(shoe: Shoe) {
            binding.also {
                it.shoe = shoe
                it.shoeListener = shoeListener
                it.executePendingBindings()
            }
        }

        fun setListener(listener: ShoeListener) {
            shoeListener = listener
        }
    }

    fun interface ShoeListener {
        fun onItemClick(shoe: Shoe)
    }
}