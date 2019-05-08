package org.familysearch.spark.scala

import org.apache.spark.sql.SparkSession
import org.familysearch.spark.scala.util.SparkUtil

/**
  * Class created by dalehulse on 4/5/17.
  */
object CreateBibleDataFrameFromRawText {
  def main(args: Array[String]): Unit = {
    val spark = SparkUtil.createSparkSession(getClass.getName)
    val input = SparkUtil.getInputDir("bible-books-text")
    val output = SparkUtil.prepareOutputDir("bible-books-parquet")

    println("Reading parquet files from " + input)
    println("Writing result to " + output)
    run(spark, input, output)
    spark.stop()
  }

  /**
    * Run the main() method from your IDE when you want to run your code
    *
    * Task 9: Learn how to create SparkSQL DataFrames from raw text and persist it to parquet files.
    *
    *   For this task read in raw text and convert it to a DataFrame
    *
    *   There are several ways to create a DataFrame from raw text.
    *     1) Inferring the schema using reflection: http://spark.apache.org/docs/latest/sql-programming-guide.html#inferring-the-schema-using-reflection
    *     2) Programmatically specifying the schema: http://spark.apache.org/docs/latest/sql-programming-guide.html#programmatically-specifying-the-schema
    *
    *   You may use which ever method you like. The end result needs to have the following fields for each row: "word", "book", and "testament". If you are going to infer the schema,
    *   make sure you include "import spark.implicits._" at the beginning of the run function.
    *
    *   The input dataset has the following schema: <word>\t<book>\t<testament>
    *     now	esther	old-testament
    *     came	esther	old-testament
    *     pass	esther	old-testament
    *     days	esther	old-testament
    *     ahasuerus	esther	old-testament
    *     ahasuerus	esther	old-testament
    *     reigned	esther	old-testament
    *     india	esther	old-testament
    *
    *   After creating the DataFrame, persist it to parquet files:
    *     val result = // code to generate DataFrame
    *     result.write.parquet(output)
    *
    *   Note: You will need to invoke textFile() from the SparkContext to read in the raw text. You can access the SparkContext from the SparkSession
    *   Example:
    *     spark.sparkContext.textFile(input)
    *
    * @param spark configured spark session
    * @param input bible books input directory
    * @param output result output directory
    */
  def run(spark: SparkSession, input: String, output: String): Unit = {
    // todo write code here
  }
}
