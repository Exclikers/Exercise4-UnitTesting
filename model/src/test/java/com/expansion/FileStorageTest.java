package com.expansion;

import org.junit.Test;
import org.junit.Assert;

import com.expansion.FileStorage;

public class FileStorageTest {



	FileStorage store = new FileStorage();



	@Test
	public void FileStorageTest() throws Exception {

		Assert.assertNotNull(store.generateASCII());

	}



}