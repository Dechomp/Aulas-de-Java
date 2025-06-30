
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author PC-connect
 */
public class NotaProdutoDAO implements ClasseDAO {
    private Conexao conexao;
    private Connection conn;
    
    public NotaProdutoDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public void inserir (NotaProduto notaProduto){
        if ("Entrada".equals(notaProduto.getTipo())){
            String sql = "INSERT INTO  notaEntradaProduto (nEP_quantidade, nEP_valorUnitario, nEP_valorTotal, pro_id, noE_id) "
                    + "VALUES (?,?,?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, notaProduto.getQuantidade());
                stmt.setFloat(2, notaProduto.getValorUnitario());
                stmt.setFloat(3, notaProduto.getValorTotal());
                stmt.setInt(4, notaProduto.getProdutoID());
                stmt.setInt(5, notaProduto.getNotaId());
                

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir produtos na nota de entrada: " + ex.getMessage());
            }
        }
        else{
            String sql = "INSERT INTO  notaSaidaProduto (nSP_quantidade, nSP_valorUnitario, nSP_valorTotal, pro_id, noS_id) "
                    + "VALUES (?,?,?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, notaProduto.getQuantidade());
                stmt.setFloat(2, notaProduto.getValorUnitario());
                stmt.setFloat(3, notaProduto.getValorTotal());
                stmt.setInt(4, notaProduto.getProdutoID());
                stmt.setInt(5, notaProduto.getNotaId());
                

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir produtos na nota de saida: " + ex.getMessage());
            }
        }
        
    }
    
    public ArrayList<NotaProduto> getProdutosNota(NotaProduto notaProduto){
        if ("Entrada".equals(notaProduto.getTipo())){
            
            String sql = "SELECT mEP_id, nEP_quantidade, nEP_valorUnitario, nEP_valorTotal, pro_id "
                    + "FROM notaEntradaProduto "
                    + "where noE_id = ?";

            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ArrayList<NotaProduto> lista = new ArrayList<>();
                stmt.setInt(1, notaProduto.getNotaId()  );
                ResultSet rs = stmt.executeQuery();

                rs.first();
                do{
                    NotaProduto np = new NotaProduto();
                    np.setId(rs.getInt("nEP_id"));
                    np.setQuantidade(rs.getInt("nEP_quantidade"));
                    np.setValorUnitario(rs.getFloat("nEP_valorInitario"));
                    np.setValorTotal(rs.getFloat("nEP_valorInitario"));
                    np.setProdutoID(rs.getInt("pro_id"));
                    // np.setNotaId(notaProduto.getNotaId());

                    lista.add(np);
                }while(rs.next());


                return lista;
            }catch (SQLException ex){
                System.out.println("Erro ao consultar produtos na nota: "+ ex.getMessage());
                return null;
            }
        }
        else{
            String sql = "SELECT nSP_id, nSP_quantidade, nSP_valorUnitario, nSP_valorTotal, pro_id "
                    + "FROM notaSaidaProduto "
                    + "where noS_id = ?";
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ArrayList<NotaProduto> lista = new ArrayList<>();
                
                stmt.setInt(1, notaProduto.getNotaId());
                
                ResultSet rs = stmt.executeQuery();

                rs.first();
                do{
                    NotaProduto np = new NotaProduto();
                    np.setId(rs.getInt("nSP_id"));
                    np.setQuantidade(rs.getInt("nSP_quantidade"));
                    np.setValorUnitario(rs.getFloat("nSP_valorUnitario"));
                    np.setValorTotal(rs.getFloat("nSP_valorTotal"));
                    np.setProdutoID(rs.getInt("pro_id"));
                    // np.setNotaId(notaProduto.getNotaId());

                    lista.add(np);
                }while(rs.next());


                return lista;
            }catch (SQLException ex){
                System.out.println("Erro ao consultar produtos na nota: "+ ex.getMessage());
                return null;
            }
        }
    }
    
   /*
     public Produto getProduto(int id){
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
    
    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deletar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
