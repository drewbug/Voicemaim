package ug.drew.voicemaim;

import android.app.Notification;
import android.util.Log;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedMod implements IXposedHookLoadPackage {

  @Override
  public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
    final String packageName = lpparam.packageName;

    XposedHelpers.findAndHookMethod("android.app.NotificationManager", lpparam.classLoader, "notify", String.class, int.class, Notification.class, new XC_MethodHook() {
      @Override
      protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        Log.i("Voicemaim", packageName);
        Log.i("Voicemaim", (String) param.args[0]);
        Log.i("Voicemaim", Integer.toString((int) param.args[1]));
        // param.setResult(null);
      }
    });
  }

}
