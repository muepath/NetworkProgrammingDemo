package SimpleExampleDemo.Sychronized;

import java.io.*;

public class BookB implements  Runnable {
    OutputStreamWriter out ;
    public BookB(OutputStreamWriter out){
        this.out=out;
    }
    public  void  print() throws IOException {
        synchronized (this) {
            out.write("this is a bad book \n");
            out.write("bookB\n");
            out.write("i dislike this book \n");
        }
    }
    @Override
    public void run() {
        for (int i = 0 ;i<10;i++){
            try {
                print();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
