package assignment.demoapplication.com.mvvmarchitecture.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

val DD_MMMM_format = "dd MMMM"
val DD_MMMM_YYYY_format = "dd MMMM yyyy"
@SuppressLint("SimpleDateFormat")
fun getDateFromLong(dateInMillis: Long, format: String) :String{
    val formatter : SimpleDateFormat = SimpleDateFormat(format)
    return "01 January".takeIf { dateInMillis == null } ?: formatter.format( Date(dateInMillis))
}