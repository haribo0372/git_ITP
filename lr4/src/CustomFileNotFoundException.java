import java.io.File;

public class CustomFileNotFoundException extends Exception{
    private File file;

    public String getFilePath(){return file.getAbsolutePath();}

    public CustomFileNotFoundException(String message, File file){
        super(message);
        this.file = file;
    }
}
