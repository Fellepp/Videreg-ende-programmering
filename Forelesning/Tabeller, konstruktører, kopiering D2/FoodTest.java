/*
Hva bør en konstruktør gjøre med objektvariabler som er tabeller?
1. Ingenting
	Tabellen må initieres ved deklareringen
	Brukes dersom tabellen "utvides" underveis
2. Tabellstørrelsen som parameter
	Brukes dersom fast tabellstørrelse for objektet, og tabellen er tom ved start
3. Hele tabellen som parameter
	Som 2. men tabellen har startverdi
*/

class Diet{
	//private String[] food = new String[4]; Alternativ 1
	private String[] food = null; //Alternativ 2 og 3

	//Alternativ 2
	public Diet(int dietSize){
		food = new String[dietSize];
	}

	/*Alternativ 3 - Må huske å kopiere tabellen!
	public Diet(String[] food){
		this.food = food;
		//Kopier tabellen
	*/

	private boolean okValue(String food){
		return (food != null && !food.equals("") && !alreadyRegistered(food));
	}

	/* Lager en ny ved hjelp av findFreePosition()
	private boolean dietCompleted(){
		for(int i = 0; i<food.length; i++){
			if(food[i] == null){
				return false;
			}
		}
		return true;
	}
	*/

	private boolean dietCompleted(){
		if(findFreePosition() < 0) return true;
		return false;
	}

	private int findFreePosition(){
		for(int i = 0; i<food.length; i++){
			if(food[i] == null){
				return i;
			}
		}
		return -1;
	}

	private boolean alreadyRegistered(String newFood){
		for(int i = 0; i<food.length; i++){
			if(newFood.equals(food[i])){
				return true;
			}
		}
		return false;
	}

	public boolean regFood(String newFood){
		if(okValue(newFood) && !dietCompleted()){ //not null, not "", not already registered
			newFood = newFood.trim();
			int pos = findFreePosition();
			food[pos] = newFood;
			return true;
		}else{
			return false;
		}
	}

	public String toString(){
		String s = "";
		for(int i = 0; i<food.length; i++){
			s += food[i] + " ";
		}
		s += "\n";
		return s;
	}
}
class FoodTest{
	public static void main(String[]args){
		Diet d = new Diet(4);
		d.regFood("apple");
		d.regFood("meat");
		System.out.println(d.toString());
	}
}