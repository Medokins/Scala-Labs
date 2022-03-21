//Reminder:  6 points, time ~1h, no other help except the scala console
//Write the program that:
//  1 takes the arguments from command line and prints their number to the screen
//    2 then prints all arguments inserting spaces to that 80 characters are used
//  e.g. :
//
//  > scala lab1 hello there people one 2 III
//  6         hello            there           people           one        2          III
//  ^
//80 characters
//
//3 extend this program to take the "width" as a first argument, i.e.:
//  > scala lab1  30 hello there people one 2 III
//  6  hello    there   people     one   2   III
//  ^
//30 characters

object Exercise_1 {
  def main(args : Array[String]) : Unit = {
    val width  = args(0).toInt
    printWithSpaces(args, width)
  }

  def printWithSpaces(args : Array[String], width : Int) : Unit = {

    val numberOfWords = args.length - 1
    val numberOfCharacters = args.toString.length
    val spacesRequired = (width - numberOfCharacters) / numberOfWords

    val argsUpdated = args.slice(1, numberOfWords + 1)

    print(numberOfWords + " "*spacesRequired)
    println(argsUpdated.mkString(" "*spacesRequired))
  }
}
