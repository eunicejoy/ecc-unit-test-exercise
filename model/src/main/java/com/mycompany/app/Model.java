package com.mycompany.app;

import org.apache.commons.collections4.*;
import org.apache.commons.io.*;

import java.util.*;
import java.io.*;
/**
 * Hello world!
 *
 */
public class Model
{
    public static int x = 0;
    public static int y = 0;
    public static int linesCount = 0;
    public static String[][] arrays;
    public static ArrayStack<String> arrayList = new ArrayStack<String>();
    public static boolean isModified;
    public static boolean tableIsPrinted;
    public static ArrayStack<String> indexList = new ArrayStack<String>();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void print(){

    int idx = 0;
    int ctr = 0;

    String cell = "";
    String lines = "";

    System.out.println("");
    System.out.println("From text file\t[1]");
    System.out.print("Random\t\t[2]: ");
    Scanner userInput = new Scanner(System.in);

    int userChoice = userInput.nextInt();

    if(userChoice == 1){
      isModified = true;
      try{
        if(tableIsPrinted){
          System.out.println("");
          for(String value : arrayList){
              System.out.print(" " + value + ", \t");
              idx++;
              if((idx % linesCount) == 0){
                  System.out.println();
                  idx = 0;
                  ctr++;
              }
          }
        } else{
          arrayList.clear();
          indexList.clear();
          File file = new File("C:\\Users\\Eunice\\Java\\arrays.txt");
          Scanner read = new Scanner(file);

          while(read.hasNextLine()){
            String line = read.nextLine();
            line = line.substring(0, line.length()-1);
            parseData(line);
            linesCount++;
          }

          System.out.println("");
          int row = 0;

          tableIsPrinted = true;
          // got the data from text File
          if(y == 0){
            row = linesCount;
          } else{
            row = y;
          }

          for(String cellContent : arrayList){

             System.out.print(" " + cellContent +", \t");
             indexList.add(ctr + "," + idx);
             idx++;

             if((idx % row ) == 0){
                 System.out.println();
                 idx = 0;
                 ctr++;
             }
         }
        }


      }catch(FileNotFoundException e){
        System.out.println("Something went wrong.");
      }
    }

    else if(userChoice == 2){
      arrayList.clear();
      indexList.clear();
      //generate random dimensions
      Random randomizer = new Random();

      x = randomizer.nextInt(10) + 1;
      y = randomizer.nextInt(10) + 1;

      arrays = new String[x][y];

      System.out.println("");

      for(int i=0;i<x;i++){
        for(int j=0;j<y;j++) {
            arrays[i][j] = generateRandomCharacters() + ":" + generateRandomCharacters();
            arrayList.add(arrays[i][j]);
        }
      }

      // print table and save index to indexList

      int row = 0;


      // got the data from text File
        if(y == 0){
          row = linesCount;
        } else{
          row = y;
        }

        for(String cellContent : arrayList){

           System.out.print(" " + cellContent +", \t");
           indexList.add(ctr + "," + idx);
           idx++;

           if((idx % row ) == 0){
               System.out.println();
               idx = 0;
               ctr++;
           }
       }

       tableIsPrinted = true;

      } else{
        System.out.println("Invalid input.");
      }
    }

    public static String generateRandomCharacters(){
  //  String characters = "!\"#$%&\'()*+-./0123456789;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    String characters = "abcdefghijklmnopqrstuvwxyz";
    String randomCharacters = "";
    int size = characters.length();

    Random random = new Random();

    for(int i = 1; i<4; i++){

      String character = Character.toString(characters.charAt(random.nextInt(size)));
      randomCharacters += character;
    }

    return randomCharacters;
  }

  public static void parseData(String line){
    Scanner scanLine = new Scanner(line);
    scanLine.useDelimiter(",\t");
    while(scanLine.hasNext()){
      arrayList.add(scanLine.next().trim());
    }
  }

  public static void reset(){
    print();
    isModified = false;
  }
}
