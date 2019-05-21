package com.athena.core.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.athena.core.common.entity.ConnectionStatus


object ConnectionUtil {

    @SuppressLint("MissingPermission")
    fun getConnectionStatus(context: Context): ConnectionStatus {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo

        if (!activeNetwork?.isConnected!!) return ConnectionStatus.NOT_CONNECTED

        when (activeNetwork.type) {
            ConnectivityManager.TYPE_WIFI -> return ConnectionStatus.WIFI
            ConnectivityManager.TYPE_MOBILE -> return ConnectionStatus.CELLULAR
        }

        return ConnectionStatus.NOT_CONNECTED
    }
}