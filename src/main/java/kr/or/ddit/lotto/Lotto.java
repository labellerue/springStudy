package kr.or.ddit.lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
	
	private int maxNum;
	private int ballNum;
	
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getBallNum() {
		return ballNum;
	}
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}

	public int[] execute() {
		Set<Integer> dangCheom = new HashSet<Integer>();
		while(dangCheom.size() < ballNum) {
			int resultNum = (int)(Math.random()*maxNum)+1;
			dangCheom.add(resultNum);
		}
		Object[] objArr = dangCheom.toArray();
		
		int[] lotts = new int[dangCheom.size()];
		for(int i=0 ; i<dangCheom.size() ; i++) {
			lotts[i] = (int)objArr[i];
		}
		
		return lotts;
	}

	
}
