package com.projearq.sistemavendas.aplicacao.servicos.restricoes;

import com.projearq.sistemavendas.negocio.strategy.IRestricoesStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RestricoesNivelBaixo implements IRestricoesStrategy {

    private final String NOME = "NIVEL_BAIXO";
    private final int QUANTIDADE_MAXIMA_ITENS_VENDA = 10;
    private final int QUANTIDADE_MAXIMA_ITEM = 10;
    private final int VALOR_MAXIMA_TOTAL_VEBDA = 10;
    private final LocalTime HORA_MAXIMA = LocalTime.of(20, 00,0);

    @Override
    public boolean restringeQuantidadeItensVenda(int quantidadeItensVenda) {
        return this.passouDoHorarioRestricao() ? quantidadeItensVenda > this.QUANTIDADE_MAXIMA_ITENS_VENDA : false;
    }

    @Override
    public boolean restringeQuantidadeItem(int quantidadeItem) {
        return this.passouDoHorarioRestricao() ? quantidadeItem > this.QUANTIDADE_MAXIMA_ITEM : false;
    }

    @Override
    public boolean restringeValorTotalVenda(int valorTotalVenda) {
        return this.passouDoHorarioRestricao() ? valorTotalVenda > this.VALOR_MAXIMA_TOTAL_VEBDA : false;
    }

    @Override
    public String obtemNomeStrategy() {
        return this.NOME;
    }

    private boolean passouDoHorarioRestricao() {
        return LocalTime.now().isAfter(this.HORA_MAXIMA);
    }

}
