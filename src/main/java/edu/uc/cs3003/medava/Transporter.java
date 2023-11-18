package edu.uc.cs3003.medava;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Transporter {

    // constructor is used to determine or specify the paratameters 

    public Transporter(String transporterName, double lowTemp, double highTemp) {
        mTransporterName = transporterName;
        mLowTemperature = lowTemp;
        mHighTemperature = highTemp;
    }

    // teh following function is the meduim used to transport
    // the medicine
    private String mTransporterName;
    public String getTransporterName(){
        return mTransporterName;
    }

    // the following is a list that only support instances of Medicine 
    // class

    private List<Shippable> goods;
    
    // instance initializer, since List is an abstact class
    // therefore ArrayList subclass is used, it will
    // support the same operations as List
    {
        goods = new ArrayList<Shippable>();
    }

    // simulates the shipping of the goods using the transporter
    public void ship(){
        // Do some shipping!
    }

    // since the pharmacy will only choose a shipper who is able to 
    // control the temperature and keep it safe and compatiable with
    // the safe temperatures of the medicine
    // the following parameters are to track the temperature 
    private double mLowTemperature, mHighTemperature;
    


    // this version of load and unload useses reflection 
    /*
    // used to add the an instance medicine to goods
    // if the medicine instance is compatiable with the transporter
    public boolean load(Object itemToLoad) {
        try {
            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
                    Double.class, Double.class);
            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
            if (resultOfMethodCall) {
                goods.add(itemToLoad);
            }
            return resultOfMethodCall;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            return false;
        }
    }


    // unload the cargo 
    public Object unload() {
        return goods.remove(0);
    }
    */

    // this version of load and unload useses interfaces-- shippable 
    // interface
    public Shippable unload() {
        return goods.remove(0);
    }

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            return goods.add(itemToLoad);
        }
        return false;
    }



    // check wether the transporter has cargo
    public boolean isEmpty() {
        return goods.isEmpty();
    }






}
