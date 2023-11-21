package edu.uc.cs3003.medava;

public abstract class Medicine implements Shippable {

    public Medicine(String medicineName){
        mMedicineName = medicineName;
        
    }
    private String mMedicineName;

    // getter: allows certain entities to see a value that has a private access modifier
    public String getMedicineName(){
        return mMedicineName;
    }

    // these two methods declarations will be overridden in subclasses, using virtual methods feature on java
    public double minimumTemperature(){
        return 0.0;
    }
    public double maximumTemperature(){
        return 100.0;
    }


    // this function to determine the acceptable range of temperatures for medicines 
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        if (this.minimumTemperature() <= lowTemperature && highTemperature <= this.maximumTemperature()){
            return true;
        }
        return false;
    }


    public abstract MedicineSchedule getSchedule();
    
    
}
