import java.io.*;
import java.util.*;

public class ReadWriteFile{
    static int lastScore;
    
    static Scanner sc=new Scanner(System.in);
    static void Write(int newScore){

        try{
             
            FileOutputStream fw=new FileOutputStream("test.txt");
            DataOutputStream dw=new DataOutputStream(fw);
            dw.writeInt(newScore);

        }catch(IOException e){

            System.out.print(e);
        }
    }
    static void Read(){


        try{
            FileInputStream fr=new FileInputStream("F:\\SHARAD\\GAME\\test.txt");
            DataInputStream dr=new DataInputStream(fr);

            try{ lastScore=dr.readInt();
                
            }
            catch(IOException e ){
                System.out.println(e);

            }

        }catch(FileNotFoundException e){

            System.out.println("File Not Found");}
    }

    
    
    public static void main(String args[]){
        
        
       // Read();
      //  Write();
      
      System.out.print(lastScore);
      
    }
}