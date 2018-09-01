
package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Config {
    public void Config(){
    
    }
    
    public static void Write(String s) throws FileNotFoundException, IOException{
        File f = new File("record.txt");
        if(f.exists()){
            FileOutputStream fos = new FileOutputStream("record.txt",true);
            PrintWriter scrivi = new PrintWriter(fos);
            scrivi.append(s);
            scrivi.close();
    }else if(f.createNewFile()){
                PrintWriter scrivi = new PrintWriter(f);
                scrivi.println(s);
                scrivi.close();
            }
    }
    
}
