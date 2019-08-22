package com.athena.core.extension

import android.text.InputFilter
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.widget.EditText

fun EditText.numberOnly() {
    inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL or
            InputType.TYPE_NUMBER_FLAG_SIGNED
    keyListener = DigitsKeyListener.getInstance("0123456789")
}

fun EditText.maxLength(maxLength: Int) {
    filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
}