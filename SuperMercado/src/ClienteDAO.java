
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júlio de Souza
 * @since 16/06/2025;
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
}
