package sk.bigRam.richard;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBigRam {
	
	// test is performed with use JUnit 4 

	private Methods methods = new Methods();

	@Test
	public void testResultBigRam() {
		LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
		lMap.put("the quick", 2);
		lMap.put("quick brown", 1);
		lMap.put("brown fox", 1);
		lMap.put("fox and", 1);
		lMap.put("and the", 1);
		lMap.put("quick blue", 1);
		lMap.put("blue hare", 1);


		assertEquals(lMap, Methods.populateHashMap("The quick brown fox and the quick blue hare"));//	        											The quick brown fox and the quick blue hare

	};

	// THIS TEST IS only for example for successfully work method
	@Test
	public void testForReturnString() {
		List<String> listValues2 = new ArrayList<String>();
		List<String> numberOfArray = new ArrayList<String>();
		listValues2.add("[the quick");
		listValues2.add("quick brown");
		listValues2.add("brown fox");
		listValues2.add("fox and");
		listValues2.add("and the");
		listValues2.add("quick blue");
		listValues2.add("blue hare]");

		numberOfArray.add("2");
		numberOfArray.add("1");
		numberOfArray.add("1");
		numberOfArray.add("1");
		numberOfArray.add("1");
		numberOfArray.add("1");
		numberOfArray.add("1");

		methods.printValues();
		assertEquals("\nSuccessfully done", methods.jUnitMethod(listValues2, numberOfArray));
	}

	@Test
	public void testForNullString() {
		methods.printValues();
		assertEquals(null, methods.printValues());
	}

	@Test
	public void existString() throws IOException {
		byte[] file1Bytes = Files.readAllBytes(Paths.get("file.txt"));
		String file = new String(file1Bytes, StandardCharsets.UTF_8);
		assertEquals("The quick brown fox and the quick blue hare", file);
	}

}
