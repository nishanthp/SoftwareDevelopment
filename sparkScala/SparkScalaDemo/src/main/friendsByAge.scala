package main

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import javax.script.ScriptContext

object friendsByAge {
  
  def main (args: Array[String]){
    // Set up the logger.
  Logger.getLogger("org").setLevel(Level.ERROR);
  
  // Spark Context. 
  val sc = new SparkContext("local[*]", "friendList");
  
  // Loaded the data file within the spark context. 
  val lines = sc.textFile("../fakefriends.csv");
  
  //
  val rdd = lines.map(parseLine);
  
  // mapValues only deal with values, not the keys.
  val intermrdd = rdd.mapValues(x => (x,1));
  
  val resultrdd = intermrdd.reduceByKey( (x,y) => (x._1 + y._1 , x._2 + y._2));
  
  val totalAges = resultrdd.mapValues(x => x._1 / x._2);
  
  // action.
  val average = totalAges.collect();
  
  average.sorted.foreach(println);
  
  }
  
  def parseLine(line : String) ={
    val fields = line.split(",");
    val age = fields(2).toInt;
    val friendCount = fields(3).toInt;
    (age, friendCount)
  }
  
  
  
  
}