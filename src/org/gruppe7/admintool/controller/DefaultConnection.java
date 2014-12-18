/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gruppe7.admintool.controller;

import java.util.List;
import org.gruppe7.admintool.model.Category;
import org.gruppe7.admintool.model.Question;

/**
 *
 * @author Markus
 */
public interface DefaultConnection extends AutoCloseable{
    
    public Category createCategory(Category category); 
    
    public Category findCategoryById(int id);
    
    public Category findCategoryByDescription(String description);
    
    public void updateCategory(Category category);
    
    public void deleteCategory(Category category);
    
    public Question createQuestion (Question question);
    
    public Question findQuestionById(int id);
    
    public void updateQuestion (Question question);
    
    public void deleteQuestion (Question question);
    
    public List<Question> getQuestionsByCategory (Category category);
    
    public List<Question> getQuestionsByCategoryId (int categoryId);
}
