package SimpleExampleDemo.InstanceCallback;

import javax.xml.bind.DatatypeConverter;

public class InstanceCallbackDigestUserInterface {
    private  String filename;
    private byte[] digest;
    public InstanceCallbackDigestUserInterface(String filename){
        this.filename = filename;
    }
    void receiveDigest(byte[] digest){
        this.digest = digest;
        System.out.println(this);
    }
    public void calculateDigest(){
       InstanceCallbackDigest icd = new InstanceCallbackDigest(filename,this);
        Thread t = new Thread(icd);
        t.start();
    }
    @Override
    public  String toString(){
        String result = filename +":";
        if(digest!=null){
            result += DatatypeConverter.printHexBinary(digest);
        }else {
            result+="digest not avaliable";
        }
        return result;
    }
    public static void main(String[] args) {
        String[] filenames = {"D:\\tmp\\1.txt","D:\\tmp\\2.txt"};
        for(String filename:filenames){
            InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
            d.calculateDigest();
        }
    }
}
