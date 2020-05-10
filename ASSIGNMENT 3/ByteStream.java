import java.io.*;

public class ByteStream {
    public static void main(String[] args ) throws IOException,FileNotFoundException{

        FileInputStream fi = new FileInputStream("C:\\Users\\DELL\\Desktop\\desktop\\ASSIGNMENT 3\\input.txt");
        FileOutputStream fo = new FileOutputStream("C:\\Users\\DELL\\Desktop\\desktop\\ASSIGNMENT 3\\output.txt");
        int temp;

        while ((temp = fi.read()) != -1) {
            fo.write(temp);

        }
        fi.close();
        fo.close();

    }
}

