import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
    int r,c;
    int count;
    boolean isMine;
    boolean flagged ;
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count= count;
    }

    public Tile(int r,int c){
        this.r=r;
        this.c=c;
        flagged = false ;
    }
    public void toggle(){
        flagged =!flagged;
        if (flagged) {
            this.setIcon(new ImageIcon("C:/Users/mdurd/Downloads/minesweeper-master/Minesweeper/flag.png"));
        }else this.setIcon(null);
    }
       
    public int getR() {
        return r;
    }
    
    public void setR(int r){
        this.r=r;
    }
    
    public int getC(){
        return c;
    }
    
    public void setC(int c){
        this.c=c;
    }    
}