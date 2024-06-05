package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public interface DecorToolbar {
    void animateToVisibility(int i);

    boolean canShowOverflowMenu();

    boolean canSplit();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isSplit();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> sparseArray);

    void saveHierarchyState(SparseArray<Parcelable> sparseArray);

    void setCollapsible(boolean z);

    void setCustomView(View view);

    void setDefaultNavigationContentDescription(int i);

    void setDefaultNavigationIcon(Drawable drawable);

    void setDisplayOptions(int i);

    void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterViewCompat.OnItemSelectedListener onItemSelectedListener);

    void setDropdownSelectedPosition(int i);

    void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView);

    void setHomeButtonEnabled(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setLogo(Drawable drawable);

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuPrepared();

    void setNavigationContentDescription(int i);

    void setNavigationContentDescription(CharSequence charSequence);

    void setNavigationIcon(int i);

    void setNavigationIcon(Drawable drawable);

    void setNavigationMode(int i);

    void setSplitToolbar(boolean z);

    void setSplitView(ViewGroup viewGroup);

    void setSplitWhenNarrow(boolean z);

    void setSubtitle(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(WindowCallback windowCallback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}