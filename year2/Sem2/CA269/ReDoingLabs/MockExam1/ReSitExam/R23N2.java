import java.util.*;

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

interface RainbowDay extends SunnyDay, RainyDay {}

class PicnicHoliday implements Day{
	String accessories;
	int avgTemp;

	@Override
	public int getAvgTemp(){
		return avgTemp;
	}

	public String getAccessories(){
		return accessories;
	}

}

class IndoorHoliday extends PicnicHoliday implements RainbowDay{
	private int sunshine;
	private double rainfall;
	private boolean sporadicRainfall;

	public int getSunshine(){
		return sunshine;
	}
	public double getRainfall(){
		return rainfall;
	}
	public boolean isSporadic(){
		return sporadicRainfall;
	}

	public static List<Day> getOutdoorDays(List<Day> daysList){
		List<Day> outdoorDays = new LinkedList<>();
		for (Day day : daysList){
			if (day instanceof SunnyDay){
				outdoorDays.add(day);
			} else if (day instanceof RainyDay){
				RainyDay newDay = (RainyDay) day;
				if (newDay.isSporadic()){
					if (newDay.getRainfall() < 2){
						outdoorDays.add(day);
					}
				}
			}
		}
		return outdoorDays;
	}

	public static List<Day> prioritiseDays(List<Day> daysList){
		List<Day> priorityDays = new LinkedList<>(daysList);
		Collections.sort(priorityDays, new Comparator<Day>(){
			@Override
			public int compare(Day d1, Day d2){
				int avgTemp1 = d1.getAvgTemp();
				int avgTemp2 = d2.getAvgTemp();
				return Integer.compare(avgTemp2, avgTemp1);
			}
		});
		return priorityDays;
	}

	public IndoorHoliday(int avgTemp, int sunshine, double rainfall, boolean sporadicRainfall, String accessories){
		this.avgTemp = avgTemp;
		this.accessories = accessories;
		this.sunshine = sunshine;
		this.rainfall = rainfall;
		this.sporadicRainfall = sporadicRainfall;
	}


}