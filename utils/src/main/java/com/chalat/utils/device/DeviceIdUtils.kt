package com.chalat.utils.device

import android.content.Context
import android.content.Context.MODE_PRIVATE
import java.util.*

/**
 *
 * Created by Chalat Chansima on 4/11/18.
 *
 */
class DeviceIdUtils(private val context: Context){

    fun getDeviceId(): String {
        val sharedPreferences = context.getSharedPreferences(PREF_DEVICE_ID, MODE_PRIVATE)
        var deviceId = sharedPreferences.getString(DEVICE_ID_KEY, "")
        if (deviceId.isNullOrBlank()) {
            deviceId = UUID.randomUUID().toString()
            sharedPreferences.edit()
                    .putString(DEVICE_ID_KEY, deviceId)
                    .apply()
        }
        return deviceId
    }

    companion object {
        const val PREF_DEVICE_ID = "com.chalat.utils.PREF_DEVICE_ID"
        const val DEVICE_ID_KEY = "com.chalat.utils.DEVICE_ID_KEY"
    }

}