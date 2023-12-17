import java.io.File;

public class CustomFile {
    public static File getFile(String path) throws CustomFileNotFoundException{
        File newFile = new File(path);
        if (!newFile.exists()) throw new CustomFileNotFoundException("Error:" +
                " FILE NOT FOUND", newFile);

        return newFile;
    }

    public static void main(String[] args){

        try{
            File file = CustomFile.getFile("C:\\Users\\User\\" +
                    "IdeaProjects\\lr4\\sile.txt");
            System.out.println("File " + file.getName() + " can be open");
        }
        catch(CustomFileNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getFilePath());
        }
    }
}
