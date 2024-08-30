import java.util.*;


enum Grade{
	GradeFail, GradePass, GradeDistinction;
}
class Student implements Comparable<Student>{
	private int marks;
	public int getMarks(){
		return this.marks;
	}
	public void setMarks(int marks){
		this.marks = marks;
	}

	public int compareTo(Student student){
		return student.getMarks() - this.marks; // descending
		// OR
		// Integer.compare(student.getMarks(), this.getMarks());
	}
}

class Classroom{
	List<Student> students = null;
	Map<Grade, Integer> gradedStudents = null;


	
	public void calculateGradeStatistics(){
		this.gradedStudents = new HashMap<>();
		this.gradedStudents.put(Grade.GradeFail, 0);
		this.gradedStudents.put(Grade.GradePass, 0);
		this.gradedStudents.put(Grade.GradeDistinction, 0);

		for (Student student : students){
			int mark = student.getMarks();
			if (mark < 40){
				this.gradedStudents.put(Grade.GradeFail, this.gradedStudents.get(Grade.GradeFail) + 1);
			} else if(mark >= 40 && mark <= 75){
				this.gradedStudents.put(Grade.GradePass, this.gradedStudents.get(Grade.GradePass) + 1);
			} else{
				this.gradedStudents.put(Grade.GradeDistinction, this.gradedStudents.get(Grade.GradeDistinction) + 1);
			}
		}
	}

	Classroom(){
		this.students = new ArrayList<>();
	}
	public Queue<Student> getGraduatingStudents(){
		Queue<Student> graduatingStudents = new LinkedList<>();
		for (Student student : students){
			if (student.getMarks() < 40){
				;
			} else{
				graduatingStudents.add(student);
			}
		}

		List<Student> list = new ArrayList<>(graduatingStudents);
		Collections.sort(list);

		Queue<Student> sortedQueue = new LinkedList<>(list);

		return sortedQueue;

	}

	public void addStudent(Student student){
		if (student != null){
			this.students.add(student);
		}
	}

	public List<Student> getGradedStudents(int marks){
		List<Student> gradedStudents = new ArrayList<>();
		for (Student student : students){
			if(student.getMarks() < marks){
				;
			} else{
				gradedStudents.add(student);
			}
		}
		return gradedStudents;
	}

	public double getAverageMarks(){
		int totalMarks = 0;
		int countStudents = students.size();
		double averageMarks = 0;
		if (this.students != null){
			for (Student student : students){
				totalMarks += student.getMarks();
			}
		}
		averageMarks = totalMarks / countStudents;
		return averageMarks;
	}

	public boolean hasStudent(Student student){
		if (student != null){
			return students.contains(student);
		}
		return false;
	}
}