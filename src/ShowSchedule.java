import java.util.ArrayList;
import java.util.Collections;

public class ShowSchedule {

    ShowSchedule(Student student){
        this.student = student;
        this.week = student.getWeek();
        this.day = student.getDay();
    }

    public void showTodaySchedele(){
        System.out.println("Розклад занять на Сьогодні");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == day){
                if(isCorrectWeek(pair)){
                   pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showMondaySchedele(){
        System.out.println("Розклад занять на Понеділок");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 1){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showTuesdaySchedele(){
        System.out.println("Розклад занять на Вівторок");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 2){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showWednesdaySchedele(){
        System.out.println("Розклад занять на Середу");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 3){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showThursdaySchedele(){
        System.out.println("Розклад занять на Четвер");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 4){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showFridaySchedele(){
        System.out.println("Розклад занять на П'ятницю");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 5){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showSaturdaySchedele(){
        System.out.println("Розклад занять на Суботу");
        ArrayList<Pair> pairs = new ArrayList<>();

        for(Pair pair : student.getMyPairs()){
            if(pair.getDay() == 6){
                if(isCorrectWeek(pair)){
                    pairs.add(pair);
                }
            }
        }
        Collections.sort(pairs);
        showDisciplines(pairs);
    }

    public void showWeekSchedele(){
       for(int i = 1; i <= 6; i++){
           showSheldueByDayNumber(i);
       }
    }

    public void showSheldueByDayNumber(int i){
        switch (i){
            case 1:{
                showMondaySchedele();
                break;
            }
            case 2:{
                showTuesdaySchedele();
                break;
            }
            case 3:{
                showWednesdaySchedele();
                break;
            }
            case 4:{
                showThursdaySchedele();
                break;
            }
            case 5:{
                showFridaySchedele();
                break;
            }
            case 6:{
                showSaturdaySchedele();
                break;
            }
        }
    }

    public void showDisciplines(ArrayList<Pair> pairs){
        for(int i = 0; i < pairs.size(); i++)
            System.out.println(pairs.get(i));
    }

    private boolean isCorrectWeek(Pair pair) {
        if(pair.getWeek().contains(Integer.toString(week))) return true;
        if(pair.getWeek().contains("-")){
            String[] weeks = pair.getWeek().split("-");
            if(Integer.parseInt(weeks[0]) <= week && Integer.parseInt(weeks[1]) >= week) return true;
        }
        return false;
    }


    private Student student;
    private int week;
    private int day;
}
