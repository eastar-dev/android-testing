package dev.eastar.tdd.main

import androidx.lifecycle.ViewModel

class SingleViewModel constructor(val gameRepository: GameRepository) : ViewModel() {
    // TODO: Implement the ViewModel

    init {
        gameRepository.generatRandomNumber()
    }

    fun tryNumber(number: Int, who: String = "") {
        gameRepository.tryNumberResult(number, who)
    }
}