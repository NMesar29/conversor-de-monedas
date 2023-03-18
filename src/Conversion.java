
import java.util.Hashtable;

public class Conversion {
	private String conversion;
	private double valor;
	private static Hashtable<String, Double> dicConversiones = new Hashtable<String, Double>();
	private static Hashtable<String, Character> dicSimbolos = new Hashtable<String, Character>();

	public Conversion(String conversion,double valor) {
		this.conversion = conversion;
		this.valor = valor;
		diccionarios(this.valor);
	}
	
	public double realizarConversion() {
		return dicConversiones.get(this.conversion);
	}
	
	public char generarSimbolo() {
		return dicSimbolos.get(this.conversion);
	}

	public static void diccionarios(double valor) {
		//Agregar converisiones de moneda a diccionario: {Conversion : Constante}
		dicConversiones.put(Constant.CONV_COPUSD,Constant.COPUSD*valor);
		dicConversiones.put(Constant.CONV_USDCOP,Constant.USDCOP*valor);
		dicConversiones.put(Constant.CONV_COPEUR,Constant.COPEUR*valor);
		dicConversiones.put(Constant.CONV_EURCOP,Constant.EURCOP*valor);
		dicConversiones.put(Constant.CONV_COPGBP,Constant.COPGBP*valor);
		dicConversiones.put(Constant.CONV_GBPCOP,Constant.GBPCOP*valor);
		dicConversiones.put(Constant.CONV_COPJPY,Constant.COPJPY*valor);
		dicConversiones.put(Constant.CONV_JPYCOP,Constant.JPYCOP*valor);
		dicConversiones.put(Constant.CONV_COPKRW,Constant.COPKRW*valor);
		dicConversiones.put(Constant.CONV_KRWCOP,Constant.KRWCOP*valor);
		
		//Agregar conversiones de temperatura a diccionario
		dicConversiones.put(Constant.CONV_CELKEL, valor+273.0);
		dicConversiones.put(Constant.CONV_KELCEL, valor-273.0);
		dicConversiones.put(Constant.CONV_CELFAR, (9*valor/5)+32.0);
		dicConversiones.put(Constant.CONV_FARCEL, (valor-32.0)*5/9);
		dicConversiones.put(Constant.CONV_FARKEL, ((valor-32.0)*5/9)+273);
		dicConversiones.put(Constant.CONV_KELFAR, (9*(valor-273)/5)+32.0);
		
		//Crear diccionario de constantes
		dicSimbolos.put(Constant.CONV_COPUSD,Constant.SYMBOL_USD);
		dicSimbolos.put(Constant.CONV_USDCOP,Constant.SYMBOL_COP);
		dicSimbolos.put(Constant.CONV_COPEUR,Constant.SYMBOL_EUR);
		dicSimbolos.put(Constant.CONV_EURCOP,Constant.SYMBOL_COP);
		dicSimbolos.put(Constant.CONV_COPGBP,Constant.SYMBOL_GBP);
		dicSimbolos.put(Constant.CONV_GBPCOP,Constant.SYMBOL_COP);
		dicSimbolos.put(Constant.CONV_COPJPY,Constant.SYMBOL_JPY);
		dicSimbolos.put(Constant.CONV_JPYCOP,Constant.SYMBOL_COP);
		dicSimbolos.put(Constant.CONV_COPKRW,Constant.SYMBOL_KRW);
		dicSimbolos.put(Constant.CONV_KRWCOP,Constant.SYMBOL_COP);	
		dicSimbolos.put(Constant.CONV_CELKEL, Constant.SYMBOL_KELVIN);
		dicSimbolos.put(Constant.CONV_KELCEL, Constant.SYMBOL_CELSIUS);
		dicSimbolos.put(Constant.CONV_CELFAR, Constant.SYMBOL_FAHRENHEIT);
		dicSimbolos.put(Constant.CONV_FARCEL, Constant.SYMBOL_CELSIUS);
		dicSimbolos.put(Constant.CONV_FARKEL, Constant.SYMBOL_KELVIN);
		dicSimbolos.put(Constant.CONV_KELFAR, Constant.SYMBOL_FAHRENHEIT);
	}
}
