package tests;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;

public class Util {

	
	public static String createpiechart(int passed, int failed, int skipped){
		// Create pie chart
		int total = passed + failed + skipped;
		int passed_percentage = (passed == 0) ? 0 : (passed * 100 / total);
		int failed_percentage = (failed == 0) ? 0 : (failed * 100 / total);
		int skipped_percentage = (skipped == 0) ? 0 : (skipped * 100 / total);
		Slice s1 = Slice.newSlice(passed_percentage, Color.BLUE, "Passed", "Passed");
		Slice s2 = Slice.newSlice(failed_percentage, Color.RED, "Failed", "Failed");
		Slice s3 = Slice.newSlice(skipped_percentage, Color.newColor("CACACA"), "Skipped", "Skipped");
		PieChart chart = GCharts.newPieChart(s1, s2, s3);
		chart.setTitle("CFA API Automation Result", Color.BLACK, 16);
		chart.setSize(500, 200);
		chart.setThreeD(true);
		String url = chart.toURLString();
		System.out.println("Pie chart is created");
		return url;
	}
	
	
	
}
