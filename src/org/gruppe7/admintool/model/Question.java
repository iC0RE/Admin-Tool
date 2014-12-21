/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gruppe7.admintool.model;

/**
 *
 * @author Paul
 */
public class Question {
    private Integer id;
    private String content;
    private String aAnswer;
    private String bAnswer;
    private String cAnswer;
    private String dAnswer;
    private Integer category_id;
   
    public Question() {
    id = null;
    content = null;
    aAnswer = null;
    bAnswer = null;
    cAnswer = null;
    dAnswer = null;
    category_id = null;
    }

    
    
    
    public Question(int id, String content, String aAnswer, String bAnswer, String cAnswer, String dAnswer, int category_id) {
        this.id = id;
        this.content = content;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.dAnswer = dAnswer;
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getaAnswer() {
        return aAnswer;
    }

    public void setaAnswer(String aAnswer) {
        this.aAnswer = aAnswer;
    }

    public String getbAnswer() {
        return bAnswer;
    }

    public void setbAnswer(String bAnswer) {
        this.bAnswer = bAnswer;
    }

    public String getcAnswer() {
        return cAnswer;
    }

    public void setcAnswer(String cAnswer) {
        this.cAnswer = cAnswer;
    }

    public String getdAnswer() {
        return dAnswer;
    }

    public void setdAnswer(String dAnswer) {
        this.dAnswer = dAnswer;
    }
    
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return getContent();
    }
}