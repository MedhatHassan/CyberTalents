package android.support.v4.media.routing;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import android.support.v4.media.routing.MediaRouterJellybean;
import android.util.Log;
import android.view.Display;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class MediaRouterJellybeanMr1 extends MediaRouterJellybean {
    private static final String TAG = "MediaRouterJellybeanMr1";

    /* loaded from: classes.dex */
    public interface Callback extends MediaRouterJellybean.Callback {
        void onRoutePresentationDisplayChanged(Object obj);
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* loaded from: classes.dex */
    public static final class RouteInfo {
        public static boolean isEnabled(Object routeObj) {
            return ((MediaRouter.RouteInfo) routeObj).isEnabled();
        }

        public static Display getPresentationDisplay(Object routeObj) {
            return ((MediaRouter.RouteInfo) routeObj).getPresentationDisplay();
        }
    }

    /* loaded from: classes.dex */
    public static final class ActiveScanWorkaround implements Runnable {
        private static final int WIFI_DISPLAY_SCAN_INTERVAL = 15000;
        private boolean mActivelyScanningWifiDisplays;
        private final DisplayManager mDisplayManager;
        private final Handler mHandler;
        private Method mScanWifiDisplaysMethod;

        public ActiveScanWorkaround(Context context, Handler handler) {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            this.mDisplayManager = (DisplayManager) context.getSystemService("display");
            this.mHandler = handler;
            try {
                this.mScanWifiDisplaysMethod = DisplayManager.class.getMethod("scanWifiDisplays", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }

        public void setActiveScanRouteTypes(int routeTypes) {
            if ((routeTypes & 2) != 0) {
                if (!this.mActivelyScanningWifiDisplays) {
                    if (this.mScanWifiDisplaysMethod != null) {
                        this.mActivelyScanningWifiDisplays = true;
                        this.mHandler.post(this);
                        return;
                    }
                    Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays because the DisplayManager.scanWifiDisplays() method is not available on this device.");
                }
            } else if (this.mActivelyScanningWifiDisplays) {
                this.mActivelyScanningWifiDisplays = false;
                this.mHandler.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mActivelyScanningWifiDisplays) {
                try {
                    this.mScanWifiDisplaysMethod.invoke(this.mDisplayManager, new Object[0]);
                } catch (IllegalAccessException ex) {
                    Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays.", ex);
                } catch (InvocationTargetException ex2) {
                    Log.w(MediaRouterJellybeanMr1.TAG, "Cannot scan for wifi displays.", ex2);
                }
                this.mHandler.postDelayed(this, 15000L);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class IsConnectingWorkaround {
        private Method mGetStatusCodeMethod;
        private int mStatusConnecting;

        public IsConnectingWorkaround() {
            if (Build.VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                Field statusConnectingField = MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING");
                this.mStatusConnecting = statusConnectingField.getInt(null);
                this.mGetStatusCodeMethod = MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (IllegalAccessException e) {
            } catch (NoSuchFieldException e2) {
            } catch (NoSuchMethodException e3) {
            }
        }

        public boolean isConnecting(Object routeObj) {
            MediaRouter.RouteInfo route = (MediaRouter.RouteInfo) routeObj;
            if (this.mGetStatusCodeMethod != null) {
                try {
                    int statusCode = ((Integer) this.mGetStatusCodeMethod.invoke(route, new Object[0])).intValue();
                    return statusCode == this.mStatusConnecting;
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class CallbackProxy<T extends Callback> extends MediaRouterJellybean.CallbackProxy<T> {
        public CallbackProxy(T callback) {
            super(callback);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRoutePresentationDisplayChanged(MediaRouter router, MediaRouter.RouteInfo route) {
            ((Callback) this.mCallback).onRoutePresentationDisplayChanged(route);
        }
    }
}