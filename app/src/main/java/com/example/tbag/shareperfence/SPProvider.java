package com.example.tbag.shareperfence;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by tbag on 2017/1/13.
 */

public class SPProvider extends BaseProvider{
  //通过method来判断不同的方法 extra来获取参数 arg是否为空来判断是否需要new一个sp
  public static final String METHOD_APPLY_STRING = "0";
  public static final String METHOD_GET_STRING = "1";
  public static final String METHOD_PUT_STRING = "2";
  public static final String METHOD_APPLY_BOOLEAN = "3";
  public static final String METHOD_GET_BOOLEAN = "4";
  public static final String METHOD_REMOVE_KEY = "5";
  public static final String METHOD_APPLY_FLOAT = "6";
  public static final String METHOD_GET_FLOAT = "7";
  public static final String METHOD_APPLY_INT = "8";
  public static final String METHOD_GET_INT = "9";
  public static final String METHOD_APPLY_LONG = "10";
  public static final String METHOD_GET_LONG = "11";
  public static final String METHOD_CONTAIN_KEY = "12";

  private static final String AUTHORITY = "com.example.tbag.shareperfence.provider";
  private static final String SCHEME = "content://";
  public static final String URI = SCHEME + AUTHORITY; //provider对应的uri

  public static final String EXTRA_KEY = "key";
  public static final String EXTRA_VALUE = "value";
  public static final String EXTRA_DEFAULT_VALUE = "default_value";
  private static final String DEFAULT_SAVE_FILE = "public_default"; // public存储位置, 存储简单数据, 共享一个文件
  private SharedPreferences sharedPreferences;//主sp
  private int preferencesModel = Context.MODE_PRIVATE;

  @Override public boolean onCreate() {
    sharedPreferences = getNewSharePreferences(DEFAULT_SAVE_FILE);
    return false;
  }

  @Override public Bundle call(@NonNull String method, String arg, Bundle extras) {
    // 用于将数据返回给调用方，例如getString()、getBoolean()
    Bundle replyData = null;
    switch (method) {
      case METHOD_APPLY_STRING: {
        String key = extras.getString(EXTRA_KEY);
        String value = extras.getString(EXTRA_VALUE);
        // 将值存起来 - putString()
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().putString(key, value).apply();
        } else {
          getNewSharePreferences(arg).edit().putString(key, value).apply();
        }
        break;
      }
      case METHOD_PUT_STRING: {
        String key = extras.getString(EXTRA_KEY);
        String defValue = extras.getString(EXTRA_VALUE);
        // 将值存起来 - putString()
        boolean value;
        if (TextUtils.isEmpty(arg)) {
          value =sharedPreferences.edit().putString(key, defValue).commit();
        } else {
          value = getNewSharePreferences(arg).edit().putString(key, defValue).commit();
        }
        replyData = new Bundle();
        replyData.putBoolean(EXTRA_VALUE, value);
        break;
      }
      case METHOD_GET_STRING: {
        String key = extras.getString(EXTRA_KEY);
        String defValue = extras.getString(EXTRA_DEFAULT_VALUE);
        String value;  // 获取到的值 - getString()
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.getString(key, defValue);
        } else {
          value = getNewSharePreferences(arg).getString(key, defValue);
        }
        replyData = new Bundle();
        // 将获取到的值放进Bundle
        replyData.putString(EXTRA_VALUE, value);
        break;
      }
      case METHOD_APPLY_BOOLEAN: {
        String key = extras.getString(EXTRA_KEY);
        boolean value = extras.getBoolean(EXTRA_VALUE);
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().putBoolean(key, value).apply();
        } else {
          getNewSharePreferences(arg).edit().putBoolean(key, value).apply();
        }
        break;
      }
      case METHOD_GET_BOOLEAN: {
        String key = extras.getString(EXTRA_KEY);
        boolean defValue = extras.getBoolean(EXTRA_DEFAULT_VALUE);
        boolean value;
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.getBoolean(key, defValue);
        } else {
          value = getNewSharePreferences(arg).getBoolean(key, defValue);
        }
        replyData = new Bundle();
        replyData.putBoolean(EXTRA_VALUE, value);
        break;
      }
      case METHOD_APPLY_INT: {
        String key = extras.getString(EXTRA_KEY);
        int value = extras.getInt(EXTRA_VALUE);
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().putInt(key, value).apply();
        } else {
          getNewSharePreferences(arg).edit().putInt(key, value).apply();
        }
        break;
      }
      case METHOD_GET_INT: {
        String key = extras.getString(EXTRA_KEY);
        int defValue = extras.getInt(EXTRA_DEFAULT_VALUE);
        int value;
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.getInt(key, defValue);
        } else {
          value = getNewSharePreferences(arg).getInt(key, defValue);
        }
        replyData = new Bundle();
        replyData.putInt(EXTRA_VALUE, value);
        break;
      }
      case METHOD_REMOVE_KEY: {
        String key = extras.getString(EXTRA_KEY);
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().remove(key).apply();
        } else {
          getNewSharePreferences(arg).edit().remove(key).apply();
        }
        break;
      }
      case METHOD_CONTAIN_KEY: {
        String key = extras.getString(EXTRA_KEY);
        boolean value;
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.contains(key);
        } else {
          value = getNewSharePreferences(arg).contains(key);
        }
        replyData = new Bundle();
        replyData.putBoolean(EXTRA_VALUE, value);
        break;
      }
      case METHOD_APPLY_LONG: {
        String key = extras.getString(EXTRA_KEY);
        long value = extras.getLong(EXTRA_VALUE);
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().putLong(key, value).apply();
        } else {
          getNewSharePreferences(arg).edit().putLong(key, value).apply();
        }
        break;
      }
      case METHOD_GET_LONG: {
        String key = extras.getString(EXTRA_KEY);
        long defValue = extras.getLong(EXTRA_DEFAULT_VALUE);
        long value;
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.getLong(key, defValue);
        } else {
          value = getNewSharePreferences(arg).getLong(key, defValue);
        }
        replyData = new Bundle();
        replyData.putLong(EXTRA_VALUE, value);
        break;
      }
      case METHOD_APPLY_FLOAT: {
        String key = extras.getString(EXTRA_KEY);
        float value = extras.getLong(EXTRA_VALUE);
        if (TextUtils.isEmpty(arg)) {
          sharedPreferences.edit().putFloat(key, value).apply();
        } else {
          getNewSharePreferences(arg).edit().putFloat(key, value).apply();
        }
        break;
      }
      case METHOD_GET_FLOAT: {
        String key = extras.getString(EXTRA_KEY);
        float defValue = extras.getLong(EXTRA_DEFAULT_VALUE);
        float value;
        if (TextUtils.isEmpty(arg)) {
          value = sharedPreferences.getFloat(key, defValue);
        } else {
          value = getNewSharePreferences(arg).getFloat(key, defValue);
        }
        replyData = new Bundle();
        replyData.putFloat(EXTRA_VALUE, value);
        break;
      }
    }
    // 将获取到的值返回给调用方，若为put操作，replyData则为null
    return replyData;
  }

  private SharedPreferences getNewSharePreferences(String arg) {
    return getContext().getSharedPreferences(arg, preferencesModel);
  }
}
