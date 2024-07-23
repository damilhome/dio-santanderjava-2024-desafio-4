import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final int CORRENTE = 001;
    private static final int POUPANCA = 002;

    private String nome;
    private int agencia;
    private List<Conta> contas;

    public Banco(String nome, int agencia){
        this.nome = nome;
        this.agencia = agencia;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void criarContaCorrente(String nome, int doc) {
        contas.add(new ContaCorrente(new Cliente(nome, doc), this.agencia, CORRENTE));
    }

    public void criarContaPoupanca(String nome, int doc) {
        contas.add(new ContaPoupanca(new Cliente(nome, doc), this.agencia, POUPANCA));
    }

    public void sacar(int doc, int tipo, double valor) {
        for(Conta c : contas) {
            if(c.cliente.getDoc() == doc && c.getCodigo() == tipo) {
                c.sacar(valor);
            }
        }
    }

    public void depositar(int doc, int tipo, double valor) {
        for(Conta c : contas) {
            if(c.cliente.getDoc() == doc && c.getCodigo() == tipo) {
                c.depositar(valor);
            }
        }
    }

    public void transferir(int docRemetente, int codigoRemetente, int docDestino, int codigoDestino, double valor) {
        for(Conta c : contas) {
            if(c.cliente.getDoc() == docRemetente && c.getCodigo() == codigoRemetente) {
                c.sacar(valor);
            }
        }
        for(Conta c : contas) {
            if(c.cliente.getDoc() == docDestino && c.getCodigo() == codigoDestino) {
                c.depositar(valor);
            }
        }
    }

    public void imprimirExtrato(int doc, int tipo) {
        for(Conta c : contas) {
            if(c.cliente.getDoc() == doc && c.getCodigo() == tipo) {
                c.imprimirInfosComuns();
            }
        }
    }

    public void listarClientes() {
        System.out.println("=== CLIENTES ===");
        contas.forEach(c -> System.out.println(c.cliente.getNome() + "\nTipo de conta: " + c.getCodigo()));
    }
}
