package com.paging.example.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.paging.example.databinding.ActivityMainBinding
import com.paging.example.view.adapter.AnswerAdapter
import com.paging.example.view.adapter.BaseLoadStateAdapter
import com.paging.example.viewmodel.AnswerListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mAnswerListViewModel: AnswerListViewModel by viewModels()

    private lateinit var mAnswerAdapter: AnswerAdapter

    //**********************************************************************************************
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listConfig()
    }

    override fun onResume() {
        super.onResume()

        loadAnswerList()
    }

    //**********************************************************************************************
    private fun listConfig() {
        mAnswerAdapter = AnswerAdapter(this)

        mAnswerAdapter.setOnItemClickListener { _, answer ->

        }

        recyclerViewAnswer.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = mAnswerAdapter.withLoadStateFooter(
                footer = BaseLoadStateAdapter()
            )
        }
    }

    //**********************************************************************************************
    private fun loadAnswerList() {

        lifecycleScope.launch {
            mAnswerAdapter.addLoadStateListener { loadStates ->

                when (loadStates.refresh) {
                    is LoadState.Loading -> {
                        progressBar.visibility = View.VISIBLE
                    }

                    is LoadState.NotLoading -> {
                        progressBar.visibility = View.INVISIBLE
                    }

                    is LoadState.Error -> {
                        progressBar.visibility = View.INVISIBLE

                        Toast.makeText(
                            this@MainActivity,
                            "Failed to Load Data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }

            mAnswerListViewModel.getAnswerList().collectLatest { pagingData ->
                mAnswerAdapter.submitData(pagingData)
            }
        }

    }

}