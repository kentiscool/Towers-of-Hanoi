package hanoi;

import java.util.ArrayList;

public class hanoi {
	
	public static ArrayList<Integer> p0 = new ArrayList<Integer>();
	public static ArrayList<Integer> p1 = new ArrayList<Integer>();
	public static ArrayList<Integer> p2 = new ArrayList<Integer>();
	public static ArrayList <ArrayList<Integer>> pegs = new ArrayList <ArrayList<Integer>>();
	public static int discs1;
	
	public static void main(String[] args) {
		pegs.add(p0);
		pegs.add(p1);
		pegs.add(p2);
		
		start(10); // max is 1000000000 idk why
	}
	
	public static int findSpare(int start,int target) {
		int i;
		for (i = 0; i<2; i++) {
			if (i != start && i != target) {
				return i;
			}
		}
		return 2;
	}
	
	public static void start(int discs) {
		discs1 = discs;
		for (int i = 0; i < discs; i++) {
			p0.add(i);
		}
		System.out.println(pegs);
		outterDraw(discs-1);
		solve(0,2,discs-1);
		System.out.println(pegs);
	}
	
	public static void outterDraw(int level) {
		
		for (int n = 0; n < 3 ; n++) {
			
			for (int y = 0; y < discs1 + 2; y++) {
				System.out.print(" ");
			}
			System.out.print("+");
			for (int y = 0; y < discs1 + 2; y++) {
				System.out.print(" ");
			}
		}
			
		System.out.println("");
		innerDraw(level);
		for (int n =0; n<3;n++) {
			System.out.print(" ");
			for (int y = 0; y < discs1 + 1; y++) { 
				System.out.print("*");
			}
			System.out.print("*");
			for (int y = 0; y < discs1 + 1; y++) {
				System.out.print("*");
			}
			System.out.print(" ");
			
		}
	}
	
	public static void innerDraw(int level) {
	
		if (level<0) {}
		else{
			innerDraw(level-1);
			for (int x=0; x<3; x++) {
				int m = discs1 - (pegs.get(x).size());
				if (level<m) {
				for (int y = 0; y < discs1 + 2; y++) {
					System.out.print(" ");
					}
				System.out.print("+");
				for (int y = 0; y < discs1 + 2; y++) {
					System.out.print(" ");
					}	
				}else {
					for (int z = (pegs.get(x)).get(level-m); z<(discs1 + 2); z++) {
						System.out.print(" ");
						}
					for (int y = 0; y<(pegs.get(x)).get(level-m); y++) {
						System.out.print("#");
						}
					System.out.print("#");
					for (int y = 0; y<(pegs.get(x)).get(level-m); y++) {
						System.out.print("#");
						}
					for (int z = (pegs.get(x)).get(level-m); z<(discs1 + 2); z++) {
						System.out.print(" ");
						}
						
					}
					
				}
			System.out.println("");
		}
			
	}
		
	public static void move(int start, int target) {
		int s = (pegs.get(start)).get(0);
		(pegs.get(target)).add(0,s);
		(pegs.get(start)).remove(0);	
		
		System.out.println(pegs);
		System.out.println("");
		outterDraw(discs1-1);
		System.out.println("");
		
	}
	
	public static int solve(int start, int target, int level) {
		if (level==0){
			System.out.println(start + "-->" + target);
			move(start,target);
			return 0;
		}
		int spare = findSpare(start,target);
		solve(start,spare,level-1);
		System.out.println(start + "-->" + target);
		move(start,target);
		solve(spare,target,level-1);
		return 0;
	}
	
}
