package com.mvovk.models;

import java.util.ArrayList;

public class Calendar {
    private TimeStamps working_hours;
    private ArrayList<TimeStamps> planned_meeting;

    public ArrayList<TimeStamps> getPlanned_meeting() {
        return planned_meeting;
    }

    public void setPlanned_meeting(ArrayList<TimeStamps> planned_meeting) {
        this.planned_meeting = planned_meeting;
    }

    public TimeStamps getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(TimeStamps working_hours) {
        this.working_hours = working_hours;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "working_hours=" + working_hours +
                ", planned_meeting=" + planned_meeting +
                '}';
    }
}
