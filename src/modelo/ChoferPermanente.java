package modelo;


import java.time.*;

/**
 * clase concreta chofer permanente de la empresa, extiende de chofer empleado
 */
public class ChoferPermanente extends ChoferEmpleado{
	
	//tiene que ser el mismo valor para todos los choferes permanentes osea que podria un atributo estatico
    protected static double plus_X_antiguedad=0.12;// en decimal de 1 a 100
    protected static double plus_X_hijos=0.06;
    protected LocalDate fecha_ingreso;

	public ChoferPermanente(LocalDate fecha_ingreso) {
        super();
        this.fecha_ingreso = fecha_ingreso;
    }

    public static double getPlus_X_antiguedad() {
		return plus_X_antiguedad;
	}

	public static void setPlus_X_antiguedad(double plus_X_antiguedad) {
		ChoferPermanente.plus_X_antiguedad = plus_X_antiguedad;
	}

	public static double getPlus_X_hijos() {
		return plus_X_hijos;
	}

	public static void setPlus_X_hijos(double plus_X_hijos) {
		ChoferPermanente.plus_X_hijos = plus_X_hijos;
	}

	public ChoferPermanente(double sueldo_basico, double aportes) {
		super(sueldo_basico, aportes);
	}

	public ChoferPermanente(String dni,String nombre,int sueldobasico,int aportes) {
        super(dni,nombre,sueldobasico,aportes);
        this.fecha_ingreso=LocalDate.now();
    }
    public ChoferPermanente(String dni,String nombre,int sueldobasico,int aportes,LocalDate fecha_ingreso) {
        super(dni,nombre,sueldobasico,aportes);
        this.fecha_ingreso = fecha_ingreso;
    }
    

    public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDate fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

    /**
     * @return el sueldo bruto del chofer
     */
    @Override
    public double getSueldoBruto() {
        //sueldo bruto con hijos y antiguedad
        double ans=this.sueldo_basico;
        int date=LocalDate.now().getYear()-this.fecha_ingreso.getYear();
        double ans_antiguedad=ans *(date* this.plus_X_antiguedad );
        double ans_hijos=ans* this.plus_X_hijos ;
        

        return ans+ans_antiguedad +ans_hijos;
    }

    /**
     * @return el sueldo neto es decir el sueldo bruto - el porcentaje de aportes
     */
    @Override
    public double getSueldoNeto() {
        // sueldo bruto - aportes jubilatiorios
        return this.getSueldoBruto() * (1-this.aportes/100);
    }

	@Override
	public String toString() {
		return "ChoferPermanente [fecha_ingreso=" + fecha_ingreso + ", sueldo_basico=" + sueldo_basico + ", aportes="
				+ aportes + ", dni=" + dni + ", nombre=" + nombre + "]";
	}
    
}
