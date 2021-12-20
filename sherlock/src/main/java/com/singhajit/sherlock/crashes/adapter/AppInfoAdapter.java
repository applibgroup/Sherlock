package com.singhajit.sherlock.crashes.adapter;

import ohos.agp.components.BaseItemProvider;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;
import ohos.agp.render.layoutboost.LayoutBoost;
import ohos.app.Context;
import com.example.sherlock.ResourceTable;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoRowViewModel;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoViewModel;

import java.util.List;

/**
 * AppInfoAdapter.
 */
public class AppInfoAdapter extends BaseItemProvider {
    /**
     * AppInfoViewModels.
     */
    private final List<AppInfoRowViewModel> appInfoViewModels;
    /**
     * AdapterContext.
     */
    final private Context adapterContext;

    /**
     * AppInfoAdapter constructor.
     */
    public AppInfoAdapter(AppInfoViewModel appInfoViewModel, Context context) {
        this.appInfoViewModels = appInfoViewModel.getAppInfoRowViewModels();
        this.adapterContext = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        Component view = LayoutBoost.inflate(adapterContext, ResourceTable.Layout_app_info_row, componentContainer, false);
        render(appInfoViewModels.get(position), view);
        return view;
    }

    public void render(AppInfoRowViewModel appInfoViewModel, Component componentContainer) {
        Text appInfoAttr = (Text) componentContainer.findComponentById(ResourceTable.Id_app_info_attr);
        Text appInfoVal = (Text) componentContainer.findComponentById(ResourceTable.Id_app_info_val);
        appInfoAttr.setText(appInfoViewModel.getAttr());
        appInfoVal.setText(appInfoViewModel.getVal());
    }
}


