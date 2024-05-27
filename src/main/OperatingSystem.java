package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class OperatingSystem  {
	
	static Queue<Process> ReadyList = new LinkedList<Process>();
	static Queue<Process> newQueue = new LinkedList<Process>();
	static Queue<Process> priorityLow = new LinkedList<Process>();
	static Queue<Process> priorityMedium = new LinkedList<Process>();
	static Queue<Process> priorityHigh = new LinkedList<Process>();
	
	//----------------------------------------//
	public static Queue<Process> getReadyList() {
		return ReadyList;
	}
	public static void setReadyList(Queue<Process> readyList) {
		ReadyList = readyList;
	}
	
	//----------------------------------------------//
	//PROGRAM SYNTAX
	public static String writeFile (String filename, String data ){
		try{
		int i =0;
		FileWriter writer = new FileWriter(filename);
		writer.write(data);
		writer.close();
		System.out.println(i++);
		}
		catch (IOException execption){
			System.out.println("Input/output error" + execption);
		}
		return data;
		
	}
	
	public static String readFile (String filename) {
		String filedata = "";
		int i =0;
		try{
		File file = new File (filename);
		Scanner scan = new Scanner (file);
		while (scan.hasNextLine()){
			filedata = filedata.concat(scan.nextLine() );
			System.out.println(i++);
		}
		
	}
		catch (IOException execption){
			System.out.println("Input/output error" + execption);
		}
		finally{
			return filedata;
		}
		}
	
	
	public static String assign(){
		Scanner sc = new Scanner(System.in);
		String y = sc.nextLine();
		return y;
	
	}
	
	public static  void print (Object x){
		System.out.println(x);
	}
	//--------------------------------------------------//
	//TODO
	public static void  createProcess(){
		int count =0;
		int priority1 = 0;
		 int pid = 0;
//		 while(count<3){
//		  priority1 = (int)Math.random()*3 +1;
//		 }
		 Process P1 = new Process (pid++ , ProcessState.NEW, (int)Math.random()*3 +1, "");
		 System.out.println(P1);
		 System.out.println(P1.getStatus());
		 System.out.println(P1.getPriorityProcess());
		 ReadyList.add(P1);
		 newQueue.add(P1);
		 
//		// int priority2 = (int)Math.random()*3 +1;
//		 Process P2 = new Process (pid++ , ProcessState.NEW, priority2, "Process B");
//		 System.out.println(P2);
//		 System.out.println(P2.getStatus());
//		 System.out.println(P2.getPriorityProcess());
//		 ReadyList.add(P2);
//		 newQueue.add(P2);
		 
		 System.out.println(ReadyList);
		 
//		 
		// return P1;
		 
		 
	}
	//--------------------------------------------------//
	
	public static void Scheduler_RR(){
	
		long start = System.currentTimeMillis();
		long timeSlice =  start+1*100;
 
		while (!(ReadyList.isEmpty() )){
			if (ReadyList.peek().getStatus() == ProcessState.TERMINATED){
				ReadyList.remove(ReadyList.peek());	
				System.out.println("Process is terminated so won't run");
			}
			else 
			//if (ReadyList.peek().getName1() == "Process A"){	
			 while(System.currentTimeMillis()<timeSlice){
				 ReadyList.peek().resume();
				 //  ReadyList.peek().start();
				   Process.processA();
				   System.out.println("Process no 1 is executing");
				   ReadyList.add(ReadyList.peek());
				   
			 }
			 break;
			//}
			
//			 //if (ReadyList.peek().getName1() == "Process B"){
//				while(System.currentTimeMillis()<timeSlice){
//					 ReadyList.peek().resume();
//					   Process.processB();
//					   System.out.println("Process no 1 is executing");
//					   ReadyList.add(ReadyList.peek());
//					   
//				 }	
//			 }
//			break;
			 
		}
		ReadyList.peek().suspend();
		ReadyList.peek().interrupt();
		System.out.println("Done executing");
		 
		}
		 
	
	
	//------------------------------------------------------//
	
	public static void Scheduler_FCFS(){
		while (!ReadyList.isEmpty()){
			if (ReadyList.peek().getStatus() == ProcessState.TERMINATED){
				ReadyList.remove(ReadyList.peek());	
				System.out.println("Process is terminated so won't run");
			}
			else 
			{
				while (!(ReadyList.peek().interrupted())){
			  	ReadyList.peek().resume();
			  	Process.processA();
			  	System.out.println("Process is executing");
			  	System.out.println(ReadyList);
			  
			  	break;
				}
				
	   	ReadyList.peek().stop();
		ReadyList.remove(ReadyList.peek());
	   	System.out.println("Process is done executing");
		//ReadyList.peek().setState(ProcessState.TERMINATED);
		
			}
			}
	}
//			while (!ReadyList.peek().interrupted()){
//			  	ReadyList.peek().run();
//			  	Process.processB();
//			  
//			  	System.out.println("Process is executing");
//			  	System.out.println(ReadyList);
//				}
//				ReadyList.peek().interrupt();
//				break;
//			}
		
	
	
	//------------------------------------------------------//

	public static void  Scheduler_MLQS(){
		
		if (ReadyList.peek().getPriorityProcess() == 1){
			priorityHigh.add(ReadyList.peek());
			System.out.println("Process is in High level queue now  ");
			Scheduler_FCFS();
		}
		else if (ReadyList.peek().getPriorityProcess() == 2){
			priorityMedium.add(ReadyList.peek());
			System.out.println("Process is in Medium level queue now  ");
			Scheduler_FCFS();
		}
		else if (ReadyList.peek().getPriorityProcess() == 3){
			priorityLow.add(ReadyList.peek());
			System.out.println("Process is in low level queue now  ");
			Scheduler_FCFS();
		}
	}
	
	//------------------------------------------------------//

	public static void main(String[] args) throws IOException{
	    
	    createProcess();
	    createProcess();
		//System.out.println(writeFile("C:/Users/LenOvo/Desktop/koko" , ""));
		//Process.processA();
	  
	}
}
