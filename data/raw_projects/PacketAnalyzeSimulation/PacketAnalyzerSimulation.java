import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PacketAnalyzerSimulation extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton generatePacketButton;
    private Random random;

    public PacketAnalyzerSimulation() {
        super("Network Packet Analyzer Simulation");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        random = new Random();

        // Table setup
        String[] columns = {"Time", "Source IP", "Destination IP", "Protocol", "Size (Bytes)"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button to generate packets
        generatePacketButton = new JButton("Generate Packet");
        generatePacketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePacket();
            }
        });
        add(generatePacketButton, BorderLayout.SOUTH);

        // Auto-generate packets every 2 seconds
        Timer timer = new Timer(2000, e -> generatePacket());
        timer.start();

        setVisible(true);
    }

    private void generatePacket() {
        String time = java.time.LocalTime.now().withNano(0).toString();
        String sourceIP = randomIP();
        String destIP = randomIP();
        String protocol = randomProtocol();
        int size = random.nextInt(1500) + 20; // Packet size between 20-1520 bytes

        Object[] row = {time, sourceIP, destIP, protocol, size};
        tableModel.addRow(row);
    }

    private String randomIP() {
        return random.nextInt(256) + "." + random.nextInt(256) + "." +
               random.nextInt(256) + "." + random.nextInt(256);
    }

    private String randomProtocol() {
        String[] protocols = {"TCP", "UDP", "ICMP", "HTTP", "HTTPS"};
        return protocols[random.nextInt(protocols.length)];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PacketAnalyzerSimulation());
    }
}
