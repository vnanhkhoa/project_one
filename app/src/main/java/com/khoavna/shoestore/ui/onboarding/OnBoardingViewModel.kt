package com.khoavna.shoestore.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khoavna.shoestore.ui.onboarding.adapter.OnboardingPageAdapter.Companion.WELCOME_PAGE

class OnBoardingViewModel: ViewModel() {

    private val _pageCurrent = MutableLiveData(WELCOME_PAGE)
    val pageCurrent: LiveData<Int>
        get() = _pageCurrent

    fun setPageCurrent(page: Int) {
        _pageCurrent.value = page
    }
}
