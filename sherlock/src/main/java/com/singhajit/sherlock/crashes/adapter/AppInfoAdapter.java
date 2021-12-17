package com.singhajit.sherlock.crashes.adapter;

import com.example.sherlock.ResourceTable;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoRowViewModel;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoViewModel;
import ohos.agp.components.*;
import ohos.agp.render.layoutboost.LayoutBoost;
import ohos.app.Context;

import java.util.List;

public class AppInfoAdapter extends BaseItemProvider {
  private final List<AppInfoRowViewModel> appInfoViewModels;
  private Context adapterContext;

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

    component = LayoutBoost.inflate(adapterContext, ResourceTable.Layout_app_info_row,componentContainer,false);
    render(appInfoViewModels.get(position), component);
    return component;
  }

  void render(AppInfoRowViewModel appInfoViewModel, Component componentContainer) {

    Text appInfoAttr = (Text) componentContainer.findComponentById(ResourceTable.Id_app_info_attr);
    Text appInfoVal = (Text) componentContainer.findComponentById(ResourceTable.Id_app_info_val);

    appInfoAttr.setText(appInfoViewModel.getAttr());
    appInfoVal.setText(appInfoViewModel.getVal());

  }

}


