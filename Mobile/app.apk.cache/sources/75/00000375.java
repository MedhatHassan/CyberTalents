package android.support.v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {
    private static final String LOG_TAG = "SupportMenuInflater";
    private static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    private final Object[] mActionProviderConstructorArguments;
    private final Object[] mActionViewConstructorArguments;
    private Context mContext;
    private Object mRealOwner;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = {Context.class};
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }

    @Override // android.view.MenuInflater
    public void inflate(int menuRes, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(menuRes, menu);
            return;
        }
        XmlResourceParser parser = null;
        try {
            try {
                parser = this.mContext.getResources().getLayout(menuRes);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                parseMenu(parser, attrs, menu);
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        switch(r0) {
            case 1: goto L55;
            case 2: goto L10;
            case 3: goto L27;
            default: goto L59;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r1 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        r5 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_GROUP) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        r2.readGroup(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_ITEM) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        r2.readItem(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_MENU) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        r4 = r2.addSubMenuItem();
        parseMenu(r11, r12, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
        r1 = true;
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        r5 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
        if (r1 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r5.equals(r6) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        r1 = false;
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_GROUP) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        r2.resetGroup();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_ITEM) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:
        if (r2.hasAddedItem() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
        if (r2.itemActionProvider == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
        if (r2.itemActionProvider.hasSubMenu() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b4, code lost:
        r2.addSubMenuItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
        r2.addItem();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c4, code lost:
        if (r5.equals(android.support.v7.internal.view.SupportMenuInflater.XML_MENU) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c6, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d0, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r3 != false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseMenu(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            android.support.v7.internal.view.SupportMenuInflater$MenuState r2 = new android.support.v7.internal.view.SupportMenuInflater$MenuState
            r2.<init>(r13)
            int r0 = r11.getEventType()
            r1 = 0
            r6 = 0
        Lb:
            r7 = 2
            if (r0 != r7) goto L42
            java.lang.String r5 = r11.getName()
            java.lang.String r7 = "menu"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L29
            int r0 = r11.next()
        L1e:
            r3 = 0
        L1f:
            if (r3 != 0) goto Ld1
            switch(r0) {
                case 1: goto Lc9;
                case 2: goto L4a;
                case 3: goto L7b;
                default: goto L24;
            }
        L24:
            int r0 = r11.next()
            goto L1f
        L29:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Expecting menu, got "
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L42:
            int r0 = r11.next()
            r7 = 1
            if (r0 != r7) goto Lb
            goto L1e
        L4a:
            if (r1 != 0) goto L24
            java.lang.String r5 = r11.getName()
            java.lang.String r7 = "group"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L5c
            r2.readGroup(r12)
            goto L24
        L5c:
            java.lang.String r7 = "item"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L68
            r2.readItem(r12)
            goto L24
        L68:
            java.lang.String r7 = "menu"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L78
            android.view.SubMenu r4 = r2.addSubMenuItem()
            r10.parseMenu(r11, r12, r4)
            goto L24
        L78:
            r1 = 1
            r6 = r5
            goto L24
        L7b:
            java.lang.String r5 = r11.getName()
            if (r1 == 0) goto L8a
            boolean r7 = r5.equals(r6)
            if (r7 == 0) goto L8a
            r1 = 0
            r6 = 0
            goto L24
        L8a:
            java.lang.String r7 = "group"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L96
            r2.resetGroup()
            goto L24
        L96:
            java.lang.String r7 = "item"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto Lbe
            boolean r7 = r2.hasAddedItem()
            if (r7 != 0) goto L24
            android.support.v4.view.ActionProvider r7 = android.support.v7.internal.view.SupportMenuInflater.MenuState.access$000(r2)
            if (r7 == 0) goto Lb9
            android.support.v4.view.ActionProvider r7 = android.support.v7.internal.view.SupportMenuInflater.MenuState.access$000(r2)
            boolean r7 = r7.hasSubMenu()
            if (r7 == 0) goto Lb9
            r2.addSubMenuItem()
            goto L24
        Lb9:
            r2.addItem()
            goto L24
        Lbe:
            java.lang.String r7 = "menu"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L24
            r3 = 1
            goto L24
        Lc9:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Unexpected end of document"
            r7.<init>(r8)
            throw r7
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.SupportMenuInflater.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    private Object findRealOwner(Object owner) {
        if (!(owner instanceof Activity) && (owner instanceof ContextWrapper)) {
            return findRealOwner(((ContextWrapper) owner).getBaseContext());
        }
        return owner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = {MenuItem.class};
        private Method mMethod;
        private Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object realOwner, String methodName) {
            this.mRealOwner = realOwner;
            Class<?> c = realOwner.getClass();
            try {
                this.mMethod = c.getMethod(methodName, PARAM_TYPES);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, item)).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, item);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        private ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemEnabled;
        private int itemIconResId;
        private int itemId;
        private String itemListenerMethodName;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        public void readGroup(AttributeSet attrs) {
            TypedArray a = SupportMenuInflater.this.mContext.obtainStyledAttributes(attrs, R.styleable.MenuGroup);
            this.groupId = a.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = a.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = a.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = a.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = a.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = a.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            a.recycle();
        }

        public void readItem(AttributeSet attrs) {
            TypedArray a = SupportMenuInflater.this.mContext.obtainStyledAttributes(attrs, R.styleable.MenuItem);
            this.itemId = a.getResourceId(R.styleable.MenuItem_android_id, 0);
            int category = a.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory);
            int order = a.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder);
            this.itemCategoryOrder = ((-65536) & category) | (65535 & order);
            this.itemTitle = a.getText(R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = a.getText(R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = a.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(a.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemNumericShortcut = getShortcut(a.getString(R.styleable.MenuItem_android_numericShortcut));
            if (a.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.itemCheckable = a.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.itemCheckable = this.groupCheckable;
            }
            this.itemChecked = a.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.itemVisible = a.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = a.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = a.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = a.getString(R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = a.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = a.getString(R.styleable.MenuItem_actionViewClass);
            this.itemActionProviderClassName = a.getString(R.styleable.MenuItem_actionProviderClass);
            boolean hasActionProvider = this.itemActionProviderClassName != null;
            if (hasActionProvider && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (hasActionProvider) {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            a.recycle();
            this.itemAdded = false;
        }

        private char getShortcut(String shortcutString) {
            if (shortcutString == null) {
                return (char) 0;
            }
            return shortcutString.charAt(0);
        }

        private void setItem(MenuItem item) {
            item.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
            if (this.itemShowAsAction >= 0) {
                MenuItemCompat.setShowAsAction(item, this.itemShowAsAction);
            }
            if (this.itemListenerMethodName != null) {
                if (SupportMenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
            }
            if (item instanceof MenuItemImpl) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) item;
            }
            if (this.itemCheckable >= 2) {
                if (item instanceof MenuItemImpl) {
                    ((MenuItemImpl) item).setExclusiveCheckable(true);
                } else if (item instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) item).setExclusiveCheckable(true);
                }
            }
            boolean actionViewSpecified = false;
            if (this.itemActionViewClassName != null) {
                View actionView = (View) newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments);
                MenuItemCompat.setActionView(item, actionView);
                actionViewSpecified = true;
            }
            if (this.itemActionViewLayout > 0) {
                if (!actionViewSpecified) {
                    MenuItemCompat.setActionView(item, this.itemActionViewLayout);
                } else {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.itemActionProvider != null) {
                MenuItemCompat.setActionProvider(item, this.itemActionProvider);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu subMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(subMenu.getItem());
            return subMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private <T> T newInstance(String className, Class<?>[] constructorSignature, Object[] arguments) {
            try {
                Class<?> clazz = SupportMenuInflater.this.mContext.getClassLoader().loadClass(className);
                Constructor<?> constructor = clazz.getConstructor(constructorSignature);
                return (T) constructor.newInstance(arguments);
            } catch (Exception e) {
                Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + className, e);
                return null;
            }
        }
    }
}