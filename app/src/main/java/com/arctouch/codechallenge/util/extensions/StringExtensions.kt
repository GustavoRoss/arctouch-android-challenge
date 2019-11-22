package com.arctouch.codechallenge.util.extensions

import java.text.Normalizer
import java.util.*

private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

fun String.normalize(): String {
    val locale = Locale.getDefault()

    val normalizer = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(normalizer, "").toLowerCase(locale)
}
