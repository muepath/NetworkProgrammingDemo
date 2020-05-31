package SimpleExampleDemo.Stream;

import java.io.*;

public class GenerateCharactersDemo {
    public static void main(String[] args) {
        File file = new File("d:/tmp", "generateCharacters.txt");
        try {
            file.createNewFile(); // 创建文件
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try(FileOutputStream out = new FileOutputStream(file)) {
            generateCharactersX(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //生成字符串
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter=33;
        int numberOfPrintableCharacters=94;
        int numberOfCharactersPerLine=72;
        int start = firstPrintableCharacter;
        while (true){
            for (int i=start;i<start+numberOfCharactersPerLine;i++){
                //wirte接受一个0-255的int值并将其写入输出流  如果输出流是网络流该 int值将会被包装很多信息头
                out.write(((i-firstPrintableCharacter)%numberOfPrintableCharacters)+firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start=((start+1)-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
        }

    }
    //带缓冲的生成字符串
    public static  void  generateCharactersX(OutputStream out)throws IOException{
        int firstPrintableCharacter=33;
        int numberOfPrintableCharacters=94;
        int numberOfCharactersPerLine=72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine+2];
        while (true){
            for (int i=start;i<start+numberOfCharactersPerLine;i++){
                line[i-start]= (byte)(((i-firstPrintableCharacter)%numberOfPrintableCharacters)+firstPrintableCharacter);
            }
            line[72]=(byte)'\r';
            line[73]=(byte)'\n';
            out.write(line);
            start=((start+1)-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
        }
    }
}
