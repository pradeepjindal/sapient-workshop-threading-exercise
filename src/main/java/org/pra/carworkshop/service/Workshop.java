package org.pra.carworkshop.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.staff.EmployeeSheet;
import org.pra.carworkshop.task.Task;
import org.pra.carworkshop.work.JobSchedulerI;

public class Workshop implements WorkshopI {
	
	private List<Task> taskList;
	private List<JobCard> jobCardList;
	private List<EmployeeSheet> employeeSheetList;

	@Override
	public int addTasks(List<Task> taskList) {
		this.taskList = taskList;
		return this.taskList.size();
	}

	@Override
	public int addJobCard(List<JobCard> taskCardList) {
		this.jobCardList = taskCardList;
		return this.jobCardList.size();
	}

	@Override
	public int addEmployeeSheet(List<EmployeeSheet> employeeSheetList) {
		this.employeeSheetList = employeeSheetList;
		return this.employeeSheetList.size();
	}

	@Override
	public void scheduleJob(JobSchedulerI jobScheduler) {
		jobScheduler.scheduleJob(jobCardList, employeeSheetList);
	}

	@Override
	public void executeJob() {

		ExecutorService executorService;
		for(EmployeeSheet employeeSheet : employeeSheetList) {
			executorService = Executors.newSingleThreadExecutor();
			for(JobCard jobCard : employeeSheet.getJobList()) {
				executorService.execute(jobCard);
			}
			
		}
	}
}
