package dev.eastar.tdd.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dev.eastar.tdd.data.repo.GameRepositoryImpl
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.junit.Test

import org.junit.Assert.*

class SingleViewModelTest {

    @Test
    fun tryNumber() {
        //given
        val singleViewModel = SingleViewModel(GameRepositoryFack())
        //when
        val observer = Observer<Unit> {}
        singleViewModel.tryNumber( 10 , "" ).observeForever(observer)

        try {
        //then
            val gameResult = GameResult()
            val actual = singleViewModel.gameResult.value
            MatcherAssert.assertThat(actual, Is.`is`(gameResult))

        } finally {
            // Whatever happens, don't forget to remove the observer!
            singleViewModel.gameResult.removeObserver(observer)
        }
    }
}