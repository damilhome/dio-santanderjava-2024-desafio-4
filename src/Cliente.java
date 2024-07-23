public class Cliente {

    private String nome;
    private int doc;

    public Cliente(String nome, int doc) {
        this.nome = nome;
        this.doc = doc;
    }

    public String getNome() {
        return nome;
    }

    public int getDoc() {
        return doc;
    }
}
