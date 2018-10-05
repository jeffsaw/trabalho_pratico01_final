package trabalho_pratico01;
import javax.swing.JOptionPane;

public class ContaEspecial extends Conta{
    
    
    private double limite = 100f;
    private double limiteInicial;
    private double multa;
     
    
    @Override
    public void sacar(double valor){
        
        if(limite <= 0){
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente: " + (this.getSaldo() + limite));
        }
        else if(valor > this.getSaldo() ){
            JOptionPane.showMessageDialog(null,"Saldo da conta insuficiente, usar cheque especial?");
            double valorMulta = Math.abs(this.getSaldo() - valor) * multa;
            double saldoChequeRestante = ((this.getSaldo() + limite) - valor) - valorMulta;
            this.setSaldo(0.0);
            limite = saldoChequeRestante;
            JOptionPane.showMessageDialog(null,"Sauqe efetuado com sucesso. " + "\n" + "Saldo restante do Cheque Especial: " + limite); 
            
        }
        else if( valor > (this.getSaldo() + limite)){
            JOptionPane.showMessageDialog(null,"Confirmar Saque?");
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente."  + "\n" + "Saldo total da conta: " + (this.getSaldo() + limite));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Confirmar Saque?");
            double saldoEspecial = this.getSaldo() - valor;
            this.setSaldo(saldoEspecial);
            JOptionPane.showMessageDialog(null,"Sauqe efetuado com sucesso. " + "\n" + "Saldo restante: " + this.getSaldo()); 
        }
    }
    
    @Override
    public void depositar(double valor){
        if(limite <= 0  && valor <= 100 ){
            limite += valor;
            JOptionPane.showMessageDialog(null,"Deposito efetuado com sucesso.");
        }
        else if(limite < 100 && valor > 100){
            if(limite <= 0){
                limite += 100;
            }else{
                limite = 100;
            }this.setSaldo(valor-100);
            JOptionPane.showMessageDialog(null,"Deposito efetuado com sucesso.");
        }
        else if(limite < 100 && valor <= 100){
             limite += valor;
             if(limite > 100){
                this.setSaldo(limite-100); 
                limite = 100;
             }
        }
        else{
            double valorDeposito = this.getSaldo();
            valorDeposito += valor;
            this.setSaldo(valorDeposito);
            JOptionPane.showMessageDialog(null,"Deposito efetuado com sucesso.");
        }
    }  
    
    @Override
    public void trasferir(Conta destino, double valor){
        if(limite <= 0){
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente: " + (this.getSaldo() + limite));
        }
        else if( valor > (this.getSaldo() + limite))
        {
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente: " + (this.getSaldo() + limite));
        }
        else if(valor > this.getSaldo() ){
            JOptionPane.showMessageDialog(null,"Saldo da conta insuficiente, usar cheque especial?");
            double valorMulta = Math.abs(this.getSaldo() - valor) * multa;
            double saldoChequeRestante = ((this.getSaldo() + limite) - valor) - valorMulta;
            this.setSaldo(0.0);
            limite = saldoChequeRestante;
            destino.depositar(valor);
        }
        else if(this.getSaldo() >= valor)
        {
            double saldo = this.getSaldo();
            saldo -= valor;
            this.setSaldo(saldo);
            destino.depositar(valor);
        }   
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getLimiteInicial() {
        return limite;
    }

    public void setLimiteInicial(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
   
     @Override
    public void tipoConta(){
        System.out.println("Tipo de Conta: Conta Especial.");
    }
    
    }
    

