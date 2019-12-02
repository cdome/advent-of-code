import java.io.File
import kotlin.system.exitProcess

fun main() {
    val code2 = File("day02b.txt").readLines()[0].split(',').map { it.toInt() }
    for (noun in 0..99) {
        for (verb in 0..99) {
            if (runIntCodeV1(code2, noun, verb) == 19690720) {
                println(100 * noun + verb)
                exitProcess(0)
            }
        }
    }
}