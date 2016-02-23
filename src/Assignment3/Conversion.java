package Assignment3;


public class Conversion {
	// rounds the value to nearest decimal place
	public static double Rounding(double value, int decimalPlace){ 		
		int digit = 10; 
		for(int i = 0; i< decimalPlace; i++){
			digit *= 10;
		}
		double money =((int)(value * digit));
		int temp = (int)money;
		int counter = 0;
		while(temp % 10 != 0){
			temp++;
			counter++;
		}
		digit /=10;
		if(counter <= 5 && counter > 0){money +=10;}
		money = ((int)money) / 10;
		money /= digit;
		return money;
	}
	//convert string into double value and returns -1 if string is not a number.
	//pass in -1 for decimalPlace if the value returned does not need to be rounded
	//decimalPlace is used for Rounding
	public static double StringToDouble (String inputString, int decimalPlace){
		int index = 0;
		int decimal = -1;
		char letter = inputString.charAt(index);
		int doclength = inputString.length();
		if (doclength==0){return -1;}
		if (doclength ==1 && letter =='.'){return -1;}
		while (((Character.isDigit(letter)==true)||(letter == '.'))&& index!=doclength-1){		
			index++;
			if(letter == '.'){decimal = index;}
			letter = inputString.charAt(index);										//takes the letter at the pointer
			}
		if(index + 1 == doclength){
			double outputValue = Double.parseDouble(inputString);
			if(decimal != -1 && (index - decimal >=decimalPlace)&& decimalPlace != -1){
				outputValue = Rounding(outputValue , decimalPlace);
				}
			return outputValue;
		}
		return -1;
	}
	public static int StringToInt (String inputString){
		int index = 0;
		char letter = inputString.charAt(index);
		int doclength = inputString.length();
		if (doclength==0){return -1;}
		if (doclength ==1 && letter =='.'){return -1;}
		while (((Character.isDigit(letter)==true))&& index!=doclength-1){		
			index++;
			letter = inputString.charAt(index);										//takes the letter at the pointer
			}
		if(index + 1 == doclength){
			long UpperLimit = Integer.parseUnsignedInt(inputString);
			if(UpperLimit > Integer.MAX_VALUE || UpperLimit <0){return -1;}
			int outputValue = Integer.parseInt(inputString);
			return outputValue;
		}
		return -1;
	}

}	
