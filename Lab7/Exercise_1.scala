/*The goal is to prepare two traits that will be used to add additional info to printed messages when writing text on the screen.
 TimeStamp will prefix the printed message with the time stamp:
 val today = Calendar.getInstance().getTime() (from java.util.Calendar can be used to obtain current time)
 The Quote trait that will wrap printed text in "".
*/

import java.util.Calendar

object Exercise_1 {
  def main(args: Array[String]): Unit = {
    val lqt = new Logger with Quote with TimeStamp
    println("With Qotes and TimeStamp")
    lqt.my_print("Hello world")

    val lq = new Logger with Quote
    println("With Qotes NO TimeStamp")
    lq.my_print("Hello world")

    val l = new Logger
    println("NO Qotes NO TimeStamp")
    l.my_print("Hello world")
  }
}

class Logger {
  def my_print(sample: String): Unit = print(sample)
}

trait Quote extends Logger {
  override def my_print(sample: String): Unit = {
    print("\"")
    super.my_print(sample)
    print("\"\n")
  }
}

trait TimeStamp extends Logger {
  val today = Calendar.getInstance().getTime()
  override def my_print(sample: String): Unit ={
    print(today.toString + " ")
    super.my_print(sample)}
}
