/*
Exercise 1
 The goal of the exercise is to use scala collections in order to perform various tasks.
 We have a list of people objects (you need to add appropriate class Person):
 val people = List( Person("John", "Doe", 23, "male"), Person("Joan", "Doe", 23, "female"), Person("Steve", "Jenkins", 24, "male"), Person("Eva", "Robinson", 25, "female"),
 Person("Ben", "Who", 22, "male"), Person("Janet", "Reed", 21, "female"), Person("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female") )
 The meaning of fields is obvious.
 Using collections API (simple for loop solutions are excluded) print the following information.
 !All operations should happen in one pass over the collection!
 - Print all people name + family name, wiht M/F before each. (in single pass - easy)
 - Count, simultaneously all males & famales. (in single pass, so so)
 - Obtain average age. (in single pass, hard)
 - Obtain average age for males and females. (in slingle pass, killer)
*/
object Exercise_1 {
  def main(args: Array[String]): Unit = {
    val people = List( Person("John", "Doe", 23, "male"), Person("Joan", "Doe", 23, "female"), Person("Steve", "Jenkins", 24, "male"), Person("Eva", "Robinson", 25, "female"),
      Person("Ben", "Who", 22, "male"), Person("Janet", "Reed", 21, "female"), Person("Rob", "Jenkins", 26, "male"), Person("Ella", "Dawson", 27, "female") )

    //First one
    println(people.collect({case x: Person =>
      if(x.sex == "male") ("M " + x.name + " " + x.family_name)
      else ("F " + x.name + " " + x.family_name)
      }))

    //Second one
    var male_count = 0
    var female_count = 0
    people.collect({case x: Person =>
      if(x.sex == "male") male_count += 1
      else female_count += 1
    })
    println("Males: " + male_count + " Females: " + female_count)

    //Third one
    var age = 0
    people.collect({case x: Person => age += x.age})
    println("Average age = " + age / people.length)

    //Fourth one
    var female_age = 0
    var male_age = 0
    people.collect({case x: Person =>
      if(x.sex == "male") male_age += x.age
      else female_age += x.age
    })
    println("Female average age: " + female_age / female_count + " Male average age: "+ male_age / male_count )
  }

  case class Person(name: String, family_name: String, age: Int, sex: String)
}