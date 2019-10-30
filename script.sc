import scala.io.Source

:load utilities.sc

val grimmLines: Vector[String] = loadFile("text/GrimmFairyTales.txt")
showMe(grimmLines)
//isolate the individual characters as elements of a vector
println(grimmLines.size)
//use .groupBy to sort them into a vector containing each individual element and a listing of every occurrence

//create a histogram of the form Vector[(Char, Int)]

//properly produce the histogram in text form
