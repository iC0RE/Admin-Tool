/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.tool;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Markus
 */
public class DataBase {
    
    private Connection c;
    
    private List<Question> createQuestionList (ResultSet rs) {
        List<Question> qList = new ArrayList();
        try{
            while (rs.next()){
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setContent(rs.getString("frage"));
                question.setaAnswer(rs.getString("aAntwort"));
                question.setbAnswer(rs.getString("bAntwort"));
                question.setcAnswer(rs.getString("cAntwort"));
                question.setdAnswer(rs.getString("dAntwort"));
                question.setCategory_id(rs.getInt("kategorie_id"));
                qList.add(question);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return qList;
    }
    
    public void createQuestion (Question question){
        java.sql.PreparedStatement ps;
        try {
            ps = this.c.prepareStatement("INSERT INTO frage (frage,aAntwort,bAntwort,cAntwort,dAntwort,kategorie_id");
            ps.setString(1, question.getContent());
            ps.setString(2, question.getaAnswer());
            ps.setString(3, question.getbAnswer());
            ps.setString(4, question.getcAnswer());
            ps.setString(5, question.getdAnswer());
            ps.setInt(6, question.getCategory_id());
            ps.executeUpdate();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public List<Question> loadQuestion(){
        List<Question> qList = new ArrayList();
        try{
            java.sql.PreparedStatement ps = this.c.prepareStatement("SELECT * FROM frage");
            ResultSet rs = ps.executeQuery();
            qList = createQuestionList(rs);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return qList;
    }
}
