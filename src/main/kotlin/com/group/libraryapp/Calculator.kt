package com.group.libraryapp

import java.lang.IllegalArgumentException

class Calculator(
        private var _number: Int
) {
    val number: Int
        get() = this._number

    fun add(operand: Int) {
        this._number += operand
    }

    fun minus(operand: Int) {
        this._number -= operand
    }

    fun multiply(operand: Int) {
        this._number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("cannot divide by 0")
        }
        this._number /= operand
    }
}