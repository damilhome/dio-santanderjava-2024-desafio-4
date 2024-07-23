public class Main {
    public static void main(String[] args) {
        Banco banco1 = new Banco("Banco 1", 1);
        banco1.criarContaCorrente("Danilo", 12345);
        banco1.criarContaPoupanca("Danilo", 12345);

        banco1.depositar(12345, 001, 100);
        banco1.imprimirExtrato(12345, 001);

        banco1.transferir(12345, 001, 12345, 002, 50);
        banco1.imprimirExtrato(12345, 001);
        banco1.imprimirExtrato(12345, 002);

        banco1.sacar(12345, 002, 25);
        banco1.imprimirExtrato(12345, 002);

        banco1.listarClientes();
    }
}
