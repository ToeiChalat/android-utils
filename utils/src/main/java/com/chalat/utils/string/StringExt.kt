package com.chalat.utils.string

/**
 *
 * Created by Chalat Chansima on 4/17/18.
 *
 */

/**
 * Convert String format [1, 2, 3] to List of Int
 */
fun String.toList(): List<Int> {
    val result = ArrayList<Int>()
    val string = this.removeSurrounding("[", "]")
    val stringBuilder = StringBuilder()
    string.forEach {
        if (it != ',') {
            stringBuilder.append(it)
        } else {
            addIntFromStringBuilder(stringBuilder, result)
        }
    }
    // For the last digit result
    addIntFromStringBuilder(stringBuilder, result)
    return result
}

private fun addIntFromStringBuilder(stringBuilder: StringBuilder, result: ArrayList<Int>) {
    val int = stringBuilder.toString()
            .trim()
            .toInt()
    stringBuilder.clear()
    result.add(int)
}