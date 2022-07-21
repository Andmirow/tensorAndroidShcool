package hw3.FileSystemNodekt

import java.io.File

class FileSystemKt(var dir : File) : AbstractFileSystemNodeKt(dir){

    constructor(path : String): this(File(path))
}