package hw3

import hw2.fileSystemNode.FileSystem
import hw3.FileSystemNodekt.FileSystemKt
import hw3.cards.CardKotlin
import hw3.cards.Suit


class Main {

}

fun main(args : Array<String>){

    val cardKotlin = CardKotlin(Suit.clubs)
    println(cardKotlin.toString())
    val cardKotlin3 = CardKotlin(Suit.clubs)
    println(cardKotlin3.toString())
    val cardKotlin2 = CardKotlin(Suit.clubs, 5)
    println(cardKotlin2.toString())
    val cardKotlin4 = CardKotlin(Suit.clubs)
    println(cardKotlin4.toString())


    val file = FileSystemKt("testFileSistenFolder\\folder1\\file.txt")
    println(file.getExtension())
    val parentFile = file.getParentFile()
    if (parentFile != null) {
        println(parentFile.name)
    }






}