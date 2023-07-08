package com.khoavna.shoestore.ui.onboarding.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.khoavna.shoestore.ui.onboarding.instructions.InstructionFragment
import com.khoavna.shoestore.ui.onboarding.welcome.WelcomeFragment

class OnboardingPageAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val SIZE_PAGE = 2
        const val WELCOME_PAGE = 0
        const val INSTRUCTION_PAGE = 1
    }

    override fun getItemCount(): Int = SIZE_PAGE

    override fun createFragment(position: Int): Fragment = when (position) {
        WELCOME_PAGE -> WelcomeFragment()
        INSTRUCTION_PAGE -> InstructionFragment()
        else -> throw IllegalAccessException()
    }
}
