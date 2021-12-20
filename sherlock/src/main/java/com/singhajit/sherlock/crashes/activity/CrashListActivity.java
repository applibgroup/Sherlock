package com.singhajit.sherlock.crashes.activity;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayoutManager;
import ohos.agp.components.ListContainer;
import com.example.sherlock.ResourceTable;
import com.singhajit.sherlock.core.database.SherlockDatabaseHelper;
import com.singhajit.sherlock.crashes.action.CrashListActions;
import com.singhajit.sherlock.crashes.adapter.CrashAdapter;
import com.singhajit.sherlock.crashes.presenter.CrashListPresenter;
import com.singhajit.sherlock.crashes.viewmodel.CrashesViewModel;

/**
 * Crash list activity.
 */
public class CrashListActivity extends Ability implements CrashListActions {
    /**
     * Crash list presenter.
     */
    private CrashListPresenter presenter;

    /**
     * Crash list presenter.
     */
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_crash_list_activity);
        SherlockDatabaseHelper database = new SherlockDatabaseHelper(this);
        presenter = new CrashListPresenter(this);
        presenter.render(database);
    }

    @Override
    public void render(CrashesViewModel viewModel) {
        ListContainer crashList = (ListContainer) findComponentById(ResourceTable.Id_crash_list);
        CrashAdapter crashAdapter = new CrashAdapter(viewModel.getCrashViewModels(), presenter, this);
        crashList.setItemProvider(crashAdapter);
        crashList.setLayoutManager(new DirectionalLayoutManager());
        DirectionalLayout noCrashFoundLayout = (DirectionalLayout) findComponentById(ResourceTable.Id_no_crash);
        noCrashFoundLayout.setVisibility(viewModel.getCrashNotFoundViewState().getVisibility());
    }

    @Override
    public void openCrashDetails(int crashId) {
        Intent intent = new Intent();
        intent.setParam(CrashActivity.CRASH_ID, crashId);
        startAbility(intent);
    }
}
