public class Main {
    public static void main(String[] args) {
        Cliente Gabriel = new Cliente("Gabriel");
        Conta cc = new ContaCorrente(Gabriel);
        cc.depositar(1200);
        cc.sacar(1500);

        Cliente Maria = new Cliente("maria");
        Conta cc1 = new ContaCorrente(Maria);

        Cliente Jose = new Cliente("Jose");
        Conta cc2 = new ContaCorrente(Jose);

        Cliente Diego = new Cliente("Diego");
        Conta cc3 = new ContaCorrente(Diego);
        cc.transferir(500, cc3);

        Cliente Julia = new Cliente("Julia");
        Conta cc4 = new ContaCorrente(Julia);
        cc.transferir(500, cc4);

        Conta.exibirContas();
    }

}
