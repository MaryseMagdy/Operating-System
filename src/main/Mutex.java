package main;

import java.util.Queue;

public class Mutex {

	SemValues mutexValue;
	Queue <Process> queue;
	int ownerID;
	boolean available;
	Queue<Process> ReadyList;
	
	
	
	public int getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	
	
	
	
//	public void acquire() {
//		while (!available)
//		 /* busy wait */
//		available = false;;
//		}

}
