package com.mvovk;

import com.mvovk.models.Calendar;
import com.mvovk.models.TimeStamps;

import java.util.ArrayList;

public class Solution {




//    public void getSolution(Calendar c1, Calendar c2){
//        ArrayList<TimeStamps> meeting = new ArrayList<>();
//
//        long workStart = 0;
//        long workEnd = 0;
//
//        if ((getSeconds(c1.getWorking_hours().getStart())<getSeconds(c2.getWorking_hours().getEnd()))&&
//                (getSeconds(c2.getWorking_hours().getStart())<getSeconds(c1.getWorking_hours().getEnd()))){
//            workStart = getMax(getSeconds(c1.getWorking_hours().getStart()),getSeconds(c2.getWorking_hours().getStart()));
//            workEnd = getMin(getSeconds(c1.getWorking_hours().getEnd()),getSeconds(c2.getWorking_hours().getEnd()));
//        }
//
//
//        System.out.println(toUsualFormat(workStart));
//        System.out.println(toUsualFormat(workEnd));
//
//
//        System.out.println("meeting");
//
//
//    }


    public void getSolution(Calendar c1, Calendar c2){
        ArrayList<TimeStamps> meeting = new ArrayList<>();
        long tmpMax = getMax(getSeconds(c1.getWorking_hours().getStart()), getSeconds(c2.getWorking_hours().getStart()));
        long tmpMin = 0;
        long dif;
        int i = 0, j = 0;

        while (i<c1.getPlanned_meeting().size()&&j<c2.getPlanned_meeting().size()){
            System.out.println("i = "+ i +"   j = "+j);
            tmpMin = getMin(getSeconds(c1.getPlanned_meeting().get(i).getStart()),getSeconds(c2.getPlanned_meeting().get(j).getStart()));
            System.out.println("end1 "+c1.getPlanned_meeting().get(i).getEnd()+" end2: "+c2.getPlanned_meeting().get(j).getEnd());
            System.out.println("Max "+ toUsualFormat(tmpMax)+" Min "+ toUsualFormat(tmpMin));

            dif = tmpMin - tmpMax;


            if (dif/1800L>=1){
                TimeStamps timeStamps = new TimeStamps();
                timeStamps.setStart(toUsualFormat(tmpMax));
                timeStamps.setEnd(toUsualFormat(tmpMin));
                meeting.add(timeStamps);
            }
            else              {
                int ii = i-1, jj= j-1;
                System.out.println("HELOOO "+ ii+" HII "+ jj);
                if (getSeconds(c1.getPlanned_meeting().get(i).getStart())<
                        getSeconds(c2.getPlanned_meeting().get(j).getStart())){
                    System.out.println("-j");
                    j--;
                }
                else {
                    System.out.println("-i");
                    i--;
                }
            }

            System.out.println(meeting);
            if (i<0)
                tmpMax = getMax(getSeconds(c1.getWorking_hours().getStart()), getSeconds(c2.getPlanned_meeting().get(j).getEnd()));
            else if (j<0)
                tmpMax = getMax(getSeconds(c2.getWorking_hours().getStart()), getSeconds(c1.getPlanned_meeting().get(i).getEnd()));
            else
                tmpMax = getMax(getSeconds(c1.getPlanned_meeting().get(i).getEnd()), getSeconds(c2.getPlanned_meeting().get(j).getEnd()));

            if (i<(c1.getPlanned_meeting().size()))
            i++;
            if (j<(c2.getPlanned_meeting().size()))
            j++;

        }
        System.out.println("Max "+ toUsualFormat(tmpMax)+" Min "+ toUsualFormat(tmpMin));
       // tmpMax
                tmpMin = getMin(getSeconds(c1.getWorking_hours().getEnd()), getSeconds(c2.getWorking_hours().getEnd()));

        dif = tmpMin - tmpMax;

        if (dif/1800L>=1){
            TimeStamps timeStamps = new TimeStamps();
            timeStamps.setStart(toUsualFormat(tmpMax));
            timeStamps.setEnd(toUsualFormat(tmpMin));
            meeting.add(timeStamps);
        }
        System.out.println(meeting);


    }







//        long tmpMin = getMin(getSeconds(c1.getPlanned_meeting().get(0).getStart()),getSeconds(c2.getPlanned_meeting().get(0).getStart()));
//        System.out.println("Max "+ tmpMax+" Min "+ tmpMin);
//
//        long dif = tmpMin - tmpMax;
//        if (dif/1800L>=1){
//            TimeStamps timeStamps = new TimeStamps();
//            timeStamps.setStart(String.valueOf(tmpMax));
//            timeStamps.setEnd(String.valueOf(tmpMin));
//            meeting.add(timeStamps);
//        }
//        for (int i = 0; i < c1.getPlanned_meeting().size()-1;i++){
//             tmpMax = getMax(getSeconds(c1.getPlanned_meeting().get(0).getEnd()), getSeconds(c2.getPlanned_meeting().get(0).getEnd()));
//             tmpMin = getMin(getSeconds(c1.getPlanned_meeting().get(i+1).getStart()),getSeconds(c2.getPlanned_meeting().get(i+1).getStart()));
//            dif = tmpMin - tmpMax;
//            if (dif/1800L>=1){
//                TimeStamps timeStamps = new TimeStamps();
//                timeStamps.setStart(String.valueOf(tmpMax));
//                timeStamps.setEnd(String.valueOf(tmpMin));
//                meeting.add(timeStamps);
//            }
//            System.out.println("Max "+ tmpMax+" Min "+ tmpMin);}
//    }

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
