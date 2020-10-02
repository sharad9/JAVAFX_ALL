import javax.swing.*;             
import java.awt.BasicStroke;    
import java.awt.Graphics2D;
import java.lang.Thread;    
import java.util.Random;    
import java.awt.Font;   
import java.awt.Color;  
import java.awt.*; 
import java.util.TimerTask;   
import java.io.*;
//import sun.audio.*;

class Control extends JPanel{
    private int width;       
    private int height; 
    private int A[];
    private int B[];
    private int snakelen =400;  
    private String direction = "right";  
    private int i=0;
    private int a;            
    private int b;            
    private int c;            
    private int d;    
    private int lunchX;       
    private int lunchY;       
    static boolean lunchavailable; 
    private  Random ran = new Random();
    static int Score=-1;         
    static boolean GameOver;        
    String keystroke = "right";
    private float thick=3;
    private int lastScore;
    private boolean Read=false;
    private boolean started=false;
    
    private InputStream is1,is2;
   
    //private AudioStream as1,as2;
    //private AudioData ad1,ad2;
    //private ContinuousAudioDataStream cas1,cas2;
   
    Control(int w, int h){
        width = w;
        height = h;
        A = new int[2000];
        B = new int[2000];

        for(int i=0;i<snakelen;i++){
            A[i]=20+i;
            B[i]=200;
        }

        setFocusable(true);
        setVisible(true);
        setSize(width, height);
       
      

        //cas1=new ContinuousAudioDataStream(ad1);
        //cas2=new ContinuousAudioDataStream(ad2);
         
    }
    void gamestarted(){
        if(started==false){t1.start();}
       
    }

    void drawlunch(Graphics2D g){
        if(lunchavailable==false){
            if(Score%10==5){Score+=4; snakelen++;}

            lunchX = ran.nextInt(width-100)+20;
            lunchY = ran.nextInt(height-100)+20;
            Score++;
            snakelen+=1;

            lunchavailable=true;
        }
        if(lunchavailable==true ){

            g.setColor(Color.BLACK);
            //g.setStroke(new BasicStroke(10f));
            if(Score%10==5){
                g.setColor(Color.RED);
                if(selfbite()==true)GameOver=true;//snakelen++;Score++;
                //g.setStroke(new BasicStroke(15f));

            }
            g.fillOval(lunchX-7,lunchY-7,15,15);

        }

        if ( 

        (lunchX-7) < A[0] &&
        (lunchX+7) > A[0] &&
        (lunchY-7) < B[0] &&
        (lunchY+7) > B[0] &&

        lunchavailable==true)
        {  
            snakelen++;lunchavailable=false;
        }
        if (
        width-15== A[1] ||
        0+15==A[1] ||
        height-15== B[1] ||
        0+15==B[1]
        ){
            GameOver = true;

        }

    }

    boolean selfbite(){
        for (int x=20;x<=snakelen;x++){

            if(A[x]==A[0]&&B[x]==B[0]){
                GameOver=true;
                break;
            }
        }

        if(GameOver==true)return true;
        else return false;
    }

    void movesnake(int x, int y){
        a = A[0]+x;
        b = B[0]+y;

        for (i=0;i<snakelen;i++) {
            c = A[i];
            d = B[i];
            A[i] = a;
            B[i] = b;
            a = c;
            b = d;
        }
        A[snakelen]=a;
        B[snakelen]=b;

    } 

    void GameOverDisplay(Graphics2D g){

        String msg = " YOUR SCORE: "+Score + ":Do Your Best!";

        Font small = new Font("TimesRoman", Font.TRUETYPE_FONT+Font.BOLD, 50);
        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg,10, height/2 );
         Font font = new Font("TimesRoman", Font.TRUETYPE_FONT+Font.BOLD, 70);
         g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Highest Score :"+lastScore,100,100);

    }

    void ScoreDispay(Graphics2D g){
        Font small2=new Font("",Font.BOLD,30);
        g.setColor(Color.black);

        g.setFont(small2);
        g.drawString("SCORE :"+Score,200,35);
        g.drawString("LOCATION :"+A[0]+" "+B[0],400,35);
        g.drawString("SPEED :"+(7-SNAKE.DELAY),800,35);

    }

    void drawsnake(Graphics2D g){
        g.setColor(Color.green);

        g.setStroke(new BasicStroke(thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));

        g.drawPolyline(A,B,snakelen);
        if(Score%20==0){SNAKE.DELAY--;snakelen+=1;thick++;Score++;}

    }

    public void paintComponent(Graphics g){

        if (keystroke=="right" && direction!="left") {
            direction="right";

        }
        else if (keystroke=="left"&& direction!="right") {
            direction="left";
        }
        else if (keystroke=="up"&& direction!="down") {

            direction="up";
        }
        else if (keystroke=="down"&& direction!="up") {
            direction="down";
        }

        if (direction=="down" && GameOver==false) {
            movesnake(0, 1);
        }
        else if (direction=="up" && GameOver==false) {
            movesnake(0, -1);
        }
        else if (direction=="left" && GameOver==false) {
            movesnake(-1, 0);
        }
        else if (direction=="right" && GameOver==false) {
            movesnake(1, 0);   
        }   
        update(g);
    }
    
    Thread t1=new Thread(new Runnable()

        {
        public  void run(){
             if(started==false){
        //AudioPlayer.player.start(cas1); 
           
          } 
        //  AudioPlayer.player.stop(cas1);
          
          started=true;
           t1.stop();
        }

        });
        
        


    public void update(Graphics g){
        gamestarted();
        g.setColor(Color.white);
        g.fillRect(0,0,width, height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(25f));

        g2.drawRect(0,0,width,height);
        Graphics2D g2D = (Graphics2D) g;

        drawsnake(g2D);
        ScoreDispay(g2D);
        drawlunch(g2D);
        
      if(GameOver==true) {
          
            
            if(Read==false){
              // AudioPlayer.player.start(cas2); 
                 try{Thread.sleep(1093);}catch(Exception e){}
               // AudioPlayer.player.stop(cas2);
                ReadWriteFile.Read();

                lastScore=ReadWriteFile.lastScore;
                if(lastScore<Score)
                    ReadWriteFile.Write(Score);

            }
            Read=true;
            

            g.clearRect(0,0,width, height); 
            GameOverDisplay(g2D);

            GameOverDisplay(g2D);
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(40f));

            g2.drawRect(0,0,width,height);

        }

    }
}