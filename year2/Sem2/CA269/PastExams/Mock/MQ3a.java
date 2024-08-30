import java.util.List;
import java.util.ArrayList;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

// list of all students 
class Classroom{
    List <Student> students = new ArrayList<Student>();
    void addStudent(Student student){
        this.students.add(student);
    }

    List<Students> getGradedStudents(int marks){
        // make a new list of all graded students 
        List<Student> gradedStudents = new ArrayList<>(this.students);
        List <Student> passedStudents = new ArrayList<Student>();
        for (Student student : gradedStudents){
            if (student.getMarks() >= marks){
                passedStudents.add(student);
            }
            // or
            // if (student.getMarks() < 40){
            //     gradedStudents.remove(student);
            // }
        }
        return passedStudents;
    }
    double getAverageMarks(){
        int total = 0;
        for (Student student: students){
            total += student.getMarks();
        }
        return total / this.students.size();

    }
    boolean hasStudent(Student studentName){
        for(Student student : students){
            if (studentName.equals(student)){
                return true;
            }
            return false;
        }
    }

}