package main;

import java.util.LinkedList;
import java.util.Queue;

public class semRead {
	static Queue<Process> ReadQueue = new LinkedList<Process>();
	static SemValues value = SemValues.One ;
	static Process p = new Process();
	
	 public static void semReadWait( ) {
			if (value == SemValues.One ) {
				p.setState(ProcessState.RUNNING);
				value = SemValues.Zero;
				System.out.println("semReadwait:Process is now running");
			}
			else{
			ReadQueue.add(p); 
			p.setState(ProcessState.WAITING);
			System.out.println("SemReadWait:Process is now blocked, waiting to for the resource and added to the Queue Read");
			
			}
			} 
		 
		 public static void  semReadPost() {
			 if (value == SemValues.Zero)
				 value = SemValues.One;
				 else {
					 ReadQueue.remove(p);
				p.setState(ProcessState.READY);
				System.out.println("SemReadPost:Process is now Ready, waiting to be executed and added");	
				//OperatingSystem.ReadyList.add(p);
				
				 }
				 }
		
	
}
	
	
	
	
	
//	 public void semReadWait( Semaphore s) {
//		 s.countR--;
//		 if (s.countR < 0) {
//			 s.waitingQueue.add(A);
//			 A.setState(ProcessState.WAITING);
//	
//		 }
//	 }
//	
//	
//	 public void  semReadPost(Semaphore s) {
//		 s.countR++;
//		 if (s.countR <= 0) {
//			s.waitingQueue.remove(A);
//			A.setState(ProcessState.READY);
//			s.ReadyList.add(A);
//			
//			 }
//			 }
	
//	 public void semReadWait( Mutex m) {
//	
//		 if (m.mutexValue == SemValues.One) {
//			 m.ownerID = Process.getPID();
//			 m.mutexValue = SemValues.One;
//			 } else {
//				 m.queue.add(A);
//				 A.setState(ProcessState.WAITING);
//			 }
//			 }
//	
//	
//	 void semSignalB(Mutex m) {
//		
//		 if (m.ownerID == Process.getPID()&& m.queue.isEmpty() ) 
//		 m.mutexValue = SemValues.One ;
//		 
//		 else {
//			 m.queue.remove(A);
//				A.setState(ProcessState.READY);
//				m.ReadyList.add(A);
//		       m.setOwnerID(Process.getPID());
//
//		 }
//		 }
//		 }
//	
//	
	
	
	
	

