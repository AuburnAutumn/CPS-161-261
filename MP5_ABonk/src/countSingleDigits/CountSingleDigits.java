package countSingleDigits;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountSingleDigits {

	public class CountDigit {

	}

	public static void main(String[] args) {
		Random rand = new Random();

		Stream.generate(() -> rand.nextInt(10)).limit(100).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " : " + v));

	}

}
