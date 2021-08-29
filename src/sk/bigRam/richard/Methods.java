package sk.bigRam.richard;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Methods {
	int cislo = 5;
	String words;
	static List<String> listValues2 = new ArrayList<String>();
	static List<String> numberOfArray = new ArrayList<String>();

	public static LinkedHashMap<String, Integer> populateHashMap(String given) {
		LinkedHashMap<String, Integer> lMap = new LinkedHashMap<String, Integer>();
		String[] arr = given.split(" ");
		if (arr.length < 2) {
			return null;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			String sTemp = arr[i] + " " + arr[i + 1];
			sTemp = sTemp.toLowerCase();
			if (lMap.get(sTemp) != null) {
				int j = lMap.get(sTemp);
				lMap.replace(sTemp, j + 1);

			} else {
				lMap.put(sTemp, 1);
			}

		}
		Set<String> listValues = lMap.keySet();
		String celyNazov = listValues.toString();
		String celeCisla = lMap.values().toString();
		for (int i = 0; i < listValues.size(); i++) {
			listValues2.add(celyNazov.split(",")[i]);
			numberOfArray.add(celeCisla.split(",")[i]);

		}
		return lMap;
	}

	public String loadFile() {
		File loadFile = new File("file.txt");
		if (loadFile.length() == 0) {
			System.out.println("Your file is empty! \nPlease insert words into file!");
			return null;
		} else {
			try {
				Scanner fileReader = new Scanner(loadFile);
				while (fileReader.hasNextLine()) {
					words = fileReader.nextLine();
				}

				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error occurred");
				e.printStackTrace();
			}
		}
		return words;
	}

	public String printValues() {
		for (int i = 0; i < listValues2.size(); i++) {
			if (listValues2.size() >= 1) {
				if (i == 0) {
					String firstValue = listValues2.get(0).replace("[", "");
					String firstNumber = numberOfArray.get(0).replace("[", "");

					if (listValues2.size() == 1) {
						String fullString = firstValue.replace("]", "");
						System.out.println("" + fullString + ", " + 1 + "");
						return "\nSuccessfully done";

					} else {

						listValues2.set(0, firstValue);
						System.out.println(" " + firstValue + ", " + firstNumber);
					}

				}

				else if (i == listValues2.size() - 1) {
					String lastValue = listValues2.get(i).replace("]", "");
					String lastNumber = numberOfArray.get(i).replace("]", "");
					System.out.println(lastValue + "," + lastNumber);
//					System.out.println(listValues2 + "  po  uprave:" + i);
					return "\nSuccessfully done";
				}

				else {
					System.out.println(listValues2.get(i) + "," + numberOfArray.get(i) + "");
				}

			}

		}
		return null;
	}

	// FOR JUnit Test
	// THIS TEST IS only for example for successfully work method seen in jUnit Test
	public String jUnitMethod(List<String> listValues2, List<String> numberOfArray) {
		for (int i = 0; i < listValues2.size(); i++) {
			if (listValues2.size() >= 1) {
				if (i == 0) {
					String firstValue = listValues2.get(0).replace("[", "");
					String firstNumber = numberOfArray.get(0).replace("[", "");

					if (listValues2.size() == 1) {
						String fullString = firstValue.replace("]", "");
						System.out.println("" + fullString + ", " + 1 + "");
						return "\nSuccessfully done";

					} else {

						listValues2.set(0, firstValue);
						System.out.println(" " + firstValue + ", " + firstNumber);
					}

				}

				else if (i == listValues2.size() - 1) {
					String lastValue = listValues2.get(i).replace("]", "");
					String lastNumber = numberOfArray.get(i).replace("]", "");
					System.out.println(lastValue + "," + lastNumber);

					return "\nSuccessfully done";
				}

				else {
					System.out.println(listValues2.get(i) + "," + numberOfArray.get(i) + "");
				}

			}

		}
		return null;
	}

}
