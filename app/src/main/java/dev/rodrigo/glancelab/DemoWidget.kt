package dev.rodrigo.glancelab

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.updateAll
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.action.clickable
import java.text.DateFormat
import java.util.Date

class DemoWidget : GlanceAppWidget() {
    override val sizeMode = SizeMode.Responsive(setOf(DpSize(120.dp, 60.dp), DpSize(240.dp, 120.dp)))
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val timestamp = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(Date())
        provideContent { WidgetContent(timestamp) }
    }
}

@Composable
private fun WidgetContent(timestamp: String) {
    val size = LocalSize.current
    val expanded = size.width >= 200.dp && size.height >= 100.dp
    Column(GlanceModifier.fillMaxSize().padding(12.dp)) {
        Text(if (expanded) "Responsive Glance widget" else "Glance")
        Spacer(GlanceModifier.height(6.dp))
        Text("Updated $timestamp")
        if (expanded) {
            Spacer(GlanceModifier.height(8.dp))
            Text("Size ${size.width.value.toInt()}×${size.height.value.toInt()} dp", GlanceModifier.clickable(actionRunCallback<RefreshAction>()))
            Text("Tap the size line to refresh")
        }
    }
}

class RefreshAction : ActionCallback {
    override suspend fun onAction(context: Context, glanceId: GlanceId, parameters: androidx.glance.action.ActionParameters) {
        DemoWidget().updateAll(context)
    }
}

class DemoWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = DemoWidget()
}
