
class Q1a{
	String title;
	int number;
	int marks;

	public String toString(){
		return this.number + " " + this.title + " " + "("this.marks + " marks)";
	}

	Q1A(String title, int number, int marks){
		this.title = title;
		this.number = number;
		this.marks = marks;
	}
}

class Q1b{
	private String title;
	int number;
	private int marks;

	public String getTitle(){
		return title;
	}

	public int getNumber(){
		return number;
	}
	public int getMarks(){
		return marks;
	}

	public void setTitle(String title){
		this.title = title;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void setMarks(int marks){
		if(this.marks < 0){
			this.marks = 0;
		} else{
			this.marks = marks;
		}
	}
	public String toString(){
		return this.number + " " + this.title + " " + "("this.marks + " marks)";
	}
	Q1b(){
		this.title = "untitled";
		this.number = 0;
		this.marks = 0;
	}

	Q1b(String title, int number, int marks){
		this.title = title;
		this.number = number;
		this.marks = marks;
	}
}

class Q1c{
	private static int MQUESTION_COUNT = 0;
	private String title;
	int number;
	private int marks;

	public String getTitle(){
		return title;
	}

	public int getNumber(){
		return number;
	}
	public int getMarks(){
		return marks;
	}

	public void setTitle(String title){
		this.title = title;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void setMarks(int marks){
		if(this.marks <= 0){
			this.marks = 0;
		} else{
			this.marks = marks;
		}
	}
	public String toString(){
		return this.number + " " + this.title + " " + "("this.marks + " marks)";
	}
	Q1c(){
		this.title = "untitled";
		this.number = 0;
		this.marks = 0;
		Q1c.MQUESTION_COUNT++;
	}

	Q1c(String title, int number, int marks){
		this.title = title;
		this.number = number;
		this.marks = marks;
		Q1C.MQUESTION_COUNT++;
	}

	Q1c(String title, int marks){
		this.title = title;
		this.marks = marks;
		this.number = MQUESTION_COUNT;
		Q1c.MQUESTION_COUNT++;
	}
}

