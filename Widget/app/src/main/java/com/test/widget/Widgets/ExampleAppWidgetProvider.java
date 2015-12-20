package com.test.widget.Widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.test.widget.MainActivity;
import com.test.widget.R;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, WidService.class);
            intent.putExtra(WidService.ACTION, WidService.ACTION_BT);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

            Intent intent1 = new Intent(context, WidServiceWiFI.class);
            intent1.putExtra(WidServiceWiFI.ACTION, WidServiceWiFI.ACTION_BT);
            PendingIntent pendingIntent1 = PendingIntent.getService(context, 0, intent1, 0);

            Intent intent2 = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 0, intent2, 0);


            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.view_mywidget);
            views.setOnClickPendingIntent(R.id.buttonBl, pendingIntent);
            views.setOnClickPendingIntent(R.id.buttonWF, pendingIntent1 );
            views.setOnClickPendingIntent(R.id.buttonAC, pendingIntent2);


            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }





    }
}
