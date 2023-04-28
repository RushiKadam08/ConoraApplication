package com.coronaapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class App
{

    public static String getData(String c) throws Exception {

        StringBuffer sb = new StringBuffer();

        sb.append("<html>" + "<body style ='text-align:center;color:red;'>");
        sb.append(c.toUpperCase() +"<br>");
        String url ="https://www.worldometers.info/coronavirus/country/"+c+"/";
        Document document = Jsoup.connect(url).get();

        Elements elements = document.select("#maincounter-wrap");
        elements.forEach(e -> {
            String text = e.select("h1").text();
            String count = e.select(".maincounter-number>span").text();

            sb.append(text).append(" ").append(count).append("<br>");
        } );
        sb.append("</body>" + "</html>");

      return sb.toString();
    }
}
