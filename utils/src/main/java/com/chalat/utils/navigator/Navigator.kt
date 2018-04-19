package com.chalat.utils.navigator

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import java.lang.ref.WeakReference

/**
 * Implementation of the [BaseNavigator].
 */
class Navigator(activity: Activity) : BaseNavigator {

    private val activity: WeakReference<Activity> = WeakReference(activity)

    override fun startActivity(cls: Class<*>) {
        val intent = Intent(activity.get(), cls)
        activity.get()?.startActivity(intent)
    }

    override fun finishActivity() {
        activity.get()?.finish()
    }

    override fun startActivityThenFinish(cls: Class<*>) {
        startActivity(cls)
        finishActivity()
    }

    override fun startActivityWithExtraThenFinish(cls: Class<*>,
                                                  extraKey: String,
                                                  extraValue: String) {
        startActivityWithExtra(cls, extraKey, extraValue)
        finishActivity()
    }

    override fun startActivityAndClearAllActivity(cls: Class<*>) {
        val intent = Intent(activity.get(), cls)
        activity.get()?.startActivity(intent)
        activity.get()?.finishAffinity()
    }

    override fun finishActivityWithResult(resultCode: Int) {
        activity.get()?.setResult(resultCode)
        activity.get()?.finish()
    }

    override fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        val intent = Intent(activity.get(), cls)
        activity.get()?.startActivityForResult(intent, requestCode)
    }

    override fun startActivityForResultWithExtra(cls: Class<*>,
                                                 requestCode: Int,
                                                 extraKey: String,
                                                 extraValue: String) {
        val intent = Intent(activity.get(), cls)
        intent.putExtra(extraKey, extraValue)
        activity.get()?.startActivityForResult(intent, requestCode)
    }

    override fun startActivityWithExtra(cls: Class<*>, extraKey: String, extraValue: Any) {
        val intent = Intent(activity.get(), cls)
        intent.putExtra(extraKey, extraValue)
        activity.get()?.startActivity(intent)
    }

    override fun startActivityWithExtras(cls: Class<*>, hashMap: HashMap<String, *>) {
        val intent = Intent(activity.get(), cls)
        hashMap.forEach { intent.putExtra(it.key, it.value) }
        activity.get()?.startActivity(intent)
    }


    @SuppressLint("MissingPermission")
    override fun callWithTelephoneNumber(selectedTelephoneNumber: String?) {
        val uri = "tel:" + selectedTelephoneNumber?.trim()
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse(uri)
        activity.get()?.startActivity(intent)
    }

}
