//Game Program : 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class game extends JPanel implements KeyListener,ActionListener{
    
    // length of snake : 
    private int[] xsnakelength = new int[750];  // x coordinate
    private int[] ysnakelength = new int[750];  // y coordinate

    // variables for movement directions :
    private boolean right = true; 
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

    //length of snake body : 
    private int lengthofbody=3;
    private int moves=0;  //to set the position for snake 

    public game(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay,this);
        timer.start();

        requestFocus();
    }

    public void paint(Graphics g){
        // set position for snake : 
        if(moves==0){
            xsnakelength[0]=100;  // mouth position at start
            xsnakelength[1]=75;  
            xsnakelength[2]=50; 

            ysnakelength[0]=100;  // mouth position at start
            ysnakelength[1]=100;  
            ysnakelength[2]=100;  
        }


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

        //pasting snake images : 
        rightmouth = new ImageIcon("./assets/rightmouth.png");
        rightmouth.paintIcon(this,g,xsnakelength[0],ysnakelength[0]);

        //length of body
        for(int i=0;i<lengthofbody;i++){
            if(i==0 && right){
                rightmouth = new ImageIcon("./assets/rightmouth.png");
                rightmouth.paintIcon(this,g,xsnakelength[i],ysnakelength[i]);
            }
            if(i==0 && left){
                leftmouth = new ImageIcon("./assets/leftmouth.png");
                leftmouth.paintIcon(this,g,xsnakelength[i],ysnakelength[i]);
            }
            if(i==0 && up){
                upmouth = new ImageIcon("./assets/upmouth.png");
                upmouth.paintIcon(this,g,xsnakelength[i],ysnakelength[i]);
            }
            if(i==0 && down){
                downmouth = new ImageIcon("./assets/downmouth.png");
                downmouth.paintIcon(this,g,xsnakelength[i],ysnakelength[i]);
            }
            if(i!=0){
                snakeimage = new ImageIcon("./assets/snakeimage.png");
                snakeimage.paintIcon(this,g,xsnakelength[i],ysnakelength[i]);
            }
        }  
        g.dispose();   
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(right){
            for(int i = lengthofbody - 1; i >= 0; i--){
                ysnakelength[i + 1] = ysnakelength[i];
            }
            for(int i = lengthofbody - 1;i>=0;i--){
                if(i==0){
                    xsnakelength[i] = xsnakelength[i] + 25;   
                }
                else{
                    xsnakelength[i] = xsnakelength[i-1];
                }
            }
            repaint();
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT && !left){ //to get the value from when you press right key
            moves++;
            System.out.println("Right arrow key pressed");
            right = true;
            up = false;
            down = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){ //to get the value from when you press left key
            moves++;
            if(!right){
                left=true;
            }
            else{
                left=false;
                right=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){ //to get the value from when you press down key
            moves++;
            if(!up){
                down=true;
            }
            else{
                down=false;
                up=true;
            }
            right=false;
            left=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){ //to get the value from when you press up key
            moves++;
            if(!down){
                up=true;
            }
            else{
                up=false;
                down=true;
            }
            right=false;
            left=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}