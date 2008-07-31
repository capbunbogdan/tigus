package org.tigus.selection;

import org.tigus.core.*;
import java.util.*;

/**
 * @author Bogdan Cap-Bun
 * 
 */
public class QuestionSelect {
    
    /*
     * Class that splits a given question set into several (close to) equal difficulty question sets
     */
    
    private int NumberOfQuestions;
    /*
     * Number of questions that a resulting question set should contain ( default : 22 )
     */
    
    private int NumberOfSets;
    /*
     * Number of resulting question sets ( default : The maximum number that could be ) 
     */
    
    private int NumberOfDifficulties;
    /*
     * Number of difficulties of the questions
     * There are 3 possible difficulties:
     * 1 - difficult
     * 2 - medium
     * 3 - easy
     */
    
    private QuestionSet QSet;
    /*
     * The initial question set
     */
    
    public void setNumberOfQuestions(int NumberOfQuestions){
        this.NumberOfQuestions = NumberOfQuestions;
    }
    
    public int getNumberOfQuestions(){
        return(NumberOfQuestions);
    }
    
    public void setNumberOfSets(int NumberOfSets){
        this.NumberOfSets = NumberOfSets;
    }
    
    public int getNumberOfSets(){
        return(NumberOfSets);
    }
    
    public int getNumberOfDifficulties(){
        return(NumberOfDifficulties);
    }
    
    public void setQuestionSet(QuestionSet QSet){
        this.QSet = new QuestionSet(QSet);
    }
    
    public QuestionSet getQuestionSet(){
        return(QSet);
    }
    
    public QuestionSelect(QuestionSet QSet, int NumberOfQuestions, int NumberOfSets){
        this.QSet = new QuestionSet(QSet);
        this.NumberOfQuestions = NumberOfQuestions;
        this.NumberOfSets = NumberOfSets;
        this.NumberOfDifficulties = 3;
    }
    
    /*
     * Function for splitting one question set into several question sets
     * @param QSet input question set
     * @return the resulting list of question sets
     */
    public ArrayList<QuestionSet> split(){
        
        ArrayList<QuestionSet> QuestionPolls = new ArrayList<QuestionSet>();
        
        return QuestionPolls;
    }
}