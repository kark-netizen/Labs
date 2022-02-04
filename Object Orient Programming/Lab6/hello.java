import java.io.*;
import java.util.*;
class hello{
    public static void main(String[] args) throws IOException{
        try{
            File f = new File("a.txt");
        }catch(Exception E){
            System.out.println("yes");

        }
        finally{
            System.out.println("hello");
        }
        
    }
}
