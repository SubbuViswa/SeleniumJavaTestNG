package com.subbu.utils;

import java.util.Random;

public class IDGeneratorUtil {

	
	public String getRandomId(String prefix) {
		Random random = new Random();
		String id = prefix + Math.abs(random.nextInt());
		return id;
	}

	public String getRandomEmail(String prefix) {
		Random random = new Random();
		String email = prefix + Math.abs(random.nextInt()) + "@haeus.com";
		return email;
	}
	
	public String getRandomGrpName(String prefix) {
		Random random = new Random();
		String randGrp= prefix + Math.abs(random.nextInt());
		return randGrp;
	}

	public int getRandomNumber() {
		Random random = new Random();
		int a=random.nextInt(10)+1;
		return a;
	}
	
	public int getRandomNum() {
		Random random = new Random();
		return Math.abs(random.nextInt());
	}
	
	public int getRandomNumWithinLimit(int limit) {
		Random random = new Random();
		return Math.abs(random.nextInt(limit)+1);
	}
	
	public int get7digitRandomNum() {
		Random random = new Random();
		return Math.abs(random.nextInt(9000000)+1000000);
	}
}
