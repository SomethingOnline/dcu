import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Interface for a day with average temperature
interface Day {
    int getAvgTemp();
}

// Interface for a sunny day, extends Day and adds sunshine duration
interface SunnyDay extends Day {
    int getSunshine(); // minutes of sunshine
}

// Interface for a rainy day, extends Day and adds rainfall amount and sporadic rain indicator
interface RainyDay extends Day {
    double getRainfall(); // amount of rainfall in mm
    boolean isSporadic(); // if rain will continue all day
}

// Interface for a day that is both sunny and rainy, hence a potential rainbow day
interface RainbowDay extends SunnyDay, RainyDay { }

// Class for a picnic holiday, implements Day
class PicnicHoliday implements Day{
    private String accessories;
    int avgTemp;

    // Constructor
    public PicnicHoliday(String accessories, int avgTemp){
        this.accessories = accessories;
        this.avgTemp = avgTemp;
    }

    // Getter for average temperature
    public int getAvgTemp(){
        return this.avgTemp;
    }

    // Setter for average temperature
    public void setAvgTemp(int avgTemp){
        this.avgTemp = avgTemp;
    }

    // Method to get outdoor days from a list of days
    public static List<Day> getOutdoorDays(List<Day> days){
        List<Day> outdoorDays = new ArrayList<>();
        for (Day day: days){
            if (day instanceof SunnyDay){
                if (day instanceof RainyDay){
                    RainyDay rainyDay = (RainyDay) day;
                    if (rainyDay.isSporadic() && rainyDay.getRainfall() < 2){
                        outdoorDays.add(day);
                    }
                } else {
                    outdoorDays.add(day);
                }
            }
        }
        return outdoorDays;
    }

    // Method to prioritise days based on average temperature
    static List<Day> prioritiseDays(List <Day> days){
        Collections.sort(days, (a, b) -> compare(a, b));
        return days;
    }

    // Comparison method for sorting
    static int compare(Day a, Day b){
        return b.getAvgTemp() - a.getAvgTemp();
    }
}

// Class for an indoor holiday, extends PicnicHoliday and implements RainbowDay
class IndoorHoliday extends PicnicHoliday implements RainbowDay{
    private int sunshine;
    private double rainfall;
    private boolean sporadicRainfall;

    // Constructor
    public IndoorHoliday(int avgTemp, int sunshine, double rainfall, boolean sporadicRainfall, String accessories){
        super(accessories, avgTemp);
        this.sunshine = sunshine;
        this.rainfall = rainfall;
        this.sporadicRainfall = sporadicRainfall;
    }

    // Getter for sunshine duration
    public int getSunshine(){
        return this.sunshine;
    }

    // Getter for rainfall amount
    public double getRainfall(){
        return this.rainfall;
    }

    // Getter for sporadic rainfall indicator
    public boolean isSporadic(){
        return this.sporadicRainfall;
    }
}