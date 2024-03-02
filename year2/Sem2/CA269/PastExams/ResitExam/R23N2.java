import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

interface Day {
    int getAvgTemp();
}

interface SunnyDay extends Day {
    int getSunshine(); // minutes of sunshine
}

interface RainyDay extends Day {
    double getRainfall(); // amount of rainfall in mm
    boolean isSporadic(); // if rain will continue all day
}

interface RainbowDay extends SunnyDay, RainyDay { }

class PicnicHoliday implements Day{
    private String accessories;
    int avgTemp;

    public PicnicHoliday(String accessories, int avgTemp){
        this.accessories = accessories;
        this.avgTemp = avgTemp;
    }
    public int getAvgTemp(){
        return this.avgTemp;
    }
    public void setAvgTemp(int avgTemp){
        this.avgTemp = avgTemp;
    }

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

    static List<Day> prioritiseDays(List <Day> days){
        Collections.sort(days, (a, b) -> compare(a, b));
        return days;
    }
    static int compare(Day a, Day b){
        return b.getAvgTemp() - a.getAvgTemp();
    }
}

class IndoorHoliday extends PicnicHoliday implements RainbowDay{
    private int sunshine;
    private double rainfall;
    private boolean sporadicRainfall;
    public IndoorHoliday(int avgTemp, int sunshine, double rainfall, boolean sporadicRainfall, String accessories){
        super(accessories, avgTemp);
        this.sunshine = sunshine;
        this.rainfall = rainfall;
        this.sporadicRainfall = sporadicRainfall;
    }
    public int getSunshine(){
        return this.sunshine;
    }
    public double getRainfall(){
        return this.rainfall;
    }
    public boolean isSporadic(){
        return this.sporadicRainfall;
    }
}