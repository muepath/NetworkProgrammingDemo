package SimpleExampleDemo.StaticCallback;

import SimpleExampleDemo.StaticCallback.CallBackDigest;

import javax.xml.bind.DatatypeConverter;

public class CallBackDigestUserInterface {
    public static void receiveDigester(byte[] digest,String filename){
        StringBuilder result = new StringBuilder(filename);
        result.append(":");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }
    public static void main(String[] args) {
        String[] filenames = {"D:\\tmp\\1.txt","D:\\tmp\\2.txt"};
        for(String filename:filenames){
           CallBackDigest cd = new CallBackDigest(filename);
           Thread t = new Thread(cd);
            t.start();
        }
    }

}
