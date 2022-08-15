package com.app.sportnewz.sportdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import com.app.sportzdomain.usecase.SportzUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportzViewModel @Inject constructor(private val sportzUseCase: SportzUseCase):ViewModel()  {
    private var sportzDataList = MutableLiveData<ArrayList<SportsNewsViewData>>()
    val sportzList: LiveData<ArrayList<SportsNewsViewData>> = sportzDataList

    init {
        fetchSportsNews()
    }
    /**
     * Method to fetch the sports news data.
     */
    fun fetchSportsNews(){
        viewModelScope.launch {
            sportzUseCase.execute()
                .map { onNewsDataReady(it) }
                .collect()
            }
        }
     private fun onNewsDataReady(it: ApiResponse<ResponseEntity>) : ArrayList<SportsNewsViewData>? {
        val result = it.data?.let { SportsDataMapper().mapFrom(it) }
         sportzDataList.value = result
        return result
    }
}