package lk.redwolfdynamic.ims.model;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DropdownTable extends JFrame {

    private JTable jTable1;

    public DropdownTable() {
        // Set frame properties
        setTitle("Student Status Table");
        setSize(400, 300); // Set a suitable size for the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setLocationRelativeTo(null); // Center the frame on the screen

        initComponents();
        populateTable();
        // Add dropdown to the 'Status' column (index 2, as it's the third column)
        addDropdownToColumn(2); 
    }

    private void initComponents() {
        jTable1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(jTable1);
        add(scrollPane); // Add the JScrollPane containing the table to the frame
    }

    private void populateTable() {
        String[] columnNames = {"Student Id", "Name", "Status"};
        Object[][] data = {
            {"1", "a", "Atend"},
            {"2", "b", "Not Atend"},
            {"3", "c", "Atend"},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            // Override isCellEditable to allow editing only for the "Status" column
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Only the "Status" column (index 2) is editable
            }
        };
        jTable1.setModel(model);
    }

    private void addDropdownToColumn(int columnIndex) {
        TableColumn statusColumn = jTable1.getColumnModel().getColumn(columnIndex);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Atend");
        comboBox.addItem("Not Atend");

        statusColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DropdownTable().setVisible(true));
    }
}