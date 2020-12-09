package business;

import model.Request;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MetricsTest {

    @Test
    public void printSuccessfulRequestsTest() {

        List<Request> requests = new ArrayList<>();

        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "200", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "201", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "200", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "200", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "200", "888"));
        requests.add(new Request("ad03032.compuserve.com", "31/Aug/1995:23:37:25", "0400", "GET", "/shuttle/countdown", "HTTP/1.0", "302", "888"));

        double actualValue = Metrics.printSuccessfulRequests(requests);

        assertEquals(38.46153846153846, actualValue, 0.0);


    }

}
