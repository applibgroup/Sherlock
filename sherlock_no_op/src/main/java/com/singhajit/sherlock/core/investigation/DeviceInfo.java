package com.singhajit.sherlock.core.investigation;

public class DeviceInfo {

    private DeviceInfo() {
    }

    public String getManufacturer() {
        return "";
    }

    public String getBrand() {
        return "";
    }

    public String getName() {
        return "";
    }

    public String getSdk() {
        return "";
    }

    public static class Builder {

        public Builder withBrand() {
            return this;
        }

        public Builder withSDK() {
            return this;
        }

        public Builder withModel() {
            return this;
        }

        public Builder withManufacturer() {
            return this;
        }

        public DeviceInfo build() {
            return new DeviceInfo();
        }
    }
}
