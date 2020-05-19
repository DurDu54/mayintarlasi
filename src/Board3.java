import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Board3 extends JPanel implements MouseListener{
     Tile[][] board=new Tile[16][30];
    
    public void generateMines(){
        
        int count = 0;
        while(count<99){
            int row = (int)(Math.random()*board.length);
            int col = (int)(Math.random()*board[0].length);
            while(board[row][col].isMine){
                row = (int)(Math.random()*board.length);
                col = (int)(Math.random()*board[0].length);
            }
            board[row][col].isMine= true;
            count++;
        }
    }
    
    
    public void updateCount(int r,int c){
        
        if (!board[r][c].isMine) {
            return;
        }
       
        for (int row = r-1; row <= r+1; row++) {
            for (int col = c-1; col <= c+1; col++){
                try {
                board[row][col].count++;
                }catch(Exception e){
                    
                }
            }
        }
        
        
        
    }

    public void countMines(){
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                
                updateCount(row,col);
                
                }
            }
        
        
        
    } 
    public void displayMines(){
       for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine) {
                    board[row][col].setIcon(new ImageIcon("C:/Users/mdurd/Downloads/minesweeper-master/Minesweeper/mine.png"));                
                }else{
                    board[row][col].setText(board[row][col].getCount()+""); 
                }                
            }
        } 
        //System.out.println("game over");
        repaint();
    }
    
    
    
    
    
    
    
    public Board3(){
    JFrame frame= new JFrame("ZOR MAYIN TARLASI");
    frame.setSize(1300, 1000);
    frame.setLocation(300,80);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //tarla düzeni
    frame.setLayout(new GridLayout(16,30));
    
    
    
    //tahta
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Tile t = new Tile(row,col);
                t.addMouseListener(this);
                frame.add(t);
                board[row][col]= t;
            }
        }
    
    
    
    generateMines();
    countMines();
    //displayMines();
    frame.setVisible(true);
    }   
    public void gameOver(){
        System.out.println("Game Ower");
        JFrame gameOwer=new JFrame("Oyun Bitti");
        gameOwer.setSize(300, 300);
        gameOwer.setResizable(true);
        gameOwer.setLayout(new GridLayout(2,0));
        gameOwer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOwer.setLocation(800, 370);
        JLabel bitti=new JLabel("ƠƳƲƝ ƁƖƬƬƖ");
        bitti.setLocation(200,300);
        JPanel bit=new JPanel();
        gameOwer.add(bit);
        bit.add(bitti);
        JPanel tek = new JPanel();
        tek.setLocation(500, 300);
        JButton tekrar=new JButton("Tekrar");
        gameOwer.add(tek);
        tek.add(tekrar);
        tekrar.addActionListener(new Action());
        
        gameOwer.setVisible(true);
        
    }
    static class Action implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                System.out.println("click");
                
                main tekrar = new main();
                tekrar.baslat();
            }
    }
    
    public void goster(int r,int c){
   
    if(r<0 || r>=board.length || c<0|| c>=board[0].length ||
    board[r][c].getText().length()>0 || board[r][c].isEnabled()==false){
      return;
    }else if(board[r][c].count!=0){
      board[r][c].setText(board[r][c].count+"");
      board[r][c].setEnabled(false);
    }else{
      board[r][c].setEnabled(false);
      goster(r-1,c);//north
      goster(r+1,c);//south
      goster(r,c-1);//east
      goster(r,c+1);//west
    }
    }
    
    @Override
    public void mouseClicked(MouseEvent arg0) {
        if (arg0.getButton()==1) {
            System.out.println("left");
             Tile t = (Tile)(arg0.getComponent());
             if (t.isMine) {
                gameOver();
                displayMines();
            } else {
                 goster(t.r,t.c); 
            }
        } else if (arg0.getButton()==3) {
            System.out.println("right");
            Tile t = (Tile)(arg0.getComponent());
            t.toggle();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        
    }
    
    
}
