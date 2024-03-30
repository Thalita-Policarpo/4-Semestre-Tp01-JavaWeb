 package br.edu.infnet.thalitapolicarpo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.thalitapolicarpo.model.domain.Extintor;

@SpringBootTest
class ExtintorTeste {
	@Test
	void ExtintorDadosValidos(){
		Extintor ext1 = new Extintor();
		ext1.setNumeroControleInterno(01);
		ext1.setLocalizacao("Prédio 1, Térreo, Sala Gerador");
		ext1.setCargaExtintora("AP");
		ext1.setCapacidade("10L");
		ext1.setNumeroCilindro("12456");
		ext1.setNumeroSeloInmetro("123546789");
		ext1.setDataVencimento("01/12/2024");
		ext1.setProximoTesteHidrostatico(2025);
		System.out.println(ext1);
		assertEquals("Equipamento em conformidade", ext1.VerificarDatas());
	}
		
	@Test
	void ExtintorDataVencimentoVencida(){
		Extintor ext2 = new Extintor();		
		ext2.setNumeroControleInterno(02);
		ext2.setLocalizacao("Prédio 1, 1º Andar, sala da gerência");
		ext2.setCargaExtintora("CO2");
		ext2.setCapacidade("6KG");
		ext2.setNumeroCilindro("65432");
		ext2.setNumeroSeloInmetro("456789132");
		ext2.setDataVencimento("01/12/2022");
		ext2.setProximoTesteHidrostatico(2026);
		System.out.println(ext2);
		assertEquals("Equipamento em não conformidade - Data de vencimento expirada", ext2.VerificarDatas());
	}
	
	@Test
	void ExtintorTesteHidrostaricoVencido(){
		Extintor ext3 = new Extintor();		
		ext3.setNumeroControleInterno(03);
		ext3.setLocalizacao("Prédio 1, 1º Andar, Administração");
		ext3.setCargaExtintora("PQS-BC");
		ext3.setCapacidade("4KG");
		ext3.setNumeroCilindro("65897");
		ext3.setNumeroSeloInmetro("2356897");
		ext3.setDataVencimento("01/12/2026");
		ext3.setProximoTesteHidrostatico(2021);
		System.out.println(ext3);
		assertEquals("Equipamento em não conformidade - Teste hidrostático vencido", ext3.VerificarDatas());
}

	@Test
	void ExtintordaDatasVencidas(){
	
		Extintor ext4 = new Extintor();	
		ext4.setNumeroControleInterno(04);
		ext4.setLocalizacao("Prédio 1, 2º Andar, Sala Manutenção");
		ext4.setCargaExtintora("PQS-ABC");
		ext4.setCapacidade("6KG");
		ext4.setNumeroCilindro("89784");
		ext4.setNumeroSeloInmetro("1245785");
		ext4.setDataVencimento("01/12/2020");
		ext4.setProximoTesteHidrostatico(2020);
		System.out.println(ext4);
		assertEquals("Equipamento em não conformidade - Data de vencimento expirada e teste hidrostático vencido", ext4.VerificarDatas());
}
	@Test
	void ConstrutorExtintorDadosValidos() {
		
		Extintor ext5 = new Extintor(05,"Prédio 2, Térreo, Recepção", "95642", "4567891529", "CO2", "6KG", "01/05/2024", 2026);
		System.out.println(ext5);
		assertEquals("Equipamento em conformidade", ext5.VerificarDatas());
	}
}
