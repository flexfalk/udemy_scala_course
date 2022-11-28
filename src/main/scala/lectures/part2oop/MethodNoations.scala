package lectures.part2oop

object MethodNoations extends App{

  class Person(val name : String, val favoriteMovie : String, val age : Int=20) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = this.name + " is hanging out with " + person.name
    def unary_! : String = s"$name, what the heck?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
    def apply(n : Int): String = s"$name watched her favorite movie $favoriteMovie $n times"

    //overload the +
    def +(nickname : String): Person = new Person(name= name + " (" + nickname + ")", favoriteMovie=favoriteMovie)

    def unary_+ : Person = new Person(name=name, favoriteMovie=favoriteMovie, age=age+1)

  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception")
  //infix nation = operator notation , only works with methods that have 1 parameter. An Example of syntactic sugar

  val tom = new Person("Tom", "Fight Club")

  println(mary hangOutWith tom)

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS

  //prefix notation
  val x = -1
  val y = 1.unary_- //equavalent


  //unuary_ prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)

//  println(mary isAlive) //not working for me for some reason? Maybe i use another version of scala

  //Apply.. scala specfic apply
  println(mary.apply())
  println(mary()) // equivalent


  //exercise 1
  val foo = mary.+("the rockstar")
  println(foo.name)

  //exercise 2. Add an age to the person class. Add unary + operator => new person with age + 1

  println(mary.age)
  val sofus = +mary
  println(sofus.age)

  println(sofus(3))

  //exercise 3. Add a "lears" method in Person  => "Mary learns Scala". Add a learnsScala method, calls leartns method with "Scala".
  //skip bcause of postfix

  //exercise 4: Overload the apply method mary.apply(2) => Mary wathced Incepotion 2 times






  /*
  1. Overload + operator
    mary + "the rockstar" => new person "Mary the (rockstar"

  */

}
