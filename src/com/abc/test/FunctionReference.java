package com.abc.test;

import java.io.File;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/26 11:02
 */
public class FunctionReference {
  public static void main(String[] args){
    functionReference();
  }
  public static void functionReference(){
    File[] hiddenFiles = new File(".").listFiles(file->file.isHidden());
    for(File file:hiddenFiles){
      System.out.println(file.getName());
    }
  }
}
