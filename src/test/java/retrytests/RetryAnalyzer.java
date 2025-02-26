package retrytests;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{


    private int count = 0;
    private static final int MAX_RETRY_COUNT = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY_COUNT) {
            count++;
            System.out.println("Retrying test: " + result.getName() + " for the " + count + " time.");
            return true; // Retry the test
        }
        return false;  // Stop retrying after MAX_RETRY_COUNT attempts
    }





}
