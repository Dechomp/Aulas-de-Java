
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
public class ClienteDAO implements ClasseDAO{
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (Cliente cliente){
        String sql = "INSERT INTO cliente (cli_cpf, cli_nome, cli_email) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCPF());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage());
        }
    }


    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
