package lectures.part3fn

object WhatsAFunction extends App{

  //DREAM : use and as first class elements
  //problem: oop world

  val doubler = new MyFunction[Int, Int] {
  override def apply(n : Int): Int = n*2
  }

  println(doubler(2))

  //function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(1, 2))
  //Function types: Function2[A, B, R] == (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. a funbctino that takes to strings and concatenate
  2. MyList transform the Mypredicate and MyTransformer into function types
  3. def a function which takes an argument int and returns another function which takes an int and returns an in
    - whats the typpe of this function
    - how to do it
  */

  //1
//  val stringConcat: ((String, String) => String) = new Function3[String, String, String] {
//    override def apply(a: String, b: String): String = a + b
//  }

  def stringConcat: ((String, String)=>String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(stringConcat("hello", " world"))

  //2 is done in mylist

  //3
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x : Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }


  val superAdd = (x: Int) => (y: Int) => x + y


  val adder3 = superAdder(3)

  println(adder3(4))
  println(superAdd(3)(4)) //curried function


}

trait MyFunction[A, B] {
  def apply(element: A): B
}
