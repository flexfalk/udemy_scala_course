package lectures.part2oop

object Generics extends App{

  class MyList[+A] {
    //use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    */
  }
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //question: does list of cat extends list of animals? To that there is 3 posssible answers

  //1.yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog)?? HARD QUESTION: Answer : We return a List of animals

  //2. NO = INVARIANCE
  class InvariantList[A]
  //this cant compile
//  val invariantAnimialList: InvariantList[Animal] = new InveriantList[Cat]

  //3. Hell, No = CONTRAVARIANT. The opposite relation to covariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types

  class Cage[A <: Animal](animal: A)
  //A<:Animal means it accept any type which is a subtype of Animal
  //A>:Animal means it only accept a type that is a supertype of animal

  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car) //will not compile







}
