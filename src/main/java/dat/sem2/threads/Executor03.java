package dat.sem2.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 The purpose of Executor03 is to...

 @author kasper
 */
public class Executor03 {

    public static void main( String[] args ) {
        //ExecutorService workingJack = Executors.newSingleThreadExecutor();
        ExecutorService workingJack = Executors.newFixedThreadPool( 4);
        System.out.println( "Main starts" );


        for ( int count = 0; count < 25; count++ ) {
            Runnable task = new MyTask( count, "aaa" );
            workingJack.submit( task );
        }
        System.out.println( "Main is done" );
        workingJack.shutdown();
    }

}

class MyTask implements Runnable {

    char [] bogstaver = "abcdefghijklmnopqrstuvxyz".toCharArray();

    private int count = 0;
    private String s;


    MyTask( int cnt, String p ) {

        count = cnt;
        s = p;
    }

    @Override
     public void run() {
        System.out.println( "Task: " + count + " " + bogstaver[count]+bogstaver[count]+bogstaver[count] );
    }
}
