object LearningScala2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(141); 
  // Flow control
  
  // If / else syntax
  if (1 > 3) println("Impossible!") else println("The world makes sense.");$skip(96); 
  
  if (1 > 3) {
  	println("Impossible!")
  } else {
  	println("The world makes sense.")
  };$skip(73); 
  
  // Matching - like switch in other languages:
  val number = "name";System.out.println("""number  : String = """ + $show(number ));$skip(126); 
  number match {
  	case "mio" => println("One")
  	case "name" => println("Two")
 	case _ => println("Something else")
 
 	};$skip(87); 
 	
 	// For loops
 	for (x <- 1 to 4) {
 		val squared = x * x
 		println(squared)
 	};$skip(81); 
                                                  
  // While loops
  var x = 10;System.out.println("""x  : Int = """ + $show(x ));$skip(47); 
  while (x >= 0) {
  	println(x)
  	x -= 1
  };$skip(59); 
                                                  
  x = 0;$skip(42); 
  do { println(x); x+=1 } while (x <= 10);$skip(63); 
    
    println({val forString = "String"; forString+ "Con"});$skip(154); val res$0 = 
                                                  
   // Expressions
   // "Returns" the final value in a block automatically
   
   {val x = 10; x + 20};System.out.println("""res0: Int = """ + $show(res$0));$skip(82); 
                                                
	 println({val x = 10; x + 20});$skip(269); 
	 
	 // EXERCISE
	 // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
	 
	 	var prev = 0;System.out.println("""prev  : Int = """ + $show(prev ));$skip(17); ;
	 	var curr = 1;System.out.println("""curr  : Int = """ + $show(curr ));$skip(180); ;
	   for(iter <- 1 to 9){
	   if (iter < 2) {
	   println(prev)
	   println(curr)
	   } else{
	   var next = prev + curr;
	   println(next);
	   prev = curr;
	   curr = next;
	   }}
	   
	   }
}
