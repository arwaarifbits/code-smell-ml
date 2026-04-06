import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MazeGame extends JFrame {

    // CONFIG
    static final int ROWS = 11;
    static final int COLS = 11;
    static final int CELL = 50;

    // GAME STATE
    int[][] maze;
    int playerR = 1, playerC = 1;
    final int exitR = ROWS - 2, exitC = COLS - 2;
    String playerName;
    long startTime;
    int moves = 0;

    MazePanel panel;
    java.util.List<int[]> solutionPath = new java.util.ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MazeGame::new);
    }

    public MazeGame() {
        playerName = JOptionPane.showInputDialog(null, "Enter Player Name:", "Maze Game", JOptionPane.PLAIN_MESSAGE);
        if (playerName == null || playerName.trim().isEmpty()) System.exit(0);

        maze = generateMaze();
        panel = new MazePanel();

        JButton solveBtn = new JButton("Auto Solve (A*)");
        JButton exitBtn = new JButton("Exit Game");

        solveBtn.addActionListener(e -> {
            solveAStar();
            animateSolution();
        });

        exitBtn.addActionListener(e -> System.exit(0));

        JPanel top = new JPanel();
        top.add(new JLabel("Player: " + playerName));
        top.add(solveBtn);
        top.add(exitBtn);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setTitle("Maze Game");
        setSize(COLS * CELL + 20, ROWS * CELL + 90);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        SwingUtilities.invokeLater(() -> panel.requestFocusInWindow());

        startTime = System.currentTimeMillis();
    }

    // ================= MAZE GENERATION =================
    int[][] generateMaze() {
        int[][] m = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                m[r][c] = 1;

        carve(1, 1, m, new Random());
        m[1][1] = 0;
        m[exitR][exitC] = 0;
        return m;
    }

    void carve(int r, int c, int[][] m, Random rand) {
        int[][] dirs = {{2,0},{-2,0},{0,2},{0,-2}};
        java.util.List<int[]> dirList = java.util.Arrays.asList(dirs);
        java.util.Collections.shuffle(dirList, rand);

        for (int[] d : dirList) {
            int nr = r + d[0], nc = c + d[1];
            if (nr > 0 && nc > 0 && nr < ROWS - 1 && nc < COLS - 1 && m[nr][nc] == 1) {
                m[r + d[0]/2][c + d[1]/2] = 0;
                m[nr][nc] = 0;
                carve(nr, nc, m, rand);
            }
        }
    }

    // ================= A* SOLVER =================
    void solveAStar() {
        class Node {
            int r, c, g, h;
            Node p;
            Node(int r,int c,int g,int h,Node p){this.r=r;this.c=c;this.g=g;this.h=h;this.p=p;}
            int f(){return g+h;}
        }

        solutionPath.clear();
        for(int r=0;r<ROWS;r++)
            for(int c=0;c<COLS;c++)
                if(maze[r][c]==2) maze[r][c]=0;

        PriorityQueue<Node> open = new PriorityQueue<>((a,b)->a.f()-b.f());
        boolean[][] closed = new boolean[ROWS][COLS];

        open.add(new Node(playerR,playerC,0,Math.abs(exitR-playerR)+Math.abs(exitC-playerC),null));
        Node endNode=null;

        while(!open.isEmpty()){
            Node n=open.poll();
            if(n.r==exitR && n.c==exitC){endNode=n;break;}
            closed[n.r][n.c]=true;
            int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] x:d){
                int nr=n.r+x[0], nc=n.c+x[1];
                // SAFE CHECK: only walkable cells (0)
                if(nr>0 && nr<ROWS && nc>0 && nc<COLS && maze[nr][nc]==0 && !closed[nr][nc]){
                    open.add(new Node(nr,nc,n.g+1,Math.abs(exitR-nr)+Math.abs(exitC-nc),n));
                }
            }
        }

        if(endNode!=null){
            Node n=endNode;
            while(n!=null){
                if(maze[n.r][n.c]==0) maze[n.r][n.c]=2; // mark solution path
                solutionPath.add(0,new int[]{n.r,n.c});
                n=n.p;
            }
        }
    }

    // ================= AUTO-SOLVE ANIMATION =================
    void animateSolution(){
        if(solutionPath.isEmpty()) return;
        new Thread(()->{
            try{
                for(int[] pos:solutionPath){
                    // SAFE: move only to walkable (0) or solution (2) cells
                    if(maze[pos[0]][pos[1]]==0 || maze[pos[0]][pos[1]]==2){
                        playerR=pos[0];
                        playerC=pos[1];
                        panel.repaint();
                        Thread.sleep(200);
                    }
                }
                finishGame();
            }catch(InterruptedException ignored){}
        }).start();
    }

    // ================= FINISH GAME =================
    void finishGame(){
        long time=(System.currentTimeMillis()-startTime)/1000;
        int opt=JOptionPane.showOptionDialog(this,
                "Finished!\nPlayer: "+playerName+
                        "\nTime: "+time+"s\nMoves: "+moves,
                "Game Over", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, new String[]{"Restart","Exit"},"Exit");

        if(opt==0){dispose(); new MazeGame();}
        else{System.exit(0);}
    }

    // ================= PANEL =================
    class MazePanel extends JPanel implements KeyListener {
        MazePanel(){
            setFocusable(true);
            addKeyListener(this);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for(int r=0;r<ROWS;r++){
                for(int c=0;c<COLS;c++){
                    if(maze[r][c]==1) g.setColor(Color.BLACK);
                    else if(maze[r][c]==2) g.setColor(Color.GREEN);
                    else g.setColor(Color.WHITE);
                    g.fillRect(c*CELL,r*CELL,CELL,CELL);
                    g.setColor(Color.GRAY);
                    g.drawRect(c*CELL,r*CELL,CELL,CELL);
                }
            }
            g.setColor(Color.BLUE);
            g.fillRect(exitC*CELL+10,exitR*CELL+10,30,30);
            g.setColor(Color.RED);
            g.fillOval(playerC*CELL+10,playerR*CELL+10,30,30);
        }

        public void keyPressed(KeyEvent e){
            int r=playerR,c=playerC;
            // SAFE: move only if target cell is 0 or 2 (not black) and within bounds
            if(e.getKeyCode()==KeyEvent.VK_UP && r-1 >= 0 && (maze[r-1][c]==0 || maze[r-1][c]==2)) r--;
            if(e.getKeyCode()==KeyEvent.VK_DOWN && r+1 < ROWS && (maze[r+1][c]==0 || maze[r+1][c]==2)) r++;
            if(e.getKeyCode()==KeyEvent.VK_LEFT && c-1 >= 0 && (maze[r][c-1]==0 || maze[r][c-1]==2)) c--;
            if(e.getKeyCode()==KeyEvent.VK_RIGHT && c+1 < COLS && (maze[r][c+1]==0 || maze[r][c+1]==2)) c++;
            if(r!=playerR || c!=playerC) moves++;
            playerR=r; playerC=c;
            repaint();
            if(playerR==exitR && playerC==exitC) finishGame();
        }
        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e){}
    }
}