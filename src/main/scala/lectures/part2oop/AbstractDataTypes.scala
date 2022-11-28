package lectures.part2oop

object AbstractDataTypes extends App{

  // abstract. Can not be instanciated
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    //actually dont need override, since superclass is abstract, it allready knows
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  //traits - the ultimate abstract class
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"i am a croc an im eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  //  println(croc.preferredMeal)

  //traits vs abstract classes
  //1 - traits do not have constructor parameters
  //2 - multiple traits may be inherited, but only 1 abstract class: this is how you implement multiple inheritance
  //3 - traits = behavior, abstract class = "thing"

}
