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
public class ContaCorrente {
    float saldo;
    boolean possivel;
    
    public void definirSaldoAtual(float saldo){
        
        
        
        this.saldo = saldo;
    }
    
    public boolean depositar(float deposito){
        
        
        this.saldo += deposito;
        System.out.println("Deposito de " + deposito + " confirmado, estado da conta: R$ " + this.saldo);
        return true;
    }
    
    public boolean sacar(float saque) throws Exception{
        
        
        if(saldo < saque){
            possivel = false;
            throw new Exception("Saldo insuficiente para saque, conta atual R$ " + this.saldo + "\nTentativa de saque de R$ " + saque + "\nPara haver saque, falta R$ " + (this.saldo - saque) * -1 );
            
        }
        else{
            this.saldo -= saque;
            System.out.println("Saque de " + saque + " confirmado, estado da conta: R$ " + this.saldo);
            possivel = true;
        }
        
        return possivel;
    }
    
    
}
