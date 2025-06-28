
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PROFESSOR
 */
public class DataDAO {
    private Conexao conexao;
    private Connection conn;
    
    public DataDAO(){
        this.conexao = new Conexao();
        this.conn =  this.conexao.getConexao();
    }
    
    public String getData(){
        String sql = "select day(sysdate()) dia, month(sysdate()) mes, year(sysdate()) ano;";
        
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                

                ResultSet rs = stmt.executeQuery();

                rs.first();
                
                Data data = new Data();
                data.setDia(rs.getString("dia"));
                data.setMes(rs.getString("mes"));
                data.setAno(rs.getString("ano"));



                return data.mostrarData();
            }catch (SQLException ex){
                System.out.println("Data não encontrada "+ ex.getMessage());
                return null;
            }
    }
}
