public class CtaCheques extends Cuenta {
	private double sobregiro;
	private double deuda;

	public CtaCheques(double saldo, double sobre){
		super( saldo );
		sobregiro = sobre;
	}
	public double getSobregiro(){return sobregiro;}
	public void setSobregiro(double x){sobregiro=x;}
	public void depositar(double monto){
		regD(monto);;
		if( deuda > 0 )
			if( deuda > monto ){
				deuda -= monto;
				return;
			}else {
				monto -= deuda;
				deuda = 0;
			}
		saldo += monto;
	}
	public void retirar(double monto){
		regR(monto);
		if( saldo > monto ){
			saldo -= monto;
			return;
		}
		if( saldo + ( sobregiro - deuda )  > monto &&
			apertura.diff(Fecha.toDay()) < 360 ){
			saldo = 0;
			deuda += monto - saldo;
			return;
		}
		System.out.println("LOG: Su cuenta no es capaz de retirar el monto solicitado");
	}
}