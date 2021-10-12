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
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0 ,intent,0)
            val views = RemoteViews(context!!.packageName, R.layout.app_widget)
            views.setOnClickPendingIntent(R.id.app_widget_btn,pendingIntent)
            appWidgetManager!!.updateAppWidget(appWidgetId,views)
        }
    }
}