package com.singhajit.sherlock.crashes.viewmodel;

import com.singhajit.sherlock.core.investigation.AppInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppInfoViewModel {
    private final ArrayList<AppInfoRowViewModel> appInfoRowViewModels;

    public AppInfoViewModel(AppInfo appInfo) {
        Map<String, String> appDetails = appInfo.getAppDetails();
        appInfoRowViewModels = toAppInfoRowViewModels(appDetails);
    }

    private ArrayList<AppInfoRowViewModel> toAppInfoRowViewModels(Map<String, String> appDetails) {
        ArrayList<AppInfoRowViewModel> viewModels = new ArrayList<>();
        for (String key : appDetails.keySet()) {
            viewModels.add(new AppInfoRowViewModel(key, appDetails.get(key)));
        }
        return viewModels;
    }

    public String getDetails() {
        StringBuilder builder = new StringBuilder();
        for (AppInfoRowViewModel appRowViewModel : appInfoRowViewModels) {
            builder.append(appRowViewModel.getAttr()).append(": ").append(appRowViewModel.getVal()).append("\n");
        }

        return builder.toString();
    }

    public List<AppInfoRowViewModel> getAppInfoRowViewModels() {
        return appInfoRowViewModels;
    }
}
