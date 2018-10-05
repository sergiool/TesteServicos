package site.ufsj.testeservicos;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class IntentServiceTest extends IntentService {

    public static final String TAG_INTENT_SERVICE = "TAG_INTENT_SERVICE";

    public IntentServiceTest() {
        super("IntentServiceTest");
    }

    // Invoked when this intent service is started.
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            // Get current child thread.
            Thread currThread = Thread.currentThread();
            // Get current thread info.
            String threadInfo = getThreadInfo(currThread);
            // Log current thread info.
            Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyIntentService child thread info." + threadInfo);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyIntentService onCreate() method is invoked.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyIntentService onDestroy() method is invoked.");
    }

    // Return thread info data include thread id, name and priority.
    public static String getThreadInfo(Thread thread)
    {
        long threadId = thread.getId();
        String threadName = thread.getName();
        int threadPriority = thread.getPriority();

        StringBuffer buffer = new StringBuffer();
        buffer.append(" id = ");
        buffer.append(threadId);
        buffer.append(" , name = ");
        buffer.append(threadName);
        buffer.append(" , priority = ");
        buffer.append(threadPriority);

        return buffer.toString();
    }

}
