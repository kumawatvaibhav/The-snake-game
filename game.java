//Game Program : 
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class game extends JPanel{
    
    // length of snake : 
    private int[] xsnakelength = new int[750];
    private int[] ysnakelength = new int[750];

    // variables for movement directions :
    private boolean right = false; 
    private boolean left = false; 
    private boolean up = false; 
    private boolean down = false;


    private ImageIcon Titleimage;   // title image variable
    // Snake image variable for mouth: 
    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon snakeimage; //snake body variable 

    //variable for Speed of snake :
    private Timer timer;
    private int delay=100; 

    public game(){}

    public void paint(Graphics g){

        //Border for title image : 
        g.setColor(Color.WHITE);
        g.drawRect(25,10,850,55);

        Titleimage = new ImageIcon("./assets/snaketitle.jpg");
        Titleimage.paintIcon(this,g,26,11);

        //Border for game-play :
        g.setColor(Color.WHITE);
        g.drawRect(25,75,850,570);

        // set the background color of game-play area : 
        g.setColor(Color.BLACK);
        g.fillRect(26,76,849,572);

        
    }
}