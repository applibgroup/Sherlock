package com.singhajit.sherlock.core;

import com.singhajit.sherlock.core.investigation.AppInfo;
import com.singhajit.sherlock.core.investigation.AppInfoProvider;
import com.singhajit.sherlock.core.investigation.Crash;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

public class Sherlock {
    public static void init() {
    }

    public static boolean isInitialized() {
        return false;
    }

    public static Sherlock getInstance() {
        return new Sherlock();
    }

    public List<Crash> getAllCrashes() {
        return new ArrayList<>();
    }

    public static void setAppInfoProvider() {
    }

    public AppInfoProvider getAppInfoProvider() {
        return () -> new AppInfo();
    }
}
