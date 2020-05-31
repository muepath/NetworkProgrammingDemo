package SimpleExampleDemo.Sychronized;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Process {
    public static void main(String[] args) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("D:\\tmp\\1.txt"));
            BookA a= new BookA(out);
            BookB b = new BookB(out);
            Thread t1 = new Thread(b);
            Thread t2 = new Thread(b);
            Thread t3 = new Thread(a);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
