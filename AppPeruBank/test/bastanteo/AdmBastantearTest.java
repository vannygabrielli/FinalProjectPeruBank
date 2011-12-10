package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdmBastantearTest {

	@Test
	public void RegistrarResultadoBastanteo()throws PeruBankException {
		
		//------------------------------
		//preparamos el ejemplo
		//------------------------------
				
		//Bastanteo: ***** BASTANTEAR PODERES *****
				
		String CodCli      = "CL001";
		String IdGrupoBast = "A";
		String TipoInterv  = "A";      // (A)A   Sola firma / (C)Conjunto
		String CodPoder    = "CHCO";   // (CHCO) Cobro Cheques / (EFRE) Retiro Efectivo 
		String OtrGpoBast  = "B";
		String Moneda      = "USD";    // (SOL)  Soles / (USD) Dolares
		Double Importe     = 2500.00; 
		String CodUser     = "US001";
		
		Calendar FecReg  = Calendar.getInstance();   // Fecha Registro TODAY
		Calendar FecVenc = Calendar.getInstance();   // Fecha Vencimiento
		
		//añadir 6 meses a la fecha vencimiento
		FecVenc.add(FecVenc.DATE, 180);
		
		AdmBastantear regbast = new AdmBastantear();
		          				
	    //ejecutar
	    regbast.registrarBastanteo(CodCli, IdGrupoBast, TipoInterv,	CodPoder,                               
	    		                   OtrGpoBast, Moneda , Importe, CodUser, 
	                               FecReg, FecVenc );
	    
	    //Validar registro 
	    Bastanteo bastanteo = regbast.buscarCliente(CodCli, IdGrupoBast, 
	    		                                    TipoInterv, CodPoder);
        
	     // Verificar
        assertNotNull(bastanteo);
	    
	}
			
}