package com.mikhailovskii.lab2;

import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class LabEjb {

    private final Faculty[] faculties = {
            new Faculty("A", 100, 1000),
            new Faculty("B", 200, 2000),
            new Faculty("C", 300, 3000),
            new Faculty("D", 200, 2000),
            new Faculty("E", 100, 1000),
    };

    public double calculatePaymentForSeveralSemesters(double period, String facultyName) throws FacultyNotFoundException {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                return faculty.getPayment() * period;
            }
        }
        throw new FacultyNotFoundException(facultyName);
    }

    public ArrayList<String> getTwoSmallestFaculties() {
        ArrayList<String> smallestFaculties = new ArrayList<>();

        for (int i = 0; i < faculties.length - 1; i++) {
            for (int j = i + 1; j < faculties.length; j++) {
                if (faculties[i].getSize() > faculties[j].getSize()) {
                    Faculty faculty = faculties[i];
                    faculties[i] = faculties[j];
                    faculties[j] = faculty;
                }
            }
        }
        if (faculties.length >= 2) {
            smallestFaculties.add(faculties[0].toString());
            smallestFaculties.add(faculties[1].toString());
        }

        return smallestFaculties;

    }


}
