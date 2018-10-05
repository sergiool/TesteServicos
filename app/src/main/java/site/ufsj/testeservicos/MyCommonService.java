package site.ufsj.testeservicos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyCommonService extends Service {
    public MyCommonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Invoked when the service is started.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Create a child thread.
        Thread childThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    Thread currThread = Thread.currentThread();

                    currThread.sleep(1000);

                    String currThreadInfo = IntentServiceTest.getThreadInfo(currThread);

                    Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService child thread info. " + currThreadInfo);

                    // Invoke below method to stop the background service manually.
                    stopSelf();
                }catch(InterruptedException ex)
                {
                    Log.e(IntentServiceTest.TAG_INTENT_SERVICE, ex.getMessage(), ex);
                }
            }
        };

        // Start the child thread.
        childThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService onCreate() method is invoked.");
    }

    @Override
    public void onDestroy() {
        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService onDestroy() method is invoked.");
    }
}
