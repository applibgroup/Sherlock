package com.singhajit.sherlock.core.investigation;



public class DeviceInfoProvider {

  public static DeviceInfo getDeviceInfo() {

    return new DeviceInfo.Builder()
        .withManufacturer(new ohos.distributedhardware.devicemanager.DeviceInfo().getDeviceName())
        .withModel(ohos.system.DeviceInfo.getModel())
        .withBrand(ohos.system.DeviceInfo.getName())
        .withSDK(ohos.system.DeviceInfo.getDeviceType())
        .build();
  }

}
