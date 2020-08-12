package jUnitExamples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.*;
import static java.time.Duration.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class StandardJavaBasicTest {
  
  @Test
  public void testArraysEquals() {
	  
	  char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
	  char[] actual = "Jupiter".toCharArray();
	  
	  assertArrayEquals(expected, actual, "Arrays should be equal");
  }//end test ArraysEqual
  
  @Disabled
  public void testFail() {
	  // Test not completed
	  fail("FAIL - test not completed");
  }//end testFail
  
  @Test
  public void testMultipleAssertion() {  
  
	  assertAll("heading",
      () -> assertEquals(4, 2*2, "4 is 2 times 2"),
      () -> assertEquals("java", "JAVA".toLowerCase())
	  );
  }//end 
  
  @Test
  public void testEqualIterator() {
	  
	  Iterable<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
	  Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));
	  
	  assertIterableEquals(al, ll);
  }
  
  public void testNotEqual() {
	  
	  Integer value = 5; // result of an algorithm
	  
	  assertNotEquals(0, value, "The result cannot be 0");
  }
  
  @Test
  void testExpectedException() {
	  
	  assertThrows(NumberFormatException.class, () -> {
		  Integer.parseInt("One");});
  }
  
  @Test
  public void testTimeout() {
	  
	// code that requires less then 2 seconds to execute, sleep is in miliSeconds 
    assertTimeout(ofSeconds(2),() -> {  Thread.sleep(1000);});

  }

}
