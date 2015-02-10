package com.erisite.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.erisite.model.MainForm;

public class FileReader {

	private static final int EMPLOYEE_NAME = 0;
	private static final int FIRST_NAME = 1;
	private static final int LAST_NAME = 2;
	private static final int EMPLOYEE_BY = 4;
	private static final int EMP_USERNAME = 5;
	private static final int PASSWORD = 6;
	private static final int CONFIRM_PASSWORD = 7;

	public static List<MainForm> readCsvData(String filePath) {
		BufferedReader br = null;
		String line = null;
		String cvsSplitBy = ",";
		List<MainForm> mainForms = new ArrayList<>();
		try {

			br = new BufferedReader(new java.io.FileReader(new File(filePath)));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				MainForm mainForm = new MainForm(country[EMPLOYEE_NAME],
						country[FIRST_NAME], country[LAST_NAME],country[EMPLOYEE_BY],country[EMP_USERNAME],country[PASSWORD],country[CONFIRM_PASSWORD]);

				mainForms.add(mainForm);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mainForms;

	}

//	public static void main(String[] args) {
//		readCsvData("C:\\Users\\318759\\Desktop\\Book1.csv");
//	}
}
