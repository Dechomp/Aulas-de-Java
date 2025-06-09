
import java.util.Scanner;


/**
 *
 * @author 2830482321036
 * @since 26/05
 */
public class Principal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();
        Pessoa p3 = new Pessoa();
        
        
        System.out.println("Digite o nome da Pessoa 1");
        p1.nome = sc.nextLine();
        System.out.println("Digite a idade da Pessoa 1");
        p1.idade = sc.nextInt();
        
        System.out.println("\nDigite o nome da Pessoa 2");
        p2.nome = sc.next();
        System.out.println("Digite a idade da Pessoa 2");
        p2.idade = sc.nextInt();
        
        System.out.println("\nDigite o nome da Pessoa 3");
        p3.nome = sc.next();
        System.out.println("Digite a idade da Pessoa 3");
        p3.idade = sc.nextInt();
        
        System.out.println("\n\nA pessoa 1 de nome " + p1.nome + " tem " + p1.idade + " anos de idade");
        System.out.println("A pessoa 2 de nome " + p2.nome + " tem " + p2.idade + " anos de idade");
        System.out.println("A pessoa 3 de nome " + p3.nome + " tem " + p3.idade + " anos de idade");
        
        
        
    }
}
