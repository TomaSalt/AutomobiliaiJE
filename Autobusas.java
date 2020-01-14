package autoy;

public class Autobusas extends Auto {
	
	public Stotele[] marsrutas;

	public int paskutine_pravaziuota_stotele = -1;
	public int kita_stotele = 0;	
	public double nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles = 0;	
	
	public Autobusas() {
		
	}

	public Autobusas( Stotele[] marsrutas) {
		
		super();
		this.marsrutas = marsrutas;			
	}
	
	public Autobusas ( String vardas, double greitis, Stotele[] marsrutas  ) {
		
		super( vardas, greitis );
		this.marsrutas = marsrutas;
		surastiAtvykimoLaikus();
	}
	
	public double nuvaziotasAtstumas () {
		
		double nuvaziotas_atstumas = 0;	
		
//		System.out.println( 
//				"\nlaiko_intervalas <= marsrutas [ " + kita_stotele + " ].atvykimo_laikas : " 
//				+ laiko_intervalas 
//				+ "<=" 
//				+ marsrutas [ kita_stotele ].atvykimo_laikas 
//				+ ": "
//				+ ( laiko_intervalas <= marsrutas [ kita_stotele ].atvykimo_laikas )
//		);
		
		if ( kita_stotele < marsrutas.length ) {
		
			if ( laiko_intervalas < marsrutas [ kita_stotele ].atvykimo_laikas ) {
			
				if ( paskutine_pravaziuota_stotele == -1 ) {
					
					nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles = nuvaziotas_atstumas = this.greitis * laiko_intervalas;
					
				} else {
					
					double isvykimo_laikas_is_paskutines_pravaziuotos_stoteles 
						= 
							marsrutas [ paskutine_pravaziuota_stotele ].atvykimo_laikas 
						+  
							marsrutas [ paskutine_pravaziuota_stotele ].stovejimo_laikas
					;
					if ( laiko_intervalas <= isvykimo_laikas_is_paskutines_pravaziuotos_stoteles ) {
						
						nuvaziotas_atstumas = nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles;
						
					} else {
						
						double laiko_intervalas_x = laiko_intervalas - isvykimo_laikas_is_paskutines_pravaziuotos_stoteles;
						nuvaziotas_atstumas = nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles + this.greitis * laiko_intervalas_x;
					}
				}
				
			} else {																														// privaziuosim nauja stotele
				
				nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles = nuvaziotas_atstumas = marsrutas [ kita_stotele ].atstumas;
	//			System.out.println( 
	//					"\nlaiko_intervalas <= marsrutas [ " + kita_stotele + " ].atvykimo_laikas : " 
	//					+ laiko_intervalas 
	//					+ "<=" 
	//					+ marsrutas [ kita_stotele ].atvykimo_laikas 
	//					+ ": "
	//					+ ( laiko_intervalas <= marsrutas [ kita_stotele ].atvykimo_laikas )
	//			);			
	//			System.out.println( "\nnuvaziotas_atstumas_iki_paskutines_pravaziotos_ " +  kita_stotele  + " _stoteles: " + nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles );
				paskutine_pravaziuota_stotele++;
				kita_stotele++;
			}
		} else {
			
			nuvaziotas_atstumas = nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles;
		}
		
		return nuvaziotas_atstumas;
	}	
	
	public void surastiAtvykimoLaikus() {
	
		double suma_stovejimo_laiko = 0;
		
		for( int i = 0; i < marsrutas.length; i++ ) {
			
			marsrutas[ i ].atvykimo_laikas =  suma_stovejimo_laiko + marsrutas[ i ].atstumas /  greitis;
			suma_stovejimo_laiko += marsrutas [ i ].stovejimo_laikas;
		}
	}
	
	public String parodyti ( ) {
		
		String stoteles = "";
		
		for (int i = 0; i < marsrutas.length; i++ ) {
			
			stoteles += " " + marsrutas[ i ].parodyti();
		} 
		return  super.parodyti() + "\n\t---- Marsrutas:" + stoteles;
	}
	
	public String parodytiPapildomaInfo() {
		
		String papildoma_info 
				= 
					"pask. prav._st.:"  + paskutine_pravaziuota_stotele + 
					" kita_stotele: " + kita_stotele + 
					" nuvaz. atst. iki pask. prav. st." + nuvaziotas_atstumas_iki_paskutines_pravaziotos_stoteles
					
		;	
		return papildoma_info;
	}
	
	public String kasAs() {
		
		return getClass().getSimpleName();
	}	
}
