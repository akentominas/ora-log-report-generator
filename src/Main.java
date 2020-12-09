import business.Metrics;
import utils.ExtractLogDataHelper;
import utils.MetricsHelper;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;


public class Main {
    public static void main(String[] args) {
        System.out.println("---THIS SOFTWARE WILL PROCESS LOG FILES AND GENERATE STATISTICAL REPORTS FOR IT---\n\n");

        int input = 0;

        Scanner console = new Scanner(System.in);

        while (input != 6) {

        System.out.println("=================================================================\n\n");
        System.out.print("PLEASE CHOOSE ONE OF THE FOLLOWING OPTIONS FROM THE LIST AND PRESS 'ENTER' \n");
        System.out.print("PRESS '1' TO GENERATE THE TOP 10 REQUESTED PAGES AND THE NUMBER OF REQUESTS MADE FOR EACH\n");
        System.out.print("PRESS '2' TO GENERATE THE PERCENTAGE OF SUCCESSFUL REQUESTS (STATUS CODE: 200-300)\n");
        System.out.print("PRESS '3' TO GENERATE THE PERCENTAGE OF UNSUCCESSFUL REQUESTS (200 < STATUS CODE > 300)\n");
        System.out.print("PRESS '4' TO GENERATE THE TOP 10 UNSUCCESSFUL REQUESTED PAGES AND THE NUMBER OF REQUESTS MADE FOR EACH\n");
        System.out.print("PRESS '5' TO GENERATE THE TOP 10 HOSTS, MAKING THE MOST REQUESTS\n");
        System.out.println("PRESS '6' TO EXIT THE PROGRAM\n\n");
        System.out.println("SELECT: ");

            input = console.nextInt();

            switch (input)
            {
                case 1 :
                    System.out.println("=================================================================");
                    Metrics.printTenMostRequestedPages(ExtractLogDataHelper.getRequestPagesList(), 10);
                    break;

                case 2 :
                    System.out.println("=================================================================");
                    Metrics.printSuccessfulRequests(ExtractLogDataHelper.getRequestPagesList());
                    break;

                case 3 :
                    System.out.println("=================================================================");
                    Metrics.printUnsuccessfulRequests(ExtractLogDataHelper.getRequestPagesList());
                    break;

                case 4 :
                    System.out.println("=================================================================");
                    Metrics.printTopTenUnsuccessfulRequests(ExtractLogDataHelper.getUnsuccessfulRequestPagesList(), 10);
                    break;

                case 5 :
                    System.out.println("=================================================================");
                    Metrics.printTenMostFrequentRequests(ExtractLogDataHelper.getRequestPagesList(), 10);
                    break;

                default :
                    System.out.println("\n\nEXIT...");
            }
        }
    }

}
