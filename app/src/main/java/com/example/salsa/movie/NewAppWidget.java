package com.example.salsa.movie;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import java.text.DateFormat;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    private static final String SHARE_PREF_FILE = "appwidgetku";
    private static final String COUNT_KEY = "count";
    private static final int lala =0;
    public static int drawable = R.drawable.movie;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //construct the remoteviews object
        SharedPreferences prefs = context.getSharedPreferences(SHARE_PREF_FILE,0);
        int count = prefs.getInt(COUNT_KEY + appWidgetId,0);
        count ++;
        //String dateString = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
        // Construct the RemoteViews object

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        NewAppWidget lala = new NewAppWidget();
        lala.setFilm(count);
        //menyimpan kembali ke sharedpred
        SharedPreferences.Editor predEditor = prefs.edit();
        predEditor.putInt(COUNT_KEY + appWidgetId,count);
        predEditor.apply();

        //setup button update
        Intent intentUpdate = new Intent(context,NewAppWidget.class);
        //action intent harus sebagai app widget update
        intentUpdate.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);

        //masukkan id dari widget yang akan diupdate
        int[] idArray =new int[]{appWidgetId};
        intentUpdate.putExtra(appWidgetManager.EXTRA_APPWIDGET_IDS,idArray);

        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context,appWidgetId,intentUpdate,PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.button_update,pendingUpdate);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

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

    private void  setFilm(int currentPlace){
        int drawableId= -1;
//ganti icon
        switch (currentPlace){
            case 1:
                drawableId = R.drawable.black;
                break;
            case 2:
                drawableId = R.drawable.captain;
                break;
            case 3:
                drawableId = R.drawable.deadpool;
                break;
            case 4:
                drawableId = R.drawable.iron;
                break;
            case 5:
                drawableId = R.drawable.thoro;
                break;
        }

        if(drawableId < 0){
            drawableId = R.drawable.warning;
        }
        drawable=drawableId;
    }
}

