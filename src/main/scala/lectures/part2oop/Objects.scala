package lectures.part2oop

object Objects {

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { //type + its only instance
    val N_EYES = 2 //class level functionality "static"
    def canFly : Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    //instance level functionality
  }

  //COMPANIONS (class and object person)

  def main(args: Array[String]): Unit = {

    println (Person.N_EYES)


    //Scala object = SINGELTON INSTANCE
    val mary = new Person ("Mary")
    val john = new Person ("John")
    println (mary == john)

    val person1 = Person
    val person2 = Person
    println (person1 == person2)


    val bobbie = Person (mary, john)

    //Scala Application = Scala object with
    //def main(args: Array[String]): Unit

    //a scala application is a scala object with ^ method
  }
}
