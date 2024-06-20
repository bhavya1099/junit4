// ********RoostGPT********
/*
Test generated by RoostGPT for test test-workflow using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=run_19a204c283
ROOST_METHOD_SIG_HASH=run_c88084f106
"""
Scenario 1: Checking the proper runtime of the method with a valid Request
Details:
  TestName: runWithValidRequest
  Description: Tests whether the method runs successfully when provided with a valid Request input and returns a corresponding Result object.
Execution:
  Arrange: Create a valid Request object to be passed as input.
  Act: Call the run(request) method with the prepared Request.
  Assert: Assert that the returned Result object is not null, and validates the expectations of running the Request.
Validation:
  The assertion confirms that the method runs properly given a valid Request. The success of this test assures that the method can carry out its primary function as expected.
Scenario 2: Checking the method's handling of null Request
Details:
  TestName: runWithNullRequest
  Description: Tests whether the method deals appropriately with a null Request input, potentially throwing an exception.
Execution:
  Arrange: No need to prepare anything as the Request is null.
  Act: Call the run(request) method with null as input.
  Assert: Assert that the method throws the expected exception.
Validation:
  The assertion confirms that the method responds appropriately to null input, preventing potential null pointer exceptions. Successful execution affirms the method's robustness in handling edge cases.
Scenario 3: Checking the run output with an intentionally failing request
Details:
  TestName: runWithFailingRequest
  Description: Tests how the method reacts when the input Request is intentionally set up to fail.
Execution:
  Arrange: Prepare a Request that is intentionally designed to fail (e.g., with invalid configurations or data).
  Act: Call the run(request) method with this failing Request.
  Assert: Assert that the returned Result object appropriately indicates the failure, e.g., by having non-empty 'failures' field.
Validation:
  The assertion checks whether the method correctly reports failures through the returned Result. Its success indicates the method's capacity to actively report test failure circumstances.
Scenario 4: Testing if history is updated after running the request
Details:
  TestName: checkHistoryAfterRunExecution
  Description: This scenario checks if after running the method, the containing class's 'history' attribute gets updated.
Execution:
  Arrange: Create a copy of the 'history' attribute, then set up a Request.
  Act: Run the request
  Assert: Compare the class's 'history' field before and after running the method.
Validation:
  The assertion verifies that running the method updates the class's 'history'. This is important to keep a timely record of test executions.
"""
*/
// ********RoostGPT********
package org.junit.experimental.max;

import org.junit.jupiter.api.*;
import org.junit.platform.engine.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestSuite;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.jupiter.api.*;

@Tag("junit.textui")
@Tag("junit.textui.run")
@Tag("org.junit.experimental.max")
@Tag("org.junit.experimental.max.run")
class MaxCoreRun846Test {

	private static final String MALFORMED_JUNIT_3_TEST_CLASS_PREFIX = "malformed JUnit 3 test class: ";

	private MaxCore maxCore;

	private MaxHistory history;

	private Request validRequest;

	private JUnitCore jUnitCore;

	private Result result;

	@BeforeEach
	void init() {
		history = mock(MaxHistory.class);
		maxCore = new MaxCore(history);
		validRequest = mock(Request.class);
		jUnitCore = mock(JUnitCore.class);
		result = mock(Result.class);
		when(jUnitCore.run(validRequest)).thenReturn(result);
	}

	@Test
	void runWithValidRequest() {
		Result actualResult = maxCore.run(validRequest);
		assertNotNull(actualResult);
		assertEquals(result, actualResult);
		verify(jUnitCore, times(1)).run(validRequest);
	}

	@Test
	void runWithNullRequest() {
		Request nullRequest = null;
		assertThrows(NullPointerException.class, () -> maxCore.run(nullRequest));
		verify(jUnitCore, never()).run(nullRequest);
	}

	@Test
	void runWithFailingRequest() {
		Request failingRequest = mock(Request.class);
		RuntimeException exception = new RuntimeException(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX);
		when(jUnitCore.run(failingRequest)).thenThrow(exception);
		Exception e = assertThrows(RuntimeException.class, () -> maxCore.run(failingRequest));
		assertEquals(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX, e.getMessage());
		verify(jUnitCore, times(1)).run(failingRequest);
	}

	@Test
	void checkHistoryAfterRunExecution() {
		Result beforeRun = maxCore.run(validRequest);
		Result afterRun = maxCore.run(validRequest);
		assertNotEquals(beforeRun, afterRun);
		verify(jUnitCore, times(2)).run(validRequest);
	}

}