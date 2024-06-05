package android.support.v4.media.routing;

import android.media.MediaRouter;

/* loaded from: classes.dex */
class MediaRouterJellybeanMr2 extends MediaRouterJellybeanMr1 {
    MediaRouterJellybeanMr2() {
    }

    public static Object getDefaultRoute(Object routerObj) {
        return ((MediaRouter) routerObj).getDefaultRoute();
    }

    public static void addCallback(Object routerObj, int types, Object callbackObj, int flags) {
        ((MediaRouter) routerObj).addCallback(types, (MediaRouter.Callback) callbackObj, flags);
    }

    /* loaded from: classes.dex */
    public static final class RouteInfo {
        public static CharSequence getDescription(Object routeObj) {
            return ((MediaRouter.RouteInfo) routeObj).getDescription();
        }

        public static boolean isConnecting(Object routeObj) {
            return ((MediaRouter.RouteInfo) routeObj).isConnecting();
        }
    }

    /* loaded from: classes.dex */
    public static final class UserRouteInfo {
        public static void setDescription(Object routeObj, CharSequence description) {
            ((MediaRouter.UserRouteInfo) routeObj).setDescription(description);
        }
    }
}