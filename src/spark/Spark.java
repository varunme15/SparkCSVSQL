package spark;

import model.Record;

import org.apache.hadoop.hive.ql.parse.HiveParser_FromClauseParser.tableAlias_return;
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.api.java.JavaSQLContext;
import org.apache.spark.sql.api.java.JavaSchemaRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.api.java.Row;
import org.apache.spark.rdd.RDD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import  java.lang.Long.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Spark {
	
	public static void main(String[] args) throws IOException{
	SparkConf conf = new SparkConf().setAppName("274Spark").setMaster("local");
	JavaSparkContext sc = new JavaSparkContext(conf);
	JavaSQLContext sqlContext = new JavaSQLContext(sc);
	//JavaRDD<Record> sd;
	JavaRDD<Record> rdd_records = sc.textFile("/home/varun/Desktop/CMPE274/input.csv").map(
			
		new Function<String, Record>() {
			
	      public Record call(String line) throws Exception {
	    	 System.out.println("!!!!!!!!!!!"+line);
	    	 //final String heading=line.first().toString();
	    	 // Here you can use JSON
	         // Gson gson = new Gson();
	         // gson.fromJson(line, Record.class);
	    	 
	         String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
	         
	         System.out.println("||||||||||||||||||||||||||||||"+fields[0]+"  / " +fields[2]+" /  "+fields[5]+" / "+fields[6]+ "  /  " +Long.parseLong(fields[8])+" /  "+Float.valueOf(fields[9].substring(1).trim()).floatValue()+"  / "+Float.valueOf(fields[10].substring(1).trim()).floatValue()+  "/"   +Float.valueOf(fields[11].substring(1).trim()).floatValue());
	         Record sd = new Record(fields[0],fields[2],fields[5],fields[6],Long.parseLong(fields[8]),Long.parseLong(fields[9].substring(1,(fields[9].length()-3))),Long.parseLong(fields[10].substring(1,(fields[10].length()-3))),Long.parseLong(fields[11].substring(1,(fields[11].length()-3))));
	         System.out.println(sd);
	         return sd;
	      }
	});
	JavaSchemaRDD schemaPeople = sqlContext.applySchema(rdd_records,Record.class);
	schemaPeople.registerTempTable("DRGrdd");
	schemaPeople.printSchema();
    
	JavaSchemaRDD res = sqlContext.sql("select DRGDefinition,sum(averageCoveredCharges) from DRGrdd group by DRGDefinition");
	System.out.println("!!!!!!!!!!!!"+res.toString());
	List<String> names = res.map(new Function<Row, String>() {
		  public String call(Row record) throws IOException {
			  //record.toString();
			  System.out.println(""+record.getString(0)+record.getLong(1));
			  
			  return record.getString(0)+","+record.getLong(1);
		  }
		}).collect();
	
	final FileWriter writer = new FileWriter("/home/varun/zipCodeDischarge.csv");
    writer.append("ZipCode");
    writer.append(',');
    writer.append("Discharge");
    writer.append('\n');
    for(int i=0;i<names.size();i++){
    	writer.append(names.get(i));
    	writer.append('\n');
    }
	writer.flush();
	writer.close();
	System.out.println(names.size());
	}
	
	
}
