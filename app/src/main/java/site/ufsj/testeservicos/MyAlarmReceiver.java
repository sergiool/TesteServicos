package site.ufsj.testeservicos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyAlarmReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "site.ufsj.testeservicos.alarm";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Thread currThread = Thread.currentThread();

        String currThreadInfo = IntentServiceTest.getThreadInfo(currThread);

        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService child thread info. " + currThreadInfo);

        Intent i = new Intent(context, IntentServiceTest.class);
        i.putExtra("foo", "bar");
        context.startService(i);

    }
}
