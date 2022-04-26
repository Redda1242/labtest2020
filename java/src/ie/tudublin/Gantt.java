package ie.tudublin;

import java.util.ArrayList;
import java.util.ListIterator;

import java.util.Iterator;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Tasks> tasks = new ArrayList<Tasks>();
	public float border;

	public void settings()
	{
		size(1000, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
        for(TableRow r:table.rows())
        {
            Tasks t = new Tasks(r);
            tasks.add(t);
        }
	}

	public void printTasks()
	{
		for(Tasks t:tasks)
        {
            System.out.println(t);
        }
	}

	public void DisplayTasks()
	{
		ListIterator<String> litr = null;
		stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = 1; i <=30; i ++)
        {
            float x = map(i, 0, 30, border+120, width-20);
            line(x, border+60, x, height - border);
            //line(border, x, width - border, x);
            fill(255);
            text(i, x, border+30);
            //text(i, border * 0.5f, x);
			//rect(x, border+60, tasks.get(2), tasks.get(3));
			
			
        }

		float y = border +130;
			for (Tasks t: tasks)
			{
				text(t.getTask(),50 , y);
				float start = map(t.getStart(), 0, 30, border+120, width-20);
				float end = map(t.getEnd(), 0, 30, border+120, width-20);
				float rectWidth = end - start;
				rectMode(CORNER);
				rect(start, y, rectWidth, 40);

				y += 50;
			}
		



	}
	
	public void mousePressed()
	{
		println("Mouse pressed");
		
		for( Tasks t: tasks)
		{
			float x = map(t.getStart(), 1, 30, border+120, width-20);
			float y = map(t.getEnd(), 1, 30, border+120, width-20);
			
			if(dist(mouseX, mouseY, x, y) < 20)
			{
				rect(x, y, mouseX, mouseY);
			}
		}
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		DisplayTasks();
	}
}
