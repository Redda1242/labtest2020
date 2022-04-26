package ie.tudublin;


import processing.core.PApplet;
import processing.data.TableRow;

public class Tasks extends PApplet{
    
    private String tasks;
    private int start;
    private int end;

    
    @Override
    public String toString() {
        return "Tasks [Task=" + tasks + ", Start=" + start + ", End=" + end ;
    }

    public Tasks(TableRow tr)
    {

        this (
        tr.getString("Task"),
        tr.getInt("Start"),
        tr.getInt("End")
        );
        

    }

    public Tasks(String tasks, int start, int end) {
        this.tasks = tasks;
        this.start = start;
        this.end = end;
    }

    public String getTask() {
        return tasks;
    }
    public void setTask(String tasks) {
        this.tasks = tasks;
    }

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

}
