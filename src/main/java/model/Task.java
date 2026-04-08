package model;

public class Task {

    private int id;
    private String description;
    private Priority priority;
    private Status status;
    private String employee;

    public Task(int id,String description,Priority priority,String employee) {

        this.id=id;
        this.description=description;
        this.priority=priority;
        this.employee=employee;
        this.status=Status.CREATED;
    }

    public int getId() {
        return id;
    }

    public String getEmployee() {
        return employee;
    }

    public Status getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
    public Priority getPriority(){
        return priority;
    }
    public void setStatus(Status status) {
        this.status=status;
    }

    public String toString() {

        return "TaskID:"+id+
                " Desc:"+description+
                " Priority:"+priority+
                " Status:"+status+
                " Assigned:"+employee;
    }

}