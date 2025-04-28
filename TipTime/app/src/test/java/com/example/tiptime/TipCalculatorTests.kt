package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        var expectedTip = NumberFormat.getCurrencyInstance().format(2)

        val tip = calculateTip(
            amount = amount,
            tipPercent = tipPercent,
            false
            )

        assertEquals(expectedTip,tip)
    }
}