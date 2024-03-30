package br.edu.infnet.thalitapolicarpo.model.domain;

import java.time.LocalDate;

public class Extintor extends Equipamento{
	
		private String numeroCilindro;
		private String numeroSeloInmetro;
		private String cargaExtintora;
		private String capacidade;
		private String dataVencimento;
		private int proximoTesteHidrostatico;


		public Extintor() {
			super();			
		}


		public Extintor(int numeroControleInterno, String localizacao, String numeroCilindro, String numeroSeloInmetro,
				String cargaExtintora, String capacidade, String dataVencimento, int proximoTesteHidrostatico) {
			super(numeroControleInterno, localizacao);
			this.numeroCilindro = numeroCilindro;
			this.numeroSeloInmetro = numeroSeloInmetro;
			this.cargaExtintora = cargaExtintora;
			this.capacidade = capacidade;
			this.dataVencimento = dataVencimento;
			this.proximoTesteHidrostatico = proximoTesteHidrostatico;
		}

		
		public String VerificarDatas() {
			// Obtém a data atual
		    LocalDate dataAtual = LocalDate.now();

		    // Divide a data de vencimento em dia, mês e ano
		    String[] partesDataVencimento = getDataVencimento().split("/");
		    int diaVencimento = Integer.parseInt(partesDataVencimento[0]);
		    int mesVencimento = Integer.parseInt(partesDataVencimento[1]);
		    int anoVencimento = Integer.parseInt(partesDataVencimento[2]);

		    // Cria um objeto LocalDate para a data de vencimento
		    LocalDate dataVencimento = LocalDate.of(anoVencimento, mesVencimento, diaVencimento);

		    // Verifica se a data de vencimento é posterior à data atual
		    if (dataVencimento.isBefore(dataAtual)) {
		        // Verifica se o próximo teste hidrostático está no ano atual ou posterior
		        if (getProximoTesteHidrostatico() < dataAtual.getYear()) {
		            return "Equipamento em não conformidade - Data de vencimento expirada e teste hidrostático vencido";
		        }
		        return "Equipamento em não conformidade - Data de vencimento expirada";
		    }

		    // Verifica se o próximo teste hidrostático está no ano atual ou posterior
		    if (getProximoTesteHidrostatico() < dataAtual.getYear()) {
		        return "Equipamento em não conformidade - Teste hidrostático vencido";
		    }

		    // Se passou por todas as verificações, retorna "Equipamento em conformidade"
		    return "Equipamento em conformidade";
		}

		public String getNumeroCilindro() {
			return numeroCilindro;
		}


		public void setNumeroCilindro(String numeroCilindro) {
			this.numeroCilindro = numeroCilindro;
		}


		public String getNumeroSeloInmetro() {
			return numeroSeloInmetro;
		}


		public void setNumeroSeloInmetro(String numeroSeloInmetro) {
			this.numeroSeloInmetro = numeroSeloInmetro;
		}


		public String getCargaExtintora() {
			return cargaExtintora;
		}


		public void setCargaExtintora(String cargaExtintora) {
			this.cargaExtintora = cargaExtintora;
		}


		public String getCapacidade() {
			return capacidade;
		}


		public void setCapacidade(String capacidade) {
			this.capacidade = capacidade;
		}


		public String getDataVencimento() {
			return dataVencimento;
		}


		public void setDataVencimento(String dataVencimento) {
			this.dataVencimento = dataVencimento;
		}


		public int getProximoTesteHidrostatico() {
			return proximoTesteHidrostatico; 
		}


		public void setProximoTesteHidrostatico(int proximoTesteHidrostatico) {
			this.proximoTesteHidrostatico = proximoTesteHidrostatico;
		}


		@Override
		public String toString() {
			return super.toString() +"\nExtintor:" + getNumeroCilindro() 
			+"\nSelo do Inmetro:" + getNumeroSeloInmetro() 
			+ "\nCarga Extintora:" + getCargaExtintora() 
			+ "\nCapacidade:" + getCapacidade() 
			+ "\nData de vencimento:" + getDataVencimento()
			+ "\nProximo Teste Hidrostatico:" + getProximoTesteHidrostatico()
			+ "\n\n===> " + VerificarDatas()+ " <===\n";
		}
			
		
}
