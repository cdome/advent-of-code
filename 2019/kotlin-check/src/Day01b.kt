import java.io.File

fun main() {
    println(File("day01a.txt").readLines().map { it.toInt() }.map {
        fuelPerMass(it).let { fuelPerModule -> fuelPerModule + fuelForFuel(fuelPerModule) }
    }.sum())
}

private fun fuelPerMass(mass: Int) = ((mass / 3) - 2)

private fun fuelForFuel(fuelMass: Int): Int = fuelPerMass(fuelMass).let { if (it < 1) 0 else it + fuelForFuel(it) }