
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class PessoaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (Pessoa pessoa){
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
                
            
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage());
        }
    }
    
    public Pessoa getPessoa(int id){
        String sql = "SELECT * FROM pessoa where id = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Comentários do professor:
            // 1º parâmetro é o SQL
            
            // 2º parâmetro é o tipo do ResultSet -
            // ResultSet scroll, ou seja, o cursor se move para frente ou para trás.
            // Este tipo de ResultSet é sensível às alterações feitas no banco de dados, ou seja, as modificações feitas no banco de dados são refletidas no ResultSet.
            
            // 3º parâmetro é sobre os parâmetros de concorrência – pode ser "read only" ou atualizável

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Pessoa p = new Pessoa();
            
            rs.first();
            
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            
            return p;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar pessoa: "+ ex.getMessage());
            return null;
        }
    }
    
    
    public boolean editar(Pessoa pessoa){
        try{
            String sql = "UPDATE pessoa set nome = ?, sexo = ?, idioma = ? WHERE id = ?";
        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
            
            return true;
        } catch(SQLException ex){
            System.out.println("Erro ao atualizar pessoa: "+ ex.getMessage());
            return false;
        }

        
        
        
    }
}
