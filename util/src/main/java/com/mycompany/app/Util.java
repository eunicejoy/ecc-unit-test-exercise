package com.mycompany.app;

import java.util.*;
/**
 * Hello world!
 *
 */
public class Util
{
    public static Model model = new Model();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void addNewRow(){
      if(model.tableIsPrinted){
        int idx = 0;
        System.out.println();
        int row = 0;
        int ctr = 0;

        // got the data from text File
        if(model.y == 0){
          row = model.linesCount;
        } else{
          row = model.y;
        }

        model.isModified = true;

        for(int i = 0;i < row ; i++){
          model.arrayList.add(model.generateRandomCharacters() + ":" +model.generateRandomCharacters());
        }

        model.indexList.clear();

        for(String cell : model.arrayList){
            System.out.print(" " + cell +", \t");
            model.indexList.add(ctr + "," + idx);
            idx++;
            if((idx % row ) == 0){
                System.out.println();
                idx = 0;
                ctr++;
            }
          }
      }else{
        System.out.println("Print table first.");
      }
    }

    public static void sortTable(){

      if(model.tableIsPrinted){
        int idx = 0;
        int row = 0;
        int ctr = 0;
        System.out.println();


        if(model.y == 0){
          row = model.linesCount;
        } else{
          row = model.y;
        }

        Collections.sort(model.arrayList);
        model.indexList.clear();

          for(String cell : model.arrayList){

             System.out.print(" " + cell +", \t");
             model.indexList.add(ctr + "," + idx);
             idx++;

             if((idx % row ) == 0){
                 System.out.println();
                 idx = 0;
                  ctr++;
             }
         }
      }else{
        System.out.println("Print table first.");
      }
    }
}
