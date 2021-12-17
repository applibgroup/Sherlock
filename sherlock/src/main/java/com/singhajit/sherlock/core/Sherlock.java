package com.singhajit.sherlock.core;

import com.singhajit.sherlock.core.database.SherlockDatabaseHelper;
import com.singhajit.sherlock.core.investigation.AppInfoProvider;
import com.singhajit.sherlock.core.investigation.CrashReporter;
import com.singhajit.sherlock.core.investigation.DefaultAppInfoProvider;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class Sherlock {
  private static final String TAG = Sherlock.class.getSimpleName();
  private static Sherlock instance;
  private final SherlockDatabaseHelper database;
  private final CrashReporter crashReporter;
  private AppInfoProvider appInfoProvider;
  /**
   * TYPE.
   */
  private static final int HILOG_TYPE = 3;
  /**
   * DOMAIN.
   */
  private static final int HILOG_DOMAIN = 0xD000F00;
  /**
   * LABEL.
   */
  private static final HiLogLabel LABEL = new HiLogLabel(HILOG_TYPE, HILOG_DOMAIN, TAG);

  private Sherlock(Context context) {
    database = new SherlockDatabaseHelper(context);
    crashReporter = new CrashReporter(context);
    appInfoProvider = new DefaultAppInfoProvider(context);
  }


  public static boolean isInitialized() {
    return instance != null;
  }

  public static Sherlock getInstance() {
    if (!isInitialized()) {
      throw new SherlockNotInitializedException();
    }
    HiLog.debug(LABEL,"Returning existing instance...");
    return instance;
  }

  public AppInfoProvider getAppInfoProvider() {
    return getInstance().appInfoProvider;
  }

  public static void init(final Context context){
    instance = new Sherlock(context);

    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread thread, Throwable ex) {
        instance.crashReporter.reportCollection(ex);
      }
    });

  }
}
