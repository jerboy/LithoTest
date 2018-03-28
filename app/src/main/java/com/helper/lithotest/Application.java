package com.helper.lithotest;

import com.facebook.soloader.SoLoader;

/**
 * Created by caojianbo on 2018/3/12.
 */

public class Application extends android.app.Application {

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, false);
  }
}
