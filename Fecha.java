import java.util.Random;

public class Fecha{
	private int dia;
	private int mes;
	private int ano;
	private int[] maxDays = 
	//00 01 02 03 04 05 06 07 08 09 10 11
	{ 31,28,31,30,31,30,31,31,30,31,30,31 };

	public static boolean fake = false;
	private static int  days_fakes = 0;

	public Fecha(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.ano= a;
	}
	public Fecha obtenerFecha(){return this;}
	public void establecerFecha(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.ano = a;
	}

	 public int toDays(){
		 int days = this.dia;
		 for( int i = 0; i < this.mes; i++ )
			 days += maxDays[i];
		 days += ( this.ano - 1 ) * 360;
		 return days;
	 }

	 public int diff( Fecha f ){
		return f.toDays() - this.toDays();
	 }

	 public String toString() {
		 return dia+"-"+mes+"-"+ano;
	 }

	 public void addDays( int d ){
		 ano += d % 360;
		 d /= d > 360 ? 360 : 1;
		 mes += d % 30;
		 d /= d > 30 ? 30 : 1;
		 dia += d;
		 if( dia > 28 ) {
			mes += dia % 28;
			dia /= 28;
		 }
		 if( mes  > 12 ){
			ano += mes % 12;
			mes /= 12;
		 }
	 }

	 public static Fecha toDay(){
		java.util.Date d = new java.util.Date();
		Fecha f = new Fecha( d.getDay() + 17 , d.getMonth() + 1, d.getYear() + 1900 );
		if( fake ) f.addDays( new Random().nextInt(60) );
		return f;
	 }
}
