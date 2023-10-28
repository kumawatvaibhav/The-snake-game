//Game Program : 
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class game extends JPanel{
    
    private ImageIcon Titleimage;
    public game(){}

    public void paint(Graphics g){

        //Border for title image : 
        g.setColor(Color.WHITE);
        g.drawRect(25,10,850,55);

        Titleimage = new ImageIcon("./assets/Title_snake.jpg");
        Titleimage.paintIcon(this,g,45,11);

        //Border for game-play :
        g.setColor(Color.WHITE);
        g.drawRect(25,75,850,570);

        // set the background color of game-play area : 
        g.setColor(Color.BLACK);
        g.fillRect(26,76,849,572);
    }
}