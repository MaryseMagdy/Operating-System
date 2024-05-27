package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;

import main.OperatingSystem;

public class Process extends Thread{

	
	private static int PID;
	private ProcessState state;
	static private int PriorityProcess;
	static private String name;

	public  int getPriorityProcess() {
		return PriorityProcess;
	}

	public static void setPriorityProcess(int priorityProcess) {
		PriorityProcess = priorityProcess;
	}

	public Process(int pID, ProcessState state, int p, String n) {
		this.PID = pID;
		this.state = state;
		this.PriorityProcess= p;
		this.name = n;
	}
	
	public static String getName1() {
		return name;
	}

	public static void setName1(String name) {
		Process.name = name;
	}

	public Process (){
		
	}

	public static void  processA() {
		System.out.println("Please enter your filename");
		semAssign.semAssignWait();
		String filename = (String) OperatingSystem.assign();
		semAssign.semAssignPost();
		
		semRead.semReadWait();
		OperatingSystem.readFile(filename);
		semRead.semReadPost();
		
		semPrint.semPrinteWait();
		OperatingSystem.print(OperatingSystem.readFile(filename));
		semPrint.semPrintPost();
	}

	public static void processB() {
        
		
		semAssign.semAssignWait();
		System.out.println("Please enter your filename");
		String filename2 = (String) OperatingSystem.assign();
		System.out.println("Please enter your data to be written in the new file");
		String data2 = (String) OperatingSystem.assign();
		semAssign.semAssignPost();
		
		semWrite.semWriteWait();
		OperatingSystem.writeFile(filename2, data2); 
		semWrite.semWritePost();
		
		semPrint.semPrinteWait();
		OperatingSystem.print(OperatingSystem.readFile(filename2));
		semPrint.semPrintPost();
	}

	public static int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	
	public ProcessState getStatus() {
		return state;
	}

	public void setState(ProcessState state) {
		this.state = state;
	}

	public static void main(String[] args)  {
		Process p = new Process();

	

	}


}
