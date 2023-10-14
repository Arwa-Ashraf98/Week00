package com.mad43.assignment00.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mad43.assignment00.databinding.ActivityMainBinding
import com.mad43.assignment00.domain.interactors.GetMobileTypeUseCase
import com.mad43.assignment00.presentation.ScreenState
import com.mad43.assignment00.presentation.viewmodel.MainViewModel
import com.mad43.assignment00.presentation.viewmodel.MobileViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    private lateinit var myViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        collectMobileData()
    }

    private fun initViewModel() {
        val mobileViewModelFactory = MobileViewModelFactory(GetMobileTypeUseCase())
        myViewModel = ViewModelProvider(this, mobileViewModelFactory)[MainViewModel::class.java]
    }

    private fun collectMobileData() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                myViewModel.mobileData.collect {
                    when (it) {
                        is ScreenState.Success -> {
                            binding.textviewMobileName.text = it.data.name
                        }
                        is ScreenState.Loading -> {
                            // handle Ui progress bar
                        }
                        else -> {
                            // showToast
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}