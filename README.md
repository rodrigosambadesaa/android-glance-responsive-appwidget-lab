# Glance Responsive AppWidget Lab

A small, original **Jetpack Glance** home-screen widget lab.

- Uses `GlanceAppWidget` and `GlanceAppWidgetReceiver`.
- `SizeMode.Responsive` provides compact and expanded breakpoints.
- Reads `LocalSize` to adapt content after widget resizing.
- Includes an in-widget refresh action using `ActionCallback` and `updateAll()`.
- Uses stable `androidx.glance:glance-appwidget:1.1.1`.

Add the widget from the launcher's widget picker, resize it, and compare the compact/expanded content.
