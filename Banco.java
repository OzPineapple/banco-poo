import java.util.ArrayList;
import java.util.Random;

public class Banco{
	public static void main( String args[] ){
		Fecha.fake = true;
		print("\nCreando cuentas");
		Cliente[] clientes ={ 
			new Cliente("Aristoteles", 	new ArrayList<Cuenta>() 	),
			new Cliente("Platon", 		new ArrayList<Cuenta>() 	),
			new Cliente("Quijote",	new ArrayList<Cuenta>() 	)
		};
		print("\nAgregando cuentas");
		clientes[2].agregarCuenta( new CtaAhorros(9060,2.8) 	);
		clientes[0].agregarCuenta( new CtaCredito(1000,16) 		);
		clientes[1].agregarCuenta( new CtaCheques(3000,1000) 	);
		clientes[2].agregarCuenta( new CtaCredito(1200,1.6) 	);
		clientes[0].agregarCuenta( new CtaAhorros(5000,1.8) 	);
		clientes[0].agregarCuenta( new CtaCheques(300,100) 		);
		clientes[1].agregarCuenta( new CtaAhorros(7000,2.1) 	);
		clientes[2].agregarCuenta( new CtaCheques(300,10) 		);
		clientes[1].agregarCuenta( new CtaCredito(10000,0.5) 	);

		print("\nReportando cuentas");
		for( Cliente c : clientes )
			c.reportarEdosCtas();
		
		print("\nModificando cuentas...");
		for( Cliente c : clientes )
			for( int i = new Random().nextInt(2) ; i  < 3 ; i++ )
				c.getCuentas().get(i).depositar(new Random().nextInt(5000));
			
		for( Cliente c : clientes )
			for( int i = new Random().nextInt(2) ; i  < 3 ; i++ )
				c.getCuentas().get(i).retirar(new Random().nextInt(900));
		
		print("\nReportando cuentas");
		for( Cliente c : clientes )
			c.reportarEdosCtas();
	}

	public static void print(String s){
		System.out.println(s);
	}
}
