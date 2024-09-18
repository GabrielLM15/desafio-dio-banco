import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 001;
    private static int SEQUENCIAL = 1000;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private static List<Conta> todasContas = new ArrayList<>();

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        todasContas.add(this);


    }

    public void sacar(double valor){
        if(valor > this.saldo){
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= valor;            
        }
        
    }

    public void depositar(double valor){
        this.saldo += valor;
        
    }

    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
        
    }

    protected void imprimirInfos(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("saldo: %.2f", this.saldo));
        
    }

    public static void exibirContas() {
        System.out.println("=== Todas as Contas ===");
        for (Conta conta : todasContas) {
            conta.imprimirInfos();
            System.out.println("------------------------");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
