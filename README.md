This repository features an example of compose multiplatform and jetpack compose compatibility
issue.

The issue appears if you use a composable function from multiplatform module in an android app and
the function calls
`MeasureResult.layout` without providing `alignmentLines` parameter (which has a default value).

## Build & Run

Run

```shell
./gradlew assembleDebug
```

and then install and run produced apk (`app/build/outputs/apk/debug/app-debug.apk`).
The app will crash right after launch with the following stacktrace (tested on android 14):

```
java.lang.NoSuchMethodError: No static method layout$default(Landroidx/compose/ui/layout/MeasureScope;IILjava/util/Map;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Landroidx/compose/ui/layout/MeasureResult; in class Landroidx/compose/ui/layout/MeasureScope; or its super classes (declaration of 'androidx.compose.ui.layout.MeasureScope' appears in /data/app/~~LU3_khy9PGLqWFNT6qOyTw==/com.firelion.composeissue--IW9u4BB3tq5PIncLBCMPw==/base.apk)
    at com.firelion.composeissue.jb.JbBoxKt.JbBox$lambda$1(JbBox.kt:15)
    at com.firelion.composeissue.jb.JbBoxKt.$r8$lambda$Qhg8UchGWaQufvJNnzws3rlvJ3A(Unknown Source:0)
    at com.firelion.composeissue.jb.JbBoxKt$$ExternalSyntheticLambda1.invoke(D8$$SyntheticClass:0)
    at androidx.compose.ui.layout.LayoutModifierImpl.measure-3p2s80s(LayoutModifier.kt:294)
    at androidx.compose.ui.node.LayoutModifierNodeCoordinator.measure-BRTryo0(LayoutModifierNodeCoordinator.kt:116)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:252)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:251)
    at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2303)
    at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:500)
    at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:256)
    at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
    at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1617)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:36)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:620)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.measure-BRTryo0(LayoutNodeLayoutDelegate.kt:596)
    at androidx.compose.ui.layout.RootMeasurePolicy.measure-3p2s80s(RootMeasurePolicy.kt:38)
    at androidx.compose.ui.node.InnerNodeCoordinator.measure-BRTryo0(InnerNodeCoordinator.kt:126)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:252)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1.invoke(LayoutNodeLayoutDelegate.kt:251)
    at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:2303)
    at androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap.observe(SnapshotStateObserver.kt:500)
    at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:256)
    at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:133)
    at androidx.compose.ui.node.OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release(OwnerSnapshotObserver.kt:113)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate.performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:1617)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:36)
    at androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate.remeasure-BRTryo0(LayoutNodeLayoutDelegate.kt:620)
    at androidx.compose.ui.node.LayoutNode.remeasure-_Sx5XlM$ui_release(LayoutNode.kt:1145)
    at androidx.compose.ui.node.MeasureAndLayoutDelegate.doRemeasure-sdFAvZA(MeasureAndLayoutDelegate.kt:354)
    at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureOnly(MeasureAndLayoutDelegate.kt:562)
    at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureOnly(MeasureAndLayoutDelegate.kt:407)
    at androidx.compose.ui.platform.AndroidComposeView.onMeasure(AndroidComposeView.android.kt:1058)
    at android.view.View.measure(View.java:27122)
    at androidx.compose.ui.platform.AbstractComposeView.internalOnMeasure$ui_release(ComposeView.android.kt:302)
    at androidx.compose.ui.platform.AbstractComposeView.onMeasure(ComposeView.android.kt:289)
    at android.view.View.measure(View.java:27122)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:7008)
    at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
    at android.view.View.measure(View.java:27122)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:7008)
    at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1608)
    at android.widget.LinearLayout.measureVertical(LinearLayout.java:878)
    at android.widget.LinearLayout.onMeasure(LinearLayout.java:721)
    at android.view.View.measure(View.java:27122)
    at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:7008)
    at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
    at com.android.internal.policy.DecorView.onMeasure(DecorView.java:750)
    at android.view.View.measure(View.java:27122)
    at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:4182)
    at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:2759)
    at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:3086)
    at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:2465)
    at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:9305)
    at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1339)
    at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1348)
    at android.view.Choreographer.doCallbacks(Choreographer.java:952)
    at android.view.Choreographer.doFrame(Choreographer.java:882)
    at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1322)
    at android.os.Handler.handleCallback(Handler.java:958)
    at android.os.Handler.dispatchMessage(Handler.java:99)
    at android.os.Looper.loopOnce(Looper.java:205)
    at android.os.Looper.loop(Looper.java:294)
    at android.app.ActivityThread.main(ActivityThread.java:8177)
    at java.lang.reflect.Method.invoke(Native Method)
    at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:552)
    at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:971)
```

## Fixes

Any of those actions will fix the crash:

+ (surprisingly) Use "Run" action in Android Studio. That action compiles and installs unsigned
  version of the app that somehow lacks the bug
+ Pass an extra parameter to `layout` function from stacktrace to eliminate `layout$default` call
+ Move affected composable function (`JbBox`) into android module