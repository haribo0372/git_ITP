import java.io.*;
import java.nio.channels.FileChannel;

public class Ex2 {
    public static void main(String[] args) {
        try{
            FileInputStream input = new FileInputStream(new File("C:\\Users\\" +
                    "User\\IdeaProjects\\lr4\\input.txt"));
            FileOutputStream output = new FileOutputStream(new File("C:\\Users\\" +
                    "User\\IdeaProjects\\lr4\\output.txt"));
            byte[] buffer = new byte[512];
            int rc;

            while((rc = input.read(buffer)) != -1) {
                output.write(buffer, 0, rc);
            }

            output.close();
            input.close();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}
