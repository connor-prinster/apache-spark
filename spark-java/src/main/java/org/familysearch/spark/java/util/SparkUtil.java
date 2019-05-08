package org.familysearch.spark.java.util;

import org.apache.commons.io.FileUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.File;
import java.io.IOException;

/**
 * Class created by dalehulse on 3/15/17.
 */
public class SparkUtil {
  private SparkUtil() {}

  public static JavaSparkContext createSparkContext(final String appName) {
    return createSparkContext(appName, true);
  }

  public static JavaSparkContext createSparkContext(final String appName, final boolean setMaster) {
    SparkConf conf = new SparkConf().setAppName(appName);
    if (setMaster) {
      conf = conf.setMaster("local[*]");
    }
    return new JavaSparkContext(conf);
  }

  public static String getInputDir(final String dir) throws IOException {
    final File file = new File("input/", dir);

    if (!file.exists()) {
      throw new IOException("File does not exist" + file.getAbsolutePath());
    }

    return file.getAbsolutePath();
  }

  public static String prepareOutputDir(final String dir) throws IOException {
    final File file = new File("output/", dir);

    if (file.exists()) {
      if (file.isDirectory()) {
        FileUtils.deleteDirectory(file);
      }
      else {
        file.delete();
      }
    }

    return file.getAbsolutePath();
  }
}
