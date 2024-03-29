import java.io.File

fun main() {
    println(runIntCodeV1(File("day02a.txt").readLines()[0].split(',').map { it.toInt() }.toMutableList(), 12, 2))
}

fun runIntCodeV1(memory: List<Int>, noun: Int, verb: Int): Int {
    val rwMemory = memory.toIntArray()
    rwMemory[1] = noun
    rwMemory[2] = verb

    val knownInstructions = mapOf<Int, (Int, Int) -> Int>(1 to Int::plus, 2 to Int::times)
    var instructionPointer = 0
    while (rwMemory[instructionPointer] in knownInstructions.keys) {
        rwMemory[rwMemory[instructionPointer + 3]] = knownInstructions[rwMemory[instructionPointer]]!!(
            rwMemory[rwMemory[instructionPointer + 1]],
            rwMemory[rwMemory[instructionPointer + 2]]
        )
        instructionPointer += 4
    }
    return if (rwMemory[instructionPointer] == 99) rwMemory[0] else -1
}