package hw3.FileSystemNodekt

import hw2.fileSystemNode.FileSystem
import hw2.fileSystemNode.FileSystemNode
import hw2.fileSystemNode.Folder
import java.io.File

class FolderKt (vararg fileSystem : FileSystemNode) : FileSystemNodeKt{

    var fileListInFolder: ArrayList<FileSystemNode> = ArrayList()
    private var directory: File? = null


    constructor(file : File) : this() {
        directory = file
        val fileArray = file.listFiles()
        for (el in fileArray) {
            fileListInFolder.add(FileSystem(el))
        }
    }

    init{
        for (fileSystemNode in fileSystem) {
            fileListInFolder.add(fileSystemNode)
        }
    }


    fun getAllFilesInThisFolder(): List<FileSystemNode> {
        return fileListInFolder
    }



    override fun getParentFile(): FileSystemNode {
        val parent = directory!!.parentFile
        return if (parent.isDirectory) {
            Folder(parent)
        } else FileSystem(directory!!.parentFile)
    }


    override fun getName(): String {
        return directory!!.name
    }

    override fun getPath(): String {
        return directory!!.absolutePath
    }


}