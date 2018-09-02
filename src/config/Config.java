
package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static view.GameOverDialog.recordlabel;


public class Config {
    public void Config(){
    
    }
    
    public static void Write(String s) throws FileNotFoundException, IOException{
        File f = new File("record.txt");
        if(f.exists()){
            FileOutputStream fos = new FileOutputStream("record.txt",true);
            PrintWriter scrivi = new PrintWriter(fos);
            scrivi.println(s);
            scrivi.close();
    }else if(f.createNewFile()){
                PrintWriter scrivi = new PrintWriter(f);
                scrivi.println(s);
                scrivi.close();
            }
    }
    
    public static void Read() throws  FileNotFoundException, IOException{
        FileReader file = new FileReader("record.txt");
        BufferedReader lettore = new BufferedReader(file);
        String riga="0"; 
        recordlabel.setText(lettore.readLine());
        while(riga != null){
           recordlabel.setText(lettore.readLine());
           riga = lettore.readLine();
           
          
                
        }
        file.close();
    }
    
}
