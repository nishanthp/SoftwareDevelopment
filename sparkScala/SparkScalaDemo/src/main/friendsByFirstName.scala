package main

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import javax.script.ScriptContext

object friendsByFirstName {
  def main(args: Array[String]){
    
    // Set logger.
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    // Create a spark context.   
    val sc = new SparkContext("local[*]", "friendByFirstName");
   
    // Load the data file into Spark Context.
    val textFile = sc.textFile("../fakefriends.csv");
    
    val rdd = textFile.map(parseLine);
    
    val interrdd = rdd.mapValues(x => (x,1));
    
    val countByFirstName = interrdd.reduceByKey((x,y) => (x._1 + y._1 , x._2 + y._2));
    
    val averageByFirstName = countByFirstName.mapValues(x => x._1 / x._2);
    
    // collect the data from the cluster manager. Compute DAC and execute the results.
    val results = averageByFirstName.collect();
    
    results.sorted.foreach(println);
    
  }
  
  def parseLine(eachLine: String) = {
    val fields = eachLine.split(",");
    val firstName = fields(1).toString;
    val friendCount = fields(2).toInt;
    (firstName, friendCount);
  }
}