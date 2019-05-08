package org.familysearch.spark.scala.util

import java.io.{File, IOException}

import org.apache.commons.io.FileUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Class created by dalehulse on 3/15/17.
  */
object SparkUtil {
  def createSparkContext(appName: String, setMaster: Boolean = true): SparkContext = {
    val conf = new SparkConf().setAppName(appName)
    if (setMaster) new SparkContext(conf.setMaster("local[*]")) else new SparkContext(conf)
  }

  def createSparkSession(appName: String): SparkSession = {
    SparkSession.builder()
      .appName(appName)
      .master("local[*]")
      .getOrCreate()
  }

  def getInputDir(dir: String): String = {
    val file = new File("input/", dir)

    if (!file.exists()) {
      throw new IOException("File does not exist" + file.getAbsolutePath)
    }

    file.getAbsolutePath
  }

  def prepareOutputDir(dir: String): String = {
    val file = new File("output/", dir)

    if (file.exists()) {
      if (file.isDirectory) FileUtils.deleteDirectory(file) else file.delete()
    }

    file.getAbsolutePath
  }
}
