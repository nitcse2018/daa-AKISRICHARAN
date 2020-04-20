package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.awt.*;

public class Create_Resume extends Frame implements ActionListener, WindowListener {
    private Label main, sub1, l1, l2, l3, l4, l5, l6, sub2, l7, l8, l9, l10, sub3, l11, l12, l13;
    private TextField tf1, tf2, tf4, tf5, tf6, tf7, tf8, tf10, tf11, tf12, tf13;
    private Choice c3, c9;
    private Button b;

    Create_Resume() {
        main = new Label("RESUME");
        main.setFont(new Font("SansSerif", Font.BOLD, 15));
        main.setBounds(200, 30, 100, 15);

        sub1 = new Label("PERSONAL DETAILS");
        sub1.setFont(new Font("SansSerif", Font.BOLD, 15));
        sub1.setBounds(10, 50, 150, 15);

        l1 = new Label("Name");
        l1.setBounds(10, 70, 100, 25);

        tf1 = new TextField(50);
        tf1.setBounds(150, 70, 300, 25);

        l2 = new Label("Age");
        l2.setBounds(10, 100, 100, 25);

        tf2 = new TextField(50);
        tf2.setBounds(150, 100, 300, 25);

        l3 = new Label("Gender");
        l3.setBounds(10, 140, 100, 25);

        c3 = new Choice();
        c3.setBounds(150, 140, 300, 25);
        c3.add("Male");
        c3.add("Female");
        c3.add("Others");

        l4 = new Label("Address");
        l4.setBounds(10, 170, 100, 25);

        tf4 = new TextField(100);
        tf4.setBounds(150, 170, 300, 30);

        l5 = new Label("Mobile");
        l5.setBounds(10, 220, 100, 25);

        tf5 = new TextField(50);
        tf5.setBounds(150, 220, 300, 25);

        l6 = new Label("Email");
        l6.setBounds(10, 250, 100, 25);

        tf6 = new TextField(50);
        tf6.setBounds(150, 250, 300, 25);

        sub2 = new Label("EDUCATIONAL QUALIFICATIONS");
        sub2.setFont(new Font("SansSerif", Font.BOLD, 15));
        sub2.setBounds(10, 280, 250, 15);

        l7 = new Label("Institution");
        l7.setBounds(10, 310, 100, 25);

        tf7 = new TextField(50);
        tf7.setBounds(150, 310, 300, 25);

        l8 = new Label("Branch");
        l8.setBounds(10, 340, 100, 25);

        tf8 = new TextField(50);
        tf8.setBounds(150, 340, 300, 25);

        l9 = new Label("Year");
        l9.setBounds(10, 370, 100, 25);

        c9 = new Choice();
        c9.setBounds(150, 370, 300, 25);
        c9.add("1st year");
        c9.add("2nd year");
        c9.add("3rd year");
        c9.add("4th year");
        c9.add("passed out");

        l10 = new Label("CGPA");
        l10.setBounds(10, 400, 100, 25);

        tf10 = new TextField(50);
        tf10.setBounds(150, 400, 300, 25);

        sub3 = new Label("OTHERS");
        sub3.setFont(new Font("SansSerif", Font.BOLD, 15));
        sub3.setBounds(10, 430, 250, 15);

        l11 = new Label("WORK EXPERIENCE");
        l11.setBounds(10, 460, 150, 20);

        tf11 = new TextField(50);
        tf11.setBounds(170, 460, 300, 20);

        l12 = new Label("SKILLS");
        l12.setBounds(10, 490, 150, 20);

        tf12 = new TextField(50);
        tf12.setBounds(170, 490, 300, 20);

        l13 = new Label("CAREER OBJECTIVE");
        l13.setBounds(10, 520, 150, 20);

        tf13 = new TextField(50);
        tf13.setBounds(170, 520, 300, 20);

        b = new Button("GENERATE RESUME");
        b.setBounds(150, 600, 200, 25);


        add(main);
        add(sub1);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(l3);
        add(c3);
        add(l4);
        add(tf4);
        add(l5);
        add(tf5);
        add(l6);
        add(tf6);
        add(sub2);
        add(l7);
        add(tf7);
        add(l8);
        add(tf8);
        add(l9);
        add(c9);
        add(l10);
        add(tf10);
        add(sub3);
        add(l11);
        add(tf11);
        add(l12);
        add(tf12);
        add(l13);
        add(tf13);
        add(b);

        setLayout(null);
        setSize(500, 700);
        setVisible(true);
        addWindowListener(this);
        b.addActionListener(this);


    }

    public void actionPerformed(ActionEvent actionEvent) {
        String name = tf1.getText();
        String age = tf2.getText();
        String gender = c3.getSelectedItem();
        String address = tf4.getText();
        String mobile = tf5.getText();
        String email = tf6.getText();
        String institute = tf7.getText();
        String branch = tf8.getText();
        String year = c9.getSelectedItem();
        String cgpa = tf10.getText();
        String workexp = tf11.getText();
        String skills = tf12.getText();
        String careerobj = tf13.getText();

        try {
            FileWriter f = new FileWriter("C:\\Users\\DELL\\IdeaProjects\\AWT_ASSIGNMENT\\Resume.txt");
            f.write("_____________________________RESUME____________________________________\n\n");
            f.write("\n\nPERSONAL DETAILS --->");
            f.write("\n       Name       :" + name);
            f.write("\n       Age        :" + age);
            f.write("\n       Gender     :" + gender);
            f.write("\n       Address    :" + address);
            f.write("\n       Mobile     :" + mobile);
            f.write("\n       Email      :" + email);
            f.write("\n\nEDUCATIONAL QUALIFICATIONS --->");
            f.write("\n       Institute  :" + institute);
            f.write("\n       Branch     :" + branch);
            f.write("\n       Year       :" + year);
            f.write("\n       CGPA       :" + cgpa);
            f.write("\n\nOTHERS --->");
            f.write("\n   WORK EXPERIENCE:" + workexp);
            f.write("\n       SKILLS     :" + skills);
            f.write("\n  CAREER OBJECTIVE:" + careerobj);
            f.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully resume generated");

    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public static void main(String[] args) {
        // write your code here
        new Create_Resume();
    }
}