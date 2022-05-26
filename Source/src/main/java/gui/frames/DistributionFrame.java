package gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistributionFrame extends JPanel implements ActionListener {
    int flag = 0;
    JPanel buttonsPanel;
    JPanel tablePanel;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;

    public DistributionFrame() {
        initializePanel();
    }

    public static void showFrame() {
        JPanel mainPanel = new DistributionFrame();
        mainPanel.setPreferredSize(new Dimension(1280, 720));
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(0xD2D6D9));

        JFrame frame = new JFrame("Student Distribution for 2022");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(new Color(0xD2D6D9));
    }

    private void setupButtonsPanel() {
        buttonsPanel.setPreferredSize(new Dimension(1280, 50));
        buttonsPanel.setBackground(new Color(0xD2D6D9));

        JLabel dormitoryLabel = new JLabel("Choose dormitory for distribution");
        dormitoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        dormitoryLabel.setBounds(0, 0, 150, 50);
        dormitoryLabel.setForeground(new Color(0x37B2DE));
        buttonsPanel.add(dormitoryLabel);

        jButton1 = new JButton("Student Dormitory 1");
        jButton2 = new JButton("Student Dormitory 2");
        jButton3 = new JButton("Student Dormitory 3");
        jButton4 = new JButton("Student Dormitory 4");
        jButton5 = new JButton("Student Dormitory 5");

        jButton1.setForeground(new Color(0x37B2DE));
        jButton2.setForeground(new Color(0x37B2DE));
        jButton3.setForeground(new Color(0x37B2DE));
        jButton4.setForeground(new Color(0x37B2DE));
        jButton5.setForeground(new Color(0x37B2DE));
    }

    private void setupTablePanel() {
        tablePanel.setPreferredSize(new Dimension(1280, 670));
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLUE));
    }

    private void initializePanel() {
        buttonsPanel = new JPanel();
        tablePanel = new JPanel();

        setupButtonsPanel();
        setupTablePanel();

        flag = 0;
        drawApp(flag);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
    }

    private void drawApp(int flag) {
        JLabel label1 = new JLabel("inceput " + flag);
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        label1.setBounds(0, 0, 325, 50);
        tablePanel.add(label1);

        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        buttonsPanel.add(jButton3);
        buttonsPanel.add(jButton4);
        buttonsPanel.add(jButton5);

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

        if(flag == 4) {
            label = new JLabel("dupa remove button 4 flag =" + flag);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
            label.setBounds(0, 0, 325, 50);
            tablePanel.add(label);
        }

        if(flag == 5) {
            label = new JLabel("dupa remove button 5 flag =" + flag);
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
        } else if (e.getSource() == jButton4) {
            flag = 4;
            drawApp(flag);
            this.revalidate();
            this.repaint();
        }  else if (e.getSource() == jButton5) {
            flag = 5;
            drawApp(flag);
            this.revalidate();
            this.repaint();
        }
    }
}
