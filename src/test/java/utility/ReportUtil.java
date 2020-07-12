package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;

import net.masterthought.cucumber.ReportBuilder;



public class ReportUtil {

	static List<String> jsonFiles(String directory) {

		List<String> jsonFiles = new ArrayList<String>();

		File dir = new File(directory);

		for (File file : dir.listFiles()) {

			if (file.getName().endsWith((".json"))) {

				jsonFiles.add("target/" + file.getName());

			}

		}

		return jsonFiles;

	}

	public static void main(String args[]) throws Exception {

		File reportOutputDirectory = new File("target/cucumberReports");

		List<String> jsonFiles = jsonFiles("target");

		String jenkinsBasePath = "";

		String buildNumber = "1";

		String projectName = "Amazon Automation";

		boolean skippedFails = true;

		boolean pendingFails = false;

		boolean undefinedFails = true;

		boolean missingFails = true;

		boolean runWithJenkins = false;

		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		configuration.setBuildNumber(buildNumber);

		configuration.addClassifications("Platform", "Windows");

		configuration.addClassifications("Browser", "chrome");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

		reportBuilder.generateReports();

	}

}