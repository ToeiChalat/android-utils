package com.chalat.utils.view

import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun Fragment.showSnackBar(message: String, duration: Int) {
    view?.let {
        Snackbar.make(it, message, duration).show()
    }
}

fun Fragment.showSnackBar(@StringRes textId: Int, duration: Int) {
    view?.let {
        Snackbar.make(it, textId, duration).show()
    }
}

fun Fragment.showSnackBar(@StringRes textId: Int) {
    view?.let {
        Snackbar.make(it, textId, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.showSnackBar(error: Throwable) {
    view?.let {
        val message = error.message ?: error.toString()
        Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.showSnackBar(message: String) {
    view?.let {
        Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
    }
}

fun Fragment.showToast(text: String) {
    Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toggleKeyboard() {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

fun Fragment.focusViewAndShowKeyboard(view: View) {
    view.requestFocus()
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}
