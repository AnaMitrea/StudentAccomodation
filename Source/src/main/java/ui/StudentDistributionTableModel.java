package ui;

import database.entity.StudentiEntity;
import database.repository.StudentRepository;

import javax.swing.table.AbstractTableModel;
import java.util.*;

class StudentDistributionTableModel extends AbstractTableModel {
    // TableModel's column names
    private final List<String> columnNames =  Arrays.asList("NUMAR MATRICOL", "MEDIE", "CAMIN");

    private List<List<Object>> data;

    public StudentDistributionTableModel() {
        data = new ArrayList<>();
        StudentRepository studRepo = new StudentRepository();
        System.out.println(studRepo.showAllOrderByGender());
        List<StudentiEntity> studs = studRepo.showAllOrderByGender();

        for(StudentiEntity student : studs) {
           List<Object> information = new ArrayList<>();
           information.add(0,student.getNrMatricol());
           information.add(1,student.getMedie());
           information.add(2,"C" + student.getCamineByIdCamin());

           data.add(information);
        }
    }

    public List<List<Object>> getData() {
        return data;
    }

    /**
     * Returns the number of rows in the table model.
     */
    public int getRowCount() {
        return data.size();
    }

    /**
     * Returns the number of columns in the table model.
     */
    public int getColumnCount() {
        return columnNames.size();
    }

    /**
     * Returns the column name for the column index.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    /**
     * Returns data type of the column specified by its index.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * Returns the value of a table model at the specified
     * row index and column index.
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }
}