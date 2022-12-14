package day19;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class 트리셋 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(new Integer(87));
		scores.add(new Integer(88));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(80));
		scores.add(new Integer(85));
		
		Integer score = null;
		score = scores.first();
		System.out.println("가장 낮은 점수 " + score);
		score = scores.last();
		System.out.println("가장 높은 점수 " + score);
		score = scores.lower(95);
		System.out.println("95점 아래 점수 " + score);
		score = scores.higher(95);
		System.out.println("95점 위 점수 " + score);
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer score1 : descendingSet) {
			System.out.print(score1 + " ");
		}
		System.out.println();
		NavigableSet<Integer> descendingSet1 = descendingSet.descendingSet();
		for(Integer score1 : descendingSet1) {
			System.out.print(score1 + " ");
		}
	}

}
