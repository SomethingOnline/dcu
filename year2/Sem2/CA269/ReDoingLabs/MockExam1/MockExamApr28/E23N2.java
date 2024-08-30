import java.util.*;

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


class DailyWeather implements Weather{
	private int minTemp;
	private int maxTemp;


	
	public static List<Weather> getStayIndoorDays(List<Weather> weatherList){
		List<Weather> stayIndoorDays = new ArrayList<>();
		for (Weather day : weatherList){
			if (day instanceof RainyWeather){
				RainyWeather rainyWeather = (RainyWeather) day;
				if(rainyWeather.hasPersistence()){
					stayIndoorDays.add(day);
				}
			}
		}
		return stayIndoorDays;
	}

	public static List<Weather> getSingleDays(List<Weather> weatherList){
		List<Weather> singleDays = new ArrayList<>();
		for (Weather day : weatherList){
			if (day instanceof SunnyWeather && !(day instanceof RainyWeather)){
				singleDays.add(day);
			} else if(day instanceof RainyWeather && !(day instanceof SunnyWeather)){
				singleDays.add(day);
			} else{
				;
			}
		}
		return singleDays;

	}
	public static List<Weather> orderByTemperatureVariance(List<Weather> weatherList){
		List<Weather> sortedWeatherList = new ArrayList<>(weatherList);
		Collections.sort(sortedWeatherList, new Comparator<Weather>(){
			@Override
			public int compare(Weather day1, Weather day2){
				int variance1 = day1.getMaxTemp() - day1.getMinTemp();
				int variance2 = day2.getMaxTemp() - day2.getMinTemp();
				return Integer.compare(variance1, variance2);
			}
		});
		return sortedWeatherList
		
	}

	public int getMinTemp(){
		return minTemp;
	}
	public int getMaxTemp(){
		return maxTemp;
	}
	public DailyWeather(int minTemp, int maxTemp){
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}
}

class SunshowerDay extends DailyWeather implements SunshowerWeather{
	private int minutesOfSunshine;
	private double amount;
	private boolean persistence;

	int getMinutesOfSunshine(){
		return minutesOfSunshine;
	}
	double getAmount(){
		return amount;
	}
	boolean hasPersistence(){
		return persistence;
	}
	SunshowerDay(int minTemp, int maxTemp, int minutesOfSunshine, double amount, boolean persistence){
		super(minTemp, maxTemp);
		this.minutesOfSunshine = minutesOfSunshine;
		this.amount = amount;
		this.persistence = persistence;
	}
}