import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class text{
    public static void main(String args[]) throws IOException {
        System.out.println("helloworld");
        FileOutputStream fileout=new FileOutputStream("/tmp/test/test",true);
        byte[] bt=("helloworld nimei").getBytes();
        fileout.write(bt,0,bt.length);
    }
}