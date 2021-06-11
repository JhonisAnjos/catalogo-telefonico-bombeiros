package dev.jhonisanjos.enums;

public enum GrauHierarquicoEnum {
	
	SOLDADO("Soldado"),
	CABO("Cabo"),
	SARGENTO("Sargento"),
	TENENTE("Tenente"),
	CAPITAO("Capitão"),
	MAJOR("Major"),
	TENENTE_CORONEL("Tenente coronel"),
	CORONEL("Coronel");
	
	private String descricao;

	private GrauHierarquicoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
