package model;

import java.time.LocalDate;

public class Membresia {

	private TipoMembresia TipoMembresia;
	private LocalDate inicioMembresia;
	private LocalDate finMembresia;
	public Membresia(model.TipoMembresia tipoMembresia, LocalDate inicioMembresia, LocalDate finMembresia) {
		TipoMembresia = tipoMembresia;
		this.inicioMembresia = inicioMembresia;
		this.finMembresia = finMembresia;
	}
	public LocalDate getInicioMembresia() {
		return inicioMembresia;
	}
	public void setInicioMembresia(LocalDate inicioMembresia) {
		this.inicioMembresia = inicioMembresia;
	}
	public LocalDate getFinMembresia() {
		return finMembresia;
	}
	public void setFinMembresia(LocalDate finMembresia) {
		this.finMembresia = finMembresia;
	}

	


	
}