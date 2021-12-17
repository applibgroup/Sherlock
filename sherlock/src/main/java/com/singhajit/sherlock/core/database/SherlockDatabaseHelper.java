package com.singhajit.sherlock.core.database;

import com.singhajit.sherlock.core.investigation.Crash;
import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.rdb.*;
import ohos.data.resultset.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SherlockDatabaseHelper extends RdbOpenCallback {

  private static final int VERSION = 2;
  private static final String DB_NAME = "Sherlock";
  RdbStore hmosRdbStore;
  DatabaseHelper hmosDatabaseHelper;


  public SherlockDatabaseHelper(Context context) {
    super();
    StoreConfig config = StoreConfig.newDefaultConfig(DB_NAME);
    hmosDatabaseHelper = new DatabaseHelper(context);
    hmosRdbStore = hmosDatabaseHelper.getRdbStore(config, VERSION, this, null);
  }

  public List<Crash> getCrashes() {
    ArrayList<Crash> crashes = new ArrayList<>();
    ResultSet resultSet = hmosRdbStore.querySql(CrashTable.SELECT_ALL, null);
    if (isCursorPopulated(resultSet)) {
      do {
        crashes.add(toCrash(resultSet));
      } while (resultSet.goToFirstRow());
    }

    resultSet.close();
    hmosRdbStore.close();

    return crashes;
  }

  public int insertCrash(CrashRecord crashRecord) {
    ValuesBucket valuesBucket = new ValuesBucket();
    valuesBucket.putString(CrashTable.PLACE,crashRecord.getPlace());
    valuesBucket.putString(CrashTable.REASON,crashRecord.getReason());
    valuesBucket.putString(CrashTable.STACKTRACE,crashRecord.getStackTrace());
    valuesBucket.putString(CrashTable.DATE,crashRecord.getDate());

    long id = hmosRdbStore.insert(CrashTable.TABLE_NAME, valuesBucket);
    hmosRdbStore.close();

    return Long.valueOf(id).intValue();
  }

  public Crash getCrashById(int id) {

    ResultSet resultSet = hmosRdbStore.querySql(CrashTable.selectById(id), null);
    Crash crash = null;

    if (isCursorPopulated(resultSet)) {
      crash = toCrash(resultSet);
      resultSet.close();
      hmosRdbStore.close();
    }

    return crash;
  }

  private Crash toCrash(ResultSet cursor) {
    int id = cursor.getInt(cursor.getColumnIndexForName(CrashTable.ID));
    String placeOfCrash = cursor.getString(cursor.getColumnIndexForName(CrashTable.PLACE));
    String reasonOfCrash = cursor.getString(cursor.getColumnIndexForName(CrashTable.REASON));
    String stacktrace = cursor.getString(cursor.getColumnIndexForName(CrashTable.STACKTRACE));
    String date = cursor.getString(cursor.getColumnIndexForName(CrashTable.DATE));
    return new Crash(id, placeOfCrash, reasonOfCrash, stacktrace, date);
  }

  private boolean isCursorPopulated(ResultSet cursor) {
    return cursor != null && cursor.goToFirstRow();
  }

  @Override
  public void onCreate(RdbStore rdbStore) {
    rdbStore.executeSql(CrashTable.CREATE_QUERY);
  }

  @Override
  public void onUpgrade(RdbStore rdbStore, int i, int i1) {
    rdbStore.executeSql(CrashTable.DROP_QUERY);
    rdbStore.executeSql(CrashTable.CREATE_QUERY);
  }


}
