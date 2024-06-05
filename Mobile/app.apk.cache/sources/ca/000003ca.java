package android.support.v7.internal.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.util.SparseArray;
import android.view.Menu;

/* loaded from: classes.dex */
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int i);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray);

    void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuPrepared();

    void setUiOptions(int i);

    void setWindowCallback(WindowCallback windowCallback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}