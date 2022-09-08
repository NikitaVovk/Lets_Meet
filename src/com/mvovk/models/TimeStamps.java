package com.mvovk.models;

public class TimeStamps {
    private  String start;
   private String end;


//   public long getSeconds (String time){
//        long timeSec;
//        timeSec = Integer.parseInt(time.split(":")[0])* 3600L +Integer.parseInt(time.split(":")[1])* 60L;
//        return timeSec;
//    }

    public String getStart() {
        return start;
    }

    public long getStartSec() {
        long timeSec;
        timeSec = Integer.parseInt(start.split(":")[0])* 3600L +Integer.parseInt(start.split(":")[1])* 60L;
        return timeSec;
    }
    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }
    public long getEndSec() {
        long timeSec;
        timeSec = Integer.parseInt(end.split(":")[0])* 3600L +Integer.parseInt(end.split(":")[1])* 60L;
        return timeSec;
    }


    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TimeStamps{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
