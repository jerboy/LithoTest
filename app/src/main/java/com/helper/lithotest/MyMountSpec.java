package com.helper.lithotest;

import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Diff;
import com.facebook.litho.Size;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnPrepare;
import com.facebook.litho.annotations.OnUnmount;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ShouldUpdate;
import com.facebook.litho.annotations.State;
import com.facebook.litho.utils.MeasureUtils;

/**
 * Created by caojianbo on 2018/3/28.
 */

@MountSpec(isPureRender = true, poolSize = 0)
public class MyMountSpec {
  @OnCreateInitialState
  static void OnCreateInitialState(ComponentContext c, StateValue<Integer> videoBean){
    Log.e("AAA", "OnCreateInitialState");
    videoBean.set(null);
  }

  @OnPrepare
  static void onPrepare(ComponentContext c, @Prop int videoId){
    Log.e("AAA", "onPrepare " + videoId);
  }

  @OnCreateMountContent
  static TextView getVideoView(ComponentContext c){
    Log.e("AAA", "getVideoView");
    return new TextView(c);
  }

  @OnMount
  static void onMount(ComponentContext c, TextView videoView, @State Integer videoBean){
    Log.e("AAA", "onMount");
    videoView.setGravity(Gravity.CENTER);
    videoView.setText("SSSSSSSS");
  }

  @OnUnmount
  static void onUnMount(ComponentContext c, TextView videoView){
    Log.e("AAA", "onUnMount");
  }

  @OnMeasure
  static void onMeasure(ComponentContext c, ComponentLayout layout, int widthSpec, int heightSpec, Size out){
    // TODO: 2018/3/28
    out.width = 100;
    out.height = 100;
//    MeasureUtils.measureWithAspectRatio(widthSpec, heightSpec, 2f, out);
  }

  @ShouldUpdate(onMount = true)
  static boolean shouldUpdate(@Prop Diff<Integer> videoId) {
    Log.e("AAA", "shouldUpdate");
    return !videoId.getPrevious().equals(videoId.getNext());
  }

}
