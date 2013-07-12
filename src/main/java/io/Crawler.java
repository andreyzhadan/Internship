package io;

import org.apache.commons.validator.UrlValidator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azhadan on 7/12/13.
 */
public class Crawler {

    private Stack<String> links = new Stack<String>();
    private Set<String> allLinks = new HashSet<String>();

    public Crawler() {
        links = new Stack<String>();
        allLinks = new HashSet<String>();
        links.add(Constants.BASE_URL);
        allLinks.add(Constants.BASE_URL);
    }

    public boolean checkCorrectness(String urlString) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(urlString);
    }

    public void crawl(String urlString) {
        //let's check url string correctness

        if (!checkCorrectness(urlString)) {
            System.out.println("URL is incorrect");
            return;
        }
        try {
            URL url = new URL(urlString);
            InputStream in = url.openStream();
            urlString = "output/" +
                    urlString.substring(0, Math.min(urlString.length(), 255))
                            .replaceAll("/", "")
                            .replaceAll("\\\\", "")
                            .replaceAll("\\?", "");
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(urlString));

            StringBuilder builder = new StringBuilder();
            int b;
            while ((b = in.read()) != -1) {
                bos.write(b);
                builder.append((char) b);
            }
            in.close();
            bos.flush();
            bos.close();

            //let's use some util lib to find urls
            List<String> urls = extractUrls(builder.toString());
            for (String elem : urls) {
                System.out.println(elem);
                if (elem.contains(Constants.DOMAIN) && !allLinks.contains(elem) && checkCorrectness(elem)) {
                    links.push(elem);
                    allLinks.add(elem);
                    System.out.print(" this link is in the same DOMAIN");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public List<String> extractUrls(String text) {
        List<String> result = new ArrayList<String>();

        Pattern pattern = Pattern.compile(
                "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                        "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                        "|mil|biz|info|mobi|name|aero|jobs|museum" +
                        "|travel|[a-z]{2}))(:[\\d]{1,5})?" +
                        "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" +
                        "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" +
                        "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                        "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" +
                        "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    public void search() {
        while (!links.isEmpty()) {
            crawl(links.pop());
        }

    }
}
