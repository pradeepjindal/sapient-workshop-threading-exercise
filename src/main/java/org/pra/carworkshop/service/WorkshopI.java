package org.pra.carworkshop.service;

import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.staff.EmployeeSheet;
import org.pra.carworkshop.task.Task;
import org.pra.carworkshop.work.JobSchedulerI;

public interface WorkshopI {

	int addTasks(List<Task> taskList);

	int addJobCard(List<JobCard> taskCardList);

	int addEmployeeSheet(List<EmployeeSheet> employeeSheetList);

	void scheduleJob(JobSchedulerI jobScheduler);

	void executeJob();

}