package main;

import java.util.LinkedList;
import java.util.Queue;

public class semPrint {

	static Queue<Process> PrintQueue = new LinkedList<Process>();
	
	static SemValues value = SemValues.One ;
	static Process p = new Process();

		
		 public static void semPrinteWait() {
			if (value == SemValues.One ) {
				p.setState(ProcessState.RUNNING);
				value = SemValues.Zero;
				System.out.println("semPrintwait:Process is now running");
			}
			else{
			PrintQueue.add(p); //add here 
			p.setState(ProcessState.WAITING);
			System.out.println("SemReadWait:Process is now blocked, waiting to for the resource and added to the Queue Print");
			
			}
			} 
		 
		 public static void  semPrintPost() {
			 if (value == SemValues.Zero)
				 value = SemValues.One;
				 else {
				PrintQueue.remove(p);
				p.setState(ProcessState.READY);
				System.out.println("SemPrintPost:Process is now Ready, waiting to be executed and added");	
		        //OperatingSystem.ReadyList.add(p);
				
				 }
				 }
		
		
	}



	
	
	
	
	
	
	
	

