package dev.eastar.tdd.data

import org.hamcrest.MatcherAssert
import org.hamcrest.collection.IsIn
import org.junit.Test

class GeneratorRandomNumberSourceImplTest {

    @Test
    fun getRandomNumber1between100() {
        //given
        val generatorRandomNumberSource = GeneratorRandomNumberSourceImpl()
        //when
        val actual: Int = generatorRandomNumberSource.getRandomNumber1between100()
        //then
        MatcherAssert.assertThat(actual, IsIn((1..100).toList()))
    }
}