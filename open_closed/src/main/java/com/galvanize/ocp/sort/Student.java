package com.galvanize.ocp.sort;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

class Student {

	private final String firstName;
	private final String lastName;
	private final int    score;

	public Student(String firstName, String lastName, int score) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getScore() {
		return score;
	}

	public String toString() {
		return "Student(firstName: " + firstName + ", lastName: " + lastName + ", score: " + score + ")";
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(1, 3, this);
	}
}