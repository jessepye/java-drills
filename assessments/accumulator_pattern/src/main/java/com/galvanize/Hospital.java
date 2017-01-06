package com.galvanize;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Hospital {
    private List<Patient> patients;

    public Hospital(List<Patient> patients) {
        this.patients = patients;
    }

    public boolean isPatientAdmitted(String firstName, String lastName) {
        for(Patient patient : patients) {
            if(StringUtils.equals(firstName, patient.getFirstName())
                    && StringUtils.equals(lastName, patient.getLastName())) {
                return true;
            }
        }
        return false;
    }
}
