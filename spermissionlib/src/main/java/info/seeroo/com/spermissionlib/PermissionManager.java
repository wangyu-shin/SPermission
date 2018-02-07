package info.seeroo.com.spermissionlib;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by seeroo_dev on 2018. 2. 6..
 */

public class PermissionManager {
    private static final String TAG = PermissionManager.class.getSimpleName();
    private static PermissionManager mInstance = null;

    PermissionManager(){

    }

    public static synchronized PermissionManager getInstance(){
        if(mInstance == null){
            mInstance = new PermissionManager();
        }

        return mInstance;
    }

    /**
     * 해당 권한
     * @param context
     * @param permission
     * @return true : 권한있음, false: 권한 없음
     */
    public boolean isCheckPermission(Context context, String permission){
        int chkRet = ContextCompat.checkSelfPermission(context, permission);
        return !(chkRet == PackageManager.PERMISSION_DENIED);
    }


    /**
     * 해당 권한이 필요한 이유를 설명해야 하는지 체크
     * @param activity
     * @param permissionName
     * @return
     */
    public static boolean isShouldShowRequestPermissionRationale(Activity activity, String permissionName){
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName);
    }


    /**
     * 해당 권한요청 팝업을 띄운다. -> 결과는 ActivityResult로 받는다.
     * @param activity
     * @param permissionList
     * @param requestCode
     */
    public void requestPermission(Activity activity, String[] permissionList, int requestCode){
        ActivityCompat.requestPermissions(activity, permissionList, requestCode);
    }

}
