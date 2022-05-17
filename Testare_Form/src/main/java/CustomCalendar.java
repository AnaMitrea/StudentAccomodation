import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 * This program demonstrates how to use JDatePicker to display a calendar
 * component in a Swing program.
 * @author www.codejava.net
 *
 */
public class CustomCalendar extends JFrame {
    private JDatePickerImpl datePicker;

    public CustomCalendar() {
        super("Calendar Component Demo");
        setLayout(new FlowLayout());

        UtilDateModel model = new UtilDateModel();
        model.setDate(2000, 1, 1);
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        add(datePicker);

        // JButton buttonOK = new JButton("OK");
        // buttonOK.addActionListener(this);
        // add(buttonOK);


        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Date selectedDate = (Date) datePicker.getModel().getValue();
        //JOptionPane.showMessageDialog(this, "The selected date is " + selectedDate);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomCalendar().setVisible(true));
    }

}