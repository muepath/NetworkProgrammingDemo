package SimpleExampleDemo.Stream;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class InputstreamDemo {
    public static void main(String[] args) {

    }
    public void readByteIntoArray(InputStream in) throws IOException {
        byte[] bytes = new byte[10];
        for (int i=0;i<10;i++){
            //read返回一个0-255的整数 如果读到输入流的末尾返回-1
            int b = in.read();
            if (b==-1)break;
            //0-255的int将会被转换为 -128~127的字节
            bytes[i]=(byte) b;
        }
    }
    public  void  readByteIntoArrayXWithBug(InputStream in)throws  IOException{
        int bytesRead=0;
        int bytesToRead=1024;
        byte[] input = new byte[bytesToRead];
        //一直尝试从输入流中读取字节直到读满1024个字节，亦即填充满整个字节数组
        while (bytesRead<bytesToRead){
            //注意这里有bug，当read读到输入流的末尾的时候，将会返回-1,如果这时已经读取到的字符串如果还没满1024，则程序会进入死循环。
            bytesRead += //每次加上上次读取到了的字节数，来表示已经读取到了的字节数
                    in.read(input,bytesRead,bytesToRead-bytesRead);//读取输入流的数据到Input数组中并返回读取到的字节数
        }
    }
    //修复了上个函数的bug
    public void readByteIntoArrayX(InputStream in )throws  IOException{
        int bytesRead=0;
        int bytesToRead=1024;
        byte[] input = new byte[bytesToRead];
        //一直尝试从输入流中读取字节直到读满1024个字节，亦即填充满整个字节数组
        while (bytesRead<bytesToRead){
            int n = in.read(input,bytesRead,bytesToRead-bytesRead);
            if(n==-1)break;//流结束
            bytesRead+=n;
        }
    }
}
