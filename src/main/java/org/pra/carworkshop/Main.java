package org.pra.carworkshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.pra.carworkshop.job.JobCard;
import org.pra.carworkshop.service.Workshop;
import org.pra.carworkshop.service.WorkshopI;
import org.pra.carworkshop.staff.Employee;
import org.pra.carworkshop.staff.EmployeeSheet;
import org.pra.carworkshop.task.Task;
import org.pra.carworkshop.work.JobSchedulerI;
import org.pra.carworkshop.work.JobSchedulerOnTimeTakenAndSkillWithOverTime;

public class Main {

	public static void main(String[] args) {
		
		// should come from config
		Task taskWash = new Task("CAR-WASH", 2, 100);
		Task taskRepair = new Task("CAR-REPAIR", 5, 1000);
		Task taskPaint = new Task("CAR-PAINT", 4, 1100);
		
		// should come from config
		Employee empSmith = new Employee("Smith", 9);
		Employee empWalker = new Employee("Walker", 9);
		Employee empJoe = new Employee("Joe", 9);
		
		empSmith.addSkill(taskRepair);
		
		empWalker.addSkill(taskRepair);
		empWalker.addSkill(taskPaint);
		
		empJoe.addSkill(taskRepair);
		empJoe.addSkill(taskPaint);
		empJoe.addSkill(taskWash);
		
		// preparation
		List<Task> taskList = new ArrayList<>();
		
		taskList.add(taskWash);
		taskList.add(taskRepair);
		taskList.add(taskPaint);

		List<JobCard> jobCardList = new LinkedList<>();
		
		jobCardList.add(new JobCard(taskRepair));
		jobCardList.add(new JobCard(taskPaint));
		jobCardList.add(new JobCard(taskWash));
		jobCardList.add(new JobCard(taskRepair));
		jobCardList.add(new JobCard(taskPaint));
		jobCardList.add(new JobCard(taskRepair));
		
		List<EmployeeSheet> employeeSheetList = new ArrayList<>();
		
		employeeSheetList.add(new EmployeeSheet(empSmith));
		employeeSheetList.add(new EmployeeSheet(empWalker));
		employeeSheetList.add(new EmployeeSheet(empJoe));
		
		// case 1 - 
		//JobSchedulerI jobScheduler = new JobSchedulerOnTimeTaken();
		//JobSchedulerI jobScheduler = new JobSchedulerOnHighFee();
		
		//JobSchedulerI jobScheduler = new JobSchedulerOnTimeTakenAndSkill();
		JobSchedulerI jobScheduler = new JobSchedulerOnTimeTakenAndSkillWithOverTime();
		
		WorkshopI workshop = new Workshop();
		workshop.addTasks(taskList);
		workshop.addJobCard(jobCardList);
		workshop.addEmployeeSheet(employeeSheetList);
		workshop.scheduleJob(jobScheduler);
		
		System.out.println("---------------------------------");
		for(EmployeeSheet employeeSheet : employeeSheetList) {
			System.out.println(employeeSheet);
		}
		System.out.println("---------------------------------");
		
		workshop.executeJob();
	}

}
