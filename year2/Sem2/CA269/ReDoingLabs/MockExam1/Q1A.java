import java.util.*;

interface Weather{
	String getName();

	int getDuration();

	boolean wasItRainy();

	boolean wasitSunny();

	boolean wasitWindy();

	boolean wasitSnowy();
}

class TypicalDay implements Weather{
	private String name = null;
	private int duration = 0;
	private boolean rainy = false;
	private boolean sunny = false;
	private boolean windy = false;
	private boolean snowy = false;

	TypicalDay(){
		this.name = "Typical Day";
		this.duration = 1440;
		this.rainy = true;
		this.sunny = true;
		this.windy = true;
		this.snowy = true;
	}
	public String getName(){
		return name;
	}

	public int getDuration(){
		return duration;
	}

	public boolean wasItRainy(){
		return rainy;
	}

	public boolean wasitSunny(){
		return sunny;
	}

	public boolean wasitWindy(){
		return windy;
	}

	public boolean wasitSnowy(){
		return snowy;
	}

	public void setName(String name){
		if (name.length() < 5){
			return ;
		} else{
			this.name = name;
		}
	}

	public void setDuration(int duration){
		if(duration < 60){
			return ;
		} else{
			this.duration = duration;
		}
	}

}

class WeatherStation{

	List<Weather> weatherList = null;
	Map<String, Integer> weatherCount = null;

	final String RAINY = "Rainy";
	final String SUNNY = "Sunny";
	final String WINDY = "Windy";
	final String SNOWY = "Snowy";

	public WeatherStation(){
		this.weatherList = new Arraylist<Weather>();
		this.weatherCount = new HashMap<String, Integer>();
		this.weatherCount.put(SUNNY, 0);
		this.weatherCount.put(RAINY, 0);
		this.weatherCount.put(WINDY, 0);
		this.weatherCount.put(SNOWY, 0);
	}

	public void addWeather(Weather weather){
		if (weather != null){
			this.weatherList.add(weather);
			int duration = weather.getDuration() / 60;
			if (weather.wasitSunny()){
				this.weatherCount.put(SUNNY, this.weatherCount.get(SUNNY) + duration)
			}
			if (weather.wasItRainy()){
				this.weatherCount.put(RAINY, this.weatherCount.get(RAINY) + duration);
			}
			if (weather.wasitSnowy()){
				this.weatherCount.put(SNOWY, this.weatherCount.get(SNOWY) + duration);
			}
			if (weather.wasitWindy()){
				this.weatherCount.put(WINDY, this.weatherCount.get(WINDY) + duration);
			}
			
		} else{
			return ;
		}
	}
}

class SingleWeather<T extends Weather>{
	private T singleton;
	public T getNewItem(){
		return singleton;
	}
	public void setSingleton(T singleton){
		this.singleton = singleton;
	}
}