package SimpleExampleDemo.Sychronized;

import java.io.*;
import java.net.StandardSocketOptions;

public class BookA implements Runnable {
    OutputStreamWriter out ;
    public BookA(OutputStreamWriter out){
        this.out=out;
    }
    public  void  print() throws IOException {
        synchronized (out) {
            out.write("this is a good book \n");
            out.write("bookA\n");
            out.write("i like this book \n");
        }
    }

    @Override
    public void run(){
        for(int i = 0 ;i <10;i++){
            try {
                print();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
