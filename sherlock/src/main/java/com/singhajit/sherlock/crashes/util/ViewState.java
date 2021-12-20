package com.singhajit.sherlock.crashes.util;

import ohos.agp.components.Component;

public class ViewState {

    private final int visibility;

    private ViewState(int visibility) {
    this.visibility = visibility;
  }

    public int getVisibility() {
    return visibility;
  }

    public static class Builder {
        private boolean isVisible;

        public Builder withVisible(boolean isVisible) {
            this.isVisible = isVisible;
            return this;
        }

        public ViewState build() {
      return new ViewState(isVisible ? Component.VISIBLE : Component.HIDE);
    }
    }
}
