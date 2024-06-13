package modelo;

public class FlotaVehiculos {
	private int cantMotos;
	private int cantAutos;
	private int cantCombis;
	public int getCantMotos() {
		return cantMotos;
	}
	public void setCantMotos(int cantMotos) {
		this.cantMotos = cantMotos;
	}
	public int getCantAutos() {
		return cantAutos;
	}
	public void setCantAutos(int cantAutos) {
		this.cantAutos = cantAutos;
	}
	public int getCantCombis() {
		return cantCombis;
	}
	public void setCantCombis(int cantCombis) {
		this.cantCombis = cantCombis;
	}
	public void subCantCombis() {
		this.cantCombis--;
	}
	public void subCantAutos() {
		this.cantAutos--;
	}
	public void subCantMotos() {
		this.cantMotos--;
	}
	public FlotaVehiculos(int cantMotos, int cantAutos, int cantCombis) {
		super();
		this.cantMotos = cantMotos;
		this.cantAutos = cantAutos;
		this.cantCombis = cantCombis;
	}
	public FlotaVehiculos() {
		super();
		this.cantMotos = 0;
		this.cantAutos = 0;
		this.cantCombis = 0;
	}
	
}
