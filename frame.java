import java.awt.Color;
import javax.swing.JFrame;
class frame{
    public static void main(String args[]){
        // Frame setting amd naming : 
        JFrame J = new JFrame();
        J.setTitle("Snake Game");  //Title set
        J.setBounds(10,10,905,700); //Set the boundary (Left margin , top margin , width , height)
        J.setResizable(false);
        J.setVisible(true);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setBackground(Color.DARK_GRAY);

        game G = new game();
        J.add(G);
    }
}
