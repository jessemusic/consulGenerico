package br.com.mattec.consul;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mattec.consul.entities.Categoria;
import br.com.mattec.consul.entities.ProdutoEntity;
import br.com.mattec.consul.reporitory.CategoriaRepository;
import br.com.mattec.consul.reporitory.ProdutoRepository;

@SpringBootApplication
public class ConsulApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository catRep;
	@Autowired
	private ProdutoRepository proRep;

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
//		ProdutoEntity p1 = new ProdutoEntity(null, "Computador", new BigDecimal("2000.00"), null, null, null);
//		ProdutoEntity p2 = new ProdutoEntity(null, "RÉGUAS",  new BigDecimal("10.00"), null, null, null);
//		ProdutoEntity p3 = new ProdutoEntity(null, "LUBRAZ",  new BigDecimal("50.00"), null,null, null);
//		ProdutoEntity p4 = new ProdutoEntity(null, "LATA DE TINTA", new BigDecimal("90.00"), null, null, null);
//		ProdutoEntity p5 = new ProdutoEntity(null, "Mouse", new BigDecimal("30.00"), null, null, null);
//		cat1.getProdutos().addAll(Arrays.asList(p1,p5));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
//		cat4.getProdutos().addAll(Arrays.asList(p4));
//		cat3.getProdutos().addAll(Arrays.asList(p3));
//		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat3));
//		p4.getCategorias().addAll(Arrays.asList(cat4));
//		p5.getCategorias().addAll(Arrays.asList(cat1));
//	
//		
//		catRep.saveAll(Arrays.asList(cat1, cat2,cat3,cat4));
//		proRep.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

	}

}
