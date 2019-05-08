package org.familysearch.spark.scala

import org.apache.spark.sql.SparkSession
import org.familysearch.spark.scala.util.SparkUtil
import org.apache.spark.sql.functions._


/**
  * Class created by dalehulse on 3/28/17.
  */
object BibleWordCountNewTestamentOnly {
  def main(args: Array[String]): Unit = {
    val spark = SparkUtil.createSparkSession(getClass.getName)
    val input = SparkUtil.getInputDir("bible-books-parquet")
    val output = SparkUtil.prepareOutputDir("new-testament-word-count")

    println("Reading parquet files from " + input)
    println("Writing result to " + output)
    run(spark, input, output)
    spark.stop()
  }

  /**
    * Run the main() method from your IDE when you want to run your code
    *
    * Task 8: Become familiar with SparkSQL
    *
    *   SparkSQL is one of the high level libraries Spark provides. SparkSQL requires data to be structured e.g. DataFrame and
    *   Dataset. Using SparkSQL's Dataset or DataFrame allows Spark to perform extra optimizations it normally would not
    *   be able to do with a RDD.
    *
    *   The purpose of this task is to become familiar with some basic operations in SparkSQL. This Spark application will use a DataFrame, aka Dataset[Row].
    *   DataFrames provide functionality that would normally be used in SQL queries. There are two ways to process a DataFrame: one is to write a SQL query
    *   in a String and the second is to use a set of functions that are similar to SQL functions.
    *
    *   The DataFrame data has already been prepared for this Spark application in a set of parquet files.
    *     See http://spark.apache.org/docs/latest/sql-programming-guide.html#parquet-files
    *
    *   Working with parquet files is very simple using the provided SparkSession object in this method called "spark"
    *     val df = spark.read.parquet(input)
    *     df.show
    *
    *     // result of df.show in stdout
    *     //+---------+------+-------------+
    *     //|     word|  book|    testament|
    *     //+---------+------+-------------+
    *     //|      now|esther|old-testament|
    *     //|     came|esther|old-testament|
    *     //|     pass|esther|old-testament|
    *     //|     days|esther|old-testament|
    *     //|ahasuerus|esther|old-testament|
    *     //|ahasuerus|esther|old-testament|
    *     //|  reigned|esther|old-testament|
    *     //|    india|esther|old-testament|
    *     //|     even|esther|old-testament|
    *     //|     unto|esther|old-testament|
    *     //| ethiopia|esther|old-testament|
    *     //|  hundred|esther|old-testament|
    *     //|    seven|esther|old-testament|
    *     //|   twenty|esther|old-testament|
    *     //|provinces|esther|old-testament|
    *     //|     days|esther|old-testament|
    *     //|     king|esther|old-testament|
    *     //|ahasuerus|esther|old-testament|
    *     //|      sat|esther|old-testament|
    *     //|   throne|esther|old-testament|
    *     //+---------+------+-------------+
    *
    *   The code above will reads in the parquet files and creates a DataFrame. df.show is invoked just to get a view of the data. Notice
    *   the schema of the data: word, book, and testament. You can use these fields like you normally would with a SQL query.
    *     val df = spark.read.parquet(input)
    *     df.createTempView("bible")
    *     val result = spark.sql("select * " +
    *                           "from bible " +
    *                           "where book = 'genesis'")
    *
    *   DataFrames also have SQL functions. When using these functions make sure to include import org.apache.spark.sql.functions._
    *     val df = spark.read.parquet(input)
    *     val result = df.where(col("book").equalTo("genesis"))
    *
    *   Here is another example which uses group by:
    *     val df = spark.read.parquet(input)
    *     df.createTempView("bible")
    *     spark.sql("select testament, count(*) as word_cnt " +
    *             "from bible " +
    *             "group by testament")
    *   or
    *     val df = spark.read.parquet(input)
    *     df.groupBy(col("testament"))
    *       .agg(count("word").as("word_cnt"))
    *
    *
    *   For this Spark application, read the parquet files into a DataFrame. Use the DataFrame to get a word count of
    *   words only in the New Testament (value is "new-testament" in the dataset). After using a DataFrame to get the New Testament
    *   word count, transform it back into an RDD and transform your result to String in the following format: <word>\t<count>.
    *   After transforming it to an RDD, invoke saveAsTextFile to save your result.
    *   Example:
    *     val result = // code to generate DataFrame
    *     result.rdd
    *       .map(row => row.getAs("word").toString + "\t" + row.getAs("word_cnt").toString)
    *       .saveAsTextFile(output)
    *
    *   See these references to learn more about SparkSQL
    *     http://spark.apache.org/docs/latest/sql-programming-guide.html for more details
    *     http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/Dataset.html
    *     http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/Column.html
    *     http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/functions.html
    *
    * @param spark configured spark session
    * @param input bible books input directory
    * @param output result output directory
    */
  def run(spark: SparkSession, input: String, output: String): Unit = {
    // todo write code here
  }
}
