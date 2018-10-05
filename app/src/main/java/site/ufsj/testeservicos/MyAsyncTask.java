package site.ufsj.testeservicos;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... voids) {
        Thread currThread = Thread.currentThread();

        String currThreadInfo = IntentServiceTest.getThreadInfo(currThread);

        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService child thread info. " + currThreadInfo);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Método que envia os produtos encontrados para a main thread.

    }
}
