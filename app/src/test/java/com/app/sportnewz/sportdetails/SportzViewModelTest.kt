package com.app.sportnewz.sportdetails

import com.app.sportnewz.base.BaseViewModelTest
import com.app.sportnewz.base.runBlockingMainTest
import com.app.sportnewz.getApiResponse
import com.app.sportnewz.getSportViewData
import com.app.sportnewz.getSportsNewsEntity
import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.usecase.SportzUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SportzViewModelTest : BaseViewModelTest() {
    @Mock
    private lateinit var sportzUseCase: SportzUseCase
    private lateinit var sportzViewModel: SportzViewModel

    @Before
    fun setUp() {
        sportzViewModel = SportzViewModel(sportzUseCase)
    }

    @Test
    fun `Given Sports News when fetchSportsNews should return Success`() = runBlockingMainTest {
        //GIVEN
        val SportsNewsEntityList = flowOf(getApiResponse())

        //WHEN
        doReturn(SportsNewsEntityList).`when`(sportzUseCase).execute()
        sportzViewModel.fetchSportsNews()

        //THEN
        assert(3 == sportzViewModel.sportzList.value?.size)
    }
}