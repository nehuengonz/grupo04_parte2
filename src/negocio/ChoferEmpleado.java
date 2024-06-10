package negocio;


/**
 * clase abstracta que extienede de chofer que a su ves es abstracta
 * se utiliza para diferenciar a los choferes con aportes y suelo basico de la empresa
 * es decir a los choferes permanentes y a los choferes temporarios
 */
public abstract class ChoferEmpleado extends Chofer{
    protected double sueldo_basico;
    protected double aportes;//aportes jubilatiorios porcentaje de 1 a 100

    
    public ChoferEmpleado(double sueldo_basico, double aportes) {
        super();
        this.sueldo_basico = sueldo_basico;
        this.aportes = aportes;
    }


    public ChoferEmpleado(String dni, String nombre,double sueldo_basico, double aportes) {
		super(dni, nombre);
		 this.sueldo_basico = sueldo_basico;
	     this.aportes = aportes;
	}

  

	public double getSueldo_basico() {
        return sueldo_basico;
    }

    public double getAportes() {
        return aportes;
    }

    public ChoferEmpleado() {
        super();
    }
}