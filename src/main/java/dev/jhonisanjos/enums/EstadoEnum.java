package dev.jhonisanjos.enums;

public enum EstadoEnum {
	BA("Bahia"),
	SP("S�o Paulo"),
	RJ("Rio de Janeiro");
	
	private String descricao;

	private EstadoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
