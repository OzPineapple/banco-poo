import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cuenta{
	protected int id;
	protected double saldo;
	protected Fecha apertura;
	protected Map<Fecha, String> movs;

	public Cuenta(double saldo){
		this( 0, Fecha.toDay(), saldo );
	}

	public Cuenta(int id, Fecha apertura, double saldo ){
		this.id = id;
		this.apertura = apertura;
		this.saldo = saldo;
		movs = new HashMap<Fecha, String>();
	}
	public void consultar(){
		regC(saldo);
		System.out.println("\t"+this.getClass().getName() + " #" + id + " Fecha de apertura: " + apertura.toString() + " Saldo actual: $" + saldo );
		java.util.Iterator it = movs.keySet().iterator();
		while(it.hasNext()){
			Fecha key = ( Fecha ) it.next();
			System.out.println( "\t\t"+movs.get(key) + " Fecha: " + key.toString() );
		}
	}
	public void depositar(double monto){
		saldo += monto;
		regD(monto);
	}
	public void retirar(double monto){
		if( monto <= saldo ){
			saldo -= monto;
			regR(monto);
		}
	}

	public void regD(double monto){
		movs.put( Fecha.toDay(), "Deposito: Monto: $"+monto );
	}

	public void regR(double monto){
		movs.put( Fecha.toDay(), "Retiro: Saldo: $"+monto );
	}

	public void regC(double monto){
		movs.put( Fecha.toDay(), "Consulta: Saldo: $"+monto );
	}

	public void setId( int id ){ this.id = id; }
	public int getId(){ return this.id; }
}