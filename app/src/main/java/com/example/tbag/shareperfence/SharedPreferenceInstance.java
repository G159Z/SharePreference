package com.example.tbag.shareperfence;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by tbag on 2017/1/13.
 */

public class SharedPreferenceInstance {
  private static final Uri uri = Uri.parse(SPProvider.URI);
  private static Context context;
  private String fileName;

  private SharedPreferenceInstance() {

  }

  public SharedPreferenceInstance(Context context,String fileName) {
    this.fileName = fileName;
    this.context  = context.getApplicationContext();
  }

  public static SharedPreferenceInstance getInstance(String fileName,Context context) {
    if (TextUtils.isEmpty(fileName)) {
      return null;
    }
    return new SharedPreferenceInstance(context,fileName);
  }
  
  
  public void applyBoolean(String key, boolean value) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putBoolean(SPProvider.EXTRA_VALUE, value);
    context.getContentResolver().call(uri, SPProvider.METHOD_APPLY_BOOLEAN, fileName, data);
  }

  public void applyFloat(String key, float value) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putFloat(SPProvider.EXTRA_VALUE, value);
    context.getContentResolver().call(uri, SPProvider.METHOD_APPLY_FLOAT, fileName, data);
  }

  public void applyInt(String key, int value) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putInt(SPProvider.EXTRA_VALUE, value);
    context.getContentResolver().call(uri, SPProvider.METHOD_APPLY_INT, fileName, data);
  }

  public void applyLong(String key, long value) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putLong(SPProvider.EXTRA_VALUE, value);
    context.getContentResolver().call(uri, SPProvider.METHOD_APPLY_LONG, fileName, data);
  }

  public void applyString(String key, String value) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putString(SPProvider.EXTRA_VALUE, value);
    context.getContentResolver().call(uri, SPProvider.METHOD_APPLY_STRING, fileName, data);
  }

  public void remove(String key) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    context.getContentResolver().call(uri, SPProvider.METHOD_REMOVE_KEY, fileName, data);
  }

  public boolean contains(String key) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_CONTAIN_KEY, fileName, data)
        .getBoolean(SPProvider.EXTRA_VALUE);
  }

  public boolean getBoolean(String key, boolean defValue) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putBoolean(SPProvider.EXTRA_DEFAULT_VALUE, defValue);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_GET_BOOLEAN, fileName, data)
        .getBoolean(SPProvider.EXTRA_VALUE);
  }

  public float getFloat(String key, float defValue) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putFloat(SPProvider.EXTRA_DEFAULT_VALUE, defValue);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_GET_FLOAT, fileName, data)
        .getFloat(SPProvider.EXTRA_VALUE);
  }

  public int getInt(String key, int defValue) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putInt(SPProvider.EXTRA_DEFAULT_VALUE, defValue);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_GET_INT, fileName, data)
        .getInt(SPProvider.EXTRA_VALUE);
  }

  public long getLong(String key, long defValue) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putLong(SPProvider.EXTRA_DEFAULT_VALUE, defValue);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_GET_LONG, fileName, data)
        .getLong(SPProvider.EXTRA_VALUE);
  }

  public String getString(String key, String defValue) {
    Bundle data = new Bundle();
    data.putString(SPProvider.EXTRA_KEY, key);
    data.putString(SPProvider.EXTRA_DEFAULT_VALUE, defValue);
    return context.getContentResolver()
        .call(uri, SPProvider.METHOD_GET_STRING, fileName, data)
        .getString(SPProvider.EXTRA_VALUE);
  }
}
