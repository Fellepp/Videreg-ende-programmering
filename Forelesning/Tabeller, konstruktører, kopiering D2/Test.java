class Test{
	public static void main(String[]args){
		int[] num = new int[6];
		num[3] = 1;
		num[5] = 2;
		for(int i = 0; i<num.length; i++){
			System.out.println(num[i]);
		}
		System.out.println();

		//"Kopiere"
		int[] numCopy = new int[num.length];
		System.arraycopy(num, 0, numCopy, 0, num.length); //fraTab, fraIndeks, tilTab, tilIndeks, antall - Slipper å kopiere med for-løkke
		for(int i = 0; i<numCopy.length; i++){
			System.out.println(numCopy[i]);
		}
		System.out.println();

		//"Utvide"
		int[] temp = new int[num.length + 2];
		System.arraycopy(num, 0, temp, 0, num.length); //Kopierer innholdet i num til temp (som er større)
		num = temp; //Num peker til temp, num peker på den lengre tabellen med samme innhold
		num[7] = 10;
		for(int i = 0; i<num.length; i++){
			System.out.println(num[i]);
		}
		System.out.println();

		//"Strenger"
		String[] food = new String[4];
		food[1] = new String("meat");
		food[3] = "cheese";
		for(int i = 0; i<food.length; i++){
			if(food[i] != null) food[i] = food[i].trim();
			System.out.println(food[i]);
		}
		System.out.println();

		//Kopiere
		String[] foodCopy = new String[food.length];
		System.arraycopy(food, 0, foodCopy, 0, food.length); //grunn kopiering
		for(int i = 0; i<foodCopy.length; i++){
			if(food[i] != null){
				foodCopy[i] = new String(food[i]); //dyp kopiering, nødvendig hvis mutable objekter. Hvis man skal kunne endre foodCopy uavhengig av food
			}
		}

		//Utvide
		String[] tempS = new String[food.length + 2];
		System.arraycopy(food, 0, tempS, 0, food.length); //grunn kopiering er nok her. Peker til samme objekter, trenger ikke opprette nye
		food = tempS; //food peker på temp og erstatter, temp "forsvinner"
		food[4]= "apple";
		for(int i = 0; i<food.length; i++){
			if(food[i] != null){
				food[i] = food[i].trim();
			}
			System.out.println(food[i]);
		}
		System.out.println();
	}
}

