public class CtaAhorros extends Cuenta implements Impuestos {
	private double tasa;

	public CtaAhorros(double saldo, double tasa){
		super(saldo);
		this.tasa = tasa;
	}

	public void consultar(){
		movs.put( Fecha.toDay(), "Consulta" );
		int lapso = apertura.diff(Fecha.toDay());
		saldo += ( lapso % 30 ) * tasa;
		if(lapso > 30  ) pagarISRmensual();
		if(lapso > 360 ) pagarISRanual();
		System.out.println("\t"+this.getClass().getName() + " #" + id + " Fecha de apertura: " + apertura.toString() );
		java.util.Iterator it = movs.keySet().iterator();
		while(it.hasNext()){
			Fecha key = ( Fecha ) it.next();
			System.out.println( "\t\t"+ movs.get(key) + ": " + key.toString() );
		}
	}
	public void pagarISRmensual(){
		if( saldo > 10000 ){
			saldo *= 1 - ISRm;
			regI(saldo, ISRm);
		}
	}
	public void pagarISRanual(){
		if( saldo > 50000 ){
			saldo *= 1 - ISRa;
			regI(saldo, ISRa);
		}
	}
}
