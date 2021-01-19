package bin.clock;

import java.util.Scanner;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        CurrentTime time = new CurrentTime();
        BinMap binar = new BinMap();
        Display frame = new Display(binar);
        CustomTime custom = new CustomTime();
        Scanner scan = new Scanner(System.in);

        int ans1 = 0;

        while (ans1 != 1 && ans1 != 2) {
            System.out.println("Chcete aktuálny čas (1) alebo nastaviť vlastný (2) ?");
            ans1 = scan.nextInt();
        }

        int finalAns1 = ans1;

        int ansHod = 100;
        int ansMin = 100;
        int ansSec = 100;

        if (finalAns1 == 2) {
            while (ansHod > 23 || ansHod < 0) {
                System.out.println("Zadajte počet hodín: ");
                ansHod = scan.nextInt();
            }
            while (ansMin > 59 || ansMin < 0) {
                System.out.println("Zadajte počet minút: ");
                ansMin = scan.nextInt();
            }
            while (ansSec > 59 || ansSec < 0) {
                System.out.println("Zadajte počet sekúnd: ");
                ansSec = scan.nextInt();
            }
        }


        custom.setCustomHod(ansHod);
        custom.setCustomMin(ansMin);
        custom.setCustomSec(ansSec);

        TimerTask clockTask = new TimerTask() {
            @Override
            public void run() {

                if (finalAns1 == 1) {

                    binar.setMap(time.getSeconds(), 4, 5);
                    binar.setMap(time.getMinute(), 2, 3);
                    binar.setMap(time.getHour(), 0, 1);


                } else {

                    binar.setMap(custom.getCustomSec(), 4, 5);
                    binar.setMap(custom.getCustomMin(), 2, 3);
                    binar.setMap(custom.getCustomHod(), 0, 1);

                }
                custom.increment();
                frame.update();
                frame.refresh();


            }
        };

        time.getTimer().scheduleAtFixedRate(clockTask, 1000, 1000);

    }
}
