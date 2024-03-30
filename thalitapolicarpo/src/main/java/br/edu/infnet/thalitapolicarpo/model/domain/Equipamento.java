package br.edu.infnet.thalitapolicarpo.model.domain;

public class Equipamento {

	private int numeroControleInterno;
    private String localizacao;
    
    public Equipamento() {
		super();
		// TODO Auto-generated constructor stub
	}    

	public Equipamento(int numeroControleInterno, String localizacao) {
        this.numeroControleInterno = numeroControleInterno++;
        this.localizacao = localizacao;
    }

	
	public int getNumeroControleInterno() {
		return numeroControleInterno;
	}

	public void setNumeroControleInterno(int numeroControleInterno) {
		this.numeroControleInterno = numeroControleInterno;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String toString() {
		return 	"Equipamento:" + getNumeroControleInterno() 
				+ "\nLocalização: " + getLocalizacao();
	}
    
    
}
