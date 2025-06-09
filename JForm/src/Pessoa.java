/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Júlio de Souza
 * @since 02/06/2025;
 */
public class Pessoa {
    String nome;
    char sexo;
    String idioma;

    public Pessoa(String nome, char sexo, String idioma) {
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
    }

    public Object[] obterDados(){
        return new Object[] {nome, sexo, idioma};
    }
}
