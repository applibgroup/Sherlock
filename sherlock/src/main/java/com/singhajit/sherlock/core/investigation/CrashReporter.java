package com.singhajit.sherlock.core.investigation;

import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.app.Context;
import ohos.event.intentagent.IntentAgent;
import ohos.event.intentagent.IntentAgentConstant;
import ohos.event.intentagent.IntentAgentHelper;
import ohos.event.intentagent.IntentAgentInfo;
import ohos.event.notification.NotificationHelper;
import ohos.event.notification.NotificationRequest;
import ohos.rpc.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrashReporter {
    /**
     * context.
     */
    private final Context context;

    /**
     * constructor.
     *
     * @param context context
     */
    public CrashReporter(Context context) {
        this.context = context;
    }

    /**
     * creates a notification.
     *
     * @param throwable throwable
     */
    public void reportCollection(Throwable throwable) {
        NotificationRequest notification = new NotificationRequest();
        NotificationRequest.NotificationNormalContent content = new NotificationRequest.NotificationNormalContent();
        content.setTitle(context.getBundleName());
        content.setText(throwable.getMessage() + "\n" + new Date().toString());
        NotificationRequest.NotificationContent notificationContent = new NotificationRequest
                .NotificationContent(content);
        notification.setTapDismissed(true);
        notification.setContent(notificationContent);
        notification.setIntentAgent(getLaunchAction(throwable));
        try {
            NotificationHelper.publishNotification(notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * intent to particular screen.
     */
    private IntentAgent getLaunchAction(Throwable ex) {
        Operation operation = new Intent.OperationBuilder().withDeviceId("").withBundleName(context.getBundleName())
                .withAbilityName("com.singhajit.sherlock.crashes.activity.CrashActivity").build();
        Intent intent = new Intent();
        intent.setParam("crash", ex);
        intent.setOperation(operation);
        List<Intent> intentList = new ArrayList<>();
        intentList.add(intent);
        List<IntentAgentConstant.Flags> flags = new ArrayList<>();
        flags.add(IntentAgentConstant.Flags.UPDATE_PRESENT_FLAG);
        IntentAgentInfo params = new IntentAgentInfo(90, IntentAgentConstant.OperationType.START_ABILITY, flags,
                intentList, null);
        return IntentAgentHelper.getIntentAgent(context, params);
    }

}