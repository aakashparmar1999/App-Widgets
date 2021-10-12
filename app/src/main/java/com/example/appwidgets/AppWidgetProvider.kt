package com.example.appwidgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

open class AppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        for (appWidgetId in appWidgetIds!!) {
            //remote view
            val views = RemoteViews(context!!.packageName, R.layout.app_widget)
            //intent
            val intent = Intent(context, MainActivity::class.java)
            //pending intent on view
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            //pending intent on view
            views.setOnClickPendingIntent(R.id.app_widget_btn, pendingIntent)

            //update the widget
            appWidgetManager!!.updateAppWidget(appWidgetId, views)
        }
    }
}