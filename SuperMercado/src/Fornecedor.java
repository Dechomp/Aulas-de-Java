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
public class Fornecedor {
    private int CNPJ;
    private String nome;
    private String nomeFantasia;

    public Fornecedor(int CNPJ, String nome, String nomeFantasia) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
