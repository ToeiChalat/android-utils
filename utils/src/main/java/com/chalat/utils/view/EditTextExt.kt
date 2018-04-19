package com.chalat.utils.view

import android.widget.EditText

/**
 * Created by Chalat on 1/10/18.
 */

fun EditText.clearText() {
    this.setText("")
}

fun EditText.getTextString(): String {
    return this.text.toString()
}