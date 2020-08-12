package project2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.jupiter.api.Assertions.*;

class ReviewHandlerHamcrestTest {

    @BeforeEach
    public void setUp() {
        this.reviewHandlerHamTest = new ReviewHandler();
        System.out.println("Setup method test environment.");
    }
    @AfterEach
    public void tearDown() {
        this.reviewHandlerHamTest = null;
        System.out.println("Cleared method test environment");
    }
	
	/**
     * Check that search returns multiple reviews containing same substring
     */
    @Test
    void testSearchBySubstring() {
		
        final MovieReview mock0 = new MovieReview(0, "filePath0", "text0 substring", ReviewScore.NEGATIVE, ReviewScore.NEGATIVE);
        final MovieReview mock1 = new MovieReview(1, "filePath1", "text1 substring", ReviewScore.NEGATIVE, ReviewScore.NEGATIVE);
        
        this.reviewHandlerHamTest.getDatabase().put(mock0.getId(), mock0);
        this.reviewHandlerHamTest.getDatabase().put(mock1.getId(), mock1);

        // Run the test
        final List<MovieReview> result = this.reviewHandlerHamTest.searchBySubstring("substring");

        // Verify the results
        assertEquals(2, result.size(), "searchBySubstring populates successfully returns three objects.");
        assertThat("The returned objects are the right objects.",result, hasItems(mock0, mock1));
    }
	
	// Add more JUnit tests using Hamcrest or IO testing here, at least one for each method in ReviewHandler
	
	public static ReviewHandler reviewHandlerHamTest;
    public final static String NEWLINE = System.getProperty("line.separator");
}
