import java.io.*;

class FS{
    public static File[] list(){
        File pwd=new File(System.getProperty("user.dir"));
        return pwd.listFiles();
    }
 
	public static File[] list(File[] dir){
        if (dir.isDirectory()){
            return dir.listFiles();
        } else {
            System.out.println ("Error. The argument is not a directory");
            // TODO Возможно есть exception у listFiles
        }
    }
}