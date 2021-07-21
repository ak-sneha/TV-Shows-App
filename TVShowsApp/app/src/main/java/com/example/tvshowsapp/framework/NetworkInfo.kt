package com.example.tvshowsapp.framework

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService


class NetworkInfo {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            return connectivityManager?.activeNetworkInfo?.isConnected ?: false
        }
    }
}