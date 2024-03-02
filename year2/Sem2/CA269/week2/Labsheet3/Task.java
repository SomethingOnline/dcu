import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

class Task {
    final String title;
    String description;
    LocalDate scheduled;
    LocalDate deadline;
    State state;

    Task(String title, State state) {
        this.title = title;
        setState(state);
    }

    Task(String title, String description, LocalDate scheduled, LocalDate deadline, State state) {
        this.title = title;
        setDescription(description);
        setScheduled(scheduled);
        setDeadline(deadline);
        setState(state);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getScheduled() {
        return scheduled;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public State getState() {
        return state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setState(State state) {
        this.state = state;
    }

    // and so on ...

    public String toString() {
        String message = this.title + " (" + this.state + ")";
        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if (deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
    }

    public static void main(String[] args) {
        Task t1 = new Task("Test", State.TODO);
        LocalDate now = LocalDate.now();
        t1.setScheduled(now);
        System.out.println(t1);
        
        Task s1 = new RepeatedTask("S1", State.TODO);
        System.out.println(s1);
        s1.setState(State.DONE);
        System.out.println(s1);

        Task s2 = new Chore("S2", State.TODO, 
        LocalDate.now(), 
        LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(s2);
        s2.setState(State.DONE);
        System.out.println(s2);

        Task t2 = new SharedTask("T2", "Alice");
        System.out.println(t2);

        Task t3 = new Dependency("T3", State.TODO, t1);
        System.out.println(t3);
        t3.setState(State.DONE);
        System.out.println(t3);
        t1.setState(State.DONE);
        t3.setState(State.DONE);
        System.out.println(t3);
    }
}

class Chore extends RepeatedTask {
    // think how to use inheritence to avoid repeating fields from Task
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
 
        super(title, state);
        // even in constructor, defer to setters
        // because there may be input validation, default values, etc. implemented in them
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
        if(state == State.DONE){
            LocalDate repeat_new = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(repeat_new);
        }
    }
}

class RepeatedTask extends Task {
    RepeatedTask(String title, State state) {
        super(title, state);
    }
     
    @Override
    public void setState(State state) {
            // if state is DONE
        if (state == State.DONE) {
            this.state = State.TODO;
        } else {
            this.state = state;
        }    
    }
}

class SharedTask extends Task{
    String name;
    SharedTask(String title, String name){
        super(title, State.WAIT);
        this.name = name;
    }
    @Override
    public String toString(){
        return super.toString() + " shared with: " + name;
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
        if(state == State.DONE && !(task_dependency.state == State.DONE)){
            return;
        } else {
            this.state = state;
        }
    }
}
