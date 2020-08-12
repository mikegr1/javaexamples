package project2;

import java.util.List;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


class ReviewHandlerTest {
  
    @BeforeEach
    public void setUp() {
        System.out.println("Setup method test environment.");
		//add setup statements here
		this.reviewHandlerUnderTest = new ReviewHandler();
    }
	
    @AfterEach
    public void tearDown() {
        System.out.println("Cleared method test environment");
		//add clear statements here
		this.reviewHandlerUnderTest = null; 
    }

    /**
     * Exemplar test case that loads an empty folder with no files in it
	 * @author steckler 
     */
    @Test
    void testLoadReviewsEmpty() {
	
        // Run the test - NullPointerException
        this.reviewHandlerUnderTest.loadReviews(this.emptyFolderPath, 0);

        // Verify the results
        assertEquals(0, reviewHandlerUnderTest.getDatabase().size(), "Loadreviews test on an empty folder");
    }
	
    /**
     * Add more tests here, at least 1 for each of the eight ReviewHandler methods 
     */
	 
	 
	/**
     * Series of pathing variables in root content folder using several created, empty, and provided folders/files to validate and expand ease of testing methods
     */
    public static ReviewHandler reviewHandlerUnderTest;
    private final static String NEWLINE = System.getProperty("line.separator");
    public static String filePath = "./test/data/Movie-reviews/notemptyfolder/test.txt";
    public static String singleRevPathPos = "./test/data/Movie-reviews/pos/204_10.txt";
    public static String singleRevPathNeg = "./test/data/Movie-reviews/neg/46_4.txt";
	public static String emptyFolderPath = "./test.data/Movie-reviews/emptyfolder";
  
}
