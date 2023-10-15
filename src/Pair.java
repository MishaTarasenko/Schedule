public class Pair implements Comparable<Pair>{

    Pair(String group, String disciplin, String teacher, int day, String time, String week, String audience){
        this.group = group;
        this.disciplin = disciplin;
        this.teacher = teacher;
        this.day = day;
        this.time = time;
        this.week = week;
        this.audience = audience;
    }

    Pair(){}

    @Override
    public int compareTo(Pair that) {
        int time1 = Integer.parseInt(this.time.split(":")[0]);
        int time2 = Integer.parseInt(that.time.split(":")[0]);
        if(that.day > this.day) return -1;
        else if (that.day < this.day) return 1;
        if(time2 > time1) return -1;
        else if(time2 < time1) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return time + "  " + disciplin + '\n' + teacher  + " " +  group + " (" + audience + ")" + '\n';
    }

    public String getDisciplin() {
        return disciplin;
    }
    public String getTeacher() {
        return teacher;
    }
    public int getDay() {
        return day;
    }
    public String getTime() {
        return time;
    }
    public String getGroup() {
        return group;
    }
    public String getWeek() {
        return week;
    }
    public String getAudience() {
        return audience;
    }


    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void setWeek(String weekEnd) {
        this.week = weekEnd;
    }
    public void setAudience(String audience) {
        this.audience = audience;
    }


    private String disciplin;
    private String teacher;
    private int day;
    private String time;
    private String group;
    private String week;
    private String audience;
}

