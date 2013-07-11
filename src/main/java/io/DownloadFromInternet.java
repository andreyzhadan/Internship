package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by azhadan on 7/11/13.
 */
public class DownloadFromInternet {
    private static final String domain = "http://skipy";
    private static List<String> allLinks = new ArrayList<String>();
    private static Stack<String> links = new Stack<String>();

    public static void main(String[] args) throws IOException {
        String baseUrl = "http://skipy.ru/";
        links.add(baseUrl);
        allLinks.add(baseUrl);
        //while (!links.isEmpty())
        crawl(links.remove(0));
    }

    public static void crawl(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output/" + urlString.replaceAll("/", "")));
        StringBuilder builder = new StringBuilder();
        int b;
        while ((b = in.read()) != -1) {
            bos.write(b);
            builder.append((char) b);
        }
        in.close();
        bos.flush();
        bos.close();
        //System.out.println(builder.toString());
        int index = 0;
        while ((index = builder.indexOf("http://", index)) != -1) {
            int index2 = builder.indexOf("\"", index);
            int index3 = builder.indexOf("\'", index);
            if (index2 > index3 && index3 != -1)
                index2 = index3;
            if (index2 != -1) {
                String link = builder.substring(index, index2);
                System.out.print(link);
                if (link.contains(domain) && !allLinks.contains(link)) {
                    links.push(link);
                    allLinks.add(link);
                    System.out.print(" this link is in the same domain");
                }
                System.out.println("\n");
                index = index2;
            }
        }
    }
}
