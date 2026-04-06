import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DistributedFileSharingSystem extends JFrame {

    private static final String SHARED_FOLDER_NAME = "shared";
    private File sharedFolder = new File(SHARED_FOLDER_NAME);
    private DefaultTableModel fileTableModel;
    private JTable fileTable;
    private DefaultListModel<String> peerListModel;
    private JList<String> peerList;
    private Map<String, List<String>> peerFiles = new HashMap<>();
    private JTextArea logArea;
    private JScrollPane logScroll;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DistributedFileSharingSystem::new);
    }

    public DistributedFileSharingSystem() {
        setTitle("Distributed File Sharing System");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        if (!sharedFolder.exists()) {
            sharedFolder.mkdir();
        }

        initUI();
        simulatePeers();
        refreshFileTable();
        log("Application started. Shared folder: " + sharedFolder.getAbsolutePath());

        setVisible(true);
    }

    private void initUI() {
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Distributed File Sharing System v1.0\nSimulated P2P File Sharing"));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // File Table
        fileTableModel = new DefaultTableModel(new Object[]{"File Name", "Size (KB)", "Last Modified"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        fileTable = new JTable(fileTableModel);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane fileScroll = new JScrollPane(fileTable);

        JButton addFileBtn = new JButton("Add File");
        addFileBtn.addActionListener(e -> addFile());

        JButton removeFileBtn = new JButton("Remove File");
        removeFileBtn.addActionListener(e -> removeFile());

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> refreshFileTable());

        JPanel fileBtnPanel = new JPanel();
        fileBtnPanel.add(addFileBtn);
        fileBtnPanel.add(removeFileBtn);
        fileBtnPanel.add(refreshBtn);

        JPanel filePanel = new JPanel(new BorderLayout());
        filePanel.setBorder(BorderFactory.createTitledBorder("Local Shared Files"));
        filePanel.add(fileScroll, BorderLayout.CENTER);
        filePanel.add(fileBtnPanel, BorderLayout.SOUTH);

        // Peer List
        peerListModel = new DefaultListModel<>();
        peerList = new JList<>(peerListModel);
        peerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane peerScroll = new JScrollPane(peerList);

        JButton downloadBtn = new JButton("Download from Selected Peer");
        downloadBtn.addActionListener(e -> downloadFile());

        JButton refreshPeersBtn = new JButton("Refresh Peers");
        refreshPeersBtn.addActionListener(e -> refreshPeers());

        JPanel peerBtnPanel = new JPanel();
        peerBtnPanel.add(downloadBtn);
        peerBtnPanel.add(refreshPeersBtn);

        JPanel peerPanel = new JPanel(new BorderLayout());
        peerPanel.setBorder(BorderFactory.createTitledBorder("Connected Peers"));
        peerPanel.add(peerScroll, BorderLayout.CENTER);
        peerPanel.add(peerBtnPanel, BorderLayout.SOUTH);

        // Log Area
        logArea = new JTextArea(5, 50);
        logArea.setEditable(false);
        logScroll = new JScrollPane(logArea);
        logScroll.setBorder(BorderFactory.createTitledBorder("Activity Log"));

        // Split Panes
        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, filePanel, peerPanel);
        mainSplit.setDividerLocation(500);

        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainSplit, logScroll);
        verticalSplit.setDividerLocation(400);

        add(verticalSplit);
    }

    private void refreshFileTable() {
        fileTableModel.setRowCount(0);
        File[] files = sharedFolder.listFiles();
        if (files != null) {
            Arrays.sort(files, Comparator.comparing(File::getName));
            for (File f : files) {
                if (f.isFile()) {
                    long sizeKB = f.length() / 1024;
                    String lastModified = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(f.lastModified()));
                    fileTableModel.addRow(new Object[]{f.getName(), sizeKB, lastModified});
                }
            }
        }
        log("Refreshed local file list.");
    }

    private void addFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select File to Share");
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File src = chooser.getSelectedFile();
            File dest = new File(sharedFolder, src.getName());
            try {
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                refreshFileTable();
                log("Added file: " + src.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to add file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                log("Error adding file: " + ex.getMessage());
            }
        }
    }

    private void removeFile() {
        int row = fileTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a file to remove.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String fileName = (String) fileTableModel.getValueAt(row, 0);
        File f = new File(sharedFolder, fileName);
        int confirm = JOptionPane.showConfirmDialog(this, "Remove " + fileName + "?", "Confirm Remove", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (f.exists() && f.delete()) {
                refreshFileTable();
                log("Removed file: " + fileName);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove file.", "Error", JOptionPane.ERROR_MESSAGE);
                log("Error removing file: " + fileName);
            }
        }
    }

    private void downloadFile() {
        String peer = peerList.getSelectedValue();
        if (peer == null) {
            JOptionPane.showMessageDialog(this, "Please select a peer first!", "No Peer Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<String> files = peerFiles.get(peer);
        if (files == null || files.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selected peer has no files available.", "No Files", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String selectedFile = (String) JOptionPane.showInputDialog(this,
                "Select file to download from " + peer,
                "Download File",
                JOptionPane.PLAIN_MESSAGE,
                null,
                files.toArray(),
                files.get(0));

        if (selectedFile != null) {
            File dest = new File(sharedFolder, selectedFile);
            if (dest.exists()) {
                int overwrite = JOptionPane.showConfirmDialog(this, "File already exists. Overwrite?", "Overwrite", JOptionPane.YES_NO_OPTION);
                if (overwrite != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            try {
                // Simulate download by creating a file with dummy content
                try (FileWriter writer = new FileWriter(dest)) {
                    writer.write("Simulated content for " + selectedFile + " downloaded from " + peer + "\n");
                }
                refreshFileTable();
                JOptionPane.showMessageDialog(this, "Successfully downloaded " + selectedFile + " from " + peer);
                log("Downloaded file: " + selectedFile + " from " + peer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to download: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                log("Error downloading file: " + ex.getMessage());
            }
        }
    }

    private void refreshPeers() {
        // In a real system, this would query the network for peers
        peerListModel.clear();
        peerListModel.addAll(peerFiles.keySet());
        log("Refreshed peer list.");
    }

    private void simulatePeers() {
        // Simulate some peers with files
        peerFiles.put("Peer_A", Arrays.asList("file1.txt", "file2.txt", "readme.md"));
        peerFiles.put("Peer_B", Arrays.asList("image.png", "document.pdf", "archive.zip"));
        peerFiles.put("Peer_C", Arrays.asList("song.mp3", "video.mp4", "presentation.pptx"));
        peerFiles.put("Peer_D", Arrays.asList("code.java", "config.xml"));
        refreshPeers();
    }

    private void log(String message) {
        logArea.append(new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()) + " - " + message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }
}