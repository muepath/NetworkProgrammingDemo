package SimpleExampleDemo.StaticCallback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CallBackDigest implements Runnable {
    private  String filename;
    public CallBackDigest(String filename){
        this.filename=filename;
    }
    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in,sha);
            while (din.read()!=-1);
            din.close();
            byte[] digest=sha.digest();
            CallBackDigestUserInterface.receiveDigester(digest,filename);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }
}
