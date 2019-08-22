package org.pra.carworkshop.task;

import java.util.Comparator;

public class TaskComparatorByFeeDesc implements Comparator<Task>  {

	@Override
	public int compare(Task o1, Task o2) {

		return Float.compare(o2.getFee(), o1.getFee());
	}

}
