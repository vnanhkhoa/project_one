package com.khoavna.shoestore.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.khoavna.shoestore.R
import com.khoavna.shoestore.databinding.FragmentOnboardingBinding
import com.khoavna.shoestore.ui.onboarding.adapter.OnboardingPageAdapter

class OnboardingFragment : Fragment(), FragmentResultListener {

    companion object {
        const val CHANGE_PAGE_REQUEST_KEY = "CHANGE_PAGE_REQUEST_KEY"
        const val PAGE_KEY = "PAGE_KEY"
        const val GO_TO_SHOE_LIST_REQUEST_KEY = "GO_TO_SHOE_LIST_REQUEST_KEY"
    }

    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var onBoardingPageAdapter: OnboardingPageAdapter
    private val viewModel: OnBoardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBoardingPageAdapter = OnboardingPageAdapter(fragment = this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding,container, false)
        binding.also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            // Set up view pager 2
            vp2Onboarding.also {
                it.adapter = onBoardingPageAdapter
                it.isUserInputEnabled = false
                indicator.setViewPager(it)
            }
        }

        initObserver()
        initListener()
    }

    private fun initObserver() {
        viewModel.pageCurrent.observe(requireActivity()) {
            binding.vp2Onboarding.currentItem = it
        }

    }

    private fun initListener() {
        binding.apply {
            btnSkip.setOnClickListener {
                goToShoeList()
            }

            vp2Onboarding.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    if (position == OnboardingPageAdapter.INSTRUCTION_PAGE) {
                        btnSkip.visibility = GONE
                    }
                }
            })
        }

    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        when (requestKey) {
            CHANGE_PAGE_REQUEST_KEY -> {
                val page = result.getInt(PAGE_KEY, OnboardingPageAdapter.WELCOME_PAGE)
                viewModel.setPageCurrent(page = page)
            }

            GO_TO_SHOE_LIST_REQUEST_KEY -> goToShoeList()
        }
    }

    private fun goToShoeList() {
        OnboardingFragmentDirections.actionOnboardingFragmentToListShoeFragment().let {
            findNavController().navigate(it)
        }

    }
}