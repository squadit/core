package com.athena.core.util

import com.athena.core.common.entity.CardType
import com.athena.core.common.entity.CardType.*

object CardUtil {

    private val visaLengths = arrayOf(13, 16, 19)
    private val masterLengths = arrayOf(16)
    private val amexLengths = arrayOf(15)

    fun getCardType(number: String?): CardType {
        if (number.isNullOrEmpty()) return NONE

        val cardNumber = number.trim().replace(" ", "")

        if (visaLengths.contains(cardNumber.length) && cardNumber[0].toString() == "4") return VISA

        val sub2 = cardNumber.substring(0, 2).toInt()

        if (masterLengths.contains(cardNumber.length)) {
            if (sub2 in 51..55) return MASTER

            val sub6 = cardNumber.substring(0, 6).toInt()
            if (sub6 in 222100..272099) return MASTER
        }

        if (amexLengths.contains(cardNumber.length) && (sub2 == 34 || sub2 == 37)) return AMEX

        return NONE
    }
}