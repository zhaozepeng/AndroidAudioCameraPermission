package com.android.audiocamerapermission;

import android.content.Context;
import android.hardware.Camera;

/**
 * Description:
 *
 * @author zhaozp
 * @since 2016-08-12
 */
public class CameraPermissionCheckUtils {
    private static final String TAG = "CameraPermissionCheckUtils";

    public static boolean checkCameraPermission(Context context) {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open(0);
            mCamera.setDisplayOrientation(90);
        } catch (Exception e) {
            canUse = false;
        }
        if (canUse) {
            mCamera.release();
            mCamera = null;
        }
        return canUse;
    }
}
