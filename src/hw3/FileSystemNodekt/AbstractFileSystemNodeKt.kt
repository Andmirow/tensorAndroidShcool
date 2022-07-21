package hw3.FileSystemNodekt

import hw2.fileSystemNode.FileSystem
import hw2.fileSystemNode.FileSystemNode
import hw2.fileSystemNode.Folder
import java.io.File

abstract class AbstractFileSystemNodeKt(var directory : File) : FileSystemNodeKt{



    constructor(path : String): this(File(path))

    open fun getExtension(): String {
        val name = getName()
        var extension: String = ""
        val index = name.lastIndexOf('.')
        if (index > 0) {
            extension = name.substring(index + 1)
        }
        return extension
    }

    override fun getParentFile(): FileSystemNode {
        val parent = directory.parentFile
        return if (parent.isDirectory) {
            Folder(parent)
        } else FileSystem(directory.parentFile)
    }

    override fun getName(): String {
        return directory.name
    }
    override fun getPath(): String {
        return directory.absolutePath
    }
}