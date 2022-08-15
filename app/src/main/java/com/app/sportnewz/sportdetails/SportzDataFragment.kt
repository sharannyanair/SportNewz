package com.app.sportnewz.sportdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.app.sportnewz.R
import com.app.sportnewz.base.BaseFragment
import com.app.sportnewz.databinding.FragmentSportzDataBinding

class SportzDataFragment : BaseFragment() {
    private var binding: FragmentSportzDataBinding? = null
    private val sportzViewModel: SportzViewModel by viewModels()
    private lateinit var sportzAdapter: SportzAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSportzDataBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        binding?.let {
            sportzAdapter = SportzAdapter(arrayListOf())
            it.rvNews.adapter = sportzAdapter
            it.swipeRefresh.setOnRefreshListener {
                sportzViewModel.fetchSportsNews()
            }
        }
        sportzViewModel.sportzList.observe(viewLifecycleOwner) { result ->
            binding?.swipeRefresh?.isRefreshing = if (!result.isNullOrEmpty()) {
                sportzAdapter.update(result)
                false
            } else {
                showError(getString(R.string.error_message)) {
                    sportzViewModel.fetchSportsNews()
                }
                false
            }

        }
    }
}