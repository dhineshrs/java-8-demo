package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(8, 3, 4, 1, 7, 3);
		IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Average values : " +summaryStatistics.getAverage());
		System.out.println("Average Count : " +summaryStatistics.getCount());
		System.out.println("Average Count : " +summaryStatistics.getCount());
		System.out.println("Average Max : " +summaryStatistics.getMax());
		System.out.println("Average Min : " +summaryStatistics.getMin());
		System.out.println("Average Max : " +summaryStatistics.getMax());
		System.out.println("Average Sum : " +summaryStatistics.getSum());

	}

}
