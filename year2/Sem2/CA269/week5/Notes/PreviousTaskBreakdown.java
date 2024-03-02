<!-- In the previous W20m labsheet, the requirements and specification for a 'Personal Task Manager' were provided where the concept Task was central to the problem. The description walked through how to create an object-oriented solution using classes and inheritance where Task was the main class and other categories could be described as its specialised types.

To summarise,
    Task - a class that definitely has a title (that cannot change) and a state,
    and optionally a scheduled date, deadline date, and description. - multiple constructors

    Chore - a Task that has a scheduled date, and additionally a repeat date
    such that once the task is DONE, its scheduled date is 'reset' to the repeat date,
    and the repeat date is advanced by 7 days. - inherits task

    Repeating task - a Task whose state is reset to TODO 
    once it is DONE. - inherits task

    Shared task - a Task that has a name field for the person it is
    shared with and starts with the state WAIT

    Dependecy - a Task that has a reference to another task, such that
    this task cannot be marked DONE until the other task is DONE

The task class:
This class represents the core functionality and contains 
the specified attributes:

class Task{
    // cannot use private here because these attributes must be INHERITED
    final String title; // title cannot be changed
    String description;
    LocalDate scheduled;
    LocalDate deadline; // not final because deadline can be updated for repeatedTasks
    State state; // state would be an enum with todo, repeatedtask etc

    // constructor
    Task(String title, State state){
        this.title = title;
        this.state = state;
    }

    // member fields of task can be accessed directly using any method
    // however, it is good practice to use getters/setters
    // final classes cannot be modified, therefore title has getter and not setter
    String getTitle(){
        return title;
    }
    LocalDate getScheduled(){
        return scheduled;
    }
    // no setter for title
    void setDescription(String description){
        this.description = description
    }
}
// RepeatedTask
// Task can be specialized into Chore, RepeatedTask, SharedTask and Dependency
// each of these are subclasses that extend class
// both chore and repeatedTask have similar entities - both must reset state to TODO if it is DONE
// because of this we will make one of them extend the other
// the parent of this will also extend Task
// RepeatedTask has lesser requirements so we will make this the parent
// so it will be Task - RepeatedTask - Chore
class RepeatedTask extends Task{
    // constructor
    RepeatedTask(String title, State state){
        // get attributes from task
        super(title, state);
    }
    @Override
    // we must override the state attribute to set it to TODO if it is done
    public void setState(State state){
        if (state = State.DONE){
            this.state = State.TODO;
            // if it is not done then dont change 
        } else{
            this.state = state;
        }
    }
}
// Chore class
// chore has new fields - date when task repeated, scheduled and repeat must be mandatory
class Chore extends RepeatedTask{
    LocalDate repeat;
    // constructor
    Chore(String title, State state, LocalDate scheduled, LocalDate repeat){
        super(title, state);
        // call setter methods
        setScheduled(scheduled);
        setRepeat(repeat);
    }
    // getter/setter for repeat
    public LocalDate getRepeat() {
        return this.repeat;
    }
    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }
    // then override state if it is done to todo and then update repeat to new repeat date
    @Override
    public void setState(State state){
        // call set state from repeatedTask - updates state to TODO if it is DONE, else continues
        super.setState(state);
        if (state == state.DONE){
            // + 7 days to repeat
            LocalDate newRepeat repeat.plus(Period.ofDays(7));
            // update scheduled to current repeat date
            setScheduled(repeat);
            // update repeat date to new repeate date
            setRepeat(newRepeat);
        }
    }
}
// class SharedTask 
// has an additional field to share the name of the person it is shared with
// requirement that it starts with State.WAIT
// distinct from chore and repeatedTask so they cant be parent classes
class SharedTask extends Task{
    String name;
    // constructor
    SharedTask(String title, String name){
        super(title, state.WAIT);
        this.name = name;
    }
    @Override
    public String toString(){
        return super.toString() + " shared with: " + name;
    }
}
// Dependancy class
// task that cannot be set to DONE unless its referenced task is DONE first
// must have extra attribute called task_dependancy and does nothing unless this has DONE
// since this behaviour associated with setting the state, we implemenet it as the setter in dependancy
class Dependancy extends Task{
    Task task_dependancy;
    Dependancy(String title, String state, Task task_dependancy){
        super(title, state);
        this.task_dependancy = task_dependancy;
    }
    // check if task_dependancy is done 
    // set state to DONE
    // if not then nothing
    @Override
    public void setState(State state){
        if (state = State.DONE && !(task_dependancy.State == DONE)){
            return;
        } else{
            this.state = state;
        }
    }
}