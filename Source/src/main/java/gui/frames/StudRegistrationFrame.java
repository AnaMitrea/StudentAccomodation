package gui.frames;

import database.repository.ValidationDataRepository;
import gui.util.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudRegistrationFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;

    private JTextField lastname;
    private JTextField firstname;
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
    private int addWidth = 580;

    private void setareTitlu() {
        JLabel lblNewUserRegister = new JLabel("Student accommodation");
        lblNewUserRegister.setFont(new Font("Helvetica Neue", Font.PLAIN, 29));
        lblNewUserRegister.setBounds(520, 52, 325, 50);
        lblNewUserRegister.setForeground(new Color(0x37B2DE));
        contentPane.add(lblNewUserRegister);
    }

    private void setareNume(int posX, int posY) {
        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(Font.BOLD, 20));
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
        lblName.setFont(lblName.getFont().deriveFont(Font.BOLD, 20));
        lblName.setBounds(posX, posY, 110, 29);
        contentPane.add(lblName);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);
    }

    private void setareGen(int posX, int posY) {
        JLabel lblGen = new JLabel("Gender");
        lblGen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGen.setFont(lblGen.getFont().deriveFont(Font.BOLD, 20));
        lblGen.setBounds(posX, posY, 110, 29);
        contentPane.add(lblGen);

        JLabel lblMale = new JLabel("Male");
        lblMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMale.setFont(lblMale.getFont().deriveFont(Font.BOLD, 18));
        lblMale.setBounds(posX + 170, posY - 8, 150, 50);
        contentPane.add(lblMale);

        radioButtonMale = new JRadioButton("");
        radioButtonMale.setBounds(posX + 170 + 50, posY, 30, 30);
        contentPane.add(radioButtonMale);

        JLabel lblFemale = new JLabel("Female");
        lblFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFemale.setFont(lblFemale.getFont().deriveFont(Font.BOLD, 18));
        lblFemale.setBounds(posX + 170 + 60 + 50, posY - 8, 150, 50);
        contentPane.add(lblFemale);

        radioButtonFemale = new JRadioButton("");
        radioButtonFemale.setBounds(posX + +170 + 60 + 50 + 70, posY, 30, 30);
        contentPane.add(radioButtonFemale);
    }

    private void setareAnGrupa(int posX, int posY) {
        JLabel lblAnGrupa = new JLabel("Year and Group");
        lblAnGrupa.setBounds(posX-8, posY - 30, 200, 29);
        lblAnGrupa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAnGrupa.setFont(lblAnGrupa.getFont().deriveFont(Font.BOLD, 20));
        contentPane.add(lblAnGrupa);

        anSelector = new JComboBox<>();
        anSelector.addItem("Select year");
        anSelector.addItem("1");
        anSelector.addItem("2");
        anSelector.addItem("3");
        anSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        anSelector.setBounds(posX + 156, posY - 30, 100, 30);
        contentPane.add(anSelector);

        grupaSelector = new JComboBox<>();
        grupaSelector.addItem("Select group");
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
        grupaSelector.setBounds(posX + 156 + 120, posY - 30, 100, 30);
        contentPane.add(grupaSelector);
    }

    private void setareEmail(int posX, int posY) {
        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setFont(lblEmailAddress.getFont().deriveFont(Font.BOLD, 20));
        lblEmailAddress.setBounds(posX, posY, 200, 29);
        contentPane.add(lblEmailAddress);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
    }

    private void setareNumarMatricol(int posX, int posY) {
        JLabel lblnrMatricol = new JLabel("Serial number");
        lblnrMatricol.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblnrMatricol.setFont(lblnrMatricol.getFont().deriveFont(Font.BOLD, 20));
        lblnrMatricol.setBounds(posX-8, posY-8, 200, 29);
        contentPane.add(lblnrMatricol);

        nrMatricol = new JTextField();
        nrMatricol.setFont(new Font("Tahoma", Font.PLAIN, 32));
        nrMatricol.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(nrMatricol);
        nrMatricol.setColumns(10);
    }

    private void setareMedie(int posX, int posY) {
        JLabel lblMedie = new JLabel("Average");
        lblMedie.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMedie.setFont(lblMedie.getFont().deriveFont(Font.BOLD, 20));
        lblMedie.setBounds(posX, posY, 110, 29);
        contentPane.add(lblMedie);

        medieField = new JTextField();
        medieField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        medieField.setBounds(posX + 156, posY - 8, 228, 50);
        contentPane.add(medieField);
    }

    private void setareDataNastere(int posX, int posY) {
        JLabel lbDataNastere = new JLabel("Date of birth");
        lbDataNastere.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbDataNastere.setFont(lbDataNastere.getFont().deriveFont(Font.BOLD, 20));
        lbDataNastere.setBounds(posX, posY - 30, 200, 29);
        contentPane.add(lbDataNastere);

        UtilDateModel model = new UtilDateModel();
        model.setDate(1975, 1, 1);
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(posX + 156, posY - 30, 228, 30);
        contentPane.add(datePicker);
    }


    /**
     * Create the frame.
     */
    public StudRegistrationFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/student.png"));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setBounds(0, 0, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
       contentPane.setBackground(new Color(0xD2D6D9));


        // titlu
        setareTitlu();

        int startPositionX = 200;
        int startPositionY = 150;

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
                boolean valid = false;
                int countDifCharacters = 0;
                int countNumbers=0;
                int count = 0;
                String lastName = lastname.getText();
                String firstName = firstname.getText();
                // gen
                String femaleGender = String.valueOf(radioButtonFemale.isSelected());
                String maleGender = String.valueOf(radioButtonMale.isSelected());
                String an = Objects.requireNonNull(anSelector.getSelectedItem()).toString();
                String grupa = Objects.requireNonNull(grupaSelector.getSelectedItem()).toString();
                String emailAdress = email.getText();
                String matricol = nrMatricol.getText();
                String medie = medieField.getText();
                //data nastere
                String dataNastere = datePicker.getJFormattedTextField().getText();

                ValidationDataRepository validationDataRepository = new ValidationDataRepository(lastName, firstName, an, grupa, emailAdress, matricol, medie, dataNastere, femaleGender, maleGender);
                try {
                    if (matricol.length() > 0 && firstName.length() > 0 && lastName.length() > 0 && (femaleGender == "true" || maleGender == "true") && an.length() > 0 && grupa.length() > 0 && emailAdress.length() > 0 && medie.length() > 0) {

                            for (int index = 0; index < medie.length(); index++) {

                                if (medie.charAt(index) == '0' || medie.charAt(index) == '1' || medie.charAt(index) == '2' || medie.charAt(index) == '3' || medie.charAt(index) == '4' || medie.charAt(index) == '5' || medie.charAt(index) == '6' || medie.charAt(index) == '7' || medie.charAt(index) == '8' || medie.charAt(index) == '9' ) {
                                    countNumbers++;
                                } else if (medie.charAt(index)=='.') {
                                    count++;
                                } else
                                    countDifCharacters++;
                            }
                        if (count == 1 && countDifCharacters == 0&&medie.length()==(count+countNumbers)&&medie.charAt(1)=='.') {
                            valid = true;
                        }
                        if (valid && !an.equals("Select an")) {
                            JOptionPane.showMessageDialog(btnNewButton, validationDataRepository.validare());
                        } else
                            JOptionPane.showMessageDialog(btnNewButton, "Informatii invalide!");

                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Nu ai completat toate campurile!");
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(600, 550, 148, 74);
        btnNewButton.setForeground(new Color(0x37B2DE));
        contentPane.add(btnNewButton);
    }
}