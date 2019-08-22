package org.pra.carworkshop.work;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.staff.EmployeeComparatorByTimeDesc;
import org.pra.carworkshop.staff.EmployeeSheet;

import java.util.List;

public class ScheduleHelper {
    void schedule(List<JobCard> jobCardList, List<EmployeeSheet> employeeSheetList) {
        int scheduleSequence = 0;
        for(JobCard jobCard : jobCardList) {
            employeeSheetList.sort(new EmployeeComparatorByTimeDesc());
            for(EmployeeSheet employeeSheet : employeeSheetList) {
                if( employeeSheet.getTimeLeft() >= jobCard.getTask().getTime()) {
                    jobCard.setScheduleSequence(++scheduleSequence);
                    jobCard.setEmployee(employeeSheet.getEmployee());
                    employeeSheet.addJobCard(jobCard);
                    break;
                }
            }
        }
    }
}
