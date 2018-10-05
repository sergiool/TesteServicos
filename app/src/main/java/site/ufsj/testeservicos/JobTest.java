package site.ufsj.testeservicos;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class JobTest extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        Thread currThread = Thread.currentThread();

        String currThreadInfo = IntentServiceTest.getThreadInfo(currThread);

        Log.d(IntentServiceTest.TAG_INTENT_SERVICE, "MyCommonService child thread info. " + currThreadInfo);

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
