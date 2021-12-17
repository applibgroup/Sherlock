package com.singhajit.sherlock.util;


import ohos.app.Context;
import ohos.rpc.RemoteException;

public class AppInfoUtil {
  public static String getAppVersion(Context context) {
    try {
      return context.getBundleManager().getBundleInfo(context.getBundleName(),0).getVersionName();
//      return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    } catch (RemoteException e) {
      return "Not Found";
    }
  }
}
