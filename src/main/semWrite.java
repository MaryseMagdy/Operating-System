package main;

import java.util.LinkedList;
import java.util.Queue;


public class semWrite {
	static SemValues value = SemValues.One ;
	static Queue<Process> WriteQueue = new LinkedList<Process>();
	static Process p = new Process();
	
	 public static void semWriteWait( ) {
			if (value == SemValues.One ) {
				p.setState(ProcessState.RUNNING);
				value = SemValues.Zero;
				System.out.println("semWritewait:Process is now running");
			}
			else{
				WriteQueue.add(p); //add here 
			p.setState(ProcessState.WAITING);
			System.out.println("SemReadWait:Process is now blocked, waiting to for the resource and added to the Queue Write");
			
			}
			} 
		 
		 public static void  semWritePost() {
			 if (WriteQueue.isEmpty())
				 value = SemValues.One;
				 else {
				WriteQueue.remove(p);
				p.setState(ProcessState.READY);
				System.out.println("SemWritePost:Process is now Ready, waiting to be executed and added");	
				//OperatingSystem.ReadyList.add(p);
				
				 }
				 }
		
	
}