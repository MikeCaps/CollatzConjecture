import java.util.*;
public class CollatzConjecture{
	public static void main(String [] args){
		
		//This code checks the Collatz sequence up to any number N and returns the size of the longest sequence, as well as the N for 
		//the longest such sequence. 
		
		int N = 0;
		boolean input = false;
		Scanner kb = new Scanner(System.in);
		System.out.println("Choose a positive integer up to 110,000");
		N = kb.nextInt();
		while(input == false){
			if(N > 110000 || N < 0)
				System.out.println("Please enter an int <= 110,000 and > 1");
			else{
			//create an array and store the number of steps to reach 1 for N up to 110,000
				input = true;
				int[] collatzArray = new int[N];
				for(int i = 0; i < N; i++){
					//System.out.println(collatz(i));
					collatzArray[i] = collatz1(i+1);
					resetCount();
				//System.out.println(collatzArray[i]);
				}
				int max = collatzArray[0];
				int maxN = collatzArray[0];
				for(int j = 0; j < N-1; j++){
					if(collatzArray[j] > max){
						max = collatzArray[j];
						maxN = j + 1;
					}
				}
				System.out.println("Max amount of steps to reach 1: " + max);
				System.out.println("Max N = " + maxN + " for N < " + N);
			}
		}
		clearSequence();
		resetCount();
		//prints a sequence of any size
		System.out.println();	
		boolean input2 = true;
		//Scanner kb2 = new Scanner(System.in);
		while(input2){
			System.out.println("Enter a positive integer. Enter \"0\" to quit.");
			int test = kb.nextInt();
			if(test != 0){
				int terms = collatz2(test);
				System.out.println();
				System.out.println("This sequence has " + (terms + 1) + " terms.");
				System.out.println("It took " + terms + " steps to reach 1");
				printSequence();
				clearSequence();
				resetCount();
				System.out.println();
			}else{
				input2 = false;
			}
		}
	
	}//end of main method
	
	public static int count = 0;//global count variable
	public static ArrayList<Integer> seq = new ArrayList<Integer>();// global array list for storing sequences.

	//returns number of steps it takes to reach 1. (This was the definition I found on wikipedia)
	//The length of the sequence, including the 1 at the end, is count+1
	public static int collatz1(int n){
		int a;
		a = n;
		//seq.add(a);
		//int count = 0; count is global and is reset in main method
		//System.out.print(a + ",");
		while(n != 1){
			if(n % 2 == 0){
				count++;
				return collatz1(n/2);
			}else{
				count++;
				return collatz1(3*n+1);
			}
		}
		return count;
		
	}//end of collatz
	
	//this method stores the terms of the sequence for printing.
	public static int collatz2(int n){
		int a;
		a = n;
		seq.add(a);
		while(n != 1){
			if(n % 2 == 0){
				count++;
				return collatz2(n/2);
			}else{
				count++;
				return collatz2(3*n+1);
			}
		}
		return count;
		
	}//end of collatz
	
	public static void printSequence(){
		int terms = seq.size();
		Scanner print = new Scanner(System.in);
		System.out.println("Print Sequence? (Y/N)");
		String response = print.next();
		if(response.equalsIgnoreCase("Y")){
			for(int i = 0; i < terms; i++){
				System.out.print(seq.get(i));
				if(i != terms-1)
					System.out.print(", ");
				if((i+1)%terms == 0)
					System.out.println();
			}
		}else if(response.equalsIgnoreCase("N")){
			System.out.println("You have chosen not to print");
		}else{
			System.out.println("Invalid input");
		}
	}
	
	public static void clearSequence(){
		seq.clear();
	}
	
	public static void resetCount(){
		count = 0;
	}
	
	
}//end of class CS2423ACapezzuto