package org.pra.carworkshop.work;

import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.job.JobCardComparatorByTaskFeeDesc;
import org.pra.carworkshop.staff.EmployeeSheet;

public class JobSchedulerOnHighFee implements JobSchedulerI {
	
	@Override
	public void scheduleJob(List<JobCard> jobCardList, List<EmployeeSheet> employeeSheetList) {
		// prioritized based on fee
		jobCardList.sort(new JobCardComparatorByTaskFeeDesc());
		new ScheduleHelper().schedule(jobCardList, employeeSheetList);
	}
}
