object LearningScala1 {
  // VALUES are immutable constants. You can't change them once defined.
  val hello: String = "This is value, which is immutable!"
                                                  //> hello  : String = This is value, which is immutable!

  println(hello)                                  //> This is value, which is immutable!
  
  // Notice how Scala defines things backwards from other languages - you declare the
  // name, then the type.
  
  // VARIABLES are mutable
  var helloThere: String = hello                  //> helloThere  : String = This is value, which is immutable!
  helloThere = hello + " There! This is mutable"
  println(helloThere)                             //> This is value, which is immutable! There! This is mutable
  
  
  // One key objective of functional programming is to use immutable objects as often as possible.
  // Try to use operations that transform immutable objects into a new immutable object.
  // For example, we could have done the same thing like this:
  val immutableHelloThere = hello + "There!"      //> immutableHelloThere  : String = This is value, which is immutable!There!
  println(immutableHelloThere)                    //> This is value, which is immutable!There!
  val newImmutable = immutableHelloThere + "I know"
                                                  //> newImmutable  : String = This is value, which is immutable!There!I know
  println(newImmutable)                           //> This is value, which is immutable!There!I know
  
  // Some other types
  val numberOne : Int = 1                         //> numberOne  : Int = 1
  val numberTwo = 2                               //> numberTwo  : Int = 2
  val truth : Boolean = true                      //> truth  : Boolean = true
  val letterA : Char = 'a'                        //> letterA  : Char = a
  val pi : Double = 3.14159265                    //> pi  : Double = 3.14159265
  val piSinglePrecision : Float = 3.14159265f     //> piSinglePrecision  : Float = 3.1415927
  val bigNumber : Long = 1234567890l              //> bigNumber  : Long = 1234567890
  val smallNumber : Byte = 127                    //> smallNumber  : Byte = 127
  
  println(f"Double the value ${pi*2}%.3f")        //> Double the value 6.283
  
  
  
  // String printing tricks
  // Concatenating stuff with +:
  println("Here is a mess: " + numberOne + truth + letterA + pi + bigNumber)
                                                  //> Here is a mess: 1truea3.141592651234567890
  
  // printf style:
  println(f"Pi is about $piSinglePrecision%.3f")  //> Pi is about 3.142
  println(f"Zero padding on the left: $numberOne%05d")
                                                  //> Zero padding on the left: 00001
                                                  
  // Substituting in variables:
  println(s"I can use the s prefix to use variables like $numberOne $truth $letterA")
                                                  //> I can use the s prefix to use variables like 1 true a
  // Substituting expressions (with curly brackets):
  println(s"The s prefix isn't limited to variables; I can include any expression. Like ${1+2}")
                                                  //> The s prefix isn't limited to variables; I can include any expression. Like
                                                  //|  3
  println(f"This is all a string $numberOne $numberTwo%04d")
                                                  //> This is all a string 1 0002
  
  println("This is also a string by concatination" + numberOne + numberTwo)
                                                  //> This is also a string by concatination12
  println(f"Add numbers ${numberTwo%02d / 2}")    //> Add numbers 0.0
  
  val string1 = "same"                            //> string1  : String = same
  val string2 = "same"                            //> string2  : String = same
  val compare = string1 == string2                //> compare  : Boolean = true
  
  println(compare)                                //> true
  
  
  
  // Using regular expressions:
  val theUltimateAnswer: String = "To life, the universe, and everything is 42."
                                                  //> theUltimateAnswer  : String = To life, the universe, and everything is 42.
  val pattern = """.* ([\d]+).*""".r              //> pattern  : scala.util.matching.Regex = .* ([\d]+).*
  val pattern(answerString) = theUltimateAnswer   //> answerString  : String = 42
  val answer = answerString.toInt                 //> answer  : Int = 42
  println(answer)                                 //> 42
  
  // Dealing with booleans
  val isGreater = 1 > 2                           //> isGreater  : Boolean = false
  val isLesser = 1 < 2                            //> isLesser  : Boolean = true
  val impossible = isGreater & isLesser           //> impossible  : Boolean = false
  val anotherWay = isGreater && isLesser          //> anotherWay  : Boolean = false
  
  val picard: String = "Picard"                   //> picard  : String = Picard
  val bestCaptain: String = "Picard"              //> bestCaptain  : String = Picard
  val isBest: Boolean = picard == bestCaptain     //> isBest  : Boolean = true
  
  // EXERCISE
  // Write some code that takes the value of pi, doubles it, and then prints it within a string with
  // three decimal places of precision to the right.
  // Just write your code below here; any time you save the file it will automatically display the results!
  
}