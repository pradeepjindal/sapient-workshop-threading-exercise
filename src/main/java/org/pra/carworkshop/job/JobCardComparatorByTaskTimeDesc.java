package org.pra.carworkshop.job;

import java.util.Comparator;

public class JobCardComparatorByTaskTimeDesc implements Comparator<JobCard> {

	@Override
	public int compare(JobCard o1, JobCard o2) {
		
		return o2.getTask().getTime() - o1.getTask().getTime();
	}

}
