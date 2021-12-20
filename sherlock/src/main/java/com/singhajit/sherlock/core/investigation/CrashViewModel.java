package com.singhajit.sherlock.core.investigation;

import com.singhajit.sherlock.crashes.viewmodel.AppInfoViewModel;
import java.text.SimpleDateFormat;

public class CrashViewModel {
  private Crash crash;
  private AppInfoViewModel appInfoViewModel;

  public CrashViewModel() {
  }

  public CrashViewModel(Crash crash) {
    System.out.println("VIJAY CRASH is there "+ crash);
    populate(crash);
  }

  public String getPlace() {

      String[] placeTrail = crash.getPlace().split("\\.");
      return placeTrail[placeTrail.length - 1];

  }

  public String getExactLocationOfCrash() {

        return crash.getPlace();
  }

  public String getReasonOfCrash() {
    return crash.getReason();

  }

  public String getStackTrace() {
    return crash.getStackTrace();

  }

  public String getCrashInfo() {

      String crashInfo = "Device Info:\n" +
              "Name: " +
              getDeviceName() + "\n" +
              "Brand: " +
              getDeviceBrand() + "\n" +
              "Android API: " +
              getDeviceAndroidApiVersion() + "\n\n" +
              "App Info:\n" +
              getAppInfoViewModel().getDetails() +
              "\n" +
              "StackTrace:\n" +
              getStackTrace() + "\n";
      return crashInfo;


  }

  public String getDeviceManufacturer() {
    return crash.getDeviceInfo().getManufacturer();

  }

  public String getDeviceName() {
    return crash.getDeviceInfo().getName();

  }

  public String getDeviceAndroidApiVersion() {
    return crash.getDeviceInfo().getSdk();

  }

  public String getDeviceBrand() {
     return crash.getDeviceInfo().getBrand();

  }

  public AppInfoViewModel getAppInfoViewModel() {
    return appInfoViewModel;
  }

  public int getIdentifier() {
    return crash.getId();

  }

  public String getDate() {

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a EEE, MMM d, yyyy");
      return simpleDateFormat.format(crash.getDate());

  }

  public void populate(Crash crash) {
    this.crash = crash;
    this.appInfoViewModel = new AppInfoViewModel(crash.getAppInfo());
  }

}
