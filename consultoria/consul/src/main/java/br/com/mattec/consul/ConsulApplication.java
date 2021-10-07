package br.com.mattec.consul;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsulApplication implements CommandLineRunner{
	
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
//		
//		
//		ProdutoEntity p1 = new ProdutoEntity(null, "Computador", new BigDecimal("2000.00"), null, null, null,
//				cat1);
//		ProdutoEntity p2 = new ProdutoEntity(null, "RÉGUAS",  new BigDecimal("10.00"), null, null, null,cat2);
//		ProdutoEntity p3 = new ProdutoEntity(null, "LUBRAZ",  new BigDecimal("50.00"), null,null, null,cat3);
//		ProdutoEntity p4 = new ProdutoEntity(null, "LATA DE TINTA", new BigDecimal("90.00"), null, null, null,cat4);
//		ProdutoEntity p5 = new ProdutoEntity(null, "Mouse", new BigDecimal("30.00"), null, null, null, cat1);
//		cat1.getProdutos().addAll(Arrays.asList(p1,p5));
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
//		
//		catRep.saveAll(Arrays.asList(cat1, cat2,cat3,cat4));
//		proRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

	}

}
