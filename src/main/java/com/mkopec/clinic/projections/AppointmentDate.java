package com.mkopec.clinic.projections;

public interface AppointmentDate {
    Long getID();
    String getSelectedDate();
    String getPartStart();
    String getPartEnd();
    String getFirstname();
    String getSurname();
    Long getDoctorID();
}
