package android.support.v4.view;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
class ViewCompatApi21 {
    ViewCompatApi21() {
    }

    public static void setTransitionName(View view, String transitionName) {
        view.setTransitionName(transitionName);
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    public static void setElevation(View view, float elevation) {
        view.setElevation(elevation);
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static void setTranslationZ(View view, float translationZ) {
        view.setTranslationZ(translationZ);
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener listener) {
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompatApi21.1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                WindowInsetsCompatApi21 insets = new WindowInsetsCompatApi21(windowInsets);
                return ((WindowInsetsCompatApi21) OnApplyWindowInsetsListener.this.onApplyWindowInsets(view2, insets)).unwrap();
            }
        });
    }
}