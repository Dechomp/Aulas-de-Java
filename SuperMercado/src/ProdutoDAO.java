
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júlio de Souza
 * @since 23/06/2025;
 */
public class ProdutoDAO implements ClasseDAO{
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    //Alterar
    public void inserir (Produto produto){
        String sql = "INSERT INTO produto (pro_nome, pro_preco, pro_codigoBarras, cat_id) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getCodidgoBarras());
            stmt.setInt(4, produto.getIdCategoria());
            
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    public Produto getProduto(int id){
        String sql = "SELECT pro_nome, pro_preco, pro_codigoBarras, cat_id FROM produto where pro_id = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto("", 0.0f, "", 0);
            
            rs.first();
            
            p.setId(id);
            p.setNome(rs.getString("pro_nome"));
            p.setPreco(rs.getFloat("pro_preco"));
            p.setCodidgoBarras(rs.getString("pro_codigoBarras"));
            p.setIdCategoria(rs.getInt("cat_id"));
            
            
            
            return p;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar produto: "+ ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutos(){
        String sql = "SELECT pro_id, pro_nome FROM produto ";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ArrayList<Produto> lista = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            do{
                Produto p = new Produto("", 0.0f, "", 0);
                p.setId(rs.getInt("pro_id"));
                p.setNome(rs.getString("pro_nome"));
                
                lista.add(p);
            }while(rs.next());
            
            
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
