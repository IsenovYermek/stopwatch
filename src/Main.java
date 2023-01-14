import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TimerState state = new TimerState();
        new TimerThread(state).start();
        new InputThread(state).start();
    }
}
class TimerState{
    int counter = 0;
    boolean isRunning = true;
    void increment(){
        System.out.println(counter ++);
    }
    void stopTimer(){
        isRunning = false;
    }
}
class TimerThread extends Thread{
    final TimerState state;
    TimerThread(TimerState state) {
        this.state = state;
    }
    @Override
    public void run() {
        super.run();
        try {
            while (state.isRunning){
                state.increment();
                sleep(1000);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class InputThread extends Thread {
    final TimerState state;
    InputThread(TimerState state) {
        this.state = state;
    }
    @Override
    public void run() {
        super.run();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s!= null){
            state.stopTimer();
        }
    }
}

