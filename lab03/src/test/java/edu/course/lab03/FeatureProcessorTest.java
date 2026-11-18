package edu.course.lab03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeatureProcessorTest {

    @Test
    void testMinMaxNormalization() {
        double[] input = {0.0, 5.0, 10.0};
        NormalizationStrategy strategy = new MinMaxNormalization();
        double[] result = strategy.normalize(input);
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 0.001);
    }

    @Test
    void testMeanCenteringNormalization() {
        double[] input = {10.0, 20.0, 30.0};
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        double[] result = strategy.normalize(input);
        assertArrayEquals(new double[]{-10.0, 0.0, 10.0}, result, 0.001);
    }

    @Test
    void testFeatureProcessorStrategyReplacement() {
        double[] input = {1.0, 2.0, 3.0};
        
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        double[] result1 = processor.process(input);
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result1, 0.001);
        
        processor = new FeatureProcessor(new MeanCenteringNormalization());
        double[] result2 = processor.process(input);
        assertArrayEquals(new double[]{-1.0, 0.0, 1.0}, result2, 0.001);
    }
    
    @Test
    void testOriginalArrayNotModified() {
        double[] input = {0.0, 5.0, 10.0};
        double[] originalCopy = input.clone();
        
        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        processor.process(input);
        
        assertArrayEquals(originalCopy, input, 0.001);
    }
}