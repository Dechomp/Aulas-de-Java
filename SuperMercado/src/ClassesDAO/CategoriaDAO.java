
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
public class CategoriaDAO implements ClasseDAO {
    private Conexao conexao;
    private Connection conn;
    
    public CategoriaDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (Categoria categoria){
        String sql = "INSERT INTO categoria (cat_nome, cat_descricao) VALUES (?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir categoria: " + ex.getMessage());
        }
    }
    
    public Categoria getCategoria(int id){
        String sql = "SELECT * FROM categoria where cat_id = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Categoria c = new Categoria("", "");
            
            rs.first();
            
            c.setId(id);
            c.setId(rs.getInt("cat_id"));
            c.setNome(rs.getString("cat_nome"));
            c.setDescricao(rs.getString("cat_descricao"));
            
            
            return c;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar categoria: "+ ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Categoria> getCategoriasNome(){
        String sql = "SELECT cat_nome FROM categoria";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            Categoria c = new Categoria("", "");
            ArrayList<Categoria> lista = new ArrayList<Categoria>();
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                rs.first();
                
                c.setNome(rs.getString("cat_nome"));
                
                lista.add(c);
            }
            
            return lista;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar categoria: "+ ex.getMessage());
            return null;
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
