package org.familysearch.spark.java;

import org.apache.spark.api.java.JavaSparkContext;
import org.familysearch.spark.java.util.SparkUtil;

import java.io.IOException;

/**
 * Class created by dalehulse on 4/5/17.
 */
public class BibleWordCountFromCommandLine {
  /**
   * Class created by dalehulse on 4/5/17.
   *
   * Run the main() method using spark-submit
   *
   * Task 6: Learn how to run a Spark application from the command line using spark-submit
   *
   *   You will need to download the binaries for spark to run the spark-submit command
   *    1) Go to http://spark.apache.org/downloads.html
   *    2) Choose the version of spark that matches the spark version of this repo (see parent pom.xml spark.version)
   *    3) Choose the Pre-Built version for the most current version of Hadoop
   *    4) Click the download link
   *    5) Extract the binaries from the tarball
   *      tar -xzvf spark-2.1.0-bin-hadoop2.7.tgz
   *
   *   In BibleWordCount and BibleWordCount2, the SparkContext was configured with a local master by invoking setMaster("local[*]") (where [*]
   *   defaults the number of threads to the number of CPU cores). For this Spark app the master has not been configured. The reason for
   *   this is to make the Spark application more flexible for the environment it is going to run in. The master can be decided when running
   *   spark-submit from the command line with the --master option.
   *
   *   This spark application will use the code you implemented in BibleWordCount2.run(), so make sure you have completed BibleWordCount2
   *   before doing this task.
   *
   *   Note that this application expects three program arguments: the input directory, the output directory, and the stop-words directory. You can pass application arguments
   *   using spark-submit by specifying them after the jar file.
   *     spark-submit [options....] app.jar /path/to/input/ /path/to/output /path/to/input/stop-words
   *
   *   Note: that input directory can be found from this project at input/bible-lines. The stop words directory can be found at input/stop-words
   *
   *   For this task, build the jar for this project and use that jar with spark-submit to run the Spark application locally.
   *     cd $PROJECT_DIR
   *     mvn clean install
   *     $SPARK_HOME/bin/spark-submit [options....] spark-java/target/spark-java.jar /path/to/input/ /path/to/output /path/to/input/stop-words
   *
   *   See http://spark.apache.org/docs/latest/submitting-applications.html
   *       http://spark.apache.org/docs/latest/submitting-applications.html#master-urls
   *
   *   It is useful to become familiar with the spark-submit script because it is used to run Spark applications on a cluster.
   *
   *   todo copy your spark-submit command here
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 3) {
      System.err.println("Application requires three arguments. 0: input directory, 1: output directory, 2: stop words directory");
      System.exit(1);
    }

    final boolean setMaster = false;
    final JavaSparkContext sc = SparkUtil.createSparkContext(BibleWordCountFromCommandLine.class.getName(), setMaster);
    final String input = args[0];
    final String output = args[1];
    final String stopWordsIn = args[2];

    System.out.println("Reading base input from " + input);
    System.out.println("Reading stop words input from " + stopWordsIn);
    System.out.println("Writing result to " + output);
    BibleWordCount2.run(sc, input, stopWordsIn, output);
    sc.stop();
  }
}
