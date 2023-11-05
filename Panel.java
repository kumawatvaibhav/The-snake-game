package snakegame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener,KeyListener{

    // length of snake : 
    private int[] snakexlength = new int[750];  // x coordinate
    private int[] snakeylength = new int[750];  // y coordinate
    private int lengthofsnake=3;  //body length including head
    
    // variables for movement directions :
    private boolean right = true; 
    private boolean left = false; 
    private boolean up = false; 
    private boolean down = false;
    private int moves=0; //to check the moves

    
    //Image variable declare and provided link of image
    private ImageIcon snaketitle = new ImageIcon( getClass().getResource("snaketitle.jpg")); 
    private ImageIcon snakeimage = new ImageIcon( getClass().getResource("snakeimage.png")); 
    private ImageIcon downmouth = new ImageIcon( getClass().getResource("downmouth.png")); 
    private ImageIcon upmouth = new ImageIcon( getClass().getResource("upmouth.png")); 
    private ImageIcon rightmouth = new ImageIcon( getClass().getResource("rightmouth.png")); 
    private ImageIcon leftmouth = new ImageIcon( getClass().getResource("leftmouth.png")); 
    
    //variable for Speed of snake :
    private Timer timer;
    private int delay=100; //100 milisecond

    Panel(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        
        timer = new Timer(delay,this);
        timer.start();  //this timer class will call actionlistener method
    }

    @Override
    public void paint(Graphics g){
        super.paint(g); 

        //Border for title image :
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851, 55);

        //Border for game-play :
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,576);

        snaketitle.paintIcon(this, g, 25, 11);  //setting the snake title image : 
        
        //for the background rectangle : 
        g.setColor(Color.BLACK);  //playground color 
        g.fillRect(25, 75, 850, 575);

        // intial position for snake : 
        if(moves==0){
            snakexlength[0]=100;  // mouth position at start
            snakexlength[1]=75;  
            snakexlength[2]=50; 
        
            snakeylength[0]=100;  // mouth position at start
            snakeylength[1]=100;  
            snakeylength[2]=100;  
            moves++;
        }

        if(left){
            leftmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        }
        if(right){
            rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        }
        if(up){
            upmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        }
        if(down){
            downmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
        }

        for(int i=1;i<lengthofsnake;i++){
            snakeimage.paintIcon(this,g,snakexlength[i],snakeylength[i]);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=lengthofsnake-1;i>0;i--){
            snakexlength[i]=snakexlength[i-1];
            snakeylength[i]=snakeylength[i-1];
        }

        if(left){
            snakexlength[0]=snakexlength[0]-25;
        }
        if(right){
            snakexlength[0]=snakexlength[0]+25;
        }
        if(up){
            snakeylength[0]=snakeylength[0]-25;
        }
        if(down){
            snakexlength[0]=snakexlength[0]+25;
        }

        //to keep the in bound and return from the parallel side
        if(snakexlength[0]>850){
            snakexlength[0]=25;
        }
        if(snakeylength[0]<25){
            snakeylength[0]=850;
        }
        if(snakeylength[0]>625){
            snakeylength[0]=75;
        }
        if(snakeylength[0]<75){
            snakeylength[0]=625;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left=true;
            right=false;
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            left=false;
            right=true;
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            left=false;
            right=false;
            up=true;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            left=false;
            right=false;
            up=false;
            down=true;
        }
    }

    // these 2 methods are no in used but have to be implement 
    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}
}