package com.projearq.sistemavendas;

import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.entidades.Produto;
import com.projearq.sistemavendas.negocio.servicos.ServicoDeEstoque;
import com.projearq.sistemavendas.negocio.servicos.ServicoDeProduto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final ServicoDeProduto servicoDeProduto;
    private final ServicoDeEstoque servicoDeEstoque;

    @Autowired
    public CommandLineAppStartupRunner(ServicoDeProduto servicoDeProduto, ServicoDeEstoque servicoDeEstoque) {
        this.servicoDeProduto = servicoDeProduto;
        this.servicoDeEstoque = servicoDeEstoque;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Começou a popular");
        Produto produto1 = new Produto();
        produto1.setCodigo(10L);
        produto1.setDescricao("Geladeira");
        produto1.setPrecoUnitario(2500.0);
        this.servicoDeProduto.adicionaProduto(produto1);
        Estoque estoque1 = new Estoque();
        estoque1.setProduto(produto1);
        estoque1.setQuantidadeDisponivel(10);
        this.servicoDeEstoque.salvarEstoqueProduto(estoque1);

        Produto produto2 = new Produto();
        produto2.setCodigo(20L);
        produto2.setDescricao("Fogao");
        produto2.setPrecoUnitario(1200.0);
        this.servicoDeProduto.adicionaProduto(produto2);
        Estoque estoque2 = new Estoque();
        estoque2.setProduto(produto2);
        estoque2.setQuantidadeDisponivel(0);
        this.servicoDeEstoque.salvarEstoqueProduto(estoque2);

        Produto produto3 = new Produto();
        produto3.setCodigo(30L);
        produto3.setDescricao("Lava louça");
        produto3.setPrecoUnitario(4300.0);
        this.servicoDeProduto.adicionaProduto(produto3);
        Estoque estoque3 = new Estoque();
        estoque3.setProduto(produto3);
        estoque3.setQuantidadeDisponivel(7);
        this.servicoDeEstoque.salvarEstoqueProduto(estoque3);

        Produto produto4 = new Produto();
        produto4.setCodigo(40L);
        produto4.setDescricao("Lava roupa");
        produto4.setPrecoUnitario(3350.0);
        this.servicoDeProduto.adicionaProduto(produto4);
        Estoque estoque4 = new Estoque();
        estoque4.setProduto(produto4);
        estoque4.setQuantidadeDisponivel(11);
        this.servicoDeEstoque.salvarEstoqueProduto(estoque4);

        Produto produto5 = new Produto();
        produto5.setCodigo(50L);
        produto5.setDescricao("Aspirador de pó");
        produto5.setPrecoUnitario(780.0);
        this.servicoDeProduto.adicionaProduto(produto5);
        Estoque estoque5 = new Estoque();
        estoque5.setProduto(produto5);
        estoque5.setQuantidadeDisponivel(22);
        this.servicoDeEstoque.salvarEstoqueProduto(estoque5);
        log.info("Terminou de popular");
    }
}
