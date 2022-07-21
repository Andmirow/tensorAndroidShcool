package hw2.fileSystemNode;

public class Main {
    public static void main(String[] args) {


        FileSystem file = new FileSystem("testFileSistenFolder\\folder1\\file.txt");
        System.out.println(file.getExtension());
        FileSystemNode parentFile = file.getParentFile();
        if (parentFile != null){
            System.out.println(parentFile.getName());
        }

    }
}
