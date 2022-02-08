package question1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Skyscraper {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iTotalFloors=0;
		LinkedList<Integer> aFloorSize=new LinkedList<Integer>();
		LinkedList<Integer> aSortedSize=new LinkedList<Integer>();
		LinkedList<Integer> Temp=new LinkedList<>();
		System.out.println("Enter the total no of floors in the building:");
		iTotalFloors=sc.nextInt();
		for(int i=0;i<iTotalFloors;i++) {
			int a;
			System.out.println("Enter the floor size given on day "+(i+1)+":");
			a=sc.nextInt();
			if(a==0) {
				System.out.println("Invalid Input.");
				i--;
				continue;
			}else if(!aFloorSize.contains(a)) {
				aFloorSize.add(a);
				aSortedSize.add(a);
			}else {
				System.out.println("****Floor Size already present. Please re-enter size.****");
				i--;
				continue;
			}
		}
		aSortedSize.sort(Comparator.reverseOrder());
		System.out.println("The order of construction is as follows:-");
		System.out.println("");
		for(int i=0;i<iTotalFloors;i++) {
			Temp.add(aFloorSize.get(i));
			Temp.sort(Comparator.reverseOrder());
			if(aFloorSize.get(i).equals(aSortedSize.getFirst())) {
				System.out.println("Day: "+(i+1)+"");
				for(int j=0;j<Temp.size();j++) {
					if(Temp.get(j).equals(aSortedSize.getFirst())) {
						aSortedSize.remove(0);
						System.out.print(Temp.getFirst()+" ");
						Temp.removeFirst();
						j--;
					}
				}
				System.out.print("\n");
			}else {
				System.out.println("Day: "+(i+1)+"");
				System.out.println("");
			}
		}
		sc.close();
	}
}
