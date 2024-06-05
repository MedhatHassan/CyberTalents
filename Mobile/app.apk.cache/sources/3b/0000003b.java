package android.support.v4.app;

import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    Op mHead;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    Op mTail;
    int mTransition;
    int mTransitionStyle;
    boolean mAllowAddToBackStack = true;
    int mIndex = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        Op next;
        int popEnterAnim;
        int popExitAnim;
        Op prev;
        ArrayList<Fragment> removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dump(prefix, writer, true);
    }

    public void dump(String prefix, PrintWriter writer, boolean full) {
        String cmdStr;
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.mName);
            writer.print(" mIndex=");
            writer.print(this.mIndex);
            writer.print(" mCommitted=");
            writer.println(this.mCommitted);
            if (this.mTransition != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.mTransition));
                writer.print(" mTransitionStyle=#");
                writer.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.mEnterAnim));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.mPopEnterAnim));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead != null) {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            Op op = this.mHead;
            int num = 0;
            while (op != null) {
                switch (op.cmd) {
                    case 0:
                        cmdStr = "NULL";
                        break;
                    case 1:
                        cmdStr = "ADD";
                        break;
                    case 2:
                        cmdStr = "REPLACE";
                        break;
                    case 3:
                        cmdStr = "REMOVE";
                        break;
                    case 4:
                        cmdStr = "HIDE";
                        break;
                    case 5:
                        cmdStr = "SHOW";
                        break;
                    case 6:
                        cmdStr = "DETACH";
                        break;
                    case 7:
                        cmdStr = "ATTACH";
                        break;
                    default:
                        cmdStr = "cmd=" + op.cmd;
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.fragment);
                if (full) {
                    if (op.enterAnim != 0 || op.exitAnim != 0) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.enterAnim));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.exitAnim));
                    }
                    if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.popEnterAnim));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.popExitAnim));
                    }
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i = 0; i < op.removed.size(); i++) {
                        writer.print(innerPrefix);
                        if (op.removed.size() == 1) {
                            writer.print("Removed: ");
                        } else {
                            if (i == 0) {
                                writer.println("Removed:");
                            }
                            writer.print(innerPrefix);
                            writer.print("  #");
                            writer.print(i);
                            writer.print(": ");
                        }
                        writer.println(op.removed.get(i));
                    }
                }
                op = op.next;
                num++;
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl manager) {
        this.mManager = manager;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOp(Op op) {
        if (this.mHead == null) {
            this.mTail = op;
            this.mHead = op;
        } else {
            op.prev = this.mTail;
            this.mTail.next = op;
            this.mTail = op;
        }
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
        this.mNumOp++;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, String tag) {
        doAddOp(0, fragment, tag, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        doAddOp(containerViewId, fragment, null, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        doAddOp(containerViewId, fragment, tag, 1);
        return this;
    }

    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = this.mManager;
        if (tag != null) {
            if (fragment.mTag != null && !tag.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + tag);
            }
            fragment.mTag = tag;
        }
        if (containerViewId != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != containerViewId) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + containerViewId);
            }
            fragment.mFragmentId = containerViewId;
            fragment.mContainerId = containerViewId;
        }
        Op op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        return replace(containerViewId, fragment, null);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        if (containerViewId == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(containerViewId, fragment, tag, 2);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        return setCustomAnimations(enter, exit, 0, 0);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int enter, int exit, int popEnter, int popExit) {
        this.mEnterAnim = enter;
        this.mExitAnim = exit;
        this.mPopEnterAnim = popEnter;
        this.mPopExitAnim = popExit;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransition(int transition) {
        this.mTransition = transition;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction addSharedElement(View sharedElement, String name) {
        if (Build.VERSION.SDK_INT >= 21) {
            String transitionName = FragmentTransitionCompat21.getTransitionName(sharedElement);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<>();
                this.mSharedElementTargetNames = new ArrayList<>();
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(name);
        }
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int styleRes) {
        this.mTransitionStyle = styleRes;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction addToBackStack(String name) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = name;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int res) {
        this.mBreadCrumbTitleRes = res;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = text;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        this.mBreadCrumbShortTitleRes = res;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = text;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bumpBackStackNesting(int amt) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v(TAG, "Bump nesting in " + this + " by " + amt);
            }
            for (Op op = this.mHead; op != null; op = op.next) {
                if (op.fragment != null) {
                    op.fragment.mBackStackNesting += amt;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v(TAG, "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
                if (op.removed != null) {
                    for (int i = op.removed.size() - 1; i >= 0; i--) {
                        Fragment r = op.removed.get(i);
                        r.mBackStackNesting += amt;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v(TAG, "Bump nesting of " + r + " to " + r.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean allowStateLoss) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, allowStateLoss);
        return this.mIndex;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        if (this.mAddToBackStack && this.mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        bumpBackStackNesting(1);
        TransitionState state = null;
        if (Build.VERSION.SDK_INT >= 21) {
            SparseArray<Fragment> firstOutFragments = new SparseArray<>();
            SparseArray<Fragment> lastInFragments = new SparseArray<>();
            calculateFragments(firstOutFragments, lastInFragments);
            state = beginTransition(firstOutFragments, lastInFragments, false);
        }
        int transitionStyle = state != null ? 0 : this.mTransitionStyle;
        int transition = state != null ? 0 : this.mTransition;
        for (Op op = this.mHead; op != null; op = op.next) {
            int enterAnim = state != null ? 0 : op.enterAnim;
            int exitAnim = state != null ? 0 : op.exitAnim;
            switch (op.cmd) {
                case 1:
                    Fragment f = op.fragment;
                    f.mNextAnim = enterAnim;
                    this.mManager.addFragment(f, false);
                    break;
                case 2:
                    Fragment f2 = op.fragment;
                    if (this.mManager.mAdded != null) {
                        for (int i = 0; i < this.mManager.mAdded.size(); i++) {
                            Fragment old = this.mManager.mAdded.get(i);
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v(TAG, "OP_REPLACE: adding=" + f2 + " old=" + old);
                            }
                            if (f2 == null || old.mContainerId == f2.mContainerId) {
                                if (old == f2) {
                                    f2 = null;
                                    op.fragment = null;
                                } else {
                                    if (op.removed == null) {
                                        op.removed = new ArrayList<>();
                                    }
                                    op.removed.add(old);
                                    old.mNextAnim = exitAnim;
                                    if (this.mAddToBackStack) {
                                        old.mBackStackNesting++;
                                        if (FragmentManagerImpl.DEBUG) {
                                            Log.v(TAG, "Bump nesting of " + old + " to " + old.mBackStackNesting);
                                        }
                                    }
                                    this.mManager.removeFragment(old, transition, transitionStyle);
                                }
                            }
                        }
                    }
                    if (f2 != null) {
                        f2.mNextAnim = enterAnim;
                        this.mManager.addFragment(f2, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment f3 = op.fragment;
                    f3.mNextAnim = exitAnim;
                    this.mManager.removeFragment(f3, transition, transitionStyle);
                    break;
                case 4:
                    Fragment f4 = op.fragment;
                    f4.mNextAnim = exitAnim;
                    this.mManager.hideFragment(f4, transition, transitionStyle);
                    break;
                case 5:
                    Fragment f5 = op.fragment;
                    f5.mNextAnim = enterAnim;
                    this.mManager.showFragment(f5, transition, transitionStyle);
                    break;
                case 6:
                    Fragment f6 = op.fragment;
                    f6.mNextAnim = exitAnim;
                    this.mManager.detachFragment(f6, transition, transitionStyle);
                    break;
                case 7:
                    Fragment f7 = op.fragment;
                    f7.mNextAnim = enterAnim;
                    this.mManager.attachFragment(f7, transition, transitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            }
        }
        this.mManager.moveToState(this.mManager.mCurState, transition, transitionStyle, true);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }
    }

    private static void setFirstOut(SparseArray<Fragment> fragments, Fragment fragment) {
        int containerId;
        if (fragment != null && (containerId = fragment.mContainerId) != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && fragments.get(containerId) == null) {
            fragments.put(containerId, fragment);
        }
    }

    private void setLastIn(SparseArray<Fragment> fragments, Fragment fragment) {
        int containerId;
        if (fragment != null && (containerId = fragment.mContainerId) != 0) {
            fragments.put(containerId, fragment);
        }
    }

    private void calculateFragments(SparseArray<Fragment> firstOutFragments, SparseArray<Fragment> lastInFragments) {
        if (this.mManager.mContainer.hasView()) {
            for (Op op = this.mHead; op != null; op = op.next) {
                switch (op.cmd) {
                    case 1:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                    case 2:
                        Fragment f = op.fragment;
                        if (this.mManager.mAdded != null) {
                            for (int i = 0; i < this.mManager.mAdded.size(); i++) {
                                Fragment old = this.mManager.mAdded.get(i);
                                if (f == null || old.mContainerId == f.mContainerId) {
                                    if (old == f) {
                                        f = null;
                                    } else {
                                        setFirstOut(firstOutFragments, old);
                                    }
                                }
                            }
                        }
                        setLastIn(lastInFragments, f);
                        break;
                    case 3:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 4:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 5:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                    case 6:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 7:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                }
            }
        }
    }

    public void calculateBackFragments(SparseArray<Fragment> firstOutFragments, SparseArray<Fragment> lastInFragments) {
        if (this.mManager.mContainer.hasView()) {
            for (Op op = this.mHead; op != null; op = op.next) {
                switch (op.cmd) {
                    case 1:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 2:
                        if (op.removed != null) {
                            for (int i = op.removed.size() - 1; i >= 0; i--) {
                                setLastIn(lastInFragments, op.removed.get(i));
                            }
                        }
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 3:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                    case 4:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                    case 5:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                    case 6:
                        setLastIn(lastInFragments, op.fragment);
                        break;
                    case 7:
                        setFirstOut(firstOutFragments, op.fragment);
                        break;
                }
            }
        }
    }

    public TransitionState popFromBackStack(boolean doStateMove, TransitionState state, SparseArray<Fragment> firstOutFragments, SparseArray<Fragment> lastInFragments) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "popFromBackStack: " + this);
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        }
        if (state == null) {
            if (firstOutFragments.size() != 0 || lastInFragments.size() != 0) {
                state = beginTransition(firstOutFragments, lastInFragments, true);
            }
        } else if (!doStateMove) {
            setNameOverrides(state, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
        }
        bumpBackStackNesting(-1);
        int transitionStyle = state != null ? 0 : this.mTransitionStyle;
        int transition = state != null ? 0 : this.mTransition;
        for (Op op = this.mTail; op != null; op = op.prev) {
            int popEnterAnim = state != null ? 0 : op.popEnterAnim;
            int popExitAnim = state != null ? 0 : op.popExitAnim;
            switch (op.cmd) {
                case 1:
                    Fragment f = op.fragment;
                    f.mNextAnim = popExitAnim;
                    this.mManager.removeFragment(f, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    break;
                case 2:
                    Fragment f2 = op.fragment;
                    if (f2 != null) {
                        f2.mNextAnim = popExitAnim;
                        this.mManager.removeFragment(f2, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    }
                    if (op.removed != null) {
                        for (int i = 0; i < op.removed.size(); i++) {
                            Fragment old = op.removed.get(i);
                            old.mNextAnim = popEnterAnim;
                            this.mManager.addFragment(old, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment f3 = op.fragment;
                    f3.mNextAnim = popEnterAnim;
                    this.mManager.addFragment(f3, false);
                    break;
                case 4:
                    Fragment f4 = op.fragment;
                    f4.mNextAnim = popEnterAnim;
                    this.mManager.showFragment(f4, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    break;
                case 5:
                    Fragment f5 = op.fragment;
                    f5.mNextAnim = popExitAnim;
                    this.mManager.hideFragment(f5, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    break;
                case 6:
                    Fragment f6 = op.fragment;
                    f6.mNextAnim = popEnterAnim;
                    this.mManager.attachFragment(f6, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    break;
                case 7:
                    Fragment f7 = op.fragment;
                    f7.mNextAnim = popEnterAnim;
                    this.mManager.detachFragment(f7, FragmentManagerImpl.reverseTransit(transition), transitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            }
        }
        if (doStateMove) {
            this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(transition), transitionStyle, true);
            state = null;
        }
        if (this.mIndex >= 0) {
            this.mManager.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return state;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mNumOp == 0;
    }

    private TransitionState beginTransition(SparseArray<Fragment> firstOutFragments, SparseArray<Fragment> lastInFragments, boolean isBack) {
        TransitionState state = new TransitionState();
        state.nonExistentView = new View(this.mManager.mActivity);
        boolean anyTransitionStarted = false;
        for (int i = 0; i < firstOutFragments.size(); i++) {
            if (configureTransitions(firstOutFragments.keyAt(i), state, isBack, firstOutFragments, lastInFragments)) {
                anyTransitionStarted = true;
            }
        }
        for (int i2 = 0; i2 < lastInFragments.size(); i2++) {
            int containerId = lastInFragments.keyAt(i2);
            if (firstOutFragments.get(containerId) == null && configureTransitions(containerId, state, isBack, firstOutFragments, lastInFragments)) {
                anyTransitionStarted = true;
            }
        }
        if (!anyTransitionStarted) {
            return null;
        }
        return state;
    }

    private static Object getEnterTransition(Fragment inFragment, boolean isBack) {
        if (inFragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(isBack ? inFragment.getReenterTransition() : inFragment.getEnterTransition());
    }

    private static Object getExitTransition(Fragment outFragment, boolean isBack) {
        if (outFragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(isBack ? outFragment.getReturnTransition() : outFragment.getExitTransition());
    }

    private static Object getSharedElementTransition(Fragment inFragment, Fragment outFragment, boolean isBack) {
        if (inFragment == null || outFragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(isBack ? outFragment.getSharedElementReturnTransition() : inFragment.getSharedElementEnterTransition());
    }

    private static Object captureExitingViews(Object exitTransition, Fragment outFragment, ArrayList<View> exitingViews, ArrayMap<String, View> namedViews) {
        if (exitTransition != null) {
            return FragmentTransitionCompat21.captureExitingViews(exitTransition, outFragment.getView(), exitingViews, namedViews);
        }
        return exitTransition;
    }

    private ArrayMap<String, View> remapSharedElements(TransitionState state, Fragment outFragment, boolean isBack) {
        ArrayMap<String, View> namedViews = new ArrayMap<>();
        if (this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(namedViews, outFragment.getView());
            if (isBack) {
                namedViews.retainAll(this.mSharedElementTargetNames);
            } else {
                namedViews = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, namedViews);
            }
        }
        if (isBack) {
            if (outFragment.mEnterTransitionCallback != null) {
                outFragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, namedViews);
            }
            setBackNameOverrides(state, namedViews, false);
        } else {
            if (outFragment.mExitTransitionCallback != null) {
                outFragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, namedViews);
            }
            setNameOverrides(state, namedViews, false);
        }
        return namedViews;
    }

    private boolean configureTransitions(int containerId, TransitionState state, boolean isBack, SparseArray<Fragment> firstOutFragments, SparseArray<Fragment> lastInFragments) {
        ViewGroup sceneRoot = (ViewGroup) this.mManager.mContainer.findViewById(containerId);
        if (sceneRoot == null) {
            return false;
        }
        final Fragment inFragment = lastInFragments.get(containerId);
        Fragment outFragment = firstOutFragments.get(containerId);
        Object enterTransition = getEnterTransition(inFragment, isBack);
        Object sharedElementTransition = getSharedElementTransition(inFragment, outFragment, isBack);
        Object exitTransition = getExitTransition(outFragment, isBack);
        if (enterTransition == null && sharedElementTransition == null && exitTransition == null) {
            return false;
        }
        ArrayMap<String, View> namedViews = null;
        ArrayList<View> sharedElementTargets = new ArrayList<>();
        if (sharedElementTransition != null) {
            namedViews = remapSharedElements(state, outFragment, isBack);
            if (namedViews.isEmpty()) {
                sharedElementTargets.add(state.nonExistentView);
            } else {
                sharedElementTargets.addAll(namedViews.values());
            }
            SharedElementCallback callback = isBack ? outFragment.mEnterTransitionCallback : inFragment.mEnterTransitionCallback;
            if (callback != null) {
                ArrayList<String> names = new ArrayList<>(namedViews.keySet());
                ArrayList<View> views = new ArrayList<>(namedViews.values());
                callback.onSharedElementStart(names, views, null);
            }
        }
        ArrayList<View> exitingViews = new ArrayList<>();
        Object exitTransition2 = captureExitingViews(exitTransition, outFragment, exitingViews, namedViews);
        if (this.mSharedElementTargetNames != null && namedViews != null) {
            View epicenterView = namedViews.get(this.mSharedElementTargetNames.get(0));
            if (epicenterView != null) {
                if (exitTransition2 != null) {
                    FragmentTransitionCompat21.setEpicenter(exitTransition2, epicenterView);
                }
                if (sharedElementTransition != null) {
                    FragmentTransitionCompat21.setEpicenter(sharedElementTransition, epicenterView);
                }
            }
        }
        FragmentTransitionCompat21.ViewRetriever viewRetriever = new FragmentTransitionCompat21.ViewRetriever() { // from class: android.support.v4.app.BackStackRecord.1
            @Override // android.support.v4.app.FragmentTransitionCompat21.ViewRetriever
            public View getView() {
                return inFragment.getView();
            }
        };
        if (sharedElementTransition != null) {
            prepareSharedElementTransition(state, sceneRoot, sharedElementTransition, inFragment, outFragment, isBack, sharedElementTargets);
        }
        ArrayList<View> enteringViews = new ArrayList<>();
        ArrayMap<String, View> renamedViews = new ArrayMap<>();
        boolean allowOverlap = isBack ? inFragment.getAllowReturnTransitionOverlap() : inFragment.getAllowEnterTransitionOverlap();
        Object transition = FragmentTransitionCompat21.mergeTransitions(enterTransition, exitTransition2, sharedElementTransition, allowOverlap);
        if (transition != null) {
            FragmentTransitionCompat21.addTransitionTargets(enterTransition, sharedElementTransition, sceneRoot, viewRetriever, state.nonExistentView, state.enteringEpicenterView, state.nameOverrides, enteringViews, renamedViews, sharedElementTargets);
            excludeHiddenFragmentsAfterEnter(sceneRoot, state, containerId, transition);
            FragmentTransitionCompat21.excludeTarget(transition, state.nonExistentView, true);
            excludeHiddenFragments(state, containerId, transition);
            FragmentTransitionCompat21.beginDelayedTransition(sceneRoot, transition);
            FragmentTransitionCompat21.cleanupTransitions(sceneRoot, state.nonExistentView, enterTransition, enteringViews, exitTransition2, exitingViews, sharedElementTransition, sharedElementTargets, transition, state.hiddenFragmentViews, renamedViews);
        }
        return transition != null;
    }

    private void prepareSharedElementTransition(final TransitionState state, final View sceneRoot, final Object sharedElementTransition, final Fragment inFragment, final Fragment outFragment, final boolean isBack, final ArrayList<View> sharedElementTargets) {
        sceneRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.BackStackRecord.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                if (sharedElementTransition != null) {
                    FragmentTransitionCompat21.removeTargets(sharedElementTransition, sharedElementTargets);
                    sharedElementTargets.clear();
                    ArrayMap<String, View> namedViews = BackStackRecord.this.mapSharedElementsIn(state, isBack, inFragment);
                    if (namedViews.isEmpty()) {
                        sharedElementTargets.add(state.nonExistentView);
                    } else {
                        sharedElementTargets.addAll(namedViews.values());
                    }
                    FragmentTransitionCompat21.addTargets(sharedElementTransition, sharedElementTargets);
                    BackStackRecord.this.setEpicenterIn(namedViews, state);
                    BackStackRecord.this.callSharedElementEnd(state, inFragment, outFragment, isBack, namedViews);
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSharedElementEnd(TransitionState state, Fragment inFragment, Fragment outFragment, boolean isBack, ArrayMap<String, View> namedViews) {
        SharedElementCallback sharedElementCallback = isBack ? outFragment.mEnterTransitionCallback : inFragment.mEnterTransitionCallback;
        if (sharedElementCallback != null) {
            ArrayList<String> names = new ArrayList<>(namedViews.keySet());
            ArrayList<View> views = new ArrayList<>(namedViews.values());
            sharedElementCallback.onSharedElementEnd(names, views, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEpicenterIn(ArrayMap<String, View> namedViews, TransitionState state) {
        View epicenter;
        if (this.mSharedElementTargetNames != null && !namedViews.isEmpty() && (epicenter = namedViews.get(this.mSharedElementTargetNames.get(0))) != null) {
            state.enteringEpicenterView.epicenter = epicenter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayMap<String, View> mapSharedElementsIn(TransitionState state, boolean isBack, Fragment inFragment) {
        ArrayMap<String, View> namedViews = mapEnteringSharedElements(state, inFragment, isBack);
        if (isBack) {
            if (inFragment.mExitTransitionCallback != null) {
                inFragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, namedViews);
            }
            setBackNameOverrides(state, namedViews, true);
        } else {
            if (inFragment.mEnterTransitionCallback != null) {
                inFragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, namedViews);
            }
            setNameOverrides(state, namedViews, true);
        }
        return namedViews;
    }

    private static ArrayMap<String, View> remapNames(ArrayList<String> inMap, ArrayList<String> toGoInMap, ArrayMap<String, View> namedViews) {
        if (!namedViews.isEmpty()) {
            ArrayMap<String, View> remappedViews = new ArrayMap<>();
            int numKeys = inMap.size();
            for (int i = 0; i < numKeys; i++) {
                View view = namedViews.get(inMap.get(i));
                if (view != null) {
                    remappedViews.put(toGoInMap.get(i), view);
                }
            }
            return remappedViews;
        }
        return namedViews;
    }

    private ArrayMap<String, View> mapEnteringSharedElements(TransitionState state, Fragment inFragment, boolean isBack) {
        ArrayMap<String, View> namedViews = new ArrayMap<>();
        View root = inFragment.getView();
        if (root != null && this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(namedViews, root);
            if (isBack) {
                return remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, namedViews);
            }
            namedViews.retainAll(this.mSharedElementTargetNames);
            return namedViews;
        }
        return namedViews;
    }

    private void excludeHiddenFragmentsAfterEnter(final View sceneRoot, final TransitionState state, final int containerId, final Object transition) {
        sceneRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.BackStackRecord.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.excludeHiddenFragments(state, containerId, transition);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void excludeHiddenFragments(TransitionState state, int containerId, Object transition) {
        if (this.mManager.mAdded != null) {
            for (int i = 0; i < this.mManager.mAdded.size(); i++) {
                Fragment fragment = this.mManager.mAdded.get(i);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == containerId) {
                    if (fragment.mHidden) {
                        if (!state.hiddenFragmentViews.contains(fragment.mView)) {
                            FragmentTransitionCompat21.excludeTarget(transition, fragment.mView, true);
                            state.hiddenFragmentViews.add(fragment.mView);
                        }
                    } else {
                        FragmentTransitionCompat21.excludeTarget(transition, fragment.mView, false);
                        state.hiddenFragmentViews.remove(fragment.mView);
                    }
                }
            }
        }
    }

    private static void setNameOverride(ArrayMap<String, String> overrides, String source, String target) {
        if (source != null && target != null && !source.equals(target)) {
            for (int index = 0; index < overrides.size(); index++) {
                if (source.equals(overrides.valueAt(index))) {
                    overrides.setValueAt(index, target);
                    return;
                }
            }
            overrides.put(source, target);
        }
    }

    private static void setNameOverrides(TransitionState state, ArrayList<String> sourceNames, ArrayList<String> targetNames) {
        if (sourceNames != null) {
            for (int i = 0; i < sourceNames.size(); i++) {
                String source = sourceNames.get(i);
                String target = targetNames.get(i);
                setNameOverride(state.nameOverrides, source, target);
            }
        }
    }

    private void setBackNameOverrides(TransitionState state, ArrayMap<String, View> namedViews, boolean isEnd) {
        int count = this.mSharedElementTargetNames == null ? 0 : this.mSharedElementTargetNames.size();
        for (int i = 0; i < count; i++) {
            String source = this.mSharedElementSourceNames.get(i);
            String originalTarget = this.mSharedElementTargetNames.get(i);
            View view = namedViews.get(originalTarget);
            if (view != null) {
                String target = FragmentTransitionCompat21.getTransitionName(view);
                if (isEnd) {
                    setNameOverride(state.nameOverrides, source, target);
                } else {
                    setNameOverride(state.nameOverrides, target, source);
                }
            }
        }
    }

    private void setNameOverrides(TransitionState state, ArrayMap<String, View> namedViews, boolean isEnd) {
        int count = namedViews.size();
        for (int i = 0; i < count; i++) {
            String source = namedViews.keyAt(i);
            String target = FragmentTransitionCompat21.getTransitionName(namedViews.valueAt(i));
            if (isEnd) {
                setNameOverride(state.nameOverrides, source, target);
            } else {
                setNameOverride(state.nameOverrides, target, source);
            }
        }
    }

    /* loaded from: classes.dex */
    public class TransitionState {
        public View nonExistentView;
        public ArrayMap<String, String> nameOverrides = new ArrayMap<>();
        public ArrayList<View> hiddenFragmentViews = new ArrayList<>();
        public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();

        public TransitionState() {
        }
    }
}