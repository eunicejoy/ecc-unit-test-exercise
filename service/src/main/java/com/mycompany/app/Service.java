package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class Service
{
    public static Model model = new Model();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String search(String searchString){
        String result = "";
        if(model.tableIsPrinted){
          boolean notFound = true;
          int counter = 0;
          String indexes = "";


          for(String array: model.arrayList){

            if(array.contains(searchString)){
              String[] part = array.split(":");
              notFound = false;
              indexes = model.indexList.get(model.arrayList.indexOf(array));

              if(part[0].contains(searchString)){
                int n = part[0].length();
                int m = searchString.length();
                int index = part[0].indexOf(searchString);
                int i = index + 1;
                int count = (index >= 0 ) ? 1:0;

                while(index != -1 && i<=(n-m)){
                    index = part[0].substring(i, n).indexOf(searchString);
                    count = (index >= 0) ? count + 1 : count;
                    i = i + index + 1;
                }
                result = "Found " + searchString + " on (" + indexes +") with "+ count +" instances on key field.";
              }

            if(part[1].contains(searchString)){
              int n = part[1].length();
              int m = searchString.length();
              int index = part[1].indexOf(searchString);
              int i = index + 1;
              int count = (index >= 0 ) ? 1:0;

              while(index != -1 && i<=(n-m)){
                  index = part[1].substring(i, n).indexOf(searchString);
                  count = (index >= 0) ? count + 1 : count;
                  i = i + index + 1;
              }

              result = "Found " + searchString + " on (" + indexes +") with "+ count +" instances on value field.";
            }
            }
          }

          System.out.println("");

          if(notFound == true){
            result = "String(s) not found.";
          }
        } else{
          result = "Print table first.";
        }

        return result;
    }

    public static void edit(){

      if(model.tableIsPrinted){
        int indexX = 0;
        int indexY = 0;
        int idx = 0;
        int ctr = 0;
        int i = 0;

        String editIndex = "";
        boolean indexNotFound = false;

        System.out.println("");
        System.out.println("Enter index you want to edit");
        System.out.print("x:");
        Scanner scanX = new Scanner(System.in);
        indexX = scanX.nextInt();
        System.out.print("y:");
        Scanner scanY = new Scanner(System.in);
        indexY = scanY.nextInt();
        editIndex = indexX +","+indexY;

          if(model.indexList.indexOf(editIndex) < 0){
            System.out.println("Index not found.");
          } else{
          for(String indexes : model.indexList){
            if(indexes.equals(editIndex)){
              i = model.indexList.indexOf(editIndex);
            }
          }

          System.out.println("Enter new characters: ");
          Scanner scanNewChars = new Scanner(System.in);
          String newChars = scanNewChars.nextLine();

          model.arrayList.set(i, newChars);

          int row = 0;

          // got the data from text File
          if(model.y == 0){
            row = model.linesCount;
          } else{
            row = model.y;
          }

          System.out.println("");
          for(String cellContent : model.arrayList){

             System.out.print(" " + cellContent +", \t");
             idx++;

             if((idx % row ) == 0){
                 System.out.println();
                 idx = 0;
                 ctr++;
             }
         }
        }
      }else{
        System.out.println("Print table first.");
      }
    }
}
