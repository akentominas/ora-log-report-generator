package business;

import model.Request;
import utils.MetricsHelper;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Metrics {

    /**
     * The printTenMostFrequentRequests method calculates the number of the most frequent requested end points
     * and printing the page and the number occurred
     *
     * @author  Anastasios Kentominas
     * @param requests is the list of all requests made
     * @param k is the number of the top most frequently requested pages that we want to print
     * @version 1.0
     * @since   2020-09-12
     */
    public static void printTenMostFrequentRequests(List<Request> requests, int k) {

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (int i = 0; i < requests.size(); i++) {
            mp.put(requests.get(i).getAddress(), mp.getOrDefault(requests.get(i).getAddress(), 0) + 1);
        }

        List<Map.Entry<String, Integer> > list =
                new ArrayList<>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i=0; i<k; i++)
            System.out.println("PAGE["+ (i+1) +"]: " + list.get(i).getKey() + " WAS REQUESTED: " + list.get(i).getValue() + " TIMES.");

    }

    /**
     * The printSuccessfulRequests method calculates percentage of successful
     * requests made
     *
     * @author  Anastasios Kentominas
     * @param requests is the list of all requests made
     * @version 1.0
     * @since   2020-09-12
     */
    public static double printSuccessfulRequests(List<Request> requests) {

        DecimalFormat df2 = new DecimalFormat("#.##");

        int totalRequests = requests.size();
        long successfulRequests = 0;

        for (int i = 0; i < requests.size(); i++) {
            successfulRequests = requests.stream().filter(
                    value -> Integer.parseInt(value.getStatus()) >=200 && Integer.parseInt(value.getStatus()) < 300
            ).count();
        }

        double successfulPercentage= MetricsHelper.calculatePercentage(successfulRequests, totalRequests);

        System.out.println("Percentage of successful requests: " + df2.format(successfulPercentage) + "%, \n " +
                                "with total requests made: " + totalRequests + " \n " +
                                "and number of successful requests: " + successfulRequests);

        return successfulPercentage;

    }

    /**
     * The printUnsuccessfulRequests method calculates percentage of unsuccessful
     * requests made
     *
     * @author  Anastasios Kentominas
     * @param requests is the list of all requests made
     * @version 1.0
     * @since   2020-09-12
     */
    public static void printUnsuccessfulRequests(List<Request> requests) {

        DecimalFormat df2 = new DecimalFormat("#.##");

        int totalRequests = requests.size();
        long successfulRequests = 0;

        for (int i = 0; i < requests.size(); i++) {
            successfulRequests = requests.stream().filter(
                    value -> Integer.parseInt(value.getStatus()) <200 || Integer.parseInt(value.getStatus()) >= 300
            ).count();
        }

        double successfulPercentage= MetricsHelper.calculatePercentage(successfulRequests, totalRequests);

        System.out.println("Percentage of unsuccessful requests: " + df2.format(successfulPercentage) + "%, \n " +
                "with total requests made: " + totalRequests + " \n " +
                "and number of unsuccessful requests: " + successfulRequests);

    }

    /**
     * The printTopTenUnsuccessfulRequests method calculates the number of the most frequently
     * unsuccessful requested pages made
     *
     * @author  Anastasios Kentominas
     * @param requests is the list of all requests made
     * @param k is the number of the top most frequently requested pages that we want to print
     * @version 1.0
     * @since   2020-09-12
     */
    public static void printTopTenUnsuccessfulRequests(List<Request> requests, int k) {

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (int i = 0; i < requests.size(); i++) {
            mp.put(requests.get(i).getAddress(), mp.getOrDefault(requests.get(i).getAddress(), 0) + 1);
        }

        List<Map.Entry<String, Integer> > list =
                new ArrayList<>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i=0; i<k; i++)
            System.out.println("PAGE["+ (i+1) +"]: " + list.get(i).getKey() + " WAS REQUESTED: " + list.get(i).getValue() + " TIMES.");
    }

    /**
     * The printTenMostRequestedPages method calculates the number of the most frequently
     * requested pages made
     *
     * @author  Anastasios Kentominas
     * @param requests is the list of all requests made
     * @param k is the number of the top most frequently requested pages that we want to print
     * @version 1.0
     * @since   2020-09-12
     */
    public static void printTenMostRequestedPages(List<Request> requests, int k) {

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (int i = 0; i < requests.size(); i++) {
            mp.put(requests.get(i).getEndPoint(), mp.getOrDefault(requests.get(i).getEndPoint(), 0) + 1);
        }

        List<Map.Entry<String, Integer> > list =
                new ArrayList<>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i=0; i<k; i++)
            System.out.println("ENDPOINT["+ (i+1) +"]: " + list.get(i).getKey() + "\tWAS REQUESTED: " + list.get(i).getValue() + " TIMES.");

    }

}
