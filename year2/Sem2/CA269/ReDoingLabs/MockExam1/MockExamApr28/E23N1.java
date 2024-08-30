public class E23N1{
	private String title;
	private String published;
	private int number;
	private boolean approvedForPublication;

	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getPublished(){
		return published;
	}
	public void setPublished(String published){
		int dashCount = 0;
		for (char c : published.toCharArray()){
			if (c == '-'){
				dashCount++;
			}
		}
		if (dashCount < 2 || published.length() < 6){
			;
		} else{
			this.published = published;
		}

	}

	public void setPublished(Int day, int month, int year){
		String date = day + "-" + month + "-" + year;
		this.published = date;
	}

	public int getNumber(){
		return number;
	}
	public void setNumber(int number){
		if (number <= 0){
			;
		} else{
			this.number = number;
		}
	}
	public boolean getApprovedForPublication(){
		return approvedForPublication;
	}
	public void setApprovedForPublication(boolean approvedForPublication){
		this.approvedForPublication = approvedForPublication;
	}

	public boolean isCameraReady(){
		return this.approvedForPublication && this.number > 0 && !this.title.equals("Untitled") && !published.equals("not set");
	}

	E23N1(){
		this.title = "Untitled";
		this.published = "not set";
		this.number = 0;
		this.approvedForPublication = false;
	}
	E23N1(String title){
		this();
		this.title = title;
	}

	public String toString(){
		if (!this.approvedForPublication){
			return this.title + " - pending approval";
		} else if (this.published.equals("not set")){
			return this.title + " - to be published";
		} else{
			return this.title + " - " + this.published;
		}
	}
}