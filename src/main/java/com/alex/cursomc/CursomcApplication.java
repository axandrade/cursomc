package com.alex.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alex.cursomc.domain.Categoria;
import com.alex.cursomc.domain.Cidade;
import com.alex.cursomc.domain.Cliente;
import com.alex.cursomc.domain.Endereco;
import com.alex.cursomc.domain.Estado;
import com.alex.cursomc.domain.ItemPedido;
import com.alex.cursomc.domain.Pagamento;
import com.alex.cursomc.domain.PagamentoComBoleto;
import com.alex.cursomc.domain.PagamentoComCartao;
import com.alex.cursomc.domain.Pedido;
import com.alex.cursomc.domain.Produto;
import com.alex.cursomc.domain.enums.EstadoPagamento;
import com.alex.cursomc.domain.enums.Perfil;
import com.alex.cursomc.domain.enums.TipoCliente;
import com.alex.cursomc.repositories.CategoriaRepository;
import com.alex.cursomc.repositories.CidadeRepository;
import com.alex.cursomc.repositories.ClienteRepository;
import com.alex.cursomc.repositories.EnderecoRepository;
import com.alex.cursomc.repositories.EstadoRepository;
import com.alex.cursomc.repositories.ItemPedidoRepository;
import com.alex.cursomc.repositories.PagamentoRepository;
import com.alex.cursomc.repositories.PedidoRepository;
import com.alex.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");		
		Categoria cat2 = new Categoria(null, "Escritório");		
		Categoria cat3 = new Categoria(null, "Eletrônicos");
		Categoria cat4 = new Categoria(null, "Jardinagem");
		Categoria cat5 = new Categoria(null, "Decoração");
		Categoria cat6 = new Categoria(null, "Perfumaria");
		Categoria cat7 = new Categoria(null, "Infantil");
		Categoria cat8 = new Categoria(null, "Feminino");
		Categoria cat9 = new Categoria(null, "Automoveis");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		
		Produto p2 = new Produto(null, "Impressora", 800.00);
		
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);		
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));		
		p3.getCategorias().add(cat1);		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "34335583028", TipoCliente.PESSOAFISICA, "banana");
		cli1.getTelefones().addAll(Arrays.asList("33526585", "33526598"));
		
		Cliente cli2 = new Cliente(null, "Ana Costa", "dddccc@gmail.com", "01774873052", TipoCliente.PESSOAFISICA, "teste");
		cli2.getTelefones().addAll(Arrays.asList("85985623656", "8562356895"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "jardim", "32655356", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "652", "Apto 801", "Papicu", "32655356", cli1, c2);
		
		Endereco e3 = new Endereco(null, "Rua dos Pregos", "23", "", "Messejana", "32655356", cli2, c3);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2022 10:32"), cli1, e2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2022 10:32"), null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);		
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);		
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		


	}

}
