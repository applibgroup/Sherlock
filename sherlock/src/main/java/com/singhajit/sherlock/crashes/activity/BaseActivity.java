package com.singhajit.sherlock.crashes.activity;

import com.example.sherlock.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class BaseActivity extends AbilitySlice {

  @Override
  protected void onStart(Intent intent) {
    super.onStart(intent);
  }

//  protected void enableHomeButton(Toolbar toolbar) {
//    setSupportActionBar(toolbar);
//    getSupportActionBar().setHomeButtonEnabled(true);
//    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//  }

//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    if (item.getItemId() == android.R.id.home) {
//      onBackPressed();
//      return true;
//    }
//    return super.onOptionsItemSelected(item);
//  }
}
