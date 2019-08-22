package org.pra.carworkshop.work;

import java.util.Collections;
import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.job.JobCardComparatorByTaskTimeDesc;
import org.pra.carworkshop.staff.EmployeeComparatorByTimeDesc;
import org.pra.carworkshop.staff.EmployeeSheet;

public class JobSchedulerOnTimeTakenAndSkillWithOverTime implements JobSchedulerI {

	@Override
	public void scheduleJob(List<JobCard> jobCardList, List<EmployeeSheet> employeeSheetList) {
		
		// prioritized based on time taken and skill is compatible and overtime is permitted
		Collections.sort(jobCardList, new JobCardComparatorByTaskTimeDesc());
		int scheduleSequence = 0;
		
		for(JobCard jobCard : jobCardList) {
			
			Collections.sort(employeeSheetList, new EmployeeComparatorByTimeDesc());
			for(EmployeeSheet employeeSheet : employeeSheetList) {
				if( employeeSheet.getEmployee().getTaskList().contains(jobCard.getTask())) {
					jobCard.setScheduleSequence(++scheduleSequence);
					jobCard.setEmployee(employeeSheet.getEmployee());
					employeeSheet.addJobCard(jobCard);
					break;
				}
			}

		}
	}
}
