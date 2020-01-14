package autoy;

public class Stotele {
	
	public String pav;
	public double atstumas;
	public double stovejimo_laikas;
	public double atvykimo_laikas;
	
	public Stotele ( String pav, double atstumas, double stovejimo_laikas ) {
		
		nustatyti ( pav, atstumas, stovejimo_laikas );
	}
	
	public void nustatyti ( String pav, double atstumas, double stovejimo_laikas ) {
		
		this.pav = pav;
		this.atstumas = atstumas;
		this.stovejimo_laikas = stovejimo_laikas;		
	}
	
	public String parodyti() {
		
		return this.pav + " " + this.atstumas + " " + this.stovejimo_laikas + " " + this.atvykimo_laikas; 
	}
	
	public double isvykimoLaikas( ) {
		
		return atvykimo_laikas + stovejimo_laikas;
	}
}
