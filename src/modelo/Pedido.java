package modelo;

import java.time.*;



/*
 * @invariant zona, SPF, usaBaul, fecha, cantPasajeros, cliente.
 */
/**
 * clase utilizada sobre la solicitud del usuario cliente
 */
public class Pedido implements Cloneable {
  private Zona zona;
  private boolean SPF; // service pet friendly
  private boolean usaBaul;
  private LocalDateTime fecha;
  private Integer cantPasajeros;
  private Cliente cliente;

  public Pedido(Zona zona, boolean SPF, boolean usaBaul,
                Integer cantPasajeros) {
    super();
    this.zona = zona;
    this.SPF = SPF;
    this.usaBaul = usaBaul;
    this.fecha =LocalDateTime.now();
    this.cantPasajeros = cantPasajeros;
  }
  

  public Pedido(Zona zona, boolean sPF, boolean usaBaul, LocalDateTime fecha, Integer cantPasajeros) {
	super();
	this.zona = zona;
	SPF = sPF;
	this.usaBaul = usaBaul;
	this.fecha = fecha;
	this.cantPasajeros = cantPasajeros;
  }


  public Zona getZona() { return zona; }

  public boolean isSPF() { return SPF; }

  public boolean getUsaBaul() { return usaBaul; }

  public LocalDateTime getFecha() { return fecha; }
  
  public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

  public Integer getCantPasajeros() { return cantPasajeros; }

  public Cliente getCliente() { return cliente; }

  public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
  public String toString() {
      return "Pedido [zona=" + zona + ", SPF=" + SPF + ", usaBaul=" + usaBaul + ", fecha=" + fecha + ", cantPasajeros="
              + cantPasajeros + ", cliente=" + cliente + "]";
  }
}
