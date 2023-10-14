package com.mad43.assignment00.presentation

import com.mad43.assignment00.presentation.model.MobileUiModel

sealed class ScreenState {
    class Success(val data: MobileUiModel) : ScreenState()
    class Failed(val error: Throwable) : ScreenState()
    object Loading : ScreenState()
}
