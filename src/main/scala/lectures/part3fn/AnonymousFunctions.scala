package lectures.part3fn

object AnonymousFunctions extends App{

  //instead od writing this , we can writer
  //val doubler = new Function1[Int, Int] {
 //   overrider def apply(x: Int) = x *2 }

  //anonymous function (LAMBDA). We can just delete all that function1 crap, and just write it like this
  val doubler: Int=>Int = x => x * 2

  println(doubler(5))

  //multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b


  // no params

  val justDoSomething: () => Int = () => 3


  //carefull
  println(justDoSomething) //function itself
  println(justDoSomething()) //call

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }


  //MORE SYNTATIC SUGAR
  val niceIncrementing : Int => Int = _ + 1 // equavalent ot  (x: Int) => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equavalent to (a, b) => a + b

  //1. MyList: replaces all functionX calls with lambda. DONE

  //2. Rewrite the "special" adder as an anonymous function
  //


}
