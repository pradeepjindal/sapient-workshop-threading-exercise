package org.pra.carworkshop.work;

import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.job.JobCardComparatorByTaskTimeDesc;
import org.pra.carworkshop.staff.EmployeeSheet;

public class JobSchedulerOnTimeTaken implements JobSchedulerI {

	@Override
	public void scheduleJob(List<JobCard> jobCardList, List<EmployeeSheet> employeeSheetList) {
		// prioritized based on time taken
		jobCardList.sort(new JobCardComparatorByTaskTimeDesc());
		new ScheduleHelper().schedule(jobCardList, employeeSheetList);
	}


}
