package android.support.v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
/* loaded from: classes.dex */
public class SupportActionModeWrapper extends ActionMode {
    final Context mContext;
    final android.support.v7.view.ActionMode mWrappedObject;

    public SupportActionModeWrapper(Context context, android.support.v7.view.ActionMode supportActionMode) {
        this.mContext = context;
        this.mWrappedObject = supportActionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    @Override // android.view.ActionMode
    public void setTag(Object tag) {
        this.mWrappedObject.setTag(tag);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence title) {
        this.mWrappedObject.setTitle(title);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence subtitle) {
        this.mWrappedObject.setSubtitle(subtitle);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.finish();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.ActionMode
    public void setTitle(int resId) {
        this.mWrappedObject.setTitle(resId);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int resId) {
        this.mWrappedObject.setSubtitle(resId);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean titleOptional) {
        this.mWrappedObject.setTitleOptionalHint(titleOptional);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {
        final Context mContext;
        final ActionMode.Callback mWrappedCallback;
        final SimpleArrayMap<android.support.v7.view.ActionMode, SupportActionModeWrapper> mActionModes = new SimpleArrayMap<>();
        final SimpleArrayMap<Menu, Menu> mMenus = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback supportCallback) {
            this.mContext = context;
            this.mWrappedCallback = supportCallback;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onCreateActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(mode), getMenuWrapper(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(mode), getMenuWrapper(menu));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public boolean onActionItemClicked(android.support.v7.view.ActionMode mode, MenuItem item) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(mode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) item));
        }

        @Override // android.support.v7.view.ActionMode.Callback
        public void onDestroyActionMode(android.support.v7.view.ActionMode mode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(mode));
        }

        private Menu getMenuWrapper(Menu menu) {
            Menu wrapper = this.mMenus.get(menu);
            if (wrapper == null) {
                Menu wrapper2 = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
                this.mMenus.put(menu, wrapper2);
                return wrapper2;
            }
            return wrapper;
        }

        private android.view.ActionMode getActionModeWrapper(android.support.v7.view.ActionMode mode) {
            SupportActionModeWrapper wrapper = this.mActionModes.get(mode);
            if (wrapper != null) {
                return wrapper;
            }
            SupportActionModeWrapper wrapper2 = new SupportActionModeWrapper(this.mContext, mode);
            this.mActionModes.put(mode, wrapper2);
            return wrapper2;
        }
    }
}