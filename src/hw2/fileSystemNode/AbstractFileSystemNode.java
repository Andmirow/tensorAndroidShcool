package hw2.fileSystemNode;

import java.io.File;

public abstract class AbstractFileSystemNode implements FileSystemNode {

    public File getDirectory() {
        return directory;
    }

    private File directory;




    public AbstractFileSystemNode(File directory) {
        this.directory = directory;

    }

    public AbstractFileSystemNode(String path) {
        this.directory = new File(path);
    }

    public String getExtension(){
        String name = getName();
        String extension = "";
        int index = name.lastIndexOf('.');
        if (index > 0) {
            extension = name.substring(index + 1);
        }
        return extension;
    }

    @Override
    public final FileSystemNode getParentFile() {
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
    public final String getPath() {
        return directory.getAbsolutePath();
    }

}
