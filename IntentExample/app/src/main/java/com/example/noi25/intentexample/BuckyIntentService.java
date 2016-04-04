package com.example.noi25.intentexample;

import android.content.Intent;
import android.app.IntentService;
import android.util.Log;

public class BuckyIntentService extends IntentService{

    public final static String TAG = "com.example.noi25.intentexample";

    public BuckyIntentService() {
        super("BuckysIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG,"The service has now started!");
    }
}
