package ui;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private JButton btnNewButton;
    private int addHeight = 120;
    private int addWidth = 580;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void setareTitlu() {
        JLabel lblNewUserRegister = new JLabel("Student accommodation");
        lblNewUserRegister.setFont(new Font("Helvetica Neue", Font.PLAIN, 29));
        lblNewUserRegister.setBounds(520, 52, 325, 50);
        lblNewUserRegister.setForeground(new Color(0x37B2DE));
        contentPane.add(lblNewUserRegister);
    }



    /**
     * Create the frame.
     */
    public MainWindow() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/student.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        contentPane.setBackground(new Color(0xD2D6D9));

        setareTitlu();

        int startPositionX = 200;
        int startPositionY = 150;

        btnNewButton = new JButton("Apply");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(() -> {
                    try {
                        UserRegistration frame = new UserRegistration();
                        frame.setVisible(true);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                });

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(400, 250, 180, 90);
        btnNewButton.setForeground(new Color(0x37B2DE));
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("See results");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(Render::showFrame);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(600, 250, 180, 90);
        btnNewButton.setForeground(new Color(0x37B2DE));
        contentPane.add(btnNewButton);

        btnNewButton = new JButton("Exit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(800, 250, 180, 90);
        btnNewButton.setForeground(new Color(0x37B2DE));
        contentPane.add(btnNewButton);
    }
}