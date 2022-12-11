package br.com.uniamerica.handleapi.entity;

public enum FormaPagamento {

    carteira("Carteira"),
        pix("Pix"),
            debito("Debito"),
                credito("Credito"),
                    credito_recorrente("Credito Recorrente"),
                        cheque("Cheque");

    public final String valor;

    private FormaPagamento(String valor){
        this.valor = valor;
    }
}
