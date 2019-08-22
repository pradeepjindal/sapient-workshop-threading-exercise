package org.pra.carworkshop.job;

import org.pra.carworkshop.staff.Employee;
import org.pra.carworkshop.task.Task;

public class JobCard implements Runnable {
	
	private static int serialNo;
	
	private int jobCardNo;
	private Task task;
	private String vehicleNo;
	
	private Employee employee;
	private int executionOrder;
	
	private int scheduleSequence;
	
	public JobCard(Task task) {
		jobCardNo = ++serialNo;
		this.task = task;
	}

	@Override
	public String toString() {
		return employee.getName() + " | " + task.getName() + " [" + task.getTime() + " Hour] Rs." + task.getFee();
	}

	public int getJobCardNo() {
		return jobCardNo;
	}
	/*
	public void setWorkOrderNo(int jobCardNo) {
		this.jobCardNo = jobCardNo;
	}
	*/

	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Task getTask() {
		return task;
	}
	/*
	public void setTask(Task task) {
		this.task = task;
	}*/



	@Override
	public void run() {
		System.out.println("scheduleSequence=" + scheduleSequence + " (" + employee.getName() + ") | starting  - " + task.getName());
		try {
			Thread.sleep(task.getTime() * 1000);
		} catch (InterruptedException e) {
			System.out.println("jobCardNo=" + jobCardNo + " | interrupted - " + task.getName());
			//e.printStackTrace();
		}
		System.out.println("scheduleSequence=" + scheduleSequence + " (" + employee.getName() + ") | finishing - " + task.getName());
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getExecutionOrder() {
		return executionOrder;
	}

	public void setExecutionOrder(int executionOrder) {
		this.executionOrder = executionOrder;
	}

	public int getScheduleSequence() {
		return scheduleSequence;
	}

	public void setScheduleSequence(int scheduleSequence) {
		this.scheduleSequence = scheduleSequence;
	}
}
