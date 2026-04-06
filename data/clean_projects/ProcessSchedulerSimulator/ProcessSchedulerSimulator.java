import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProcessSchedulerSimulator extends JFrame {

    // UI Components
    JTable processTable;
    DefaultTableModel tableModel;
    JComboBox<String> algorithmBox;
    JTextField quantumField;
    JButton addBtn, removeBtn, runBtn, clearBtn;
    JTextArea ganttChartArea;
    JTextArea resultsArea;

    List<Process> processes = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProcessSchedulerSimulator::new);
    }

    public ProcessSchedulerSimulator() {
        setTitle("OS Process Scheduler Simulator");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newSimItem = new JMenuItem("New Simulation");
        newSimItem.addActionListener(e -> clearAll());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(newSimItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Process Scheduler Simulator v1.0\nSimulates FCFS, SJF, Priority, and Round Robin scheduling algorithms."));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // ================= TOP PANEL =================
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createTitledBorder("Scheduler Settings"));
        topPanel.setBackground(new Color(240, 248, 255));

        topPanel.add(new JLabel("Algorithm:"));
        algorithmBox = new JComboBox<>(new String[]{"FCFS", "SJF", "Priority", "Round Robin"});
        algorithmBox.setToolTipText("Select scheduling algorithm");
        topPanel.add(algorithmBox);

        topPanel.add(new JLabel("Quantum (RR only):"));
        quantumField = new JTextField("2", 3);
        quantumField.setToolTipText("Time quantum for Round Robin");
        topPanel.add(quantumField);

        addBtn = new JButton("Add Process");
        addBtn.setToolTipText("Add a new process");
        removeBtn = new JButton("Remove Selected");
        removeBtn.setToolTipText("Remove selected process");
        runBtn = new JButton("Run Scheduler");
        runBtn.setToolTipText("Execute the selected algorithm");
        clearBtn = new JButton("Clear All");
        clearBtn.setToolTipText("Clear all processes");

        topPanel.add(addBtn);
        topPanel.add(removeBtn);
        topPanel.add(runBtn);
        topPanel.add(clearBtn);

        add(topPanel, BorderLayout.NORTH);

        // ================= CENTER PANEL =================
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Process Table
        String[] cols = {"Process Name", "Arrival Time", "Burst Time", "Priority"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        processTable = new JTable(tableModel);
        processTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        processTable.setRowHeight(25);
        processTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(processTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Processes"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Results Area
        resultsArea = new JTextArea(5, 50);
        resultsArea.setEditable(false);
        resultsArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        resultsArea.setBackground(new Color(255, 255, 224));
        JScrollPane resultsScroll = new JScrollPane(resultsArea);
        resultsScroll.setBorder(BorderFactory.createTitledBorder("Results"));
        centerPanel.add(resultsScroll, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // ================= BOTTOM PANEL =================
        ganttChartArea = new JTextArea();
        ganttChartArea.setEditable(false);
        ganttChartArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        ganttChartArea.setBackground(new Color(240, 255, 240));
        JScrollPane ganttScroll = new JScrollPane(ganttChartArea);
        ganttScroll.setBorder(BorderFactory.createTitledBorder("Gantt Chart"));
        add(ganttScroll, BorderLayout.SOUTH);

        // ================= BUTTON ACTIONS =================
        addBtn.addActionListener(e -> addProcess());
        removeBtn.addActionListener(e -> removeSelectedProcess());
        runBtn.addActionListener(e -> runScheduler());
        clearBtn.addActionListener(e -> clearAll());

        setVisible(true);
    }

    // ================= PROCESS CLASS =================
    static class Process {
        String name;
        int arrivalTime, burstTime, priority;
        int remainingTime, waitingTime, turnaroundTime, completionTime;
        Process(String name, int arrival, int burst, int prio) {
            this.name = name;
            this.arrivalTime = arrival;
            this.burstTime = burst;
            this.priority = prio;
            this.remainingTime = burst;
        }
    }

    // ================= ADD / REMOVE =================
    void addProcess() {
        JTextField nameField = new JTextField();
        JTextField arrivalField = new JTextField();
        JTextField burstField = new JTextField();
        JTextField prioField = new JTextField();

        Object[] message = {
                "Process Name:", nameField,
                "Arrival Time:", arrivalField,
                "Burst Time:", burstField,
                "Priority (lower number = higher priority):", prioField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Process", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText().trim();
                if (name.isEmpty()) throw new Exception("Name cannot be empty");
                int arrival = Integer.parseInt(arrivalField.getText());
                int burst = Integer.parseInt(burstField.getText());
                int prio = Integer.parseInt(prioField.getText());
                if (arrival < 0 || burst <= 0 || prio < 0) throw new Exception("Invalid values");
                Process p = new Process(name, arrival, burst, prio);
                processes.add(p);
                tableModel.addRow(new Object[]{name, arrival, burst, prio});
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void removeSelectedProcess() {
        int row = processTable.getSelectedRow();
        if (row >= 0) {
            processes.remove(row);
            tableModel.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a process to remove.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    void clearAll() {
        processes.clear();
        tableModel.setRowCount(0);
        ganttChartArea.setText("");
        resultsArea.setText("");
    }

    // ================= SCHEDULER =================
    void runScheduler() {
        if (processes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No processes added!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String algo = (String) algorithmBox.getSelectedItem();
        ganttChartArea.setText("");
        resultsArea.setText("");

        // Reset processes
        processes.forEach(p -> {
            p.remainingTime = p.burstTime;
            p.waitingTime = 0;
            p.turnaroundTime = 0;
            p.completionTime = 0;
        });

        switch (algo) {
            case "FCFS":
                runFCFS();
                break;
            case "SJF":
                runSJF();
                break;
            case "Priority":
                runPriority();
                break;
            case "Round Robin":
                runRR();
                break;
        }
        calculateResults();
    }

    void runFCFS() {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int time = 0;
        StringBuilder sb = new StringBuilder("Gantt Chart:\n");
        for (Process p : processes) {
            if (time < p.arrivalTime) time = p.arrivalTime;
            p.waitingTime = time - p.arrivalTime;
            p.completionTime = time + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            sb.append(String.format("| %s (%d-%d) ", p.name, time, time + p.burstTime));
            time += p.burstTime;
        }
        sb.append("|\n");
        ganttChartArea.setText(sb.toString());
    }

    void runSJF() {
        List<Process> list = new ArrayList<>(processes);
        int time = 0;
        StringBuilder sb = new StringBuilder("Gantt Chart:\n");
        while (!list.isEmpty()) {
            int finalTime = time;
            Process p = list.stream().filter(pr -> pr.arrivalTime <= finalTime).min(Comparator.comparingInt(pr -> pr.burstTime)).orElse(null);
            if (p == null) {
                time++;
                continue;
            }
            p.waitingTime = time - p.arrivalTime;
            p.completionTime = time + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            sb.append(String.format("| %s (%d-%d) ", p.name, time, time + p.burstTime));
            time += p.burstTime;
            list.remove(p);
        }
        sb.append("|\n");
        ganttChartArea.setText(sb.toString());
    }

    void runPriority() {
        List<Process> list = new ArrayList<>(processes);
        int time = 0;
        StringBuilder sb = new StringBuilder("Gantt Chart:\n");
        while (!list.isEmpty()) {
            int finalTime = time;
            Process p = list.stream().filter(pr -> pr.arrivalTime <= finalTime).min(Comparator.comparingInt(pr -> pr.priority)).orElse(null);
            if (p == null) {
                time++;
                continue;
            }
            p.waitingTime = time - p.arrivalTime;
            p.completionTime = time + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            sb.append(String.format("| %s (%d-%d) ", p.name, time, time + p.burstTime));
            time += p.burstTime;
            list.remove(p);
        }
        sb.append("|\n");
        ganttChartArea.setText(sb.toString());
    }

    void runRR() {
        int quantum;
        try {
            quantum = Integer.parseInt(quantumField.getText());
            if (quantum <= 0) throw new Exception();
        } catch (Exception e) {
            quantum = 2;
            quantumField.setText("2");
        }
        List<Process> list = new ArrayList<>(processes);
        Queue<Process> queue = new LinkedList<>();
        int time = 0;
        StringBuilder sb = new StringBuilder("Gantt Chart:\n");

        while (!list.isEmpty() || !queue.isEmpty()) {
            for (Process p : new ArrayList<>(list)) {
                if (p.arrivalTime <= time) {
                    queue.add(p);
                    list.remove(p);
                }
            }
            if (queue.isEmpty()) {
                time++;
                continue;
            }
            Process p = queue.poll();
            int runTime = Math.min(quantum, p.remainingTime);
            sb.append(String.format("| %s (%d-%d) ", p.name, time, time + runTime));
            time += runTime;
            p.remainingTime -= runTime;
            if (p.remainingTime > 0) {
                queue.add(p);
            } else {
                p.completionTime = time;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
            }
        }
        sb.append("|\n");
        ganttChartArea.setText(sb.toString());

        // Reset remainingTime for next run
        processes.forEach(p -> p.remainingTime = p.burstTime);
    }

    void calculateResults() {
        double totalWaiting = processes.stream().mapToInt(p -> p.waitingTime).sum();
        double totalTurnaround = processes.stream().mapToInt(p -> p.turnaroundTime).sum();
        int n = processes.size();
        double avgWaiting = totalWaiting / n;
        double avgTurnaround = totalTurnaround / n;

        StringBuilder res = new StringBuilder("Results:\n");
        res.append(String.format("Average Waiting Time: %.2f\n", avgWaiting));
        res.append(String.format("Average Turnaround Time: %.2f\n\n", avgTurnaround));
        res.append("Process Details:\n");
        for (Process p : processes) {
            res.append(String.format("%s: Waiting=%d, Turnaround=%d, Completion=%d\n", p.name, p.waitingTime, p.turnaroundTime, p.completionTime));
        }
        resultsArea.setText(res.toString());
    }
}