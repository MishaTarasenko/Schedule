import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        chooseFaculty(scanner);

        chooseSpecialty(scanner);

        inputWeekAndDay();

        studentSchedule();
    }


    private static void chooseFaculty(Scanner scanner){
        do{
            System.out.println("Виберіть свій факультет: ");
            System.out.println("ФІ --> 1");
            System.out.println("ФЕН --> 2");
            faculty = scanner.nextInt();
        }while(faculty < 0 || faculty > 2);
    }

    private static void chooseSpecialty(Scanner scanner){
        if(faculty == 1){
            do{
                System.out.println("Виберіть свою спеціальність: ");
                System.out.println("Інженерія програмного забезпечення --> 1");
                specialty = scanner.nextInt();
            }while(specialty < 0 || specialty > 1);
        }else{
            do{
                System.out.println("Виберіть свою спеціальність: ");
                System.out.println("Економіка --> 1");
                System.out.println("Фінанси, банківська справа, страхування та фондовий ринок  --> 2");
                System.out.println("Менеджмент  --> 3");
                System.out.println("Маркетинг  --> 4");
                specialty = scanner.nextInt();
            }while(specialty < 0 || specialty > 4);
        }
    }

    private static void inputWeekAndDay() {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Введіть тиждень навчання  -->  ");
            week = scanner.nextInt();
            System.out.println();
        }while (week < 1 || week > 14);

        do{
            System.out.println("Понеділок --> 1");
            System.out.println("Вівторок --> 2");
            System.out.println("Середа --> 3");
            System.out.println("Четвер --> 4");
            System.out.println("П'ятниця --> 5");
            System.out.println("Субота --> 6");
            System.out.println("Введіть день тижня(навчального)  -->  ");
            day = scanner.nextInt();
            System.out.println();
        }while (day < 1 || day > 6);
    }

    private static void studentSchedule(){
        Student student = new Student(faculty, specialty, week, day);
        ShowSchedule showSchedule = new ShowSchedule(student);
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        do{
            System.out.println("Розклад");
            System.out.println("На тиждень --> 1");
            System.out.println("На сьогодні --> 2");
            System.out.println("На Понеділок --> 3");
            System.out.println("На Вівторок --> 4");
            System.out.println("На Середу --> 5");
            System.out.println("На Четвер --> 6");
            System.out.println("На П'ятницю --> 7");
            System.out.println("На Суботу --> 8");
            num = scanner.nextInt();
            if(num == -1) break;

            switch (num){
                case 1:{
                    showSchedule.showWeekSchedele();
                    break;
                }
                case 2:{
                    showSchedule.showTodaySchedele();
                    break;
                }
                case 3:{
                    showSchedule.showMondaySchedele();
                    break;
                }
                case 4:{
                    showSchedule.showTuesdaySchedele();
                    break;
                }
                case 5:{
                    showSchedule.showWednesdaySchedele();
                    break;
                }
                case 6:{
                    showSchedule.showThursdaySchedele();
                    break;
                }
                case 7:{
                    showSchedule.showFridaySchedele();
                    break;
                }
                case 8:{
                    showSchedule.showSaturdaySchedele();
                    break;
                }
            }
        }while(true);
    }



    private static int faculty;
    private static int specialty;
    private static int week;
    private static int day;
}