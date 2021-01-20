import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Cliente{
	private String				nombre;
	private ArrayList<Cuenta>	cuentas;
	private String				numCliente;

	public Cliente(String nom, ArrayList<Cuenta> ctas){
		this.nombre = nom;
		this.cuentas = ctas;
		this.numCliente = nom.substring(0,5) +  new Random().nextInt(500) ;
	}
	public ArrayList<Cuenta> getCuentas(){return cuentas;}
	public void agregarCuenta(Cuenta cta){
		cta.setId( cuentas.size() + 1 );
		cuentas.add(cta);
		System.out.println("LOG: Cliente " + nombre + " tiene nueva cuenta #" + cta.getId() + " de " + (
				( cta instanceof CtaAhorros ) ? "Ahorros" :
				( cta instanceof CtaCheques ) ? "Cheques" :
				( cta instanceof CtaCredito ) ? "Crédito" : "Generica"
		));
	}
	public Cuenta obtenerCuenta(int index){return this.cuentas.get(index);}
	public void reportarEdosCtas(){
		System.out.println("Cliente: " + nombre +" No.Cuenta: " + numCliente );
		cuentas.forEach( ( c ) -> c.consultar() );
	}
}
