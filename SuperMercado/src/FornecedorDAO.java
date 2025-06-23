
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
 * @since 23/06/2025;
 */
public class FornecedorDAO implements ClasseDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FornecedorDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (for_CNPJ, for_nome, for_nomeFantasia) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCNPJ());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getNomeFantasia());            
            
            
            stmt.execute();
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir fornecedor: " + ex.getMessage());
        }
    }
    
    public Fornecedor getFornecedor(String CNPJ){
        String sql = "SELECT for_nome, for_nomeFantasia FROM fornecedor where for_CNPJ = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            

            stmt.setString(1, CNPJ);
            ResultSet rs = stmt.executeQuery();
            Fornecedor f = new Fornecedor("", "", "");
            
            rs.first();
            
            f.setCNPJ(CNPJ);
            f.setNome(rs.getString("for_nome"));
            f.setNomeFantasia(rs.getString("for_nomeFantasia"));
            
            
            
            return f;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar fornecedor: "+ ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Fornecedor> getFornecedores(){
        String sql = "SELECT for_CNPJ, for_nomeFantasia FROM fornecedor ";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ArrayList<Fornecedor> lista = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            
            do{
                Fornecedor f = new Fornecedor("", "", "");
                f.setCNPJ(rs.getString("for_CNPJ"));
                f.setNomeFantasia(rs.getString("for_nomeFantasia"));                
                lista.add(f);
            }while(rs.next());
            
            
            return lista;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar fornecedor: "+ ex.getMessage());
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
