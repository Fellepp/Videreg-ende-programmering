/*
Registrere nytt utstyr
Fjern utstyr fra registeret
Vis lagerstatus
Endre varebeholdning
*/

class Register{
	private java.util.ArrayList<Utstyr> liste = new java.util.ArrayList<Utstyr>();

	private boolean regFraFør(Utstyr u){
		if(liste.indexOf(u) >= 0){
			return true;
		}
		return false;
	}
	/*
	private boolean regFraFør(Utstyr u){
		for(int i = 0; i<liste.size(); i++){
			Utstyr uu = liste.get(i);
			if(uu.getBetegnelse().equals(u.getBetegnelse())) return true;
		}
		return false;
	}*/

	public boolean regNy(String b, String lev, int lager, int grense){
		if(b == null) return false;
		Utstyr u = new Utstyr(b, lev, lager, grense);
		return regNy(u);
	}

	public boolean regNy(Utstyr u){
		if(u == null) return false;
		if(!regFraFør(u)){
			liste.add(u);
			return true;
		}else return false;
	}

	public String toString(){
		return liste.toString();
	}
}

class Test{
	public static void main(String[]args){
		Register reg = new Register();
		reg.regNy(new Utstyr("bord", "XXX", 10, 2)); //(String betegnelse, String leverandør, int påLager, int nedreGrense)
		reg.regNy(new Utstyr("prosjektor", "XXX", 20, 2));
		reg.regNy("stol", "XXX", 50, 10);
		System.out.println(reg);
	}
}