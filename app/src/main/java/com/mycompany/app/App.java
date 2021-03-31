package com.mycompany.app;

import java.util.Scanner;
import org.apache.commons.collections4.*;
/**
 * Hello world!
 *
 */

public class App
{
    public static String searchString;
    public static Model model = new Model();
    public static Service service = new Service();
    public static Util util = new Util();

    public static void main( String[] args ){

      int userChoice = 8;

      while(userChoice != 0){

          System.out.println("");

          System.out.print("Print\t\t[1]\nSearch\t\t[2]\nEdit\t\t[3]\nAdd New Row\t[4]\nSort\t\t[5]\nReset\t\t[6]\nExit\t\t[0]: ");

          Scanner scanInput = new Scanner(System.in);
          userChoice = scanInput.nextInt();

          switch(userChoice){
            case 1:
              model.print();
              break;
            case 2:
              searchInput();
              break;
            case 3:
              service.edit();
              break;
            case 4:
              util.addNewRow();
              break;
            case 5:
              util.sortTable();
              break;
            case 6:
              model.reset();
              break;
            case 0:
              break;
            default:
              System.out.println("Invalid input.");

          }
      }
  }

      public static void searchInput(){

        System.out.println("");
        System.out.println("Enter strings to search: ");
        Scanner s = new Scanner(System.in);
        searchString = s.nextLine();

        System.out.println(service.search(searchString));
      }
}
