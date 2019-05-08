package org.familysearch.spark.scala

import org.apache.spark.SparkContext
import org.familysearch.spark.scala.util.SparkUtil

/**
  * Class created by dalehulse on 4/5/17.
  */
object WordsUniqueToTwoBooks {
  def main(args: Array[String]): Unit = {
    val sc = SparkUtil.createSparkContext(getClass.getName)
    val input = SparkUtil.getInputDir("bible-books-text")
    val output = SparkUtil.prepareOutputDir("words-unique-to-two-books")

    println("Reading base input from " + input)
    println("Writing result to " + output)
    run(sc, input, output)
    sc.stop()
  }

  /**
    * Run the main() method from your IDE when you want to run your code
    *
    * Task 7: Learn distinct() and groupByKey()
    *
    *   For this task use distinct() and groupByKey() to find out which words appear in only two books of the Bible.
    *
    *   Here is the input format: <word>\t<book>\t<old-testament>
    *
    *   Input Example:
    *    hangings	esther	old-testament
    *    fastened	esther	old-testament
    *    cords	esther	old-testament
    *    fine	esther	old-testament
    *    linen	esther	old-testament
    *
    *   distinct() is a method that will remove all duplicate elements from your RDD. It uses the equals() method of the object type.
    *     See http://spark.apache.org/docs/latest/programming-guide.html#transformations
    *     Example1:
    *       Before distinct():
    *         "hi"
    *         "there"
    *         "hi"
    *         "again"
    *       After distinct():
    *         "hi"
    *         "there"
    *         "again"
    *
    *     Example2:
    *       Before distinct():
    *         ("the", "genesis")
    *         ("the", "exodus")
    *         ("the, "genesis")
    *       After distinct():
    *         ("the", "genesis")
    *         ("the", "exodus")
    *
    *   groupByKey() is a function in Spark the behaves very similar to Hadoop's MapReduce.
    *     See http://spark.apache.org/docs/latest/programming-guide.html#transformations
    *
    *   groupByKey() is invoked on a PairRDD and it will run a shuffle to generate a PairRDD[K, Iterable[V]]. This shuffle will gather
    *   all of the values for a certain key into one Tuple2. You can then apply a map() function on this Tuple2 to behave like a reduce
    *   function.
    *
    *   Word Count Example:
    *     sc.textFile(input)
    *       .map(word => (word, 1L))
    *       .groupByKey()
    *       .map(tuple => {
    *         var cnt = 0L
    *         for (value <- tuple._2) {
    *           cnt += value
    *         }
    *         (tuple._1, cnt))
    *       })
    *       .saveAsTextFile(output)
    *
    *   Spark's reduceByKey() function is generally a more efficient solution for a reduce function. However, sometimes an application
    *   requires the logic of groupByKey() or in other cases it is better or more efficient to use groupByKey(). This Spark application
    *   can be implemented using reduceByKey(), but we are going to use groupByKey() to get familiar with it.
    *     See http://spark.apache.org/docs/latest/programming-guide.html#shuffle-operations
    *
    * @param sc configured SparkContext to run locally
    * @param input bible lines input directory
    * @param output result output directory
    */
  def run(sc: SparkContext, input: String, output: String): Unit = {
    // todo write code here
  }
}
