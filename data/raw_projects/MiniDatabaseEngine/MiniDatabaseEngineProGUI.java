import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

public class MiniDatabaseEngineProGUI extends JFrame {

    private static final String FILE_NAME = "database.txt";
    private DefaultTableModel tableModel;
    private JTable table;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField searchField;

    public MiniDatabaseEngineProGUI() {
        ensureFileExists();
        setTitle("Mini Database Engine (Pro GUI)");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top Panel: Buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(new Color(50, 50, 50));

        JButton addBtn = createButton("Add");
        JButton viewBtn = createButton("View All");
        JButton searchBtn = createButton("Search");
        JButton updateBtn = createButton("Update");
        JButton deleteBtn = createButton("Delete");

        topPanel.add(addBtn);
        topPanel.add(viewBtn);
        topPanel.add(searchBtn);
        topPanel.add(updateBtn);
        topPanel.add(deleteBtn);

        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Table
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel) {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                } else {
                    c.setBackground(new Color(173, 216, 230));
                }
                return c;
            }
        };
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: Live Search
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        bottomPanel.setBackground(new Color(50, 50, 50));
        JLabel searchLabel = new JLabel("Filter:");
        searchLabel.setForeground(Color.WHITE);
        searchField = new JTextField(20);
        bottomPanel.add(searchLabel);
        bottomPanel.add(searchField);
        add(bottomPanel, BorderLayout.SOUTH);

        // Load table header and data
        loadTableHeader();
        viewRecords();

        // Button actions
        addBtn.addActionListener(e -> addRecord());
        viewBtn.addActionListener(e -> viewRecords());
        searchBtn.addActionListener(e -> searchRecord());
        updateBtn.addActionListener(e -> updateRecord());
        deleteBtn.addActionListener(e -> deleteRecord());

        // Live search/filter
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filterTable(); }
            public void removeUpdate(DocumentEvent e) { filterTable(); }
            public void changedUpdate(DocumentEvent e) { filterTable(); }
        });

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(100, 35));
        return btn;
    }

    private void ensureFileExists() {
        File file = new File(FILE_NAME);
        try {
            if (!file.exists()) {
                try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                    pw.println("id,name,email"); // header
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error creating database file: " + e.getMessage());
            System.exit(1);
        }
    }

    private void loadTableHeader() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] columns = headerLine.split(",");
                tableModel.setColumnIdentifiers(columns);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }
    }

    private void viewRecords() {
        tableModel.setRowCount(0); // Clear previous data
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String header = br.readLine(); // skip header
            if (header == null) return; // file empty
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { // skip empty lines
                    tableModel.addRow(line.split(","));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }
    }


    private void addRecord() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        Object[] fields = {"ID:", idField, "Name:", nameField, "Email:", emailField};

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Record", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
                pw.println(idField.getText().trim() + "," + nameField.getText().trim() + "," + emailField.getText().trim());
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                viewRecords();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing file: " + e.getMessage());
            }
        }
    }

    private void searchRecord() {
        String id = JOptionPane.showInputDialog(this, "Enter ID to search:");
        if (id == null || id.isEmpty()) return;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(id)) {
                table.setRowSelectionInterval(i, i);
                table.scrollRectToVisible(new Rectangle(table.getCellRect(i, 0, true)));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Record with ID " + id + " not found.");
    }

    private void updateRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a record to update first.");
            return;
        }
        selectedRow = table.convertRowIndexToModel(selectedRow);

        String id = tableModel.getValueAt(selectedRow, 0).toString();
        String currentName = tableModel.getValueAt(selectedRow, 1).toString();
        String currentEmail = tableModel.getValueAt(selectedRow, 2).toString();

        JTextField nameField = new JTextField(currentName);
        JTextField emailField = new JTextField(currentEmail);
        Object[] fields = {"Name:", nameField, "Email:", emailField};

        int option = JOptionPane.showConfirmDialog(this, fields, "Update Record ID " + id, JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            List<String> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String header = br.readLine();
                records.add(header);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith(id + ",")) {
                        records.add(id + "," + nameField.getText().trim() + "," + emailField.getText().trim());
                    } else {
                        records.add(line);
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
                return;
            }

            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
                for (String rec : records) pw.println(rec);
                JOptionPane.showMessageDialog(this, "Record updated successfully!");
                viewRecords();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing file: " + e.getMessage());
            }
        }
    }

    private void deleteRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a record to delete first.");
            return;
        }
        selectedRow = table.convertRowIndexToModel(selectedRow);
        String id = tableModel.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete record ID " + id + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String header = br.readLine();
            records.add(header);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(id + ",")) records.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String rec : records) pw.println(rec);
            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            viewRecords();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing file: " + e.getMessage());
        }
    }

    private void filterTable() {
        String text = searchField.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MiniDatabaseEngineProGUI::new);
    }
}
