package com.chalat.utils.string

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 *
 * Created by Chalat Chansima on 11/28/17.
 *
 */
object StringUtils {

    internal fun constructFullName(firstName: String?, lastName: String?): String {
        return appendStringWithSeparator(listOf(firstName, lastName), " ")
    }

    fun appendStringWithSeparator(strings: List<String?>, separator: String): String {
        return strings
                .filterNotNull()
                .reduce { sum, element -> sum + separator + element }
    }

    fun removeSpecialCharacters(string: String): String {
        val re = ("[^A-Za-z0-9 ]").toRegex()
        return re.replace(string, "")
    }

    internal fun concatString(strings: List<String?>): String {
        return strings
                .filterNotNull()
                .reduce { sum, element -> sum + element }
    }

    @SuppressLint("NewApi")
    fun getSpannedFromString(string: String?): Spanned? {
        val isAndroidNorNewer =
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
        return if (isAndroidNorNewer) {
            Html.fromHtml(string, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(string)
        }
    }

    fun embedLinkToString(fileName: String, url: String): String {
        return "<a href=\"$url\">$fileName<a>"
    }

}