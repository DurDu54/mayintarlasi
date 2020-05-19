
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main {
    public static void main(String[]Args) {
     baslat();  
        
        
    }
    public static void baslat(){    
        JFrame frame=new JFrame("Giriş");
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(4,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(700, 300);
        frame.setVisible(true);
        JLabel label=new JLabel("Lütfen zorluk seviyesini seçiniz");
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.add(label);
        
        
        JButton kolay=new JButton("Kolay Seviye");
        kolay.setBounds(100, 100, 180, 60);
        JPanel panel2=new JPanel();
        frame.add(panel2);
        panel2.add(kolay);
        kolay.addActionListener(new Action());
        
        JButton orta=new JButton("Orta Seviye");
        kolay.setBounds(100, 100, 180, 60);
        JPanel panel3=new JPanel();
        panel3.add(orta);
        frame.add(panel3);
        orta.addActionListener(new Action2 ());
        
        
        JButton zor=new JButton("Zor Seviye");
        kolay.setBounds(100, 100, 180, 60);
        JPanel panel4=new JPanel();
        panel4.add(zor);
        frame.add(panel4);
        zor.addActionListener(new Action3 ());
        
    }
        
        static class Action implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                Board1 minesweeper = new Board1();
                
            }
            
        }
        static class Action2 implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                Board2 minesweeper2 = new Board2();
            }
        }
        static class Action3 implements ActionListener{
            @Override
            public void actionPerformed (ActionEvent e){
                Board3 minesweeper3 = new Board3();
            }
        } 
        
}    

