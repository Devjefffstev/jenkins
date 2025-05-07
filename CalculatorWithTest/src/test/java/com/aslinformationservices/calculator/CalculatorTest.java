package com.aslinformationservices.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
	private static final double DELTA = 1e-15;

	@Test
	void testAdd() {
		Calculator calculator = new Calculator();
		assertEquals(5.0, calculator.add(2.0, 3.0), DELTA);
		assertEquals(-1.0, calculator.add(-2.0, 1.0), DELTA);
		assertEquals(0.0, calculator.add(0.0, 0.0), DELTA);
		// try {
		// 	Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// 	Thread.currentThread().interrupt();
		// 	fail("Test interrupted");
		// }
	}

	@Test
	void testSubtract() {
		Calculator calculator = new Calculator();
		assertEquals(-1.0, calculator.subtract(2.0, 3.0), DELTA);
		assertEquals(-3.0, calculator.subtract(-2.0, 1.0), DELTA);
		assertEquals(0.0, calculator.subtract(0.0, 0.0), DELTA);
		// try {
		// 	Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// 	Thread.currentThread().interrupt();
		// 	fail("Test interrupted");
		// }
	}

	@Test
	void testMultiply() {
		Calculator calculator = new Calculator();
		assertEquals(6.0, calculator.multiply(2.0, 3.0), DELTA);
		assertEquals(-2.0, calculator.multiply(-2.0, 1.0), DELTA);
		assertEquals(0.0, calculator.multiply(0.0, 5.0), DELTA);
	}

	@Test
	void testDivide() {
		Calculator calculator = new Calculator();
		assertEquals(2.0, calculator.divide(6.0, 3.0), DELTA);
		assertEquals(-2.0, calculator.divide(-6.0, 3.0), DELTA);
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(5.0, 0.0));
	}

	@Test
	void testDivideByZeroScenario1() {
		Calculator calculator = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(5.0, 0.0));
	}

	@Test
	void testEquationSolverScenario1() {
		EquationSolver equationSolver = new EquationSolver();
		assertEquals(2.0, equationSolver.solveLinearEquation(1.0, -3.0, -1.0), DELTA);
		assertThrows(IllegalArgumentException.class, () -> equationSolver.solveLinearEquation(0.0, 0.0, 1.0));
	}

	@Test
	void testCustomFeatureMeanScenario1() {
		CustomFeature customFeature = new CustomFeature();
		double[] numbers = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		assertEquals(3.0, customFeature.calculateMean(numbers), DELTA);
	}

	@Test
	void testCustomFeatureMeanEmptyScenario1() {
		CustomFeature customFeature = new CustomFeature();
		double[] emptyArray = {};
		assertThrows(IllegalArgumentException.class, () -> customFeature.calculateMean(emptyArray));
	}

	@Test
	void testCustomFeatureMeanSingleElement() {
		CustomFeature customFeature = new CustomFeature();
		double[] singleElement = { 42.0 };
		assertEquals(42.0, customFeature.calculateMean(singleElement), DELTA);
	}

	@Test
	void testCustomFeatureMeanNegativeNumbers() {
		CustomFeature customFeature = new CustomFeature();
		double[] numbers = { -1.0, -2.0, -3.0, -4.0, -5.0 };
		assertEquals(-3.0, customFeature.calculateMean(numbers), DELTA);
	}

	@Test
	void testDivideByZeroScenario2() {
		Calculator calculator = new Calculator();
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(5.0, 0.0));
	}

	@Test
	void testEquationSolverScenario2() {
		EquationSolver equationSolver = new EquationSolver();
		assertEquals(2.0, equationSolver.solveLinearEquation(1.0, -3.0, -1.0), DELTA);
	}

	@Test
	void testCustomFeatureMeanScenario2() {
		CustomFeature customFeature = new CustomFeature();
		double[] numbers = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		assertEquals(3.0, customFeature.calculateMean(numbers), DELTA);
	}

	@Test
	void testCustomFeatureMeanEmptyScenario2() {
		CustomFeature customFeature = new CustomFeature();
		double[] emptyArray = {};
		assertThrows(IllegalArgumentException.class, () -> customFeature.calculateMean(emptyArray));
	}

	@Test
	void testHeavyWorkloadInital() {
		CustomFeature customFeature = new CustomFeature();
		int iterations = 100000; // Number of iterations to simulate workload
		int datasetSize = 1_000_000; // Size of each dataset
		double[] dataset = new double[datasetSize];

		// Populate the dataset with random values
		for (int i = 0; i < datasetSize; i++) {
			dataset[i] = Math.random() * 100;
		}

		long startTime = System.currentTimeMillis();

		// Perform multiple iterations of mean calculations
		for (int i = 0; i < iterations; i++) {
			double mean = customFeature.calculateMean(dataset);
			assertTrue(mean >= 0 && mean <= 100, "Mean should be within the expected range");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Total Execution Time for testHeavyWorkloadInital: " + (endTime - startTime) + " ms");
	}
	// @Test
	// void testHeavyWorkloadInitalize() {
	// 	CustomFeature customFeature = new CustomFeature();
	// 	int iterations = 1000000; // Number of iterations to simulate workload
	// 	int datasetSize = 1_000_000; // Size of each dataset
	// 	double[] dataset = new double[datasetSize];

	// 	// Populate the dataset with random values
	// 	for (int i = 0; i < datasetSize; i++) {
	// 		dataset[i] = Math.random() * 100;
	// 	}

	// 	long startTime = System.currentTimeMillis();

	// 	// Perform multiple iterations of mean calculations
	// 	for (int i = 0; i < iterations; i++) {
	// 		double mean = customFeature.calculateMean(dataset);
	// 		assertTrue(mean >= 0 && mean <= 100, "Mean should be within the expected range");
	// 	}

	// 	long endTime = System.currentTimeMillis();

	// 	System.out.println("Total Execution Time for testHeavyWorkloadInitalez: " + (endTime - startTime) + " ms");
	// }
	@Test
	void testHeavyWorkloadfinal() {
		CustomFeature customFeature = new CustomFeature();
		int iterations = 10000; // Number of iterations to simulate workload
		int datasetSize = 1_000_000; // Size of each dataset
		double[] dataset = new double[datasetSize];

		// Populate the dataset with random values
		for (int i = 0; i < datasetSize; i++) {
			dataset[i] = Math.random() * 100;
		}

		long startTime = System.currentTimeMillis();

		// Perform multiple iterations of mean calculations
		for (int i = 0; i < iterations; i++) {
			double mean = customFeature.calculateMean(dataset);
			assertTrue(mean >= 0 && mean <= 100, "Mean should be within the expected range");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Total Execution Time for testHeavyWorkloadfinal: " + (endTime - startTime) + " ms");
	}
	@Test
	void testHeavyWorkload() {
		CustomFeature customFeature = new CustomFeature();
		int iterations = 100000; // Number of iterations to simulate workload
		int datasetSize = 1_000_000; // Size of each dataset
		double[] dataset = new double[datasetSize];

		// Populate the dataset with random values
		for (int i = 0; i < datasetSize; i++) {
			dataset[i] = Math.random() * 100;
		}

		long startTime = System.currentTimeMillis();

		// Perform multiple iterations of mean calculations
		for (int i = 0; i < iterations; i++) {
			double mean = customFeature.calculateMean(dataset);
			assertTrue(mean >= 0 && mean <= 100, "Mean should be within the expected range");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Total Execution Time for Heavy Workload: " + (endTime - startTime) + " ms");
	}

	@Test
	void testHeavyWorkloadtesting() {
		CustomFeature customFeature = new CustomFeature();
		int iterations = 100000; // Number of iterations to simulate workload
		int datasetSize = 1_000_000; // Size of each dataset
		double[] dataset = new double[datasetSize];

		// Populate the dataset with random values
		for (int i = 0; i < datasetSize; i++) {
			dataset[i] = Math.random() * 100;
		}

		long startTime = System.currentTimeMillis();

		// Perform multiple iterations of mean calculations
		for (int i = 0; i < iterations; i++) {
			double mean = customFeature.calculateMean(dataset);
			assertTrue(mean >= 0 && mean <= 100, "Mean should be within the expected range");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Total Execution Time for testHeavyWorkloadtesting: " + (endTime - startTime) + " ms");
	}
}
