package Controller;

import Model.StatisticsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIStatisticsController {
    public StatisticsController statisticsController;

    public void onShowCollegueStatButton(){

    }

    public void showColleguesStatScreen(){
        onShowCollegueStatButton();
        String number = "0";
        JFrame frame = new JFrame("Preview");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label1 = new JLabel("Your yesterday statistics");
        JLabel label2 = new JLabel("Number of records compleated");
        JLabel label3 = new JLabel("yesterday - " + number);

        label1.setFont(new Font("Serif", Font.PLAIN, 16));
        label2.setFont(new Font("Serif", Font.PLAIN, 12));
        label3.setFont(new Font("Serif", Font.PLAIN, 12));
        label1.setBounds(20,10, 150,30);
        label2.setBounds(20,50, 150,30);
        label3.setBounds(60,90, 100,30);

        Button ok = new Button("OK");
        ok.setBounds(80, 130, 40 ,20);

        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(ok);
        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
