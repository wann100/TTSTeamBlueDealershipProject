package TTS.TeamBlue.Dealership.Classes;

import java.util.Timer;
import java.util.TimerTask;
import TTS.TeamBlue.Dealership.Classes.DepartmentLogin;

//function to countdown the time until the customer is served by the sales Rep
public class CountdownTimer {
		static int interval; 
		static Timer timer;
		
		public static void timer(int queuePosition) {
			
			if (queuePosition > 0) {
				int waitTime = queuePosition * 5; //multiplies the queue position by 5 get the total number of seconds the customer will wait
			    int delay = 1000; //how many milliseconds to delay the start of the count down
			    int period = 1000; //how many milliseconds between countdown elements
			    timer = new Timer(); //instantiating a new Timer object 
			    interval = waitTime;
			    System.out.println("\nYOU WILL BE SERVED IN:");
			    System.out.print(waitTime); //prints the overall wait time in seconds
			    timer.scheduleAtFixedRate(new TimerTask() {

			        public void run() {
			            System.out.print(", " + setInterval());

			        }
			    }, delay, period);
			    
			} else {
				System.out.println("\nNot a valid Queue Postion");
			}
		
		}
		
		//cancels the countdown at 1 and returns 0
		private static final int setInterval() {
		    if (interval == 1)
		        timer.cancel();
		    return --interval;
		}

		
		
}
