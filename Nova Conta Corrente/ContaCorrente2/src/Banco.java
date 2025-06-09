/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321036
 * @since 26/05
 */
public class Banco {
    
    public static void main(String[] args) throws Exception {
        ContaCorrente c = new ContaCorrente();
        
        c.definirSaldoAtual(1000);
        
        System.out.println("Estado atual da conta: R$ " + c.saldo);
        
        try{
            c.sacar(500);
            
            c.depositar(50);
            

            c.sacar(600);

            
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        
        
        
    }
}
