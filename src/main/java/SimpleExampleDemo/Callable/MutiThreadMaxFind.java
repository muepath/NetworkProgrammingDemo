package SimpleExampleDemo.Callable;

import java.util.concurrent.*;

public class MutiThreadMaxFind {
    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if (data.length==1)return data[0];
        else if (data.length==0) throw new IllegalArgumentException();
        FindMaxTask t1 = new FindMaxTask(0,data.length/2,data);
        FindMaxTask t2 = new FindMaxTask(data.length/2,data.length,data);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(t1);
        Future<Integer> future2 = service.submit(t2);
        return  Math.max(future1.get(),future2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = {1,2,3,4,5,56,1,3,52,1,5,10};
        int max= max(data);
        System.out.println(max);
    }
}
