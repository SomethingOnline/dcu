import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

// Q2 
interface Weather {
    int getMinTemp();
    int getMaxTemp();
}

interface SunnyWeather extends Weather {
    int getMinutesOfSunshine(); // how many minutes of sun we got in the day
}

interface RainyWeather extends Weather {
    double getAmount(); // amount of rainfall in the day, measured in mm
    boolean hasPersistence(); // whether rainfall will persist all day
}

interface SunshowerWeather extends SunnyWeather, RainyWeather { }

public class DailyWeather implements Weather{
    private int minTemp;
    private int maxTemp;

    public DailyWeather(int minTemp, int maxTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    static List<Weather> getStayIndoors(List days){
        List selected = new ArrayList<>();
        for (Weather day: days){
            if (day instanceof RainyWeather){
                if (day.hasPersistence()){
                    selected.add(day);
                }
            }
        }
        return selected;
    }
    
    static List<Weather> getSingleWeatherDays(List days){
        List selected = new ArrayList<>();
        for (Weather day: days){
            if ((day instanceof RainyWeather && !day instanceof SunnyWeather)|| (day instanceof SunnyWeather && !day instanceof RainyWeather)){
            selected.add(day);
            }
        }
        return selected;
    }

    // static List<Weather> orderByTemperatureVariance(List days){
    //     List listByTempVariance = new ArrayList<>();
    //     for (Weather day: days){

    //     }

    // }
    // private static int calcVariance(Weather weather){
    //     return weather.getMaxTemp() - weather.getMinTemp();
    // }
}

public class SunShower extends DailyWeather implements SunshowerWeather{
    private int minutesOfSunshine;
    private double amount;
    private boolean persistence;

    public SunShower(int minTemp, int maxTemp, int minutesOfSunshine, double amount, boolean persistence){
        super(minTemp, maxTemp);
        this.minutesOfSunshine = minutesOfSunshine;
        this.amount = amount;
        this.persistence = persistence;
    }

    public int getMinutesOfSunshine(){
        return minutesOfSunshine;
    }
    public double getAmount(){
        return amount;
    }
    public boolean hasPersistence(){
        return persistence;
    }
}
class E23N2 {
    public static void main(String args[]) {
        
    }
}