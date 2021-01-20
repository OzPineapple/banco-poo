public class CtaCredito extends Cuenta {
	private double tasa;
	private double deficit;

	public CtaCredito(double saldo, double tasa){
		super( saldo );
		deficit = 0;
	}
	public void depositar(double monto){
		regD(monto);
		if( deficit > 0 )
			if( deficit > monto ){
				deficit -= monto;
				return;
			} else {
				monto -= deficit;
				deficit = 0;
			}
		saldo += monto;
	}
	public void retirar(double monto){
		regR(monto);
		if( monto <= saldo ){
			saldo -= monto;
			return;
		}
		deficit += monto - saldo;
		saldo = 0;
	}
}


/* 

*/