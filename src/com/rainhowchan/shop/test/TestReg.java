package com.rainhowchan.shop.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestReg {
	@Test
	public void test(){
		Pattern pattern = Pattern.compile("(\\d{3})\\d{4,}");
		Matcher matcher = pattern.matcher("-middle?1478487144070");
		if(matcher.find()){
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.start(1)+"-----"+matcher.end(1));
		}
	}
}
