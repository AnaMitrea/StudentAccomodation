package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Render extends JPanel implements ActionListener {
    int flag = 0;
    JPanel buttonsPanel;
    JPanel tablePanel;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;

    public Render() {
        initializePanel();
    }

    public static void showFrame() {
        JPanel mainPanel = new Render();
        mainPanel.setBounds(0, 0, 1280, 720);

        JFrame frame = new JFrame("Premiere League - Season 2021-2022");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void initializePanel() {
        buttonsPanel = new JPanel();
        tablePanel = new JPanel();

        buttonsPanel.setPreferredSize(new Dimension(1280, 100));
        tablePanel.setPreferredSize(new Dimension(1280, 720));

        /*
        JLabel lblNewUserRegister = new JLabel("Repartizare camin");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        lblNewUserRegister.setBounds(0, 0, 325, 50);
        buttonsPanel.add(lblNewUserRegister);
         */

        jButton1 = new JButton("Add CD");
        jButton2 = new JButton("Add Video");
        jButton3 = new JButton("Total Play Time");

        flag = 0;
        drawApp(flag);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);

    }

    private void drawApp(int flag) {
        JLabel label1 = new JLabel("inceput " + flag);
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        label1.setBounds(0, 0, 325, 50);
        tablePanel.add(label1);

        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        buttonsPanel.add(jButton3);

        JLabel label = new JLabel("flag = " + flag);
        if(flag == 0) {
            label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
            label.setBounds(0, 0, 325, 50);
            tablePanel.add(label);
        } else {
            tablePanel.removeAll();
            this.revalidate();
            this.repaint();
        }

        if(flag == 1) {
            label = new JLabel("dupa remove button 1 flag =" + flag);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
            label.setBounds(0, 0, 325, 50);
            tablePanel.add(label);
        }

        if(flag == 2) {
            label = new JLabel("dupa remove button 2 flag =" + flag);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
            label.setBounds(0, 0, 325, 50);
            tablePanel.add(label);
        }

        if(flag == 3) {
            label = new JLabel("dupa remove button 3 flag =" + flag);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
            label.setBounds(0, 0, 325, 50);
            tablePanel.add(label);
        }

        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(tablePanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            flag = 1;
            drawApp(flag);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == jButton2) {
            flag = 2;
            drawApp(flag);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == jButton3) {
            flag = 3;
            drawApp(flag);
            this.revalidate();
            this.repaint();
        }
    }
}
