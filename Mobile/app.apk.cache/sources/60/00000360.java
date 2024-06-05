package android.support.v7.internal.app;

import android.support.v7.app.ActionBar;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;

/* loaded from: classes.dex */
class NavItemSelectedListener implements AdapterViewCompat.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener listener) {
        this.mListener = listener;
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat.OnItemSelectedListener
    public void onItemSelected(AdapterViewCompat<?> parent, View view, int position, long id) {
        if (this.mListener != null) {
            this.mListener.onNavigationItemSelected(position, id);
        }
    }

    @Override // android.support.v7.internal.widget.AdapterViewCompat.OnItemSelectedListener
    public void onNothingSelected(AdapterViewCompat<?> parent) {
    }
}