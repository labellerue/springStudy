package kr.or.ddit.lotto;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class LottoTest {

	@Test
	public void lottoTest(){
		/***Given***/

		/***When***/
		Lotto lotto = new Lotto();
		lotto.setMaxNum(55);
		lotto.setBallNum(6);
		int[] lotts = lotto.execute();

		/***Then***/
		for(int lott : lotts) {
			System.out.print(lott+", ");
		}
	} 
}
