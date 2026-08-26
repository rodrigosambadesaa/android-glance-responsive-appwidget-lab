package gal.rodrigosambade.glancelab
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.glance.*
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionRunCallback
import androidx.glance.appwidget.*
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.unit.ColorProvider
class DemoWidget: GlanceAppWidget(){
 override val sizeMode=SizeMode.Responsive(setOf(DpSize(110.dp,60.dp),DpSize(180.dp,100.dp),DpSize(260.dp,160.dp)))
 override suspend fun provideGlance(context:Context,id:GlanceId){val count=context.getSharedPreferences("widget",Context.MODE_PRIVATE).getInt("count",0);provideContent{Content(count)}}
 @Composable private fun Content(count:Int){val size=LocalSize.current;Column(modifier=GlanceModifier.fillMaxSize().padding(12.dp).background(ColorProvider(android.R.color.system_accent1_100)),verticalAlignment=Alignment.Vertical.CenterVertically){Text("Glance · $count");if(size.width>=180.dp)Text("${size.width.value.toInt()}×${size.height.value.toInt()} dp");if(size.height>=100.dp)Button("Incrementar",onClick=actionRunCallback<IncrementCallback>());if(size.width>=250.dp)Text("Layout grande")}}
}
class DemoWidgetReceiver:GlanceAppWidgetReceiver(){override val glanceAppWidget:GlanceAppWidget=DemoWidget()}
class IncrementCallback:ActionCallback{override suspend fun onAction(context:Context,glanceId:GlanceId,parameters:ActionParameters){val p=context.getSharedPreferences("widget",Context.MODE_PRIVATE);p.edit().putInt("count",p.getInt("count",0)+1).apply();DemoWidget().update(context,glanceId)}}
suspend fun updateAllWidgets(context:Context){DemoWidget().updateAll(context)}
