package SimpleExampleDemo.Tread;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestRunnable implements Runnable {
    private  String filename;
    public DigestRunnable(String filename){
        this.filename = filename;
    }
    @Override
    public void run(){
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in,sha);
            while (din.read()!=-1);
            din.close();
            byte[] digest=sha.digest();

            StringBuilder result = new StringBuilder(filename);
            result.append(":");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (IOException e) {
            System.err.println(e);
        }catch (NoSuchAlgorithmException e){
            System.err.println(e);
        }

    }

    public static void main(String[] args) {
        String[] filenames = {"D:\\tmp\\1.txt","D:\\tmp\\2.txt"};
        for(String filename:filenames){
            DigestRunnable dr = new DigestRunnable(filename);
            Thread t = new Thread(dr);
            t.start();
        }
    }
}

