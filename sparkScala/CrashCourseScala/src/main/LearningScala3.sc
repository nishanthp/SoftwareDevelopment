object LearningScala3 {
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int) :Int ={
   	return x * x
  }                                               //> squareIt: (x: Int)Int
  
  def cubeIt(x: Int): Int = {x * x * x}           //> cubeIt: (x: Int)Int
  
  //println(squareIt(2))
  
  println(cubeIt(2))                              //> 8
  
  // Functions can take other functions as parameters
  
  def transformInt(x: Int, f: Int =>Int) : Int = {
  	f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int
  
  val result = transformInt(2, squareIt)          //> result  : Int = 4
  println (result)                                //> 4
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x * x)                 //> res0: Int = 27
  
  transformInt(10, x => x / 2)                    //> res1: Int = 5
  
  transformInt(2, x => {val y = x * 2; y * y})    //> res2: Int = 16
  
  // This is really important!
  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  def transFormString(x: String, f: String => String) = {
  f(x)
  }                                               //> transFormString: (x: String, f: String => String)String
  
  val s = "mnisha"                                //> s  : String = mnisha
  println(s.toUpperCase())                        //> MNISHA
  
  transFormString("nishanth", x=>x.toUpperCase()) //> res3: String = NISHANTH
  
}