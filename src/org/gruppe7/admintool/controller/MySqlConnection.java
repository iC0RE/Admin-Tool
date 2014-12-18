/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gruppe7.admintool.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gruppe7.admintool.model.Category;
import org.gruppe7.admintool.model.Question;

/**
 *
 * @author Paul
 */
public class MySqlConnection implements DefaultConnection {
    
    private static final Logger log = Logger.getLogger(MySqlConnection.class.getCanonicalName());
    private final Connection connection;
    private final PreparedStatement createCategoryQuery;
    private final PreparedStatement findCategoryById;
    private final PreparedStatement findCategoryByDescription;
    private final PreparedStatement updateCategory;
    private final PreparedStatement deleteCategory;
    private final PreparedStatement createQuestion;
    private final PreparedStatement findQuestionById;
    private final PreparedStatement updateQuestion;
    private final PreparedStatement deleteQuestion;
    private final PreparedStatement getQuestionsByCategoryId;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            log.severe(ex.getMessage());
        }
    }
    
    public MySqlConnection(String url, String username, String password) throws SQLException {
        if (url == null || username == null || password == null) {
            throw new IllegalArgumentException("Für Datenbankverbindung muss URL und Nutzername angegeben werden.");
        } else if (url.isEmpty() || username.isEmpty()) {
            throw new IllegalArgumentException("URL oder Nutzername ist ungültig");
        }
        connection = DriverManager.getConnection(url, username, password);
        
        createCategoryQuery = connection.prepareStatement("INSERT INTO kategorie (bezeichnung) VALUES (?);", new String[]{"id"});
        findCategoryById = connection.prepareStatement("SELECT * FROM kategorie WHERE id=?");
        findCategoryByDescription = connection.prepareStatement("SELECT * FROM kategorie WHERE bezeichnung=?");
        updateCategory = connection.prepareStatement("UPDATE kategorie SET bezeichnung=? WHERE id=?");
        deleteCategory = connection.prepareStatement("DELETE FROM kategorie WHERE id=?");
        
        createQuestion = connection.prepareStatement("INSERT INTO frage (content,aAnswer,bAnswer,cAnswer,dAnswer,category_id) VALUES (?,?,?,?,?,?);", new String[]{"id"});
        findQuestionById = connection.prepareStatement("SELECT * FROM frage WHERE if=?");
        updateQuestion = connection.prepareStatement("UPDATE frage SET frage=?,aAntwort=?,bAntwort=?,cAntwort=?,dAntwort=?,kategorie_id=? WHERE id=?");
        deleteQuestion = connection.prepareStatement("DELETE FROM frage WHERE id=?");
        getQuestionsByCategoryId = connection.prepareStatement("SELECT * FROM frage WHERE kategorie_id=?");
    }
    
    @Override
    public Category createCategory(Category category) {
        // Zur Vermeidung von NullPointer-Exceptions
        if (category != null) {
            try {
                // Ausführen des INSERT-Queries.
                createCategoryQuery.setString(1, category.getTitle());
                createCategoryQuery.executeUpdate();

                // Bestimmen des vergebenen Primärschlüssels.
                try (ResultSet result = createCategoryQuery.getGeneratedKeys()) {
                    if (result.next()) {
                        final int categoryId = (int) result.getLong(1);
                        category.setId(categoryId);
                    }
                }
            } catch (SQLException ex) {
                log.warning(ex.getMessage());
            }
        }
        return category;
    }
    
    @Override
    public Category findCategoryById(int id) {
        Category category = null;
        try {
            findCategoryById.setInt(1, id);
            try (ResultSet result = findCategoryById.executeQuery()) {
                if (result.next()) {
                    category = new Category();
                    category.setId(result.getInt("id"));
                    category.setTitle(result.getString("bezeichnung"));
                }
            }
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
        
        return category;
    }
    
    @Override
    public Category findCategoryByDescription(String description) {
        Category category = null;
        try {
            findCategoryByDescription.setString(1, description);
            try (ResultSet result = findCategoryByDescription.executeQuery()) {
                if (result.next()) {
                    category = new Category();
                    category.setId(result.getInt("id"));
                    category.setTitle(result.getString("bezeichnung"));
                }
            }
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
        return category;
    }
    
    @Override
    public void updateCategory(Category category) {
        try {
            updateCategory.setString(1, category.getTitle());
            updateCategory.setInt(2, category.getId());
            updateCategory.executeUpdate();
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
    }
    
    @Override
    public void deleteCategory(Category category) {
        try {
            deleteCategory.setInt(1, category.getId());
            deleteCategory.executeUpdate();
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
    }
    
    @Override
    public Question createQuestion(Question question) {
        if (question != null) {
            try {
                createQuestion.setString(1, question.getContent());
                createQuestion.setString(2, question.getaAnswer());
                createQuestion.setString(3, question.getbAnswer());
                createQuestion.setString(4, question.getcAnswer());
                createQuestion.setString(5, question.getdAnswer());
                createQuestion.setInt(6, question.getCategory_id());
                createQuestion.executeUpdate();
                try (ResultSet result = createQuestion.getGeneratedKeys()) {
                    if (result.next()) {
                        final int id = (int) result.getLong(1);
                        question.setId(id);
                    }
                }
            } catch (SQLException ex) {
                log.warning(ex.getMessage());
            }
        }
        return question;
    }
    
    @Override
    public Question findQuestionById(int id) {
        Question question = null;
        try {
            findQuestionById.setInt(1, id);
            try (ResultSet result = findQuestionById.executeQuery()) {
                if (result.next()) {
                    question = new Question();
                    question.setId(result.getInt("id"));
                    question.setContent(result.getString("frage"));
                    question.setaAnswer(result.getString("aAntwort"));
                    question.setaAnswer(result.getString("bAntwort"));
                    question.setaAnswer(result.getString("cAntwort"));
                    question.setaAnswer(result.getString("dAntwort"));
                    question.setCategory_id(result.getInt("kategorie_id"));
                }
            }
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
        return question;
    }
    
    @Override
    public void updateQuestion(Question question) {
        try {
            updateQuestion.setString(1, question.getContent());
            updateQuestion.setString(2, question.getaAnswer());
            updateQuestion.setString(3, question.getbAnswer());
            updateQuestion.setString(4, question.getcAnswer());
            updateQuestion.setString(5, question.getdAnswer());
            updateQuestion.setInt(6, question.getCategory_id());
            updateQuestion.executeUpdate();
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
    }
    
    @Override
    public void deleteQuestion(Question question) {
        try {
            deleteQuestion.setInt(1, question.getId());
            deleteQuestion.executeUpdate();
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
    }
    
    @Override
    public List<Question> getQuestionsByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Keine Kategorie angegeben.");
        }
        
        return getQuestionsByCategoryId(category.getId());
    }
    
    @Override
    public List<Question> getQuestionsByCategoryId(int categoryId) {
        List<Question> questionList = new ArrayList<>();
        Question question = null;
        try {
            getQuestionsByCategoryId.setInt(1, categoryId);
            try (ResultSet result = getQuestionsByCategoryId.executeQuery()) {
                while (result.next()) {
                    question = new Question();
                    question.setId(result.getInt("id"));
                    question.setContent("frage");
                    question.setaAnswer("aAntwort");
                    question.setbAnswer("bAntwort");
                    question.setcAnswer("cAntwort");
                    question.setdAnswer("dAntwort");
                    question.setCategory_id(result.getInt("kategorie_id"));
                    questionList.add(question);
                }
            }
        } catch (SQLException ex) {
            log.warning(ex.getMessage());
        }
        return questionList;
    }
    
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
