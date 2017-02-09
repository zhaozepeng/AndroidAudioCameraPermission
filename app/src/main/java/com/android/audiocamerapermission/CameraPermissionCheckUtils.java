package com.android.audiocamerapermission;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;

/**
 * Description:
 *
 * @author zhaozp
 * @since 2016-08-12
 */
public class CameraPermissionCheckUtils {
    private static final String TAG = "CameraPermissionCheckUt";

    public static boolean checkCameraPermission(Context context) {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open(0);
            mCamera.setDisplayOrientation(90);
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
            canUse = false;
        }
        if (canUse) {
            mCamera.release();
            mCamera = null;
        }
        return canUse;
    }
}
