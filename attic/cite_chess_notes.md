# CITE Chess 

## A JS Framework

This JS framework, [chessboard.js](https://chessboardjs.com/index.html), can provide a UI and mechanisms for visualizing and capturing positions and games.

It is not worth re-inventing this wheel. The library looks solid and well-supported. You can write Functions in Scala-JS, with all the rigor and type-safety Scala affords, and compile them to super-optimized JS (which will be more stable and fast than anything you could code by hand in JS).

## FEN Notation

[Forsyth–Edwards Notation](https://en.wikipedia.org/wiki/Forsyth–Edwards_Notation) is a potentially useful *serialization*. 

That is, if you want to apply the CITE-Architecture, a useful ongoing test is whether you can translate positions, moves, and games from CITE to FEN. 

## Overview

- We want a `case class BoardSquare( s: String )` object, that takes a String like "c3", validated it (must consist of 'a-h' and '1-8' only), and can provide convenience methods like `.left`, `.back`, or whatever. These would be represented by simple Strings in CITE data, but can be turned into Objects in code, like we do with URNs. **But this may be unecessary.**
- **PiecePosition Collection** An *unordered* collecdtion of every possible positiong for each individual piece. We originally calculated 2,048 of these. But if we don't distinguish one White Bishop from another, there are fewer, since a "white pawn on e4" is the same regardless of which white pawn it is: 768.
	- pawn
	- king
	- queen
	- rook
	- bishop
	- knight
	- * two sides
	- * 64 squares
- **Position Collection** An *unordered* collection existing mainly to give an ID for any number of  positions, with PiecePosition objects, associated to it via **CITE Relations** (one-to-one associations, with a URN-identified “relation”).
- **Game Collection** An *ordered* collection of objects, each showing the *game-state*. Each object in this collection should have these properties:
	- A **URN**.
	- A **Label** of some kind ("Game XYX, move 1").
	- A **Position** property whose value is the URN of a **Position Object** (see above).
	- An **EnPassantTarget**, which is a (possibly empty) String.[^ep]
	- A **WhiteCanCastle** property, which can follow the FEN notation: "K", "Q", "KQ", "".
	- A **BlackCanCastle** property, which can follow the FEN notation: "k", "q", "kq", "".
	- A **NextMove** property, a String with values "w" or "b".
	- **HalfMoveClock** property. 
	- **FullMove** number, incremented after Black’s move. (These last two *could* be calculated, of course, but the point of this is to be able to pull a given object out of its context, without losing its context. If we have just one move of a game, we will want to see where it was in terms of HalfMove's since the last capture, or full moves.)
- **PositionRelations** A CiteRelationSet associating PiecePosition Objects with Position objects:

~~~
urn:cite2:fuChess:piecePosition.v1:1234
	#
urn:cite2:fuChess:relations.v1:pieceInPosition
	#
urn:cite2:fuChess:position.v1:345
~~~


[^ep]: Or, we use a Cite2Urn for this, with value either `urn:cite2:fuChess:piecePosition.v1:none` (always an option), or, *e.g.* `urn:cite2:fuChess:piecePosition.v1:234` which identifies a pawn of the correct color standing in the appropriate square.


## Steps

1. Dummy up a CEX file with skeletal versions of these Collections and Relations.
1. Write a function that takes a chessboard.js [Position Object](https://chessboardjs.com/examples.html#1003) and generates a ScalaObject, which can then be serialized to CEX.
1. Modify code I have to write this stuff out to a CEX file.
1. At that point, you can have a web-app that lets you set up pieces on a board, and write that data to CEX.
1. Write functions that turn Scala/CITE data into FEN strings or chessboard.js Position Objects, to pass them back to chessboard.js

## Misc.

- Of **positions** there are two instantiations… one considered absolutely, with no context, and one considered in the context of a game. These should be separated. For example, for a given *position*, *en-passant* is available *only if* a pawn has *just* made a two-square move; this is determined by the progress of the game, so *en-passant-target* needs to be separate data from a *Position* Object.
- No one else seems to think it is worth retaining the initial identity of pieces. So even thought a Pawn begins as King's Bishop's Pawn, that information is not retained. This makes sense, I guess, in environments where you start from an arbitrary point in the game, where the history of all prior moves is not important.
- This will take *a lot of work*. No doubt about it. 


