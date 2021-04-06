package dev.eastar.tdd.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.eastar.tdd.data.GameResult
import dev.eastar.tdd.data.repo.GameRepository

class SingleViewModel constructor(private val gameRepository: GameRepository) : ViewModel() {
    val number = gameRepository.generateRandomNumber()

    val gameResult = MutableLiveData<GameResult>()

    fun tryNumber(number: Int, who: String = "") {
    }
}

