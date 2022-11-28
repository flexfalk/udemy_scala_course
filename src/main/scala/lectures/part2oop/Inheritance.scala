package lectures.part2oop

object Inheritance extends App{

  // single class inhertiance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors

  class Person(name : String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("Crunch crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //overRIDING vs overLOADING

  //super

  //preventing overrides
  //1. use final on method
  //2. final on superclass. (prevents extension / inheritance
  //3. seal the class. Can extend classes in THIS FILE ONLY, but not in other. ex. sealed class Animal

}
