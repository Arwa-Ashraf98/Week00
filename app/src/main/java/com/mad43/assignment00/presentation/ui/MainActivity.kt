package com.mad43.assignment00.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mad43.assignment00.databinding.ActivityMainBinding
import com.mad43.assignment00.presentation.ScreenState
import com.mad43.assignment00.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    private val myViewModel: MainViewModel by inject()
//    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        appContainer = (application as App).appContainer
//        initViewModel()
        collectMobileData()
    }

//    private fun initViewModel() {
//        myViewModel =
//            ViewModelProvider(this, appContainer.mainViewModelFactory)[MainViewModel::class.java]
//    }

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