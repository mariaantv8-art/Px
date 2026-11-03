package edu.course.lab02;

public class DataSample {

    private String id;
    private String label;
    SampleStatus status;
    private final double[] features;
public DataSample(String id, String label, double[] features) {
    if (id == null  || id .isBlank()){
        throw new IllegalArgumentException("id не может быть пустым");
    }
    this.id = id;
    if (label == null || label.isBlank()){
        throw new IllegalArgumentException("label не может быть пустым");
    }
    this.label = label;
    if (features == null || features.length == 0){
        throw new IllegalArgumentException("features не может быть пустым");
    }
    this.features = features.clone();
    this .status = SampleStatus.NEW;
}
public String getId(){
    return this.id;
}
public String getLabel(){
    return this.label;
}
public double[] getFeatures(){
    return this.features.clone();
}
public void changeStatus(SampleStatus newStatus){
    if (newStatus == null){
        throw new IllegalArgumentException("статус не может быть нулевым");
    }
    this.status = newStatus;
}
public boolean isReady(){
    return this.status == SampleStatus.PROCESSED;
}
public double averageFeature(){
    double sum = 0.0;
    for (int i = 0; i < features.length; i++) {
        sum += features[i];
    }
    double average = sum / features.length;
    return average;
}
}