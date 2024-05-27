package main;
import java.util.Random;
import java.util.Scanner;

public class Handlers {

	private static Object [] Memory;
	private static DiskState status = DiskState.BUSY ;
	private static ProcessState state;
	
	public Handlers (int size)
	{
	Memory = new Object[20];
	}
	
	
	public static Events generateRandomEvent() {
	int e = new Random().nextInt(Events.values().length);
	return Events.values()[4];// ashan ytl3 random event
}

public static DiskOperations generateRandomOperation() {
	int operation = new Random().nextInt(DiskOperations.values().length);
	return DiskOperations.values()[operation];// ashan ytl3 random operation
}



public static  void handling (){ 
	
	if ( generateRandomEvent() == Events.KEYPRESS){
		KeyPress();
	}
	if ( generateRandomEvent() == Events.DISKCONTROLLER){
		DiskController();
	}
	if (generateRandomEvent() == Events.HEAP){
		ReqHeap();
	}
	if (generateRandomEvent() == Events.DIVZERO ){
	
		state = ProcessState.TERMINATED;
		System.out.println("Process is terminated");
		
	}
	if (generateRandomEvent() == Events.PRIVMEM){
		privMem();
	}
		
}


// METHOD FOR KEYPRESS
public static void KeyPress() {
	Scanner sc = new Scanner(System.in);
	char c = sc.next().charAt(0); 
	Memory[9] = c;
	System.out.println(c);	
}

//METHOD FOR DISK CONTROLLER
public static void DiskController (){
	Scanner value = new Scanner(System.in);

	 if (value.hasNextInt()){
		int decimal= value.nextInt();
		Integer.toBinaryString(decimal); 
		String lol = Integer.toBinaryString(decimal);
		System.out.println(lol);
		
		status = DiskState.BUSY; 
		state = ProcessState.RUNNING;
		System.out.println("Disk state is now busy reading the input values,"
				+ " and the process is running");
	}
		else if(value.hasNextLine()){
			status = DiskState.IDLE; 
			state = ProcessState.WAITING;
			System.out.println("Disk state is now idle, reading the string but no action is taken,"
					+ " and the process is waiting");
		}
	
	System.out.println(generateRandomOperation());	
}


public static void ReqHeap(){
	for (int i = 0; i<9 ; i++){
		if (Memory[i] != null){ 
			Memory[i] = Memory[10];	
		}	
	}
	System.out.println("A space from Privileged Memory is now specified to "
			+ "Non Priveleged memory as an empty space in Memory ");	
}

//METHOD FOR PRIVMEMORY
public static  void privMem (){
	for (int i = 0; i<Memory.length ; i++){ 
	if ( i > 9){   //if am accessing the priv memory
		for (int j= 0 ; j<10 ; j++){ //Loop over the non priv 
			if (Memory[j] == null){  //if the index inside the non-priv is empty
			Memory[i] = Memory[j]; //reallocate whats trying to access the priv to the non-priv
			}
		}
	}
		
	}
	System.out.println("An attempt to access the Priveleged Memory has taken place, "
			+ ", and its being reallocated to the Non-privileged");
			
}




//MAIN METHOD

public static void main(String[] args) {
	Handlers h = new Handlers (20);
	System.out.println(generateRandomEvent());
    handling();
	
}
}
