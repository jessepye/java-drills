package com.galvanize.ocp.sort;

import java.util.List;

import static com.galvanize.ocp.sort.SortOrder.ASC;
import static com.galvanize.ocp.sort.SortOrder.DESC;

class BubbleSort {

	static void sort(List<Student> students, SortOrder sortOrder) {

		int n = students.size();
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (sortOrder == ASC) {
					if (students.get(i - 1).getScore() > students.get(i).getScore()) {
						final Student temp = students.get(i - 1);
						students.set(i - 1, students.get(i));
						students.set(i, temp);
						swapped = true;
					}
				} else if (sortOrder == DESC) {
					if (students.get(i - 1).getScore() < students.get(i).getScore()) {
						final Student temp = students.get(i - 1);
						students.set(i - 1, students.get(i));
						students.set(i, temp);
						swapped = true;
					}
				} else {
					throw new RuntimeException("Unsupported SortOrder: " + sortOrder);
				}
			}
			n--;
		} while (swapped);
	}
}
