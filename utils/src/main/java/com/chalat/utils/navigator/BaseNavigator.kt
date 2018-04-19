package com.chalat.utils.navigator

/**
 * Handles navigation between Activities in the app.
 */
interface BaseNavigator {

    /**
     * Start an Activity
     * @param cls   the Activity class to be opened.
     */
    fun startActivity(cls: Class<*>)

    fun startActivityThenFinish(cls: Class<*>)

    fun startActivityWithExtraThenFinish(cls: Class<*>, extraKey: String, extraValue: String)

    fun startActivityWithExtra(cls: Class<*>, extraKey: String, extraValue: Any)

    fun startActivityWithExtras(cls: Class<*>, hashMap: HashMap<String, *>)

    /**
     * Start an Activity and clear other activity
     * @param cls   the Activity class to be opened.
     */
    fun startActivityAndClearAllActivity(cls: Class<*>)

    /**
     * Finish an Activity
     */
    fun finishActivity()

    /**
     * Finish an Activity with a result.
     *
     * @param resultCode the result code to be set when finishing the Activity.
     */
    fun finishActivityWithResult(resultCode: Int)

    /**
     * Start a new Activity for a result.
     *
     * @param cls         the Activity class to be opened.
     * @param requestCode the request code that will be passed to the opened Activity.
     */
    fun startActivityForResult(cls: Class<*>, requestCode: Int)

    /**
     * Start a new Activity for a result with an extra
     *
     * @param cls        the Activity class to be opened.
     * @param requestCode the request code that will be passed to the opened Activity.
     * @param extraKey   the key for the extra that is passed in the Intent.
     * @param extraValue the value for the extra the is passed in the Intent.
     */
    fun startActivityForResultWithExtra(cls: Class<*>,
                                        requestCode: Int,
                                        extraKey: String,
                                        extraValue: String)

    fun callWithTelephoneNumber(selectedTelephoneNumber: String?)
}