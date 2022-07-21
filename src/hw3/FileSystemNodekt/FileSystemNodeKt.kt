package hw3.FileSystemNodekt

import hw2.fileSystemNode.FileSystemNode

interface FileSystemNodeKt {
    fun getParentFile(): FileSystemNode
    fun getName(): String
    fun getPath(): String
}