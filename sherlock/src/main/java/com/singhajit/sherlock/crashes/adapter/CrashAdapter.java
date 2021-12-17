package com.singhajit.sherlock.crashes.adapter;

import com.example.sherlock.ResourceTable;
import com.singhajit.sherlock.core.investigation.CrashViewModel;
import com.singhajit.sherlock.crashes.presenter.CrashListPresenter;
import com.singhajit.sherlock.crashes.viewmodel.AppInfoRowViewModel;
import ohos.agp.components.BaseItemProvider;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;
import ohos.agp.render.layoutboost.LayoutBoost;
import ohos.app.Context;

import java.util.List;

public class CrashAdapter extends BaseItemProvider {
  private final List<CrashViewModel> crashes;
  private final CrashListPresenter presenter;
  private Context adapterContext;

  public CrashAdapter(List<CrashViewModel> crashes, CrashListPresenter presenter, Context context) {
    this.crashes = crashes;
    this.presenter = presenter;
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
  public Component getComponent(int pos, Component component, ComponentContainer componentContainer) {

    component = LayoutBoost.inflate(adapterContext, ResourceTable.Layout_crash_card,componentContainer,false);

    render(crashes.get(pos), presenter, component);


    return component;
  }

  void render(final CrashViewModel crashViewModel, final CrashListPresenter presenter, Component componentContainer) {

    Text crashPlace = (Text) componentContainer.findComponentById(ResourceTable.Id_crash_place);
    Text crashDate = (Text) componentContainer.findComponentById(ResourceTable.Id_crash_date);

    crashPlace.setText(crashViewModel.getPlace());
    crashDate.setText(crashViewModel.getDate());
    componentContainer.findComponentById(ResourceTable.Id_crash_card_view).setClickedListener(new Component.ClickedListener() {
      @Override
      public void onClick(Component component) {
        presenter.onCrashClicked(crashViewModel);
      }
    });
  }
}
