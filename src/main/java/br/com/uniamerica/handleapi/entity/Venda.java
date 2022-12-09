package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "vendas", schema = "public")
public class Venda  extends AbstractEntity{

    @Getter @Setter
    @Column(name = "valor_recebido", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorRecebido;

    @Getter @Setter
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Getter @Setter
    @Column(name = "valor_troco", precision = 10, scale = 2)
    private BigDecimal valorTroco;

    @Getter @Setter
    @Column(name = "valor_desconto", precision = 10, scale = 2)
    private BigDecimal valorDesconto;

    @Getter @Setter
    @Column(name = "valor_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;

    @Getter @Setter
    @JoinColumn(name= "idCliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @Getter @Setter
    @JoinColumn(name= "idFuncionario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Venda(BigDecimal valorRecebido, BigDecimal valorTotal, BigDecimal valorTroco, BigDecimal valorDesconto, BigDecimal valorFinal, Cliente cliente, Funcionario funcionario) {
        this.valorRecebido = valorRecebido;
        this.valorTotal = valorTotal;
        this.valorTroco = valorTroco;
        this.valorDesconto = valorDesconto;
        this.valorFinal = valorFinal;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
}