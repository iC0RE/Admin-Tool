/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.tool;

/**
 *
 * @author Paul
 */
public class Question {
    private int id;
    private String content;
    private String aAnswer;
    private String bAnswer;
    private String cAnswer;
    private String dAnswer;
    
    public Question() {
    }
    
    public Question(int id, String content, String aAnswer, String bAnswer, String cAnswer, String dAnswer) {
        this.id = id;
        this.content = content;
        this.aAnswer = aAnswer;
        this.bAnswer = bAnswer;
        this.cAnswer = cAnswer;
        this.dAnswer = dAnswer;
    }

    public int getId() {
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
    
}