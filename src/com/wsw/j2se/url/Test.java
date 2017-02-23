package com.wsw.j2se.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 通过网站域名URL获取该网站的源码
 * @author Administrator
 *
 */
class test {
    /** *//**
     * @param args
     *
     */
    public static void main(String[] args) throws Exception    {
        Document doc = Jsoup.connect("").get();
        System.out.println(doc);
//        URL url = new URL("http://www.mofang.com/news/");
//        String urlsource = getURLSource(url);
//        System.out.println(urlsource);
    }

    /** *//**
     * 通过网站域名URL获取该网站的源码
     * @param url
     * @return String
     * @throws Exception
     */
    public static String getURLSource(URL url) throws Exception    {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream =  conn.getInputStream();  //通过输入流获取html二进制数据
        byte[] data = readInputStream(inStream);        //把二进制数据转化为byte字节数据
        String htmlSource = new String(data);
        return htmlSource;
    }

    /** *//**
     * 把二进制流转化为byte字节数组
     * @param instream
     * @return byte[]
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream instream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[]  buffer = new byte[1204];
        int len = 0;
        while ((len = instream.read(buffer)) != -1){
            outStream.write(buffer,0,len);
        }
        instream.close();
        return outStream.toByteArray();
    }
}