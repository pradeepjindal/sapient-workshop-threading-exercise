package org.pra.carworkshop.work;

import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.staff.EmployeeSheet;

public interface JobSchedulerI {

	void scheduleJob(List<JobCard> jobCardList, List<EmployeeSheet> employeeSheetList);

}