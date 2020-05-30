package SimpleExampleDemo;

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

        try {
            FileOutputStream out = new FileOutputStream(file);
            generateCharacters(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter=33;
        int numberOfPrintableCharacters=94;
        int numberOfCharactersPerLine=72;
        int start = firstPrintableCharacter;
        while (true){
            for (int i=start;i<start+numberOfCharactersPerLine;i++){
                out.write(((i-firstPrintableCharacter)%numberOfPrintableCharacters)+firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start=((start+1)-firstPrintableCharacter)%numberOfPrintableCharacters+firstPrintableCharacter;
        }

    }
}
