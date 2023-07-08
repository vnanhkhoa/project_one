package com.khoavna.shoestore.ui.shoe.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.khoavna.shoestore.databinding.FragmentListShoeBinding
import com.khoavna.shoestore.ui.shoe.list.adapter.ShoeAdapter
import com.khoavna.shoestore.ui.shoe.modal.CreateShoeModal

class ListShoeFragment : Fragment() {
    private lateinit var binding: FragmentListShoeBinding
    private val viewModel: ListShoeViewModel by viewModels()
    private val shoeAdapter = ShoeAdapter {
        ListShoeFragmentDirections.actionListShoeFragmentToShoeDetailFragment(it).let { action ->
            findNavController().navigate(action)
        }
    }

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
            rclShoes.also {
                it.adapter = shoeAdapter
                it.layoutManager = LinearLayoutManager(requireActivity())
            }

            bitAdd.setOnClickListener {
                CreateShoeModal.getInstance().show(childFragmentManager, null)
            }
        }

        initObserver()

    }

    private fun initObserver() {
        viewModel.shoes.observe(viewLifecycleOwner) {
            shoeAdapter.submitList(it)
        }
    }

}