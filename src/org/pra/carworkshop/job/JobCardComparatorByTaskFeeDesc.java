package org.pra.carworkshop.job;

import java.util.Comparator;

public class JobCardComparatorByTaskFeeDesc implements Comparator<JobCard> {

	@Override
	public int compare(JobCard o1, JobCard o2) {
		
		return Float.compare(o2.getTask().getFee(), o1.getTask().getFee());
	}

}
