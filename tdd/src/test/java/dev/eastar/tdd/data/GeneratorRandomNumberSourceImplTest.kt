package dev.eastar.tdd.data

import dev.eastar.tdd.data.source.GeneratorRandomNumberSourceImpl
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.`is`
import org.hamcrest.collection.IsIn
import org.junit.Test
import java.lang.Integer.max
import java.lang.Math.min

class GeneratorRandomNumberSourceImplTest {

    @Test
    fun getRandomNumber1between100() {
        //given
        val generatorRandomNumberSource = GeneratorRandomNumberSourceImpl()
        repeat(10000) {
            //when
            val actual: Int = generatorRandomNumberSource.getRandomNumber1between100()
            //then
            MatcherAssert.assertThat(actual, IsIn((1..100).toList()))
        }
    }

    @Test
    fun getManyRandomNumberMin1Max100() {
        //given
        val generatorRandomNumberSource = GeneratorRandomNumberSourceImpl()
        //when
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        repeat(100000) {
            val actual: Int = generatorRandomNumberSource.getRandomNumber1between100()
            min = min(min, actual)
            max = max(max, actual)
        }
        //then
        MatcherAssert.assertThat(min, `is`(1))
        MatcherAssert.assertThat(max, `is`(100))
    }
}