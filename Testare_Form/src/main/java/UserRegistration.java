import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField lastname;
    private JTextField firstname;
    // variabila pt gen
    JRadioButton radioButtonMale;
    JRadioButton radioButtonFemale;
    private JComboBox<String> anSelector;
    private JComboBox<String> grupaSelector;

    private JTextField email;
    private JTextField nrMatricol;
    private JTextField medieField;
    private JDatePickerImpl datePicker;

    private JButton btnNewButton;
    private int addHeight = 120;
    private int addWidth = 700;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserRegistration frame = new UserRegistration();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void setareTitlu() {
        JLabel lblNewUserRegister = new JLabel("Repartizare camin");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        lblNewUserRegister.setBounds(600, 52, 325, 50);
        contentPane.add(lblNewUserRegister);
    }

    private void setareNume(int posX, int posY) {
        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(posX, posY, 110, 29);
        contentPane.add(lblNewLabel);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);
    }

    private void setarePrenume(int posX, int posY) {
        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(posX, posY, 110, 29);
        contentPane.add(lblName);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);
    }

    private void setareGen(int posX, int posY) {
        JLabel lblGen = new JLabel("Gen");
        lblGen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGen.setBounds(posX, posY, 110, 29);
        contentPane.add(lblGen);

        JLabel lblMale = new JLabel("Male");
        lblMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMale.setBounds(posX + 170, posY - 8, 150, 50);
        contentPane.add(lblMale);

        radioButtonMale = new JRadioButton("");
        radioButtonMale.setBounds(posX + 170 + 50, posY, 30, 30);
        contentPane.add(radioButtonMale);

        JLabel lblFemale = new JLabel("Female");
        lblFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFemale.setBounds(posX + 170 + 60 + 50, posY - 8, 150, 50);
        contentPane.add(lblFemale);

        radioButtonFemale = new JRadioButton("");
        radioButtonFemale.setBounds(posX + + 170 + 60 + 50 + 70, posY, 30, 30);
        contentPane.add(radioButtonFemale);
    }

    private void setareAnGrupa(int posX, int posY) {
        JLabel lblAnGrupa = new JLabel("Anul si Grupa");
        lblAnGrupa.setBounds(posX, posY, 200, 29);
        lblAnGrupa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblAnGrupa);

        anSelector = new JComboBox<>();
        anSelector.addItem("Select an");
        anSelector.addItem("1");
        anSelector.addItem("2");
        anSelector.addItem("3");
        anSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        anSelector.setBounds(posX + 156, posY, 100, 30);
        contentPane.add(anSelector);

        grupaSelector = new JComboBox<>();
        grupaSelector.addItem("Select grupa");
        grupaSelector.addItem("A1");
        grupaSelector.addItem("A2");
        grupaSelector.addItem("A3");
        grupaSelector.addItem("A4");
        grupaSelector.addItem("A5");
        grupaSelector.addItem("B1");
        grupaSelector.addItem("B2");
        grupaSelector.addItem("B3");
        grupaSelector.addItem("B4");
        grupaSelector.addItem("B5");
        grupaSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        grupaSelector.setBounds(posX + 156 + 120, posY, 100, 30);
        contentPane.add(grupaSelector);
    }

    private void setareEmail(int posX, int posY) {
        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(posX, posY, 200, 29);
        contentPane.add(lblEmailAddress);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(posX + 156 , posY - 8, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
    }

    private void setareNumarMatricol(int posX, int posY) {
        JLabel lblnrMatricol = new JLabel("Numar matricol");
        lblnrMatricol.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblnrMatricol.setBounds(posX, posY, 200, 29);
        contentPane.add(lblnrMatricol);

        nrMatricol = new JTextField();
        nrMatricol.setFont(new Font("Tahoma", Font.PLAIN, 32));
        nrMatricol.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(nrMatricol);
        nrMatricol.setColumns(10);
    }

    private void setareMedie(int posX, int posY){
        JLabel lblMedie = new JLabel("Medie");
        lblMedie.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMedie.setBounds(posX, posY, 110, 29);
        contentPane.add(lblMedie);

        medieField = new JTextField();
        medieField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        medieField.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(medieField);
    }

    private void setareDataNastere(int posX, int posY) {
        JLabel lbDataNastere = new JLabel("Data nastere");
        lbDataNastere.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDataNastere.setBounds(posX, posY, 200, 29);
        contentPane.add(lbDataNastere);

        UtilDateModel model = new UtilDateModel();
        model.setDate(2000, 1, 1);
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(posX + 156, posY, 228, 80);
        contentPane.add(datePicker);
    }

    // TODO validare date
    private boolean validare(){

        return false;
    }


    /**
     * Create the frame.
     */
    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/student.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TODO de cautat cum se iau proportiile ecranului pt a pune la width si height
        setBounds(450, 190, 1600, 900);

        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);


        // titlu
        setareTitlu();

        int startPositionX = 200;
        int startPositionY = 152;

        // label nume fam
        setareNume(startPositionX, startPositionY);

        // label prenume
        startPositionY += addHeight;
        setarePrenume(startPositionX, startPositionY);

        // gen
        startPositionY += addHeight;
        setareGen(startPositionX, startPositionY);

        // an si grupa
        startPositionY += addHeight;
        setareAnGrupa(startPositionX, startPositionY);

        // cealalta coloana din dr
        // email
        startPositionX = 200 + addWidth;
        startPositionY = 152;
        setareEmail(startPositionX, startPositionY);

        //nr matricol
        startPositionY += addHeight;
        setareNumarMatricol(startPositionX, startPositionY);

        // medie
        startPositionY += addHeight;
        setareMedie(startPositionX, startPositionY);

        // data nastere
        startPositionY += addHeight;
        setareDataNastere(startPositionX, startPositionY);


        // submit
        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lastName = lastname.getText();
                String firstName = firstname.getText();
                // gen
                String an = Objects.requireNonNull(anSelector.getSelectedItem()).toString();
                String grupa = Objects.requireNonNull(grupaSelector.getSelectedItem()).toString();
                String emailId = email.getText();
                String nr_matricol = nrMatricol.getText();
                String medie = medieField.getText();

                String msg = "" + firstName;
                msg += " \n";
                try {

                    System.out.println(firstName + "','" + lastName + "',' an =" + an + "',' grupa= " + grupa  + "','" +nr_matricol + "','" + medie + "','" + emailId );

                    // TODO validare
                    if(!validare()) {
                        JOptionPane.showMessageDialog(btnNewButton, "Informatii nevalide!");
                    }
                    //JOptionPane.showMessageDialog(btnNewButton, "Welcome!");
                    //JOptionPane.showMessageDialog(btnNewButton,"Welcome, " + msg + "Your account is sucessfully created");


                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(600, 700, 325, 74);
        contentPane.add(btnNewButton);
    }
}