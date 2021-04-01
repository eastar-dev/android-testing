package dev.eastar.tdd.data.repo

interface GameRepository {
    fun generateRandomNumber()
    fun tryNumberResult(number: Int, who: String)
}
