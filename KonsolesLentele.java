package autoy;

public class KonsolesLentele {
	
	String[] antrastes_pav;
	String[] formatai;
	int[] ilgiai;
	
	String eilute = "";
	String antraste = "";
	int nr_esamu = 0;
	
	public KonsolesLentele( int kiekis_stulpeliu ) {
		
		antrastes_pav = new String [ kiekis_stulpeliu ];
		formatai = new String [ kiekis_stulpeliu ];
		ilgiai = new int [ kiekis_stulpeliu ];
	}
	
	public void pridetiStulpeli( String pav, String formatas, int ilgis ) {
		
		antrastes_pav [ nr_esamu ] = pav;
		formatai [ nr_esamu ] = formatas;
		ilgiai [ nr_esamu ] = ilgis;
		
		if ( ilgis < pav.length() ) {
			
			ilgiai [ nr_esamu ] = pav.length();
		}		
		
		nr_esamu++;
	}
	
	public void suformuoti() {
		
		antraste += "|";
		eilute += "-";
	
		for ( int i = 0; i < nr_esamu; i++ ) { 
		
			antraste += String.format( " %" + ilgiai [ i ] + "s |"  , antrastes_pav [ i ] );
			 
			for ( int t = 0; t < ilgiai [ i ] + 3; t++ ) {
			
				eilute += "-";
			}
		}
	}
}
