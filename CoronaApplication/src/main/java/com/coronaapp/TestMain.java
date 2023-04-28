package com.coronaapp;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TestMain {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Corona Application");
		
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
               String result = App.getData(metaData);
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


