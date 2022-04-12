/*Exercise 2:
  Here we aim at writing two classes to handle list of everyday expenses.
  The class which will hold the information about single expense will be called Expense (needs to be a functional class).
  Class responsible for handling all of the expenses should be called ExpensesList.
  It should allow us to add single Expense, list all of them and print summary of all the expenses.
  val el = ExpensesList()
  el += Expense(5, "Bread", "food") // amount, item name, category
  el += Expense(7, "Butter", "food")
  el += Expense(3.2, "Tomatoes", "food")
  el += Expense(18, "Star Wars ticket", "entertainment")
  el.printList()
  println( el.sum )
  println( el.max )
  To speed up the implementation check the list methods like aggregate or maxBy. However, a plain for loop, would also do.*/

object Exercise_2 {
  def main(args: Array[String]): Unit = {
    val el = ExpensesList()
    el += Expense(5, "Bread", "food")
    el += Expense(7, "Butter", "food")
    el += Expense(3.2, "Tomatoes", "food")
    el += Expense(18, "Star Wars ticket", "entertainment")
    el.printList()
    println( el.sum )
    println( el.max )
  }

  class ExpensesList(var list: List[Expense] = Nil){
    def += (element: Expense): Unit ={
      list = element :: list
    }
    def printList(): Unit ={
      println(list.mkString("\n"))
    }
    def sum: Double = {
      var sum = 0.0
      for (i <- list) sum += i.price
      sum
    }
    def max: Expense = {
      val max_value: Expense => Double = element => element.price
      list.maxBy(max_value)
    }
  }
  object ExpensesList{
    def apply() = new ExpensesList()
  }

  class Expense(val price: Double, val item: String, val category: String){
    override def toString: String = {price + " " + item + "(s) of category: " + category}
  }
  object Expense{
    def apply(price: Double, item: String, category: String) = new Expense(price, item, category)
  }
}
