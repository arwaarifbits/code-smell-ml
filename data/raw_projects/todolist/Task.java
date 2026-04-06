package todolist;

public class Task {
    private String task;
    private STATUS status;

    public Task(String task) {
        this.task = task;
        this.status = STATUS.PENDING;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public STATUS getStatus() {
        return status;
    }

    public void markCompleted() {
        status = STATUS.COMPLETED;

    }
    @Override
    public String toString(){
        return task + "[" + status + "]";
    }
}
