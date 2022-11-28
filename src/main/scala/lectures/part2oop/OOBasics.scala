package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 26)
  println(person.age)

  person.greet("Daniel")
  person.greet()

  println("-------")


  val writer = new Writer("Sofus", "Konglevoll", 1996)

  println(writer.fullname())

  val novel = new Novel("Hunden og mennesket", 2003, author = writer)

}

//constructor
class Person(name : String, val age: Int = 0) {
  //body
  val x = 2
  println(1 + 3)

  //method
  def greet(name: String): Unit = println(this.name + " says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi , i Am" + this.name)

  //multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

  //exercises
  /*
  Novel and Writer Class

  Writer: first name, surname, year
   - method fullname

  Novel: name, year of release, auther
  - authorAge
  -isWrittenBy(author)
  -copy (new year of release) = new instance of novel with new release
  */
class Writer(val firstname : String, val lastname : String, val year : Int) {

    def fullname(): String = firstname + " " + lastname
  }

class Novel(val name : String, val year : Int, val author : Writer) {

  //authorAge
  def authorage(): Int =  author.year

  def isWrittenBy(author : Writer) = author == this.author

  def copy(newYear : Int): Novel = new Novel(name, newYear, author)
}



  /*
  Counter class
   - receives an int value
   - method current count
   - method to increment/decrement => new Counter
   - overload inc/dec to reveive an amount => new Counter
  */


class Counter(val value : Int) {

  def increment(): Counter = new Counter(value + 1) //immutability. Whenever you want to modify a field in an instance, you have to return a new instance of that type wit the new field
  def decrement(): Counter = new Counter(value - 1)

  //overload
  def increment(amount : Int) = new Counter(value + amount)
  def decrement(amount : Int) = new Counter(value - amount)



}




// class parameters are NOT FIELDS
//if you want them as fields, add val in front (or var)

