
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
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
        }
    }
    public Cliente getCliente(String CPF){
        String sql = "SELECT cli_nome, cli_email FROM cliente where cli_CPF = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            

            stmt.setString(1, CPF);
            ResultSet rs = stmt.executeQuery();
            Cliente c = new Cliente("", "", "");
            
            rs.first();
            
            c.setCPF(CPF);
            c.setNome(rs.getString("cli_nome"));
            c.setEmail(rs.getString("cli_email"));
            
            
            
            return c;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar cliente: "+ ex.getMessage());
            return null;
        }
    }
    public ArrayList<Cliente> getClientes(){
        String sql = "SELECT cli_CPF, cli_nome FROM cliente";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ArrayList<Cliente> lista = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery();
            
            rs.first();
            do{
                Cliente c = new Cliente();
                c.setCPF(rs.getString("cli_CPF"));
                c.setNome(rs.getString("cli_nome"));
                
                lista.add(c);
            }while(rs.next());
            
            
            return lista;
        }catch (SQLException ex){
            System.out.println("Erro ao consultar clientes: "+ ex.getMessage());
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
