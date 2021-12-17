package com.singhajit.sherlock.crashes.activity;

import com.example.sherlock.ResourceTable;

import com.singhajit.sherlock.core.investigation.CrashViewModel;
import com.singhajit.sherlock.crashes.action.CrashActions;
import com.singhajit.sherlock.crashes.adapter.AppInfoAdapter;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoViewModel;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.DirectionalLayoutManager;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CrashActivity extends Ability implements CrashActions {

    public static final String CRASH_ID = "com.singhajit.sherlock.CRASH_ID";

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_crash_activity);
        Intent dataIntent = getIntent();
        if (null != dataIntent) {
            Throwable throwable = dataIntent.getSerializableParam("crash");
            StringWriter errors = new StringWriter();
            throwable.printStackTrace(new PrintWriter(errors));
            Text text = (Text) findComponentById(ResourceTable.Id_crash);
            text.setText(errors.toString());
        }

    }

    @Override
    public void render(CrashViewModel viewModel) {
        Text crashLocation = (Text) findComponentById(ResourceTable.Id_crash_location);
        Text crashReason = (Text) findComponentById(ResourceTable.Id_crash_reason);
        Text stackTrace = (Text) findComponentById(ResourceTable.Id_activity_main);

        crashLocation.setText(viewModel.getExactLocationOfCrash());
        crashReason.setText(viewModel.getReasonOfCrash());
        stackTrace.setText(viewModel.getStackTrace());

        renderDeviceInfo(viewModel);
    }

    @Override
    public void openSendApplicationChooser(String crashDetails) {
        Intent share = new Intent();
        share.setType("text/plain");
        share.setParam(Intent.ACTION_TRANSLATE_TEXT, crashDetails);
        startAbility(Intent.createSelectIntent(share, "Share Crash Using"));
    }

    @Override
    public void renderAppInfo(AppInfoViewModel viewModel) {
        ListContainer appInfoDetails = (ListContainer) findComponentById(ResourceTable.Id_app_info_details);
        appInfoDetails.setItemProvider(new AppInfoAdapter(viewModel, this));
        appInfoDetails.setLayoutManager(new DirectionalLayoutManager());
    }

    private void renderDeviceInfo(CrashViewModel viewModel) {
        Text deviceName = (Text) findComponentById(ResourceTable.Id_crash_reason);
        Text deviceBrand = (Text) findComponentById(ResourceTable.Id_crash_reason);
        Text deviceAndroidVersion = (Text) findComponentById(ResourceTable.Id_crash_reason);

        deviceName.setText(viewModel.getDeviceName());
        deviceBrand.setText(viewModel.getDeviceBrand());
        deviceAndroidVersion.setText(viewModel.getDeviceAndroidApiVersion());
    }
}
