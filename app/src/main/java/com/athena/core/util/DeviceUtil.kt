package com.athena.core.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import com.athena.core.common.entity.FingerprintStatus

object DeviceUtil {

    fun getDeviceId(context: Context): String =
        Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)

    fun getDeviceManufacturer(): String = Build.MANUFACTURER

    fun getDeviceModel(): String = Build.MANUFACTURER + " " + Build.MODEL

    fun getDeviceVersionCode(): String = Build.VERSION.RELEASE

    fun getDeviceVersionName(): String = Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name

    /**
     * @return -2: Android SDK < 23. Not supported.
     * @return -1: Device does not support fingerprint
     * @return  0: User hasn't enrolled any fingerprints to authenticate with
     * @return  1: Everything is ready for fingerprint authentication
     */
    @SuppressLint("MissingPermission")
    fun getFingerprintStatus(context: Context): FingerprintStatus {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return FingerprintStatus.SDK_NOT_SUPPORTED

        val fingerprintManager =
            context.getSystemService(Context.FINGERPRINT_SERVICE) ?: return FingerprintStatus.DEVICE_NOT_SUPPORTED

        val fingerprintManagerCompat = FingerprintManagerCompat.from(context)

        if (!fingerprintManagerCompat.isHardwareDetected) return FingerprintStatus.DEVICE_NOT_SUPPORTED

        if (!fingerprintManagerCompat.hasEnrolledFingerprints()) return FingerprintStatus.NO_FINGERPRINT_AUTHENTICATION

        return FingerprintStatus.OK
    }

    fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
        var found = true

        try {
            packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            found = false
        }

        return found
    }
}