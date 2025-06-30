
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
            String sql = "INSERT INTO notaEntrada (noE_data, noE_valorTotal, noE_notaFiscal,for_CNPJ) VALUES (?,?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, nota.getData());
                stmt.setFloat(2, nota.getValorTotal());
                stmt.setString(3, nota.getNotaFiscal());
                stmt.setString(4, nota.getOperador());

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir nota de entrada: " + ex.getMessage());
            }
        }
        else{
            String sql = "INSERT INTO notaSaida (noS_data, noS_valorTotal,  noS_notaFiscal , cli_CPF) VALUES (?,?,?,?);";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setString(1, nota.getData());
                stmt.setFloat(2, nota.getValorTotal());
                stmt.setString(3, nota.getNotaFiscal());
                stmt.setString(4, nota.getOperador());

                stmt.execute();

            } catch(SQLException ex){
                System.out.println("Erro ao inserir nota de saida: " + ex.getMessage());
            }
        }
        
    }
    public int getID (Nota nota){
        if ("Entrada".equals(nota.getTipo())){
            String sql = "Select noE_id from notaEntrada where noE_notaFiscal = ?";
        
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                

                stmt.setString(1, nota.getNotaFiscal());
                ResultSet rs = stmt.executeQuery();

                rs.first();

                nota.setId(rs.getInt("noE_id"));



                return nota.getId();
            }catch (SQLException ex){
                System.out.println("Erro ao consultar id da nota de entrada: "+ ex.getMessage());
                return 0b0;
            }
        }
        else{
            String sql = "Select noS_id from notaSaida where noS_notaFiscal = ?;";
        
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                

                stmt.setString(1, nota.getNotaFiscal());
                ResultSet rs = stmt.executeQuery();

                rs.first();

                nota.setId(rs.getInt("noS_id"));



                return nota.getId();
            }catch (SQLException ex){
                System.out.println("Erro ao consultar id da nota de Saida: "+ ex.getMessage());
                return 0b0;
            }
        }
    }
    
   
    public Nota getNota(Nota nota){
        if ("Entrada".equals(nota.getTipo())){
            String sql = "Select noE_data, noE_valorTotal, noE_notaFiscal,for_CNPJ from notaEntrada where noE_id = ?;";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, nota.getId());
                
                ResultSet rs = stmt.executeQuery();
                
                Nota n = new Nota();
                
                rs.first();
                
                n.setId(nota.getId());
                n.setData(rs.getString("noE_data"));
                n.setNotaFiscal(rs.getString("noE_notaFiscal"));
                n.setValorTotal(rs.getFloat("noE_valorTotal"));
                n.setOperador(rs.getString("for_CNPJ"));
                n.setTipo(nota.getTipo());

                return n;
                

            } catch(SQLException ex){
                System.out.println("Erro ao consultar nota de entrada: " + ex.getMessage());
                return null;
            }
        }
        else{
            String sql = "Select noS_data, noS_valorTotal, noS_notaFiscal,cli_CPF from notaSaida where noS_id = ?;";
        
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, nota.getId());
                
                ResultSet rs = stmt.executeQuery();
                
                Nota n = new Nota();
                
                rs.first();
                
                n.setId(nota.getId());
                n.setData(rs.getString("noS_data"));
                n.setNotaFiscal(rs.getString("noS_notaFiscal"));
                n.setValorTotal(rs.getFloat("noS_valorTotal"));
                n.setOperador(rs.getString("cli_CPF"));
                n.setTipo(nota.getTipo());

                return n;
                

            } catch(SQLException ex){
                System.out.println("Erro ao consultar nota de saida: " + ex.getMessage());
                return null;
            }
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
