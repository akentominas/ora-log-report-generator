package utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MetricsHelperTest {

    @Test
    public void calculatePercentage() {

        double expectedPercentage = 14.705882352941176;
        double actualPercentage = MetricsHelper.calculatePercentage(10,68);
        assertEquals(expectedPercentage, actualPercentage, 0.0);
    }
}
