package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentTransitionCompat21 {

    /* loaded from: classes.dex */
    public static class EpicenterView {
        public View epicenter;
    }

    /* loaded from: classes.dex */
    public interface ViewRetriever {
        View getView();
    }

    FragmentTransitionCompat21() {
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static Object cloneTransition(Object transition) {
        if (transition != null) {
            return ((Transition) transition).clone();
        }
        return transition;
    }

    public static Object captureExitingViews(Object exitTransition, View root, ArrayList<View> viewList, Map<String, View> namedViews) {
        if (exitTransition != null) {
            captureTransitioningViews(viewList, root);
            if (namedViews != null) {
                viewList.removeAll(namedViews.values());
            }
            if (viewList.isEmpty()) {
                return null;
            }
            addTargets((Transition) exitTransition, viewList);
            return exitTransition;
        }
        return exitTransition;
    }

    public static void excludeTarget(Object transitionObject, View view, boolean exclude) {
        Transition transition = (Transition) transitionObject;
        transition.excludeTarget(view, exclude);
    }

    public static void beginDelayedTransition(ViewGroup sceneRoot, Object transitionObject) {
        Transition transition = (Transition) transitionObject;
        TransitionManager.beginDelayedTransition(sceneRoot, transition);
    }

    public static void setEpicenter(Object transitionObject, View view) {
        Transition transition = (Transition) transitionObject;
        final Rect epicenter = getBoundsOnScreen(view);
        transition.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.support.v4.app.FragmentTransitionCompat21.1
            @Override // android.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(Transition transition2) {
                return epicenter;
            }
        });
    }

    public static void addTransitionTargets(Object enterTransitionObject, Object sharedElementTransitionObject, final View container, final ViewRetriever inFragment, View nonExistentView, EpicenterView epicenterView, final Map<String, String> nameOverrides, final ArrayList<View> enteringViews, final Map<String, View> renamedViews, ArrayList<View> sharedElementTargets) {
        if (enterTransitionObject != null || sharedElementTransitionObject != null) {
            final Transition enterTransition = (Transition) enterTransitionObject;
            if (enterTransition != null) {
                enterTransition.addTarget(nonExistentView);
            }
            if (sharedElementTransitionObject != null) {
                Transition sharedElementTransition = (Transition) sharedElementTransitionObject;
                addTargets(sharedElementTransition, sharedElementTargets);
            }
            if (inFragment != null) {
                container.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.FragmentTransitionCompat21.2
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        container.getViewTreeObserver().removeOnPreDrawListener(this);
                        View fragmentView = inFragment.getView();
                        if (fragmentView != null) {
                            if (!nameOverrides.isEmpty()) {
                                FragmentTransitionCompat21.findNamedViews(renamedViews, fragmentView);
                                renamedViews.keySet().retainAll(nameOverrides.values());
                                for (Map.Entry<String, String> entry : nameOverrides.entrySet()) {
                                    String to = entry.getValue();
                                    View view = (View) renamedViews.get(to);
                                    if (view != null) {
                                        String from = entry.getKey();
                                        view.setTransitionName(from);
                                    }
                                }
                            }
                            if (enterTransition != null) {
                                FragmentTransitionCompat21.captureTransitioningViews(enteringViews, fragmentView);
                                enteringViews.removeAll(renamedViews.values());
                                FragmentTransitionCompat21.addTargets(enterTransition, enteringViews);
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                });
            }
            setSharedElementEpicenter(enterTransition, epicenterView);
        }
    }

    public static Object mergeTransitions(Object enterTransitionObject, Object exitTransitionObject, Object sharedElementTransitionObject, boolean allowOverlap) {
        boolean overlap = true;
        Transition enterTransition = (Transition) enterTransitionObject;
        Transition exitTransition = (Transition) exitTransitionObject;
        Transition sharedElementTransition = (Transition) sharedElementTransitionObject;
        if (enterTransition != null && exitTransition != null) {
            overlap = allowOverlap;
        }
        if (overlap) {
            TransitionSet transitionSet = new TransitionSet();
            if (enterTransition != null) {
                transitionSet.addTransition(enterTransition);
            }
            if (exitTransition != null) {
                transitionSet.addTransition(exitTransition);
            }
            if (sharedElementTransition != null) {
                transitionSet.addTransition(sharedElementTransition);
            }
            return transitionSet;
        }
        Transition staggered = null;
        if (exitTransition != null && enterTransition != null) {
            staggered = new TransitionSet().addTransition(exitTransition).addTransition(enterTransition).setOrdering(1);
        } else if (exitTransition != null) {
            staggered = exitTransition;
        } else if (enterTransition != null) {
            staggered = enterTransition;
        }
        if (sharedElementTransition != null) {
            TransitionSet together = new TransitionSet();
            if (staggered != null) {
                together.addTransition(staggered);
            }
            together.addTransition(sharedElementTransition);
            return together;
        }
        Transition transition = staggered;
        return transition;
    }

    private static void setSharedElementEpicenter(Transition transition, final EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: android.support.v4.app.FragmentTransitionCompat21.3
                private Rect mEpicenter;

                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition2) {
                    if (this.mEpicenter == null && EpicenterView.this.epicenter != null) {
                        this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(EpicenterView.this.epicenter);
                    }
                    return this.mEpicenter;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect getBoundsOnScreen(View view) {
        Rect epicenter = new Rect();
        int[] loc = new int[2];
        view.getLocationOnScreen(loc);
        epicenter.set(loc[0], loc[1], loc[0] + view.getWidth(), loc[1] + view.getHeight());
        return epicenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void captureTransitioningViews(ArrayList<View> transitioningViews, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.isTransitionGroup()) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    captureTransitioningViews(transitioningViews, child);
                }
                return;
            }
            transitioningViews.add(view);
        }
    }

    public static void findNamedViews(Map<String, View> namedViews, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                namedViews.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    findNamedViews(namedViews, child);
                }
            }
        }
    }

    public static void cleanupTransitions(final View sceneRoot, final View nonExistentView, Object enterTransitionObject, final ArrayList<View> enteringViews, Object exitTransitionObject, final ArrayList<View> exitingViews, Object sharedElementTransitionObject, final ArrayList<View> sharedElementTargets, Object overallTransitionObject, final ArrayList<View> hiddenViews, final Map<String, View> renamedViews) {
        final Transition enterTransition = (Transition) enterTransitionObject;
        final Transition exitTransition = (Transition) exitTransitionObject;
        final Transition sharedElementTransition = (Transition) sharedElementTransitionObject;
        final Transition overallTransition = (Transition) overallTransitionObject;
        if (overallTransition != null) {
            sceneRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.v4.app.FragmentTransitionCompat21.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (enterTransition != null) {
                        enterTransition.removeTarget(nonExistentView);
                        FragmentTransitionCompat21.removeTargets(enterTransition, enteringViews);
                    }
                    if (exitTransition != null) {
                        FragmentTransitionCompat21.removeTargets(exitTransition, exitingViews);
                    }
                    if (sharedElementTransition != null) {
                        FragmentTransitionCompat21.removeTargets(sharedElementTransition, sharedElementTargets);
                    }
                    for (Map.Entry<String, View> entry : renamedViews.entrySet()) {
                        View view = entry.getValue();
                        String name = entry.getKey();
                        view.setTransitionName(name);
                    }
                    int numViews = hiddenViews.size();
                    for (int i = 0; i < numViews; i++) {
                        overallTransition.excludeTarget((View) hiddenViews.get(i), false);
                    }
                    overallTransition.excludeTarget(nonExistentView, false);
                    return true;
                }
            });
        }
    }

    public static void removeTargets(Object transitionObject, ArrayList<View> views) {
        Transition transition = (Transition) transitionObject;
        int numViews = views.size();
        for (int i = 0; i < numViews; i++) {
            transition.removeTarget(views.get(i));
        }
    }

    public static void addTargets(Object transitionObject, ArrayList<View> views) {
        Transition transition = (Transition) transitionObject;
        int numViews = views.size();
        for (int i = 0; i < numViews; i++) {
            transition.addTarget(views.get(i));
        }
    }
}