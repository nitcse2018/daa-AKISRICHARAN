import java.io.*;

public class CharacterStream {
    public static void main(String[] args ) throws IOException,FileNotFoundException{

        FileInputStream fi = new FileInputStream("C:\\Users\\DELL\\Desktop\\desktop\\ASSIGNMENT 3\\inputc.txt");
        FileOutputStream fo = new FileOutputStream("C:\\Users\\DELL\\Desktop\\desktop\\ASSIGNMENT 3\\outputc.txt");
        int temp;

        while ((temp = fi.read()) != -1) {
            fo.write((char)temp);

        }
        fi.close();
        fo.close();

    }
}

