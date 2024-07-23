public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private int codigo;
    protected Cliente cliente;

    public Conta(Cliente cliente, int agencia, int codigo) {
        this.agencia = agencia;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    protected void imprimirInfosComuns() {
        System.out.println("=== EXTRATO ===");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Tipo de conta: %d", this.codigo));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
