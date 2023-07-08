package com.khoavna.shoestore.ui.onboarding.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.khoavna.shoestore.databinding.FragmentInstructionBinding
import com.khoavna.shoestore.ui.onboarding.OnboardingFragment

class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnLetGo.setOnClickListener {
                setFragmentResult(
                    requestKey = OnboardingFragment.GO_TO_SHOE_LIST_REQUEST_KEY,
                    result = bundleOf()
                )
            }
        }
    }
}