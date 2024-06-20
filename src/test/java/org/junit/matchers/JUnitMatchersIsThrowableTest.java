// ********RoostGPT********
/*
Test generated by RoostGPT for test test-workflow using AI Type Azure Open AI and AI Model roostgpt-4-32k
ROOST_METHOD_HASH=isThrowable_17033c9adc
ROOST_METHOD_SIG_HASH=isThrowable_c7dcc22354
Scenario 1: Valid Throwable Matcher
  Details:
    TestName: testIfIsThrowableReturnsTheCorrectMatcher
    Description: This test ensures that the method returns the correct matcher for a given throwableMatcher.
  Execution:
    Arrange: Instantiate a Throwable matcher.
    Act: Invoke the isThrowable method with the Throwable matcher as argument.
    Assert: Verify that the returned matcher is the same as the argument passed.
  Validation:
    This test verifies that the method correctly delegates the supplied matcher without altering it. This is important for ensuring correct function matching in the app, as matcher deviations could lead to incorrect exception handling.
Scenario 2: Null Throwable Matcher
  Details:
    TestName: testIfIsThrowableReturnsNullOnNullInput
    Description: This test checks if the method can handle null input gracefully.
  Execution:
    Arrange: No arranging is required in this scenario since the input is null.
    Act: Invoke the isThrowable method with null as the argument.
    Assert: Verify that the method returns null.
  Validation:
    The test verifies that the method can handle null input, avoiding potential NullPointerExceptions. This ensures that the application remains stable even if something goes wrong and a null matcher is supplied.
Scenario 3: Matcher type not of Throwable
  Details:
    TestName: testIfIsThrowableThrowsClassCastExceptionForNonThrowableMatcher
    Description: This test is designed to confirm if the method throws a ClassCastException when a Matcher not of type Throwable is passed.
  Execution:
    Arrange: Instantiate a Matcher not of type Throwable.
    Act: Invoke the isThrowable method with this Matcher as argument.
    Assert: Confirm that a ClassCastException is thrown.
  Validation:
    This test verifies the method's type safety, ensuring that invalid input types lead to clear, understandable exceptions. This helps to maintain robustness and prevent erratic behavior from incorrect Matcher usage.
Scenario 4: Custom Throwable Matcher
  Details:
    TestName: testIfIsThrowableCanHandleCustomThrowableMatcher
    Description: This test checks if the method can handle custom Throwable Matchers.
  Execution:
    Arrange: Instantiate a custom Throwable Matcher.
    Act: Invoke the isThrowable method with the custom Matcher as the argument.
    Assert: Verify that the returned Matcher is the same as the custom Matcher passed.
  Validation:
    This test verifies that the method can handle custom throwable Matchers, ensuring that the functionality is not limited to built-in Matcher types. This promotes flexibility and extensibility in exception handling.
*/
// ********RoostGPT********
package org.junit.matchers;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.StacktracePrintingMatcher;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hamcrest.core.CombinableMatcher.CombinableBothMatcher;
import org.hamcrest.core.CombinableMatcher.CombinableEitherMatcher;
import org.junit.experimental.categories.Category;

@Category(Categories.isThrowable.class)
// Mock for ThrowableMatcher
class ThrowableMatcherMock extends Throwable implements Matcher<Throwable> {

	@Override
	public boolean matches(Object item) {
		return item instanceof Throwable;
	}

	@Override
	public void describeMismatch(Object item, org.hamcrest.Description mismatchDescription) {
	}

	@Override
	public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
	}

	@Override
	public void describeTo(org.hamcrest.Description description) {
	}

}

public class JUnitMatchersIsThrowableTest {

	@Test
	public void testIfIsThrowableReturnsTheCorrectMatcher() {
		Throwable throwableMatcher = new ThrowableMatcherMock();
		Matcher actualMatcher = JUnitMatchers.isThrowable((Matcher<Throwable>) throwableMatcher);
		assertEquals(throwableMatcher, actualMatcher);
	}

	@Test
	public void testIfIsThrowableReturnsNullOnNullInput() {
		Matcher actualMatcher = JUnitMatchers.isThrowable(null);
		assertNull(actualMatcher);
	}

	@Test(expected = ClassCastException.class)
	public void testIfIsThrowableThrowsClassCastExceptionForNonThrowableMatcher() {
		Object nonThrowableMatcher = new Object();
		JUnitMatchers.isThrowable((Matcher<Throwable>) nonThrowableMatcher);
	}

	@Test
	public void testIfIsThrowableCanHandleCustomThrowableMatcher() {
		Throwable throwableMatcher = new ThrowableMatcherMock();
		Matcher actualMatcher = JUnitMatchers.isThrowable((Matcher<Throwable>) throwableMatcher);
		assertEquals(throwableMatcher, actualMatcher);
	}

}