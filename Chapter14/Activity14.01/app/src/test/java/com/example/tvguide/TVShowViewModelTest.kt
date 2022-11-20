package com.example.tvguide

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.tvguide.model.TVShow
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var tvShowRepository: TVShowRepository

    @Test
    fun getTVShows() {
        val tvShowLiveData = MutableLiveData<List<TVShow>>()
        val shows = listOf(
            TVShow(name = "Show")
        )
        tvShowLiveData.postValue(shows)

        Mockito.`when`(tvShowRepository.tvShows)
            .thenReturn(tvShowLiveData)
        val tvShowViewModel = TVShowViewModel(tvShowRepository)

        assertEquals(
            tvShowLiveData.value,
            tvShowViewModel.getTVShows().getOrAwaitValue()
        )
    }

}