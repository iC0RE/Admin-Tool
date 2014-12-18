package org.gruppe7.admintool.controller.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.logging.Logger;
import org.gruppe7.admintool.controller.DefaultConnection;
import org.gruppe7.admintool.controller.MySqlConnection;
import org.gruppe7.admintool.model.Category;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langep16
 */
public class MySqlConnectionTest {

    private static final Logger log = Logger.getLogger(MySqlConnectionTest.class.getCanonicalName());
    private DefaultConnection connection;
    private Integer categoryId;

    @Before
    public void init() {
        try {
            connection = new MySqlConnection("jdbc:mysql://127.0.0.1:3306/qtool", "root", "");
        } catch (SQLException e) {
            log.severe(e.getMessage());
        }
    }

    @After
    public void clean() throws Exception {
        connection.close();
    }

    @Test
    public void categoryCrudTest() {
        createCategoryTest();
        readCategoryTest();
        updateCategoryTest();
        deleteCategoryTest();
    }
    
    @Test
    public void questionCrudTest() {
        createQuestionTest();
        readQuestionTest();
        updateQuestionTest();
        deleteQuestionTest();
    }

    public void createCategoryTest() {
        Category category = new Category();
        category.setTitle("test");
        category = connection.createCategory(category);
        Assert.assertNotNull(category.getId());
        categoryId = category.getId();
        log.info(String.format("Erzeugen der Kategorie druchgeführt. Primärschlüssel ist %d.", categoryId));
    }

    public void readCategoryTest() {
        Category category = connection.findCategoryById(categoryId);
        Assert.assertNotNull(category);
        log.info(String.format("Auslesen der Kategorie druchgeführt. Primärschlüssel ist %d.", category.getId()));
    }

    public void updateCategoryTest() {
        Category category = connection.findCategoryById(categoryId);
        category.setTitle("testUpdate");
        connection.updateCategory(category);

        category = connection.findCategoryById(categoryId);
        Assert.assertEquals("testUpdate", category.getTitle());
        log.info(String.format("Aktualisieren der Kategorie druchgeführt. Primärschlüssel ist %d.", category.getId()));
    }

    public void deleteCategoryTest() {
        Category category = connection.findCategoryById(categoryId);
        connection.deleteCategory(category);

        category = connection.findCategoryById(categoryId);
        Assert.assertNull(category);
        log.info(String.format("Löschen der Kategorie druchgeführt. Referenz ist %s.", category));
    }
    
    public void createQuestionTest() {
        
    }
    
    public void readQuestionTest() {
        
    }
    
    public void updateQuestionTest() {
        
    }
    
    public void deleteQuestionTest() {
        // Aufräumen heißt: Nicht nur <Question> wegwerfen, sondern auch <Category>.
    }
}
