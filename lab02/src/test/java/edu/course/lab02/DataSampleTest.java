package edu.course.lab02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DataSampleTest {
   @Test 
    void testDataSample(){
        double[] myFeatures = {1.0 ,2.0};
        DataSample sample = new DataSample("id-123", "Кот", myFeatures);
        assertEquals("id-123",sample.getId());
        assertEquals("Кот",sample.getLabel());
    }
     @Test 
    void testDataSampleStatus(){
        DataSample sample = new DataSample("id1", "Кот", new double[]{1.0});
        sample.changeStatus(SampleStatus.PROCESSED);
        assertTrue(sample.isReady());
    }
    @Test 
    void testDataSampleDefensiveCopy(){
        double[] myData = {5.0, 10.0};
        DataSample sample = new DataSample("id1", "Кот", myData);
        myData[0] = 999.0;
        assertEquals(5.0, sample.getFeatures()[0], 1e-9);
    }
    @Test 
    void testDataSampleAverageFeature(){
        DataSample sample = new DataSample("id1", "Кот", new double[]{1.0, 2.0, 3.0});
        assertEquals(2.0, sample.averageFeature(), 1e-9);
    }
}
