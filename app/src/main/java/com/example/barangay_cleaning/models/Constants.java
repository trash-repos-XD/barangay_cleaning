package com.example.barangay_cleaning.models;

import com.example.barangay_cleaning.R;

import java.util.ArrayList;
import java.util.Collections;

public class Constants {

    private static Resident kyle=new Resident(1,R.drawable.kyle, "Kyle", "Moraga", 22, "St. Matthew Subdivision");
    private static Resident temp_profile=new Resident(2,R.drawable.temp_profile, "Gabriel", "Manimtim", 24, "St. Matthew Subdivision");
    private static Resident rizal=new Resident(3,R.drawable.rizal, "Jose", "Rizal", 22, "St. Matthew Subdivision");
    private static Resident mabini=new Resident(4,R.drawable.mabini, "Apolinario", "Mabini", 32, "St. Matthew Subdivision");
    private static Resident antonio=new Resident(5,R.drawable.antonio, "Antonio", "Luna", 42, "St. Matthew Subdivision");
    private static Resident gregorio=new Resident(6,R.drawable.gregorio, "Gregorio", "Del Pilar", 45, "St. Matthew Subdivision");
    private static Resident josefa=new Resident(7,R.drawable.josefa, "Josefa", "Escoba", 32, "St. Matthew Subdivision");

    public static ArrayList<Resident> getResidents(){
        ArrayList<Resident> residents= new ArrayList<>();

        residents.add(kyle);
        residents.add(temp_profile);
        residents.add(rizal);
        residents.add(mabini);
        residents.add(antonio);
        residents.add(gregorio);
        residents.add(josefa);

        Collections.sort(residents, (r1, r2) -> r1.getFirstName().compareToIgnoreCase(r2.getFirstName()));

        return residents;
    }

    public static ArrayList<Report> getReports(){
        ArrayList<Report> reports= new ArrayList<>();

        reports.add(new Report(R.drawable.report1, "Littering", "Unresolved", kyle));
        reports.add(new Report(R.drawable.report2, "Littering", "Resolved", rizal));
        reports.add(new Report(R.drawable.report3, "Littering", "Unresolved", temp_profile));
        reports.add(new Report(R.drawable.report4, "Littering", "Unresolved", mabini));
        reports.add(new Report(R.drawable.report5, "Littering", "Resolved", gregorio));
        reports.add(new Report(R.drawable.report6, "Littering", "Unresolved", kyle));
        reports.add(new Report(R.drawable.report7, "Vandalism", "Unresolved", temp_profile));
        reports.add(new Report(R.drawable.report8, "Vandalism", "Unresolved", kyle));
        reports.add(new Report(R.drawable.report9, "Vandalism", "Unresolved", temp_profile));

        Collections.sort(reports, (r1, r2) -> r1.getOffender().getFirstName().compareToIgnoreCase(r2.getOffender().getFirstName()));

        return  reports;
    }

    public static ArrayList<Area> getAreas(){
        ArrayList<Area> areas= new ArrayList<>();

        areas.add(new Area(R.drawable.garden, "Garden", "clean"));
        areas.add(new Area(R.drawable.school, "School", "unclean"));
        areas.add(new Area(R.drawable.covered_court, "Covered Court", "clean"));
        areas.add(new Area(R.drawable.park, "Park", "unclean"));

        Collections.sort(areas, (r1, r2) -> r1.getName().compareToIgnoreCase(r2.getName()));

        return  areas;
    }

}
