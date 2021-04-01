package dev.eastar.tdd.main

import androidx.lifecycle.ViewModel
import dev.eastar.tdd.data.repo.GameRepository

class SingleViewModel constructor(private val gameRepository: GameRepository) : ViewModel() {
    init {
        gameRepository.generateRandomNumber()
    }

    fun tryNumber(number: Int, who: String = "") {
        gameRepository.tryNumberResult(number, who)
    }
}