package main
import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import javax.script.ScriptContext
import breeze.linalg.max

object MaxTemp {
   def main(args: Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR);
    
    val sc = new SparkContext("local[*]", "MaxTemp");
    
    val textFile = sc.textFile("../1800.csv");
    
    val rdd = textFile.map(parseLine);
    
    val tminsrdd = rdd.filter(x => x._2 == "TMAX");
    
    val removetminrdd = tminsrdd.map(x => (x._1, x._3.toFloat));
    
    val groupByStation = removetminrdd.reduceByKey((x,y) => max(x,y));
    
    val results = groupByStation.collect();
    
    results.sorted.foreach(println);
    
  }
  
  def parseLine(eachLine: String) = {
    val fields = eachLine.split(",");
    val stationId = fields(0);
    val tempType = fields(2).toString;
    val temp = fields(3).toFloat;
    (stationId, tempType, temp);
  }
}