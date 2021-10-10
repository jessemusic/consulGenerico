package br.com.mattec.consul;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsulApplication implements CommandLineRunner {

//	@Autowired
//	private CategoriaRepository catRep;
//	@Autowired
//	private ProdutoRepository proRep;

	public static void main(String[] args) {
		SpringApplication.run(ConsulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Categoria cat1 = new Categoria(null, "Informática");
//		Categoria cat2 = new Categoria(null, "Escritório");
//		Categoria cat3 = new Categoria(null, "Oléos lubrificantes automotivos");
//		Categoria cat4 = new Categoria(null, "Materiais para contruções");
//		ClientEntity cli1 = ClientEntity.builder().id(2l).build();
//		ClientEntity cli2 = ClientEntity.builder().id(1l).build();
//		ClientEntity cli3 = ClientEntity.builder().id(3l).build();
//		ClientEntity cli4 = ClientEntity.builder().id(4l).build();
//		
//		
//		PedidoEntity ped1 = new PedidoEntity(null,1,LocalDateTime.now(), 3,cli1);
//		PedidoEntity ped2 = new PedidoEntity(null,2,LocalDateTime.now(), 10,cli2);
//		PedidoEntity ped3 = new PedidoEntity(null,3,LocalDateTime.now(), 2,cli3);
//		PedidoEntity ped4 = new PedidoEntity(null,4,LocalDateTime.now(), 7,cli4);
//		PedidoEntity ped5 = new PedidoEntity(null,5,LocalDateTime.now(), 11,cli1);
//		
//
//		ProdutoEntity p1 = new ProdutoEntity(null, 1, "Computador", new BigDecimal("2000.00"), 15, cat1,ped1);
//		ProdutoEntity p2 = new ProdutoEntity(null, 2, "RÉGUAS", new BigDecimal("10.00"), 100, cat2,ped2);
//		ProdutoEntity p3 = new ProdutoEntity(null, 3, "LUBRAZ", new BigDecimal("50.00"), 50, cat3,ped3);
//		ProdutoEntity p4 = new ProdutoEntity(null, 4, "LATA DE TINTA", new BigDecimal("90.00"), 40, cat4,ped4);
//		ProdutoEntity p5 = new ProdutoEntity(null, 5, "Mouse", new BigDecimal("30.00"), 20, cat1,ped5);
//		cat1.getProdutos().addAll(Arrays.asList(p1, p5));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
//		cat4.getProdutos().addAll(Arrays.asList(p4));
//		cat3.getProdutos().addAll(Arrays.asList(p3));
//
//		p1.getCategorias().getId();
//		p2.getCategorias().getId();
//		p3.getCategorias().getId();
//		p4.getCategorias().getId();
//		p5.getCategorias().getId();
//
//		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
//		proRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

	}

}
