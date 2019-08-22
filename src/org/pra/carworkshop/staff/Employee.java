package org.pra.carworkshop.staff;

import java.util.ArrayList;
import java.util.List;

import org.pra.carworkshop.task.Task;

public class Employee {

	private final String name;
	private final int workingHour;
	private List<Task> taskList;

	public Employee(String name, int workingHour) {
		this.name = name;
		this.workingHour = workingHour;
		taskList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	public String getName() {
		return name;
	}
/*
	public void setName(String name) {
		this.name = name;
	}
*/
	public int getWorkingHour() {
		return workingHour;
	}
/*
	public void setTime(int time) {
		this.time = time;
	}
	*/

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	public int addSkill(Task task) {
		taskList.add(task);
		return taskList.size();
	}
}
