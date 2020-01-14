package autoy;

public class Auto {

	public String pav = "Neaiskus";
	public Double greitis;
	public Double laiko_intervalas = 0.0;
	
	public Auto() {
		
		this.greitis = 0.0;
	}
	public void maxLaikas(atstumas) {
		
		this.atstumas = atstumas;
		this.laikas = this.atstumas / this.greitis;
		
	return (this.laikas);
		
	
	public Auto ( String vardas, double greitis ) {
		
		this.pav = vardas;
		this.greitis = greitis;
	}
	
	public void pavadinti ( String vardas ) {
		
		this.pav = vardas;
	}
	
	public void keistiGreiti ( double greitis ) {
		
		this.greitis = greitis;
	}
	
	public void judeti ( double laiko_intervalas ) {
		
		this.laiko_intervalas += laiko_intervalas;			
	}

	public double nuvaziotasAtstumas () {
		
		return (this.greitis * laiko_intervalas);
	}
	
	public String parodyti ( ) {
		
		return  kasAs() + ": " + this.pav + " " + this.greitis;
	}
	
	public String kasAs() {
		
		return "Automobilis";
	}
	
	public String parodytiPapildomaInfo() {
		
		return " tiesiog vaziuoja";
	}
}
