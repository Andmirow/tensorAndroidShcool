package hw2.fileSystemNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemNode{

    List<FileSystemNode> fileListInFolder = new ArrayList<>();

    private File directory;

    public File getDirectory() {
        return directory;
    }

    public Folder(File file){
        this.directory = file;
        File[] fileArray = file.listFiles();
        for (File el : fileArray){
            fileListInFolder.add(new FileSystem(el));
        }
    }

    public Folder(FileSystemNode ... fileSystem){
        for (FileSystemNode fileSystemNode : fileSystem){
            fileListInFolder.add(fileSystemNode);
        }
    }

    public List<FileSystemNode> getAllFilesInThisFolder(){
        return fileListInFolder;
    }

    @Override
    public FileSystemNode getParentFile() {
        File parent = directory.getParentFile();
        if (parent.isDirectory()){
            return new Folder(parent);
        }
        return new FileSystem(directory.getParentFile());
    }

    @Override
    public String getName() {
        return directory.getName();
    }

    @Override
    public String getPath() {
        return directory.getAbsolutePath();
    }
}
