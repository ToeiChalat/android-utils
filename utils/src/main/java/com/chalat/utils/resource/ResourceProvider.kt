package com.chalat.utils.resource

import android.content.Context
import android.support.annotation.StringRes

class ResourceProvider(private val context: Context) : BaseResourceProvider {

    override fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }

    override fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, *formatArgs)
    }
}