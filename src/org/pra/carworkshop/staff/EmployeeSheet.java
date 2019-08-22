package org.pra.carworkshop.staff;

import java.util.LinkedList;
import java.util.List;

import org.pra.carworkshop.job.JobCard;

public class EmployeeSheet {

	private int serialNo;
	
	private List<JobCard> jobCardList;

	private Employee employee;
	private int timeLeft;

	public EmployeeSheet(Employee employee) {

		jobCardList = new LinkedList<>();
		timeLeft = employee.getWorkingHour();
		this.employee = employee;
	}
	
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();
		for(JobCard jobCard : jobCardList) {
			//stringBuilder.append(employee.getName()).append(" | jobCardNo=").append(jobCard.getJobCardNo()).append(" | ").append(jobCard).append("\n");
			stringBuilder.append("_schedule.seq=" + jobCard.getScheduleSequence() + " | " + employee.getName() + "   " +  jobCard.getExecutionOrder() + "(jobCardNo=" + jobCard.getJobCardNo() + ") |" + 
			jobCard.getTask().getName() + " [" + jobCard.getTask().getTime() + " Hour] Rs." + jobCard.getTask().getFee() + "\n");
		}
		return stringBuilder.toString();

	}

	public int addJobCard(JobCard jobCard) {
		jobCard.setExecutionOrder(++serialNo);
		jobCardList.add(jobCard);
		timeLeft -= jobCard.getTask().getTime();
		return jobCardList.size();
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}

	public Employee getEmployee() {
		return employee;
	}
	/*
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	*/
	
	public List<JobCard> getJobList() {
		return jobCardList;
	}
}
