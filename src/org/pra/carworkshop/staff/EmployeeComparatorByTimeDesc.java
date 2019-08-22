package org.pra.carworkshop.staff;

import java.util.Comparator;

public class EmployeeComparatorByTimeDesc implements Comparator<EmployeeSheet>  {

	@Override
	public int compare(EmployeeSheet o1, EmployeeSheet o2) {

		return o2.getTimeLeft() - o1.getTimeLeft();
	}

}
