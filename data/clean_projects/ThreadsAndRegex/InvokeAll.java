import java.util.concurrent.Executors;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.*;

public class InvokeAll {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Callable<String>> tasks = Arrays.asList(
                () ->{Thread.sleep(1000); return "task 1 has been done";},
                 () ->{Thread.sleep(1000); return "task 2 has been done";},
                 () ->{Thread.sleep(1000); return "task 1 has been done";}
        );

            String results =executor.invokeAny(tasks);
        System.out.println("Task 1:" + results);
    }
}
