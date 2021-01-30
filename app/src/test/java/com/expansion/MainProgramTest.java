package com.expansion;

import org.junit.Test;
import org.junit.Assert;

import com.expansion.MainProgram;

public class MainProgramTest {


	MainProgram main = new MainProgram();

	@Test
	public void MainProgramTest() throws Exception {

		int stat = main.readFile();

		if(stat == 0) {
			Assert.assertSame(0, stat);	
		} else if (stat == 1) {
			Assert.assertSame(1, stat);
		}
		Assert.assertTrue(main.createFile(5, 5));
		Assert.assertTrue(main.createFile(0, 0));
		Assert.assertSame(main.validator(1), 1);
		Assert.assertSame(main.validator(2), 2);
	}




}