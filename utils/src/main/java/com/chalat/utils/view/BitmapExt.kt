package com.chalat.utils.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.view.View


/**
 *
 * Created by Chalat Chansima on 11/23/17.
 *
 */

fun Bitmap.addCenterImage(centerImage: Bitmap): Bitmap {
    val resultBitmap = Bitmap.createBitmap(this.width, this.height, this.config)
    val canvas = Canvas(resultBitmap)
    canvas.drawBitmap(this, Matrix(), null)
    canvas.drawBitmap(
            centerImage,
            (this.width - centerImage.width) / 2F,
            (this.height - centerImage.height) / 2F,
            Paint())
    return resultBitmap
}

fun Bitmap.addViewCenter(centerImage: View, size: Int) : Bitmap {
    val centerImageBitmap = createBitmapFromView(centerImage, size)
    return this.addCenterImage(centerImageBitmap)
}

fun createBitmapFromView(v: View, size: Int): Bitmap {
    v.measure(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.EXACTLY))
    v.layout(0, 0, v.measuredWidth, v.measuredHeight)
    val bitmap = Bitmap.createBitmap(v.measuredWidth,
            v.measuredHeight,
            Bitmap.Config.ARGB_8888)
    val c = Canvas(bitmap)
    v.layout(v.left, v.top, v.right, v.bottom)
    v.draw(c)
    return bitmap
}