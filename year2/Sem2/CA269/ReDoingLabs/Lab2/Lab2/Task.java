import java.util.*;
import java.time.LocalDate;
import java.time.Period;


enum State{
	TODO, BEGN, HALT, WAIT, DONE;

}

class Task{
	private String title;
	private String description;
	private LocalDate scheduled;
	private LocalDate deadline;
	State state;

	Task(String title, State state){
		this.title = title;
		this.state = state;
	}
	Task(String title, State state, String description, LocalDate scheduled, LocalDate deadline){
		this.title = title;
		this.state = state;
		this.description = description;
		this.scheduled = scheduled;
		this.deadline = deadline;
	}

	public String getTitle(){
		return title;
	}
	public String getDescription(){
		return description;
	}
	public State getState(){
		return state;
	}
	public LocalDate getScheduled(){
		return scheduled;
	}
	public LocalDate getDeadline(){
		return deadline;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setDescriptin(String description){
		this.description = description;
	}
	public void setState(State state){
		this.state = state;
	}
	public void setScheduled(LocalDate scheduled){
		this.scheduled = scheduled;
	}
	public void setDeadline(LocalDate deadline){
		this.deadline = deadline;
	}


	public String toString(){
		StringBuilder result = new StringBuilder(this.title + " (" + this.state + ")");
		if (scheduled != null){
			result.append("scheduled: " + scheduled);
		}
		if (deadline != null){
			result.append("deadline: " + deadline);
		}
		return result.toString();
	}

	public static void main(String[] args){

				// Check Chores work correctly on DONE -> repeat
		// note s1 is Task but object is type Chore
// test a simple Task object works correctly
		Task t1 = new Task("T1", State.TODO);
		LocalDate now = LocalDate.now();
		LocalDate.now();
		System.out.println(t1);

		/* OUTPUT
		T1 (TODO)
		*/

		Task s1 = new RepeatedTask("S1", State.TODO);
		System.out.println(s1);
		s1.setState(State.DONE);
		System.out.println(s1);

		/* OUTPUT
		S1 (TODO)
		S1 (TODO)
		*/

		// Check Chores work correctly on DONE -> repeat
		// note s2 is Task but object is type Chore
		Task s2 = new Chore("S2", State.TODO,
			LocalDate.now(),
			LocalDate.now().plus(Period.ofDays(7)));
		System.out.println(s2);
		s2.setState(State.DONE);
		System.out.println(s2);
		// verify the scheduled date has moved by +7 days

		/* OUTPUT
		S2 (TODO) scheduled: 2023-01-26
		S2 (TODO) scheduled: 2023-02-02
		*/

		Task t2 = new SharedTask("T2", "Alice");
		System.out.println(t2);

		/* OUTPUT
		T2 (WAIT) shared with: Alice
		*/

		Task t3 = new Dependency("T3", State.TODO, t1);
		System.out.println(t3);
		t3.setState(State.DONE);
		System.out.println(t3);
		t1.setState(State.DONE);
		t3.setState(State.DONE);
		System.out.println(t3);

		/* OUTPUT
		T3 (TODO) dependent on: T1 (TODO)
		T3 (TODO) dependent on: T1 (TODO)
		T3 (DONE) dependent on: T1 (DONE)
		*/
	}

}

class Chore extends Task{

	private LocalDate repeat;

	Chore(String title, State state, LocalDate scheduled, LocalDate repeat){
		super(title, state);
		setScheduled(scheduled);
		setRepeat(repeat);
	}

	public LocalDate getRepeat(){
		return repeat;
	}
	public void setRepeat(LocalDate repeat){
		this.repeat = repeat;
	}

	@Override
	public void setState(State state){
		super.setState(state);
		if (state == State.DONE){
			LocalDate repeat_new = repeat.plus(Period.ofDays(7));
			setScheduled(repeat);
			setRepeat(repeat_new);
		}
	}
}

class RepeatedTask extends Task{
	RepeatedTask(String title, State state){
		super(title, state);
	}
	@Override
	public void setState(State state){
		if (state == State.DONE){
			this.state = State.TODO;
		} else{
			this.state = state;
		}
	}
}

class SharedTask extends Task{
	private String name;

	SharedTask(String title, String name){
		super(title, State.WAIT);
		setName(name);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return super.toString() + "shared with: " + this.name;
	}

}
class Dependency extends Task{
	Task task_dependency;
	Dependency(String title, State state, Task task_dependency){
		super(title, state);
		this.task_dependency = task_dependency;
	}

	@Override
    public String toString(){
        return super.toString() + " dependent on: " + task_dependency.toString();
    }


	@Override
	public void setState(State state){
		if (this.state == State.DONE){
			if (task_dependency.state != State.DONE){
				return;
			}
		} else{
			this.state = state;
		}
	}
}