package main;
//package main;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Handlers {
//
//	private static StackObj StackMemory; 
//	private static DiskState status = DiskState.BUSY ;
//	private static ProcessState state;
//
//	
//	public Handlers(int size ) {
//		 size= 10;
//		StackMemory = new StackObj(size);
//	
//	}
//
//	
//	
//	public static Events generateRandomEvent() {
//		int e = new Random().nextInt(Events.values().length);
//		return Events.values()[4];// ashan ytl3 random event
//	}
//	
//	public static DiskOperations generateRandomOperation() {
//		int operation = new Random().nextInt(DiskOperations.values().length);
//		return DiskOperations.values()[operation];// ashan ytl3 random operation
//	}
//	
//	
//
//	public static  void handling (){ 
//		
//		if ( generateRandomEvent() == Events.KEYPRESS){
//			KeyPress();
//		}
//		if ( generateRandomEvent() == Events.DISKCONTROLLER){
//			Object value = null;
//			DiskController();
//		}
//		if (generateRandomEvent() == Events.HEAP){
//			ReqHeap();
//		}
//		if (generateRandomEvent() == Events.DIVZERO ){
//		
//			state = ProcessState.TERMINATED;
//			System.out.println("Process is terminated");
//			
//		}
//		if (generateRandomEvent() == Events.PRIVMEM){
//			privMem();
//		}
//			
//	}
//	
//	
//	
//	
//	
//		
//	
//	// METHOD FOR KEYPRESS
//	public static void KeyPress() {
//		//StackObj temp = new StackObj(50);  
//		Scanner sc = new Scanner(System.in);
//		char c = sc.next().charAt(0); //
//		
////		while (!StackMemory.isFull()) { 
////			for (int i = (int) StackMemory.top(); i>=StackMemory.size()/2 ; i--){
////				temp.push(StackMemory.pop());
////				temp.push(c);
////			}			
////			StackMemory.push(temp.pop());	
////		}
//		System.out.println(c);
//	}
//	
//	
//	//METHOD FOR DISK CONTROLLER
//	public static void DiskController (){
//		Scanner value = new Scanner(System.in);
//		
//		 if (value.hasNextInt()){
//			int decimal= value.nextInt();
//			Integer.toBinaryString(decimal); 
//			String lol = Integer.toBinaryString(decimal);
//			status = DiskState.BUSY; 
//			state = ProcessState.RUNNING;
//			System.out.println(lol);
//			System.out.println("Disk state is now busy reading the input values, and the process is running");
//		}
//			else if(value.hasNextLine()){
//				status = DiskState.IDLE; 
//				state = ProcessState.BLOCKED;
//				System.out.println("Disk state is now idle, reading the string but no action is taken, and the process is waiting");
//			}
//		
//		System.out.println(generateRandomOperation());	
//		
//
//	}
//	
//	
//	//METHOD FOR MORE HEAP
//	public static  Object ReqHeap (){  
//		//TODO if the stack is full -->  NO request more heap 
//		Object value = null;
//		Object current = null;
//		StackObj temp = new StackObj(StackMemory.size());
//			while (!StackMemory.isEmpty()){  
//					if ( StackMemory.top() == value ){
//						temp.push(StackMemory.pop()); 
//					}					
//					else
//					current = StackMemory.top(); //Empty space in the stack is found 
//					 //ta2lel men size el stack 
//		}
//			while (!temp.isEmpty()){
//				StackMemory.push(temp.pop());
//				}
//			return current;//the heap am going to return
//			// TODO sop el size el gded after ma bt2lilii 
//			//TODO you need to decide law fe makan msh fadii inside the stack w oulyy le mien (plus : inside the stack fl main) assign 
//	}
//	
//	
//	//METHOD FOR DIVZERO
////	public static void divzero (Process p, int pid){
////		state= ProcessState.TERMINATED;  //terminated
////		p.setPID(pid);  //changing the pid by a new pid
////	
////	}
////	
//	
//	//METHOD FOR PRIVMEMORY
//	public static  Object privMem (){
//		StackObj temp = new StackObj(StackMemory.size()/2);
//		boolean attempt = false;
//		Object current = null;
//		// TODO instanceof --> enti fahma dw
//		while (!StackMemory.isEmpty()){
//		for (int i =  10 ; i>=5 ; i--){
//			temp.push(StackMemory.pop()); //I sent the non-priv to a temp stack
//		}
//		}
//			for (int j = 0 ; j<StackMemory.size()/2; j++){ // am accessing the priv
//			   	if (attempt == true){ //either from user aw not user
//			   		current = temp.top(); // ana 3ayza a return non-priv (reallocating)
//		
//			   	}
//			}
//			while (!temp.isEmpty()){
//			StackMemory.push(temp.pop());
//			}
//		return current;  
//	}
//	
//	
//	
//	//MAIN METHOD
//	
//	public static void main(String[] args) {
//		Handlers h = new Handlers (10);
//	
//		StackMemory.push(123);
//		StackMemory.push(35);
//		StackMemory.push(14);
//		StackMemory.push(2);
//		StackMemory.push(14);
//		StackMemory.push(13);
//		StackMemory.push(13);
//		StackMemory.push(13);
//		StackMemory.push(13);
//		StackMemory.push(13);
//		
//		System.out.println(generateRandomEvent());
//		handling();
//
//		
//		
//		
//	}
//}
