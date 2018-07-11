package com.cardio;

import android.content.Context;
import android.content.pm.PackageManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import io.card.payment.CardIOActivity;

import java.util.HashMap;
import java.util.Map;

public class RNCardIOUtilities extends ReactContextBaseJavaModule {
  public RNCardIOUtilities(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RCTCardIOUtilities";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    // constants.put("CAN_READ_CARD_WITH_CAMERA", CardIOActivity.canReadCardWithCamera());
    boolean canReadCardWithCamera = checkCameraHardware(getReactApplicationContext());
    constants.put("CAN_READ_CARD_WITH_CAMERA", canReadCardWithCamera);
    return constants;
  }
  
  /**
   * Check if this device has a camera
   */
  private boolean checkCameraHardware(Context context) {
    if (context == null)
      return true;

    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
      // this device has a camera
      return true;
    } else {
      // no camera on this device
      return false;
    }
  }
}
