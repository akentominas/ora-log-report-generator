package utils;

import model.Request;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractLogDataHelper {

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



    public static List getListFromSource() throws IOException {

    String filename = "src\\log\\access_log_Aug95";

        List<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(filename));

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
}
