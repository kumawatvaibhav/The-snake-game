package snakegame;
import java.awt.Color;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
        // Frame setting amd naming : 
        JFrame frame = new JFrame("Snake game");  //Title set
        frame.setBounds(10,10,905,700); //Set the boundary (Left margin , top margin , width , height)
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        Panel G = new Panel();
        G.setBackground(Color.DARK_GRAY);
        frame.add(G);
    }
}
