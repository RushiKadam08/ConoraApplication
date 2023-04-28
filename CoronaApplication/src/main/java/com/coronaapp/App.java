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
    public static void main( String[] args ) throws Exception {
/*

        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter Here Country Name :" );
        String country = scanner.nextLine();
        System.out.println(getData(country));
*/

        JFrame jFrame = new JFrame("Details Country :");
        jFrame.setSize(500,500);

        Font font = new Font("Poppins", Font.BOLD, 30);

        // textfield

        JTextField textField = new JTextField();
        JLabel fLabel = new JLabel();
        textField.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        fLabel.setFont(font);
        fLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton jButton = new JButton("Get");

        jButton.addActionListener(event ->{

           try{
               String metaData = textField.getText();
               String result = getData(metaData);
               fLabel.setText(result);
           }catch (Exception e){
               e.printStackTrace();
           }

        });

        jFrame.setLayout(new BorderLayout());
        jFrame.add(textField, BorderLayout.NORTH);
        jFrame.add(fLabel,BorderLayout.CENTER);
        jFrame.add(jButton, BorderLayout.SOUTH);

        jFrame.setVisible(true);



    }
}
