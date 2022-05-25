package ui;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class TableModelDemo extends JPanel {
    public TableModelDemo() {
        initializePanel();
    }

    public static void showFrame() {
        // main panel pe care se adauga chestii
        JPanel panel = new TableModelDemo();
        panel.setOpaque(true);

        // frame ul pt aplicatia ce se deschide
        JFrame frame = new JFrame("Student Distribution 2022");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

        JLabel lblNewUserRegister = new JLabel("Repartizare camin");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        lblNewUserRegister.setBounds(100, 100, 325, 50);
        panel.add(lblNewUserRegister);
    }

    private void initializePanel() {
        // Informatia ce se va pune in tabel
        StudentDistributionTableModel tableModel = new StudentDistributionTableModel();

        // JTabel cu proprietatile lui
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);

        // daca tabelul e prea mare se face scroll
        JScrollPane scrollPane = new JScrollPane(table);

        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableModelDemo::showFrame);
    }
}