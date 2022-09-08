package com.mvovk;

import com.mvovk.models.Calendar;
import com.mvovk.models.TimeStamps;

import java.util.ArrayList;

public class Solution {
    Calendar c1,c2;
    long meetingDuration;

    public Solution(Calendar c1, Calendar c2, String meetingDuration) {
        this.c1 = c1;
        this.c2 = c2;
        this.meetingDuration = getSeconds(meetingDuration);
    }

    public ArrayList<TimeStamps> getSolution(){
        ArrayList<TimeStamps> meeting = new ArrayList<>();
        long tmpMax = getMax((c1.getWorking_hours().getStartSec()), (c2.getWorking_hours().getStartSec()));
        long tmpMin = 0;
        long dif;
        int i = 0, j = 0;

        while (i<c1.getPlanned_meeting().size()&&j<c2.getPlanned_meeting().size()){

            tmpMin = getMin((c1.getPlanned_meeting().get(i).getStartSec()),(c2.getPlanned_meeting().get(j).getStartSec()));


            dif = tmpMin - tmpMax;


            if (dif/meetingDuration>=1){
                meeting.add(new TimeStamps(toUsualFormat(tmpMax),toUsualFormat(tmpMin)));
            }
            else  {

                if (c1.getPlanned_meeting().get(i).getStartSec()<
                        c2.getPlanned_meeting().get(j).getStartSec()){

                    j--;
                }
                else {

                    i--;
                }
            }

           // System.out.println(meeting);
            if (i<0)
                tmpMax = getMax(c1.getWorking_hours().getStartSec(), c2.getPlanned_meeting().get(j).getEndSec());
            else if (j<0)
                tmpMax = getMax(c2.getWorking_hours().getStartSec(), c1.getPlanned_meeting().get(i).getEndSec());
            else
                tmpMax = getMax(c1.getPlanned_meeting().get(i).getEndSec(), c2.getPlanned_meeting().get(j).getEndSec());


            i++;

            j++;

        }
      //  System.out.println("Max "+ toUsualFormat(tmpMax)+" Min "+ toUsualFormat(tmpMin));

        tmpMin = getMin(c1.getWorking_hours().getEndSec(), c2.getWorking_hours().getEndSec());

        dif = tmpMin - tmpMax;

        if (dif/meetingDuration>=1){
            meeting.add(new TimeStamps(toUsualFormat(tmpMax),toUsualFormat(tmpMin)));

        }

        return meeting;

    }


    public  String toUsualFormat (long time){
        String usFormat = Long.toString(time/3600)+":"+(((time%3600)/60==0)?"00":(time%3600)/60);
        return usFormat;
    }


    long getSeconds (String time){
        long timeSec;
        timeSec = Integer.parseInt(time.split(":")[0])* 3600L +Integer.parseInt(time.split(":")[1])* 60L;
        return timeSec;
    }

    long getMax (long x1, long x2){
        if (x1>x2)
            return x1;
        return x2;
    }
    long getMin (long x1, long x2){
        if (x1<x2)
            return x1;
        return x2;
    }


}
