package com.khoavna.shoestore.ui.onboarding.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.khoavna.shoestore.databinding.FragmentWelcomeBinding
import com.khoavna.shoestore.ui.onboarding.OnboardingFragment
import com.khoavna.shoestore.ui.onboarding.adapter.OnboardingPageAdapter

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            btnLetGo.setOnClickListener {
                setFragmentResult(
                    requestKey = OnboardingFragment.CHANGE_PAGE_REQUEST_KEY,
                    result = bundleOf(
                        OnboardingFragment.PAGE_KEY to OnboardingPageAdapter.INSTRUCTION_PAGE
                    )
                )

            }
        }
    }
}
