import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    Student(int faculty, int specialty, int week, int day){
        this.faculty = faculty;
        this.specialty = specialty;
        this.week = week;
        this.day = day;
        switch (faculty){
            case 1:{
                this.allPairs =  XML.parsePairs("IPZ_Pairs.xml");
                break;
            }
            case 2:{
                this.allPairs =  XML.parsePairs("FEN_Pairs.xml");
                break;
            }
        }
        assert allPairs != null;
        Collections.sort(allPairs);
        myPairs = new ArrayList<>();
        chooseMyDisciplines();
    }

    //in this method you choose your disciplines and groups to them
    private void chooseMyDisciplines(){
        ArrayList<Pair> pairsAll = getDisciplines();
        Collections.sort(pairsAll);
        ArrayList<Pair> pairs = chooseDisciplines(pairsAll);
        chooseGroups(pairs);
    }

    //this method returns a list of all disciplines available to you (no repetitions)
    private ArrayList<Pair> getDisciplines(){
        ArrayList<Pair> set = new ArrayList<>();
        for(Pair pair: allPairs){
            if(pair.getGroup().equals("Лекція")){
                if(this.faculty == 2){
                    if(checkIfThisIsMyDiscipline(pair)){
                        if(!repetition(set, pair)) set.add(pair);
                    }
                }else set.add(pair);
            }
        }
        return set;
    }

    //with the help of a regular expression, the method checks whether this discipline is suitable for your specialty
    private boolean checkIfThisIsMyDiscipline(Pair pair){
        switch (specialty){
            case 1:{
                return checkDescipline(pair, "(.ек.)");
            }
            case 2:{
                return checkDescipline(pair, "(.фін.)");
            }
            case 3:{
                return checkDescipline(pair, "(.мен.)");
            }
            case 4: {
                return checkDescipline(pair, "(.мар.)");
            }
        }
        return false;
    }

    //the method checks whether the given discipline already exists in the given list
    private boolean repetition(ArrayList<Pair> set, Pair pair) {
        for(int i = 0; i < set.size(); i++){
            if(set.get(i).getDisciplin().equals(pair.getDisciplin())) return true;
        }
        return false;
    }

    //with the help of a regular expression, the method checks whether this discipline is suitable for your specialty
    private boolean checkDescipline(Pair pair, String s){
        StringBuilder str = new StringBuilder();
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(pair.getDisciplin());
        while (matcher.find()) {
            str.append(pair.getDisciplin().substring(matcher.start(), matcher.end()));
        }
        if(!str.isEmpty()) return true;
        else if(!pair.getDisciplin().contains("(")) return true;
        else return false;
    }


    //with this method you choose your disciplines
    private ArrayList<Pair> chooseDisciplines(ArrayList<Pair> pairsAll){
        ArrayList<Pair> pairs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        System.out.println();
        System.out.println("Виберіть дисципліни:");
        do {
            displayListOfDisciplines(pairsAll);
            System.out.println("Для закінчення вибору дисциплін натисніть  -->  -1");
            do{
                num = scanner.nextInt();
                if(num == -1) break;
            }while(num < 1 || num > pairsAll.size());
            if(num == -1) break;
            pairs.add(pairsAll.get(num - 1));
            myPairs.add(pairsAll.get(num - 1));
            pairsAll.remove(num - 1);
            System.out.println();
        }while(!pairsAll.isEmpty());
        return pairs;
    }

    //displays all selected disciplines
    private void displayListOfDisciplines(ArrayList<Pair> pairs){
        for(int i = 1; i <= pairs.size(); i++){
            System.out.println(pairs.get(i - 1).getDisciplin() + "  -->  " + i);
        }
    }


    //with this method you select groups for previously selected disciplines and add practices to the general list of your pairs
    private void chooseGroups(ArrayList<Pair> pairs) {
        for(Pair p: pairs){
            ArrayList<Pair> pairsAll = new ArrayList<>();
            for(Pair pair: allPairs){
                if(searchDiscipline(pair, p)){
                    pairsAll.add(pair);
                }
            }
            myPairs.addAll(chooseGroupForDiscipline(pairsAll));
        }
    }

    //
    private boolean searchDiscipline(Pair pair, Pair p){
        if(pair != p && p.getDisciplin().toLowerCase().equals(pair.getDisciplin().toLowerCase())){
            if(!pair.getGroup().equals("Лекція")) return true;
        }
        return false;
    }

    //with this method, you select groups for previously selected disciplines
    private ArrayList<Pair> chooseGroupForDiscipline(ArrayList<Pair> pairs){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Виберіть групу:");
        Collections.sort(pairs);
        int n = displayListOfGroups(pairs);
        int num = 0;
        do{
            num = scanner.nextInt();
        }while(num < 1 || num > n);
        System.out.println();
        ArrayList<Pair> pairGroup = new ArrayList<>();
        for(int i = 0; i < pairs.size(); i++){
            if(Integer.parseInt(pairs.get(i).getGroup()) == num) pairGroup.add(pairs.get(i));
        }
        return pairGroup;
    }

    //this method returns a list of all existing groups for the given discipline
    private int displayListOfGroups(ArrayList<Pair> pairs){
        System.out.println(pairs.get(0).getDisciplin());
        HashSet<Integer> groups =new HashSet<>();
        for(int i = 0; i < pairs.size(); i++){
            groups.add(Integer.valueOf(pairs.get(i).getGroup()));
        }
        int i = 1;
        for(Integer group: groups){
            System.out.println("Група " + group + "  -->  " + i);
            i++;
        }
        return i;
    }

    public String getDay(int i){
        switch (i){
            case 1: return "Понеділок";
            case 2: return "Вівторок";
            case 3: return "Середа";
            case 4: return "Четвер";
            case 5: return "П'ятниця";
            case 6: return "Субота";
        }
        return "";
    }



    public int getFaculty() { return faculty;}
    public int getSpecialty() { return specialty;}
    public ArrayList<Pair> getMyPairs() { return myPairs;}
    public int getWeek() { return week;}
    public int getDay() { return day;}


    public void setFaculty(int faculty) {this.faculty = faculty;}
    public void setSpecialty(int specialty) { this.specialty = specialty;}
    public void setMyPairs(ArrayList<Pair> pairs) { this.myPairs = pairs;}
    public void setWeek(int week) { this.week = week;}
    public void setDay(int day) { this.day = day;}

    private int faculty;
    private int specialty;
    private ArrayList<Pair> myPairs;
    private ArrayList<Pair> allPairs;
    private int week;
    private int day;
}
