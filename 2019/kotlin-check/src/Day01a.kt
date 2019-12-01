import java.io.File

fun main() {
    println(File("day01a.txt").readLines().map { ((it.toInt() / 3) - 2) }.sum())
}