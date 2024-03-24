package com.example.marvelapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.marvelapp.utils.Constants.Companion.PRIVATE_KEY
import com.example.marvelapp.utils.Constants.Companion.PUBLIC_KEY
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

class GeneratorMD5 {

    companion object {

        fun convertToHttps(url: String): String {
            return if (url.startsWith("https://")) {
                url
            } else if (url.startsWith("http://")) {
                url.replace("http://", "https://")
            } else {
                "https://$url"
            }
        }


        fun createHash(): Map<String, String> {
            val tsCode = "10:00:20";
            val textToMD5 = tsCode + PRIVATE_KEY + PUBLIC_KEY;
            val md = MessageDigest.getInstance("MD5")
            val md5Hash = BigInteger(1, md.digest(textToMD5.toByteArray())).toString(16).padStart(32, '0')
            return mapOf(
                "code" to tsCode,
                "hash" to md5Hash
            )
        }
    }
}