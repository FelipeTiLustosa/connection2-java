package src.applicantion;

import src.db.DB;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        System.out.println("Conexão bem-sucedida!");
        Statement st =null;/*Armazena resultados de uma consulta SQL.
        Permite navegar e acessar dados retornados por essa consulta.
        Oferece métodos para obter dados de diferentes tipos.*/
        ResultSet rs=null;//ele serve pra você montar o comando SQL para ser executado no caso para recuperar os dados do banco de dados.
        try {
            conn = DB.getConnection();
            st=conn.createStatement();

            rs=st.executeQuery("select * from department");
            while (rs.next()){
                System.out.println(rs.getInt("Id")+ ","+ rs.getString("Name"));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        finally {
        DB.closeConnection();
        DB.closeResultset(rs);
        DB.closeStatement(st);
        }
        System.out.println("Teste");
    }
}
