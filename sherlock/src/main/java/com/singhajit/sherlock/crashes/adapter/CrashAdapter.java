package com.singhajit.sherlock.crashes.adapter;

import ohos.agp.components.BaseItemProvider;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;
import ohos.agp.render.layoutboost.LayoutBoost;
import ohos.app.Context;
import com.example.sherlock.ResourceTable;
import com.singhajit.sherlock.core.investigation.CrashViewModel;
import com.singhajit.sherlock.crashes.presenter.CrashListPresenter;

import java.util.List;

/**
 * CrashAdapter.
 */
public class CrashAdapter extends BaseItemProvider {
    /**
     * crashes.
     */
    private final List<CrashViewModel> crashes;
    /**
     * presenter.
     */
    private final CrashListPresenter presenter;
    /**
     * adaptercontext.
     */
    private Context adapContext;

    /**
     * CrashAdapter constructor.
     *
     * @param crashes crashes
     *
     * @param presenter presenter
     *
     * @param context context
     */
    public CrashAdapter(List<CrashViewModel> crashes, CrashListPresenter presenter, Context context) {
        this.crashes = crashes;
        this.presenter = presenter;
        this.adapContext = context;
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
        Component view = LayoutBoost.inflate(adapContext, ResourceTable.Layout_crash_card, componentContainer, false);
        render(crashes.get(pos), presenter, view);
        return view;
    }

    /**
     * render.
     *
     * @param crashViewModel crashviewmodel
     *
     * @param presenter presenter
     *
     * @param componentContainer container
     */
    public void render(final CrashViewModel crashViewModel, final CrashListPresenter presenter, Component componentContainer) {
        Text crashPlace = (Text) componentContainer.findComponentById(ResourceTable.Id_crash_place);
        Text crashDate = (Text) componentContainer.findComponentById(ResourceTable.Id_crash_date);
        crashPlace.setText(crashViewModel.getPlace());
        crashDate.setText(crashViewModel.getDate());
        componentContainer.findComponentById(ResourceTable.Id_crash_card_view).setClickedListener(component ->
                presenter.onCrashClicked(crashViewModel));
    }
}
