package com.rmgyantra.GenericUtility;

import java.util.Random;

public class JavaUtility {
	public int generateRandomData() {
		Random  r=new Random();
		int number=r.nextInt(1000);
		return number;

	}
}
