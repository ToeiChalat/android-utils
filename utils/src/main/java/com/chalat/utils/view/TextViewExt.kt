package com.chalat.utils.view

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.util.Linkify
import android.view.View
import android.widget.TextView

/**
 *
 * Created by Chalat Chansima on 2/1/18.
 *
 */
interface OnTextClickListener {

    fun onTextClick()

}

fun TextView.setTextClickAble(text: String,
                              startPosition: Int,
                              endPosition: Int,
                              onTextClickListener: OnTextClickListener) {
    val ss = SpannableString(text)
    val clickableSpan = object : ClickableSpan() {
        override fun onClick(textView: View) {
            onTextClickListener.onTextClick()
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.isUnderlineText = false
        }
    }
    ss.setSpan(clickableSpan, startPosition, endPosition, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    this.text = ss
    this.movementMethod = LinkMovementMethod.getInstance()
    this.highlightColor = Color.TRANSPARENT
}

fun TextView.supportUrl() {
    this.movementMethod = LinkMovementMethod.getInstance()
}

fun TextView.supportPhoneNumber() {
    Linkify.addLinks(this, Linkify.ALL)
}