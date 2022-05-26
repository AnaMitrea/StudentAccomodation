package gui.frames;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class TableModelDemo extends JPanel {
    public TableModelDemo() {
        initializeTabel();
    }

    public static void showFrame() {
        JPanel panel = new TableModelDemo();
        panel.setOpaque(true);

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

    private void setCenteredColumns(TableColumnModel columnModel) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );

        for(int index = 0; index < 3; index++) {
            columnModel.getColumn(index).setPreferredWidth(100);
            columnModel.getColumn(index).setCellRenderer(centerRenderer);
        }
    }

    private void initializeTabel() {
        StudentDistributionTableModel tableModel = new StudentDistributionTableModel(2);
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        TableColumnModel columnModel = table.getColumnModel();
        setCenteredColumns(columnModel);

        JScrollPane scrollPane = new JScrollPane(table);

        this.setPreferredSize(new Dimension(700, 400));
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableModelDemo::showFrame);
    }
}