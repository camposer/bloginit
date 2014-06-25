import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fechas {
	public static void main(String[] args) throws ParseException {
		Date hoy = new Date();
		System.out.println("Hoy: " + hoy);
		System.out.println("TS: " + hoy.getTime());
		
		// Forma uno
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ayer = sdf.parse("2014-06-24");
		System.out.println("Ayer (SimpleDateFormat): " + ayer);
		
		// Forma dos
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, 5); // Cuando uso Calendar comienza en 0
		cal.set(Calendar.DAY_OF_MONTH, 24);
		
		ayer = cal.getTime();
		System.out.println("Ayer (Calendar): " + ayer);
		
		// Siempre ayer
		cal = Calendar.getInstance();
		cal.setTime(hoy);
		int diaAyer = cal.get(Calendar.DAY_OF_MONTH) - 1;
		cal.set(Calendar.DAY_OF_MONTH, diaAyer);
		
		// Imprimir con formato
		sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));
		System.out.println("Hoy: " + sdf.format(hoy));
		
	}
}
