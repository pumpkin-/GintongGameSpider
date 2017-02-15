import JavaBean.ProKnowledge;
import dao.impl.ProKnowledgeImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.swing.text.Style;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test{
    private static List<ProKnowledge> proKnowledges = new ArrayList<ProKnowledge>();
    public static void main(String args[]) throws ProKnowledgeImpl.FormatEexception, IOException {

        /*File file=new File("C:\\Users\\lenovo\\Desktop\\a.txt");
        FileInputStream input=new FileInputStream(file);
        InputStreamReader reader=new InputStreamReader(input);
        BufferedReader buffer=new BufferedReader(reader);
        String line=null;
        long counter=25787;
        while((line=buffer.readLine())!=null){
             counter=Long.parseLong(line);
        }

        FileOutputStream outputi=new FileOutputStream("C:\\Users\\lenovo\\Desktop\\a.txt",true);
        byte[] bt=("154541111985683"+"\r\n").getBytes();
        outputi.write(bt,0,bt.length);
        System.out.println(counter);*/

        int p=12;
        for(int i=p;i<100;i++){
            System.out.println(i);
        }


    }
}