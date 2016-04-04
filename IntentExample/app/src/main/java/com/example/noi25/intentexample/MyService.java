package com.example.noi25.intentexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public final static String TAG = "com.example.noi25.intentexample";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand methode called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(futureTime < System.currentTimeMillis()){
                        synchronized (this){
                            try{
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG,"service is doing something");
                            }catch(Exception e){}
                        }
                    }
                }

            }
        };

        Thread buckysThread = new Thread(r);
        buckysThread.start();

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy methode called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
