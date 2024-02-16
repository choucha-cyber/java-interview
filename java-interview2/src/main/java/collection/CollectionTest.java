package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

	/**
	 * operation : x -> ((x * 2) + 3) ^ 5
	 */
	public static List<Double> compute1(List<Integer> input) {
		// return null;
		List<Double> result = new ArrayList<>();
		for (Integer num : input) {
			// x -> ((x * 2) + 3) ^ 5
			double computedValue = Math.pow((num * 2) + 3, 5);
			result.add(computedValue);
		}
		return result;
	}

	/**
	 * operation : abc -> AbcAbc
	 */
	public static List<String> compute2(List<String> input) {
		// return null;
		List<String> result = new ArrayList<>();
		for (String str : input) {
			result.add(str + str.substring(0, 1).toUpperCase() + str.substring(1));
		}
		return result;
	}

}
