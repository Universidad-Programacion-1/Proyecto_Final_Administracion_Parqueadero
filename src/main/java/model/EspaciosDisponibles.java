package model;

public class EspaciosDisponibles {

	private int espaciosAutomovil;
	private int espaciosMoto;
	private int espaciosCamion;

	public EspaciosDisponibles(int espaciosAutomovil, int espaciosMoto, int espaciosCamion) {
		this.espaciosAutomovil = espaciosAutomovil;
		this.espaciosMoto = espaciosMoto;
		this.espaciosCamion = espaciosCamion;
	}

	public int getEspaciosAutomovil() {
		return espaciosAutomovil;
	}

	public void setEspaciosAutomovil(int espaciosAutomovil) {
		this.espaciosAutomovil = espaciosAutomovil;
	}

	public int getEspaciosMoto() {
		return espaciosMoto;
	}

	public void setEspaciosMoto(int espaciosMoto) {
		this.espaciosMoto = espaciosMoto;
	}

	public int getEspaciosCamion() {
		return espaciosCamion;
	}

	public void setEspaciosCamion(int espaciosCamion) {
		this.espaciosCamion = espaciosCamion;
	}

	

	

	
	
}
