fun main() {
    // Fill in the code.
    val cToF: (Double) -> Double = {c -> (9.0 / 5.0) * c + 32 }
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", cToF)
    
    val kToC: (Double) -> Double = {k -> k - 273.15 }
    printFinalTemperature(350.0, "Kelvin", "Celsius", kToC)
    
    val fToK: (Double) -> Double = {f -> (5.0/9.0) * (f - 32.0) + 273.15}
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fToK)
}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}