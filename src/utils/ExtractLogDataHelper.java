package utils;

import model.Request;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractLogDataHelper {

    /**
     * The getUnsuccessfulRequestPagesList method returns a List of Request Objects
     * with requests that have been successful (when status code > 200 and status code <300)
     *
     * @author  Anastasios Kentominas
     * @version 1.0
     * @since   2020-09-12
     */
    public static ArrayList<Request> getRequestPagesList() {

        ArrayList<Request> requests = new ArrayList<>();
        ArrayList<String[]> requestData = ExtractLogDataHelper.getArrayListData();

        for (int i = 0; i < requestData.size(); i++) {
            if (requestData.get(i).length == 8) {
                requests.add(new Request(requestData.get(i)[0],
                        requestData.get(i)[1],
                        requestData.get(i)[2],
                        requestData.get(i)[3],
                        requestData.get(i)[4],
                        requestData.get(i)[5],
                        requestData.get(i)[6],
                        requestData.get(i)[7]));
            } else {
                ////////////////**************malformed data*****************//////////////
                //System.out.println("MALFORMED: " + Arrays.toString(requestData.get(i)));
            }
        }
        return requests;
    }

    /**
     * The getUnsuccessfulRequestPagesList method returns a List of Request Objects
     * with requests that have been unsuccessful (when status code < 200 or status code >=300)
     *
     * @author  Anastasios Kentominas
     * @version 1.0
     * @since   2020-09-12
     */
    public static ArrayList<Request> getUnsuccessfulRequestPagesList() {

        ArrayList<Request> requests = new ArrayList<>();
        ArrayList<String[]> requestData = ExtractLogDataHelper.getArrayListData();

        for (int i = 0; i < requestData.size(); i++) {
            if (requestData.get(i).length == 8 && (Integer.parseInt(requestData.get(i)[6]) < 200 || Integer.parseInt(requestData.get(i)[6]) >=300)) {
                requests.add(new Request(requestData.get(i)[0],
                        requestData.get(i)[1],
                        requestData.get(i)[2],
                        requestData.get(i)[3],
                        requestData.get(i)[4],
                        requestData.get(i)[5],
                        requestData.get(i)[6],
                        requestData.get(i)[7]));
            }
        }
        return requests;
    }

    /**
     * The getArrayListData method reads from the List loaded from the log file
     * and converting them to structured List of Arrays of Strings that can be accessed
     * and manipulated
     *
     * @author  Anastasios Kentominas
     * @version 1.0
     * @since   2020-09-12
     */
    public static ArrayList<String[]> getArrayListData() {

                ArrayList<String[]> finale = new ArrayList<>();
        try {
            List list = ExtractLogDataHelper.getListFromSource();



            for (int i = 0; i < list.size(); i++) {
                String[] removedNull = Arrays.stream(list.get(i).toString().replaceAll("[\\[\\]\\-\"]","").split("\\s"))
                        .filter(value ->
                                value != null && value.length() > 0
                        )
                        .toArray(size -> new String[size]);

                finale.add(removedNull);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return finale;
    }


    /**
     * The getListFromSource method reads the logs from /log path
     * and loading them to a List as Strings
     *
     * @author  Anastasios Kentominas
     * @version 1.0
     * @since   2020-09-12
     */
    public static List getListFromSource() throws IOException {

        List<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(getFileFromResourceAsStream("log/access_log_Aug95")));

            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return result;
    }

    public static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = cl.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

}
