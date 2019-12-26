package com.abc.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/26 17:21
 */
public class Test1 {
  public static void main(String[] args) throws IOException{
    readText(new FileReader(".hidden"),reader->{
      System.out.println(reader.readLine());
    });
  }
  public static void readText(FileReader targetFile,BufferReaderProcessor processor){
    try(
        BufferedReader reader = new BufferedReader(targetFile)
        ){
      processor.process(reader);
        String result = reader.readLine();
    }catch (IOException exception){
      exception.printStackTrace();
    }
  }
}
