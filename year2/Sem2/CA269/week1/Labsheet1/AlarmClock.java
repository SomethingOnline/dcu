import java.util.Scanner;

public class AlarmClock{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        int alarmHour = input.nextInt();
        int alarmMin = input.nextInt();

        if (alarmHour > 24 || alarmMin > 59){
            alarmHour = input.nextInt();
            alarmMin = input.nextInt();
        }

        int currHour = input.nextInt();
        int currMin = input.nextInt();
        int alarmCount = 0;

        while(true){
            if (currHour > 24 || currMin > 59){
                currHour = input.nextInt();
                currMin = input.nextInt();
            }
            if ((currHour < alarmHour) || (currHour == alarmHour && currMin < alarmMin)){
                currHour = input.nextInt();
                currMin = input.nextInt();
                alarmCount++;
            }
            else{
                break;
            }
        }

        System.out.println("false alarms: " + alarmCount);
    }
}