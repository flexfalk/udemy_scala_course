package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }


  //anonymous class -> bcause of the override def eat. Othewwise cant instanciate abstract class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit= println("ahahahaha")
  }
  /*
  equiuvalent to
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = printlnt("ahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name , how can i help")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim , how can i be of service")
  }

  //so anonymous classes works for both abstract, but also non-abstract classes

}
