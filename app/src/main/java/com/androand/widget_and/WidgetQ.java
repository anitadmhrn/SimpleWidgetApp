package com.androand.widget_and;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import io.paperdb.Paper;


/**
 *
 * ANITA DWI MAHARANI
 * 1657051008
 *
 */

/**
 * Implementation of App Widget functionality.
 */
public class WidgetQ extends AppWidgetProvider {

    // ***11
    static String CLICK_ACTION = "CLICKED";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // ***!2
        Intent intent = new Intent (context, WidgetQ.class);
        intent.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);

      // hapus  CharSequence widgetText = context.getString(R.string.appwidget_text);

        //init Paper    **6
        Paper.init(context);

        //Read COntent   **7
        String title = Paper.book().read("title");
        String content = Paper.book().read("content");

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_q);
        //views.setTextViewText(R.id.appwidget_text, widgetText);  **8
        views.setTextViewText(R.id.appwidget_title, title);  // **9
        views.setTextViewText(R.id.appwidget_content, content);  // **9
        views.setOnClickPendingIntent(R.id.layout_wrapper, pendingIntent); // ***13

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

//__________________________________
    //Press ctrl+o   ***14
    //akan keluar di bawah ini ehehhehe pilih onReceive

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if(intent.getAction().equals(CLICK_ACTION))
            Toast.makeText(context, "Widget CLICKED YOOOO!!!",  Toast.LENGTH_SHORT).show();
    }
//_______________________________

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

