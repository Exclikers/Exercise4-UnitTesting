package com.expansion;

import org.junit.Test;
import org.junit.Assert;

import com.expansion.MenuOptions;

public class MenuOptionTest {


	MenuOptions menu = new MenuOptions();



	@Test
	public void MenuOptionsTest() throws Exception {
		
		Assert.assertSame(0, menu.menuPrint());
		Assert.assertNotSame(1,menu.menuPrint());

		Assert.assertNull(menu.menuSearch(null));
		Assert.assertFalse(menu.menuEditValue(null));
		Assert.assertTrue(menu.menuEditNewValue(null,"   "));
		Assert.assertFalse(menu.menuEditNewValue(null,"12345"));
		Assert.assertNotNull(menu.toSort());
		Assert.assertSame(menu.updateData(), "Successful");
		Assert.assertSame(menu.updateDimension(0), "Successful");
		Assert.assertTrue(menu.deleteData("data.txt"));
		Assert.assertTrue(menu.deleteData("dimension.txt"));
		Assert.assertTrue(menu.menuReset());
		Assert.assertTrue(menu.menuList());
		Assert.assertSame(menu.addRow(2), 0);
		Assert.assertSame(menu.addRow(1001), 0);
		Assert.assertSame(menu.selectedOption(3), 3);
		Assert.assertSame(menu.selectedOption(5), 5);
		Assert.assertSame(menu.selectedOption(8), 8);
	}



}