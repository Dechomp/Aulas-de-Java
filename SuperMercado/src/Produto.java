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
public class Produto {
    private int id;
    private String nome;
    private float preco;
    private String codidgoBarras;
    private int idCategoria;
    private int estoque;

    public Produto(String nome, float preco, String codidgoBarras, int estoque, int idCategoria ) {
        this.nome = nome;
        this.preco = preco;
        this.codidgoBarras = codidgoBarras;
        this.estoque = estoque;
        this.idCategoria = idCategoria;
        
    }

    Produto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCodidgoBarras() {
        return codidgoBarras;
    }

    public void setCodidgoBarras(String codidgoBarras) {
        this.codidgoBarras = codidgoBarras;
    }
    
    public String toString(){
        return this.id+" - "+this.nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
  
}
