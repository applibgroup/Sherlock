package com.singhajit.sherlock.core.investigation;



import com.singhajit.sherlock.util.AppInfoUtil;
import ohos.app.Context;

public class DefaultAppInfoProvider implements AppInfoProvider {
    private final Context context;

    public DefaultAppInfoProvider(Context context) {
    this.context = context;
  }

    @Override
    public AppInfo getAppInfo() {
        return new AppInfo.Builder()
            .with("Version", AppInfoUtil.getAppVersion(context))
            .build();
  }
}
