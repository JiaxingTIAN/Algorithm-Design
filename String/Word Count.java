import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}

/* Java program to demonstrate how to implement static and non-static
   classes in a java program. */
class OuterClass{
   private static String msg = "GeeksForGeeks";
    
   // Static nested class
   public static class NestedStaticClass{
      
       // Only static members of Outer class is directly accessible in nested 
       // static class 
       public void printMessage() {
 
         // Try making 'message' a non-static variable, there will be 
         // compiler error  
         System.out.println("Message from nested static class: " + msg); 
       }
    }
    
    // non-static nested class - also called Inner class
    public class InnerClass{
        
       // Both static and non-static members of Outer class are accessible in 
       // this Inner class
       public void display(){
          System.out.println("Message from non-static nested class: "+ msg);
       }
    }
} 
class Main
{
    // How to create instance of static and non static nested class?
    public static void main(String args[]){
        
       // create instance of nested Static class
       OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        
       // call non static method of nested static class
       printer.printMessage();   
  
       // In order to create instance of Inner class we need an Outer class 
       // instance. Let us create Outer class instance for creating 
       // non-static nested class
       OuterClass outer = new OuterClass();        
       OuterClass.InnerClass inner  = outer.new InnerClass();
        
       // calling non-static method of Inner class
       inner.display();
        
       // we can also combine above steps in one step to create instance of 
       // Inner class
       OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();
        
       // similarly we can now call Inner class method
       innerObject.display();
    }
}
Output:
