import java.awt.event.*;    
import javax.swing.*;           
class SNAKE extends JFrame implements KeyListener{
    private final int width = 1000; 
    private final int height =500; 
    private int keystroke = 0;
    static int DELAY=7;
    private int life=7;
    Control ground;
    public SNAKE(){
        ground = new Control(width, height);
         setUndecorated(false);
        setFocusable(true);
        setVisible(true);
        add(ground);
        addKeyListener(this);
        setResizable(true);
        
        setBounds(200,100,width, height);
        
       
          
        
        
        while (true) {
            
            try{Thread.sleep(DELAY);}catch(Exception e){};
            ground.repaint();
           
        }
        
        
    } 

    public void keyReleased(KeyEvent event){
        
    }

    public void keyTyped(KeyEvent event){
    }

    public void keyPressed(KeyEvent event){
        int id = event.getKeyCode();
        if (id==27 || id==81) {
            System.exit(0);
        }
        // Turn Left
        if (id==39 || id==68) {
            ground.keystroke = "right";
            ground.repaint();   
        }   
        // Turn Right
        if (id==37 || id==65 ) {
            ground.keystroke = "left";
            ground.repaint();
        }
        // Turn Down    
        if (id==40 || id==83) {
            ground.keystroke = "down";
            ground.repaint();
        }
        // Turn Up
        if (id ==38 || id==87) {
            ground.keystroke = "up";
            ground.repaint();
        }
    }
    
    public static void main(String[] args) {
       
      
         
        SNAKE A= new SNAKE();
        
    }
} 
       /* Keyboard Mapping
        UP      38, 87
        Down    40, 83
        Left    39, 68
        Right   37, 65
        QUIT    27, 81*/