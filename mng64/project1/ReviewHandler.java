package project1;

import java.io.Closeable;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.PrintWriter;

/**
*CS3354 Spring 2020 ReviewHandler Implementation
* @author Michael Griggs
*/



public class ReviewHandler extends AbstractReviewHandler {

    private HashMap<Integer, MovieReview> database = new HashMap<Integer, MovieReview>();
    /**
    *override function to use database
    *
    *
    */
    @Override
    public Map<Integer, MovieReview> getDatabase() {
        return database;
    }

    /**
    *loads reviews into the database
    *@param filePath
    *@param realClass
    *
    *
    */

  public void loadReviews(String filePath, int realClass){
    File folder = new File(filePath);

    if(folder.getName().endsWith(".txt") == true){

      try{

      MovieReview mr = readReview(filePath, realClass);
      mr.setPredictedScore(classifyReview(mr));
      int id = mr.getId();
      String idstr = String.valueOf(id);
      Integer myId = Integer.valueOf(idstr);
      database.put(myId, mr);
    }
      catch(IOException e){
        e.printStackTrace();
      }

      }
    else{

      File[] listOfFiles = folder.listFiles();
      for(int i = 0; i < listOfFiles.length; i++){
        File file = listOfFiles[i];
        String fp = file.getAbsolutePath();
        try{
          MovieReview mr2 = readReview(fp, realClass);
          mr2.setPredictedScore(classifyReview(mr2));
          int id2 = mr2.getId();
          String id2str = String.valueOf(id2);
          Integer myId2 = Integer.valueOf(id2str);
          database.put(myId2, mr2);
        }
        catch(IOException e){
          e.printStackTrace();
        }
      }
    }
  }

  /**
  *classifies the predicted review score of the movie review
  *@param review
  *
  */
  public ReviewScore classifyReview(MovieReview review){
    int posCount = 0;
    int negCount = 0;

    String phText ="";
    phText = review.getText();

    phText.replaceAll("\\p{Punct}", "");
    phText = phText.toLowerCase();

    String[] textArray = phText.split("\\s+");

    for (int i = 0; i < textArray.length; i++ ){
      if(getPosWords().contains(textArray[i]) == true){
        posCount++;
      }
      else if(getNegWords().contains(textArray[i]) == true){
        negCount++;
      }
    }

    ReviewScore classification = ReviewScore.UNKNOWN;

    if(posCount > negCount){
      classification = ReviewScore.POSITIVE;
    }
    else if(negCount > posCount){
      classification = ReviewScore.NEGATIVE;
    }

    review.setPredictedScore(classification);
    return classification;
  }
  /**
  *creates a basic movie review object from filePath
  *@param reviewFilePath
  *@param realClass
  *@throws IOException
  */
  public MovieReview readReview(String reviewFilePath, int realClass) throws IOException{
    Scanner readInFile = new Scanner(new FileReader(reviewFilePath));
    ReviewScore predictedScore = ReviewScore.UNKNOWN;
    ReviewScore realScore = ReviewScore.fromInteger(realClass);
    int id = getReviewIdCounter();
    String currentLine = "";
    String text="";

    while (readInFile.hasNextLine()){
      currentLine = readInFile.nextLine();
      text = text.concat(currentLine) + "\n";
    }
    close(readInFile);

    MovieReview myReview = new MovieReview (id, reviewFilePath, text, realScore, predictedScore);
    setReviewIdCounter(id + 1);

    return myReview;
  }

  /**
  *deletes review from the database
  *@param id
  *
  */
  public void deleteReview(int id){

    for(int i = 0; i < database.size(); i++) {
      if(database.containsKey(id) == true && i == id){
        database.remove(i);
        setReviewIdCounter(database.size());
      }
    }


  }

  /**
  *saves the current database to a text file
  *@throws IOException
  *
  */
  public void saveDB() throws IOException{

    boolean overright;
    if(database.size()>1000){
      overright = false;
    }
    else{
      overright = true;
    }

    PrintWriter outFile = new PrintWriter(new FileWriter(DATA_FILE_NAME, overright));


    String m = "~";

    for(int i = 0; i < database.size(); i++){
      MovieReview rh = database.get(i);
      outFile.println(rh.getId() + m + rh.getFilePath() + m + rh.getRealScore() + m + rh.getPredictedScore() + m);

    }

  }

  /**
  *loads the database text file and reads its data into working database
  *@throws IOException
  *
  */
  public void loadDB() throws IOException{

    File fp = new File(DATA_FILE_NAME);
    if (fp.exists()==true){
    Scanner scnr = new Scanner(fp);
    String inFile="";
    while(scnr.hasNextLine() == true){
      inFile = scnr.nextLine();
      String[] mr = new String[4];
      mr = inFile.split("~",4);

      String idString = mr[0];
      String filePath = mr[1];
      String realScoreStr = mr[2];
      String predictedScoreStr = mr[3];

      int id = Integer.parseInt(idString);
      ReviewScore realScore = ReviewScore.fromString(realScoreStr);
      ReviewScore predictedScore = ReviewScore.fromString(predictedScoreStr);
      File fpmr = new File(filePath);
      Scanner textReader = new Scanner(fpmr);
      String text="";
      while(textReader.hasNextLine() == true){

        String currentLine = textReader.nextLine();
        text = currentLine + "\n";

      }

      MovieReview mr1 = new MovieReview(id, filePath, text, realScore, predictedScore);
      String Aid = String.valueOf(mr1.getId());
      Integer myId = Integer.valueOf(Aid);
      database.put(myId, mr1);

      }
    }
    else{
      System.out.println("database doesnt exist");

    }


  }
  /**
  *returns movereview object based on id
  *@param id
  *
  */
  public MovieReview searchById(int id){
    String myid = String.valueOf(id);
    Integer theid = Integer.valueOf(myid);

    MovieReview mr = database.get(theid);
    return mr;
  }

  /**
  *returns a list of moveReview objects based on presence of substring in textArray
  *@param substring
  *
  *
  */

  public List<MovieReview> searchBySubstring(String substring){

    List<MovieReview> mrList = new ArrayList<MovieReview>();

    for(int i = 0; i < database.size(); i++){
      MovieReview mr = database.get(i);
      if(mr.getText().contains(substring) == true){
        mrList.add(mr);
      }
    }



    return mrList;

  }


}
