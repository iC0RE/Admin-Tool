package org.gruppe7.admintool.controller.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import config.Configuration;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import org.gruppe7.admintool.controller.DefaultConnection;
import org.gruppe7.admintool.controller.MySqlConnection;
import org.gruppe7.admintool.model.Category;
import org.gruppe7.admintool.model.Question;
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
    private Integer questionId;

    @Before
    public void init() {
        try {
            connection = new MySqlConnection();
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
        log.info(String.format("Auslesen der Kategorie durchgeführt. Primärschlüssel ist %d.", category.getId()));
        
        List<Category> categories = connection.getCategories();
        Assert.assertFalse(categories.isEmpty());
        log.info("Holen aller Kategorien durchgeführt");
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
        Category category = new Category();
        category.setTitle("deault-category");
        Question question = new Question();
        question.setContent("default-content");
        question.setaAnswer("default-aAnswer");
        question.setbAnswer("default-bAnswer");
        question.setcAnswer("default-cAnswer");
        question.setdAnswer("default-dAnswer");
        category = connection.createCategory(category);
        question.setCategory_id(category.getId());
        question = connection.createQuestion(question);
        Assert.assertNotNull(category.getId());
        categoryId = category.getId();
        Assert.assertNotNull(question.getId());
        questionId = question.getId();
        log.info(String.format("Erzeugen der Frage druchgeführt. Primärschlüssel der Frage ist %d.", questionId));
    }

    public void readQuestionTest() {
        Question question = connection.findQuestionById(questionId);
        Assert.assertNotNull(question);
        log.info(String.format("Auslesen der Frage druchgeführt. Primärschlüssel ist %d.", question.getId()));
    }

    public void updateQuestionTest() {
        Category category = connection.findCategoryById(categoryId);
        Question question = connection.findQuestionById(questionId);
        question.setContent("edit-content");
        question.setaAnswer("edit-aAnswer");
        question.setbAnswer("edit-bAnswer");
        question.setcAnswer("edit-cAnswer");
        question.setdAnswer("edit-dAnswer");
        question.setCategory_id(category.getId());
        connection.updateQuestion(question);
        Assert.assertEquals("edit-content", question.getContent());
        Assert.assertEquals("edit-aAnswer", question.getaAnswer());
        Assert.assertEquals("edit-bAnswer", question.getbAnswer());
        Assert.assertEquals("edit-cAnswer", question.getcAnswer());
        Assert.assertEquals("edit-dAnswer", question.getdAnswer());
        Assert.assertEquals(categoryId, category.getId());
        log.info(String.format("Aktualisieren der Frage druchgeführt. Primärschlüssel ist %d.", question.getId()));
    }

    public void deleteQuestionTest() {
        // Aufräumen heißt: Nicht nur <Question> wegwerfen, sondern auch <Category>.
        Question question = connection.findQuestionById(questionId);
        Category category = connection.findCategoryById(categoryId);
        connection.deleteQuestion(question);
        connection.deleteCategory(category);       
        question = connection.findQuestionById(questionId);
        Assert.assertNull(question);
        category = connection.findCategoryById(categoryId);
        Assert.assertNull(category);
        log.info(String.format("Löschen der Frage druchgeführt. Referenz ist %s.", question));
    }
}
