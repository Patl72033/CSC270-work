import scala.io.Source

:load utilities.sc

val grimmLines: Vector[String] = loadFile("text/GrimmFairyTales.txt")
val grimmString: String = grimmLines.toString

showMe(grimmLines)
//isolate the individual characters as elements of a vector
val grimmChars: Vector[Char] = grimmString.toVector
//use .groupBy to sort them into a vector containing each individual element and a listing of every occurrence
grimmChars.groupBy(i=>i).toVector

//create a histogram of the form Vector[(Char, Int)]
val grimmHisto: Vector[(Char, Int)] = (grimmChars._1, grimmChars._2.size)
//properly produce the histogram in text form
