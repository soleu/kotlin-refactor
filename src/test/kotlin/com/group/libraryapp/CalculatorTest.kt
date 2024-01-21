package com.group.libraryapp

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.Exception

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.multiplyTest()
    calculatorTest.minusTest()
    calculatorTest.divideTest()
    calculatorTest.divideExceptionTest()
}

class CalculatorTest {
    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        // 데이터 클래스로 지정되었을 경우, 이렇게 처리한다.
        val expectedCalculator = Calculator(8)
        if (calculator != expectedCalculator) {
            throw IllegalArgumentException()
        }

        // 데이터 클래스가 아닐 경우
        // 내부 인자가 public 이여야 함!
        if (calculator.number != 8) {
            throw IllegalArgumentException()
        }

        //데이터 클래스가 아닐 경우
        // private 을 사용하고 싶을 경우 !! (backing properties 사용)
        // 원래의 클래스에서 getter만 할 수 있도록 내부 인자 밖에 새로운 인자 생성
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalArgumentException()
        }
    }

    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        if (calculator.number != 15) {
            throw IllegalArgumentException()
        }
    }

    fun divideTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(2)

        // then
        if (calculator.number != 2) {
            throw IllegalArgumentException()
        }
    }

    fun divideExceptionTest() {
        // given
        val calculator = Calculator(5)

        // when
        try {
            calculator.multiply(0)
        } catch (e: IllegalArgumentException) {
            if (e.message != "cannot divided by 0") {
                throw IllegalArgumentException("message is wrong!")
            }
            // 테스트 성공
            return
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
        throw IllegalArgumentException()
    }
}