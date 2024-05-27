package main;

import java.util.LinkedList;
import java.util.Queue;

public class semAssign {

        static Queue<Process> AssignQueue = new LinkedList<Process>();
        static SemValues value = SemValues.Zero ;
		//static Process p = new Process();
		
		 public static void semAssignWait() {
		    Process p = new Process();
			if (value == SemValues.One ) {  //AssignQueue.isEmpty()
				p.setState(ProcessState.RUNNING);
				value = SemValues.Zero;
				System.out.println("semAssignwait:Process is now running");
			}
			else{
			
		
			p.setState(ProcessState.WAITING);
			AssignQueue.add(p);
			System.out.println("SemAssignWait:Process is now blocked, waiting to for the resource and added to the Queue Assign");
			}
			} 
		 
		 public static void  semAssignPost() {
			 Process p = new Process();//
			 if ( value == SemValues.Zero) //AssignQueue.isEmpty()
				 value = SemValues.One;
				 else {
				AssignQueue.remove(p);
				p.setState(ProcessState.READY);
				System.out.println("SemAssignPost:Process is now Ready, waiting to be executed and added");	
				
				//OperatingSystem.ReadyList.add(p);
				
				 }
				 }
		
		
	}


