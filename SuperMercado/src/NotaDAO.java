
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
public class NotaDAO implements ClasseDAO{
    private Conexao conexao;
    private Connection conn;
    
    public NotaDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (Nota nota){
        if ("Entrada".equals(nota.getTipo())){
            String sql = "INSERT INTO notaEntrada (noE_data, noE_valorTotal, for_CNPJ) VALUES (?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, nota.getData());
                stmt.setFloat(2, nota.getValorTotal());
                stmt.setString(3, nota.getOperador());

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir nota de entrada: " + ex.getMessage());
            }
        }
        else{
            String sql = "INSERT INTO notaSaida (noE_data, noE_valorTotal, cli_CPF) VALUES (?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, nota.getData());
                stmt.setFloat(2, nota.getValorTotal());
                stmt.setString(3, nota.getOperador());

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir nota de saida: " + ex.getMessage());
            }
        }
        
    }
    public int getID (Nota nota){
        if ("Entrada".equals(nota.getTipo())){
            String sql = "Select noE_id from notaEntrada where noE_notaFiscal = ?;";
        
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                

                stmt.setString(1, nota.getNotaFiscal());
                ResultSet rs = stmt.executeQuery();

                rs.first();

                nota.setId(rs.getInt("noR_id"));



                return nota.getId();
            }catch (SQLException ex){
                System.out.println("Erro ao consultar id: "+ ex.getMessage());
                return 0b0;
            }
        }
        else{
            String sql = "Select noS_id from notaSaida where noE_notaFiscal = ?;";
        
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                

                stmt.setString(1, nota.getNotaFiscal());
                ResultSet rs = stmt.executeQuery();

                rs.first();

                nota.setId(rs.getInt("noR_id"));



                return nota.getId();
            }catch (SQLException ex){
                System.out.println("Erro ao consultar id: "+ ex.getMessage());
                return 0b0;
            }
        }
    }
    
    
    /*
    public Produto getProduto(int id, String tipo){
        String sql = "SELECT pro_nome, pro_preco, pro_codigoBarras, pro_estoque, cat_id FROM produto where pro_id = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto p = new Produto("", 0.0f, "", 0, 0);
            
            rs.first();
            
            p.setId(id);
            p.setNome(rs.getString("pro_nome"));
            p.setPreco(rs.getFloat("pro_preco"));
            p.setCodidgoBarras(rs.getString("pro_codigoBarras"));
            p.setEstoque(rs.getInt("pro_estoque"));
            p.setIdCategoria(rs.getInt("cat_id"));
            
            
            
            return p;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar produto: "+ ex.getMessage());
            return null;
        }
    }
    */
    /*
    public ArrayList<Produto> getProdutos(){
        String sql = "SELECT pro_id, pro_nome FROM produto ";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ArrayList<Produto> lista = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            do{
                Produto p = new Produto( "", 0.0f, "", 0, 0);
                p.setId(rs.getInt("pro_id"));
                p.setNome(rs.getString("pro_nome"));
                
                lista.add(p);
            }while(rs.next());
            
            
            return lista;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar produto: "+ ex.getMessage());
            return null;
        }
    }
    */
    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
