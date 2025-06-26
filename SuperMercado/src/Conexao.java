
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júlio de Souza
 * @since 09/06/2025;
 */
public class Conexao {
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bdMercado?useTimezone=true&serverTimezone=UTC",
                "", "");
            System.out.println("Conexão realizada com sucesso!");
            return conn;
        }
        catch(Exception e){
            System.out.println("Erro ao conectar no BD: " + e.getMessage());
            return null;
        }
    }
}
