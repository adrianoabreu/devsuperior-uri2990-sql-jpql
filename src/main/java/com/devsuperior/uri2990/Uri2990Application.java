package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("*** Resultado SQL ***");		
		List<EmpregadoDeptProjection> list = repository.search1();
		List<EmpregadoDeptDTO> resultSQL = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		for(EmpregadoDeptDTO obj : resultSQL) {
			System.out.println(obj);
		}
		
		System.out.println("\n");
		
		System.out.println("*** Resultado JPQL ***");
		List<EmpregadoDeptDTO> resultJPQL = repository.search2();

		for(EmpregadoDeptDTO obj : resultJPQL) {
			System.out.println(obj);
		}
		
		System.out.println("*** Resultado SQL 2 ***");		
		List<EmpregadoDeptProjection> list2 = repository.search3();
		List<EmpregadoDeptDTO> resultSQL2 = list2.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		
		for(EmpregadoDeptDTO obj : resultSQL2) {
			System.out.println(obj);
		}
		
	}
}
