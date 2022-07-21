package hw2.fileSystemNode;


import java.io.File;

public class FileSystem extends AbstractFileSystemNode{

    public FileSystem(String path){
        super(path);
    }

    public FileSystem(File parentFile) {
        super(parentFile);
    }




}
