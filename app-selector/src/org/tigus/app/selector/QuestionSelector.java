package org.tigus.app.selector;

import org.tigus.core.*;
import org.tigus.selection.QuestionSelect;
import java.io.*;
import java.util.*;

/**
 * @author Bogdan Cap-Bun
 * 
 */
public class QuestionSelector {

	/**
	 * application that uses QuestionSelect to create QuestionSets from one QuestionSet
	 * @param args
	 */
	public static void main(String[] args) {
		
	    if(args.length == 0){
	        System.out.println("ERROR: Name of the input file is expected");
	        System.exit(-1);
	    }
	    
	    QuestionSet QSet = new QuestionSet();
	    int i = 0;
	    /*
	     * used to scan the parameters
	     */
	    int NumberOfQuestions = -1;
	    /*
	     * Number of questions per resulting question set
	     * its default value is 22
	     */
	    int NumberOfSets = -1;
	    /*
	     * Number of resulting question sets
	     * its default value is the maximum value that could be
	     */
	    if(args[i].equals("-nq")){
	        /*
	         * it means that the next parameter is the number of questions per resulting set
	         */
	        try{
	            NumberOfQuestions = Integer.parseInt(args[i+1]);
	            if(NumberOfQuestions <= 0){
	                System.err.println("ERROR: You must specifiy an integer positive number as NumberOfQuestions");
	                System.exit(2);
	            }
	            i = i + 2;
	        }
	        catch(NumberFormatException e){
	            System.err.println("ERROR: You must specify an integer number as NumberOfQuestions");
	            System.exit(1);
	        }
	    }
	    
	    if(args[i].equals("-ns")){
	        /*
	         * it means that the next parameter is the number of resulting question sets
	         */
	        try{
                NumberOfSets = Integer.parseInt(args[i+1]);
                if(NumberOfSets <= 0){
                    System.err.println("ERROR: You must specifiy an integer positive number as NumberOfSets");
                    System.exit(2);
                }
                i = i + 2;
            }
            catch(NumberFormatException e){
                System.err.println("ERROR: You must specify an integer number as NumberOfSets");
                System.exit(1);
            }
	    }
	    
	    if(args[i].equals("-nq")){
            /*
             * it means that the next parameter is the number of questions per resulting set
             */
	        try{
                NumberOfQuestions = Integer.parseInt(args[i+1]);
                if(NumberOfQuestions <= 0){
                    System.err.println("ERROR: You must specifiy an integer positive number as NumberOfQuestions");
                    System.exit(2);
                }
                i = i + 2;
            }
            catch(NumberFormatException e){
                System.err.println("ERROR: You must specify an integer number as NumberOfQuestions");
                System.exit(1);
            }
        }
        
        if(args[i].equals("-ns")){
            /*
             * it means that the next parameter is the number of resulting question sets
             */
            try{
                NumberOfSets = Integer.parseInt(args[i+1]);
                if(NumberOfSets <= 0){
                    System.err.println("ERROR: You must specifiy an integer positive number as NumberOfSets");
                    System.exit(2);
                }
                i = i + 2;
            }
            catch(NumberFormatException e){
                System.err.println("ERROR: You must specify an integer number as NumberOfSets");
                System.exit(1);
            }
        }
        
        /*
         * The next parameter will be the name of the input file
         */
	    
	    try{
		    QSet = new QuestionSet(args[i]);
		}
		catch(IOException e){
		    System.err.println("ERROR: File " + args[i] + " does not exist");
		    System.exit(0);
		}
		
		/*
		 * Switch to default values if they were not read
		 */
		if(NumberOfQuestions == -1){
		    NumberOfQuestions = 22;
		}
		
		if(NumberOfSets == -1){
		    NumberOfSets = QSet.size() / NumberOfQuestions;
		    /*
		     * We don't want to have common questions between different question polls so
		     * the maximum number of sets is the floor of the total number of questions
		     * divided by the number of questions per question set
		     */
		}
		
		
		
		QuestionSelect QSelect = new QuestionSelect(QSet, NumberOfQuestions, NumberOfSets);
		
		ArrayList<QuestionSet> QuestionPolls = QSelect.split();
		
		for(i = 0; i < QuestionPolls.size(); i++){
		    try{
		        QuestionPolls.get(i).saveToFile("Poll_" + i + ".xml");
		    }
		    catch(IOException e){
		        System.err.println("ERROR: Can't write to file Poll_" + i + ".xml");
		        System.exit(4);
		    }
		}
	}

}