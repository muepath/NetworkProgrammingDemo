package SimpleExampleDemo.Callable;

import java.util.concurrent.Callable;

public class FindMaxTask implements Callable<Integer> {
    private  int start;
    private  int end;
    private  int[] data;
    FindMaxTask (int start , int end , int[]data){
        this.data=data;
        this.end=end;
        this.start=start;
    }
    @Override
    public Integer call() throws Exception {
        int max= Integer.MIN_VALUE;
        for (int i = 0;i<data.length;i++){
            if (data[i]>max) max=data[i];
        }
        return max;
    }
}
