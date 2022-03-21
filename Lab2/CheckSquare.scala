//Reminder:  4 points, time can/should check the lecture slides scala doc (no StackOverflow or similar copy paste)
//The solution that looks like C/Java program will win only 2 points. Scala specific features need to be used.
//  Goal: generate numbers that are not squares of some numbers up to a value N. For N == 11 result should be: 1 2 3 5 6 7 8 10 11 (4 and 9 should not be printed)
//•       The N should be passed from command line, if nothing is passed then only 50 first natural numbers need to printed
//•       in IJ, to set cmd line args go to:  Run -> Edit Configurations -> Program arguments, and enter some number there

object CheckSquare {
  def main(args : Array[String]) : Unit = {
    val N = if(args.length>0) args(0).toInt else 50
    printArray(getSquares(N))
  }

  def getSquares(n : Int): IndexedSeq[Int]={
    for{i <- 0 to n; if Math.sqrt(i)%1 != 0} yield i
  }

  def printArray(arr : IndexedSeq[Int]): Unit = {
    for(i <- arr) print(i + " ")
  }

}
