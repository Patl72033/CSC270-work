import scala.io.Source
import edu.holycross.shot.cite._
import edu.holycross.shot.scm._
import edu.holycross.shot.ohco2._
import java.io._
import scala.annotation.tailrec
import java.util.Calendar

:load utilities.sc

val sides: Vector[String] = Vector("white","black")

val pieces: Vector[String] = Vector(
	"aPawn",
	"bPawn",
	"cPawn",
	"dPawn",
	"ePawn",
	"fPawn",
	"gPawn",
	"hPawn",
	"kRook",
	"kKnight",
	"kBishop",
	"King",
	"Queen",
	"qBishop",
	"qKnight",
	"qRook"
)

val columns: Vector[Char] = "abcdefgh".toVector

val rows: Vector[Int] = (1 to 8).toVector

val testVal: Int = 2048

case class PiecePosition( side: String, piece: String, column: Char, row: Int ) {
	override def toString: String = s"${side} ${piece}, at ${column}${row}" 
}

val allPossiblePiecePositions: Vector[ PiecePosition ] = {
	sides.flatMap( s => {
		pieces.flatMap( p => {
			columns.flatMap( c => {
				rows.map( r => {
					PiecePosition( s, p, c, r)
				})
			})
		})
	})
}

assert( allPossiblePiecePositions.size == testVal )

