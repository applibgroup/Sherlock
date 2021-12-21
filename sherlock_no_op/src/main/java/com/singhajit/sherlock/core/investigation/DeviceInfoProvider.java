package com.singhajit.sherlock.core.investigation;

public class DeviceInfoProvider {

    private DeviceInfoProvider() {

    }

    public static DeviceInfo getDeviceInfo() {
        return new DeviceInfo.Builder().build();
    }
}
