/*
Exercise 2
   In the second exercise the goal is to use matching to filter elements of the heterogeneous List of objects.
   The classes Company & Person should be added.
 */

object Exercise_2 {
  def main(args: Array[String]): Unit = {
    val data = List(
      Map("name" -> "John", "fname" -> "Smith", "age" -> "45"),
      Map("company" -> "ABB", "origin" -> "Sweden"),
      Map("name" -> "Kate", "fname" -> "Newsmith", "age" -> "45"),
      Map("company" -> "F4", "origin" -> "Poland"),
      List("Something", "else"),
      Map("company" -> "Saline Genovese", "origin" -> "Italy"),
      Map("company" -> "AGH", "origin" -> "Poland"),
      Map("name" -> "Christopher", "fname" -> "Blacksmith", "age" -> "14")
    )
    val p = extr(data)
    println(p)
    println(onlyPeople(p))
    println(onlyComp(p))
  }

  def extr(data: List[Any]): List[Any] = {
    val output = for (e <- data) yield analyseType(e)
    output
  }

  def analyseType(input: Any): Product = {
    input match {
      case map: Map[String, String] => analyseMap(map)
      case list: List[String] => analyseList(list)
    }
  }

  def analyseMap(input_map: Map[String, String]): Product = {
    input_map.contains("company") match {
      case true => Company(input_map("company"), input_map("origin"))
      case false => Person(input_map("name"), input_map("fname"), input_map("age"))
    }
  }

  def analyseList(input_list: List[String]): (String, String) = {
    (input_list(0), input_list(1))
  }

  def analysePerson(input_person: Any): Product = {
    input_person match {
      case person: Person => person
      case _ => None
    }
  }

  def analyseCompany(input_company: Any): Product = {
    input_company match {
      case company: Company => company
      case _ => None
    }
  }

  def onlyPeople(data: List[Any]): List[Any] = {
    val output = for (e <- data) yield analysePerson(e)
    output.filter(_ != None)
  }

  def onlyComp(data: List[Any]): List[Any] = {
    val output = for (e <- data) yield analyseCompany(e)
    output.filter(_ != None)
  }

}

case class Company(companyName: String, origin: String)
case class Person(name: String, fname: String, age: String)