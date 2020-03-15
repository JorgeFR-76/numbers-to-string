package es.jorge.projects.numbers2string;

import com.sun.org.apache.xpath.internal.operations.Number;

import java.math.BigDecimal;

public class NumberConverter {

	public static void main(String[] args) throws Exception {
		NumberConverter converter =new NumberConverter();

		System.out.println(converter.convertNumber2String(1221d));
	}
	public String convertNumber2String(Double numberToConvert) throws Exception {
		BigDecimal number = new BigDecimal(String.valueOf(numberToConvert));
		int intValue = number.intValue();
		int decimalPart  = number.subtract(new BigDecimal(intValue)).intValue();
		if (decimalPart > 0)
			return convertInt2String(intValue) + Constants.CON + convertInt2String(decimalPart);
		return convertInt2String(intValue);
	}
	private String convertInt2String(Integer number) throws Exception {
		if (number.equals(1))
			return Constants.UNO;
		else if(number.equals(2))
			return Constants.DOS;
		else if(number.equals(3))
			return Constants.TRES;
		else if(number.equals(4))
			return Constants.CUATRO;
		else if(number.equals(5))
			return Constants.CINCO;
		else if(number.equals(6))
			return Constants.SEIS;
		else if(number.equals(7))
			return Constants.SIETE;
		else if(number.equals(8))
			return Constants.OCHO;
		else if(number.equals(9))
			return Constants.NUEVE;
		else if(number.equals(10))
			return Constants.DIEZ;
		else if(number.equals(11))
			return Constants.ONCE;
		else if(number.equals(12))
			return Constants.DOCE;
		else if(number.equals(13))
			return Constants.TRECE;
		else if(number.equals(14))
			return Constants.CATORCE;
		else if(number.equals(15))
			return Constants.QUINCE;
		else if (number >15 && number < 20)
			return Constants.DECENA + convertInt2String(number-10);
		else if(number.equals(20))
			return Constants.VEINTE;
		else if(number > 20 && number <30)
			return Constants.VEINTENA + convertInt2String(number-20);
		else if(number.equals(30))
			return Constants.TREINTA;
		else if(number > 30 && number <40)
			return Constants.TREINTA + Constants.Y + convertInt2String(number-30);
		else if(number.equals(40))
			return Constants.CUARENTA;
		else if(number > 40 && number <50)
			return Constants.CUARENTA + Constants.Y + convertInt2String(number-40);
		else if(number.equals(50))
			return Constants.CINCUENTA;
		else if(number > 50 && number <60)
			return Constants.CINCUENTA + Constants.Y + convertInt2String(number-50);
		else if(number.equals(60))
			return Constants.SESENTA;
		else if(number > 60 && number <70)
			return Constants.SESENTA + Constants.Y + convertInt2String(number-60);
		else if(number.equals(70))
			return Constants.SETENTA;
		else if(number > 70 && number <80)
			return Constants.SETENTA + Constants.Y + convertInt2String(number-70);
		else if(number.equals(80))
			return Constants.OCHENTA;
		else if(number > 80 && number < 90)
			return Constants.OCHENTA + Constants.Y + convertInt2String(number-80);
		else if(number.equals(90))
			return Constants.NOVENTA;
		else if(number > 90 && number < 100)
			return Constants.NOVENTA + Constants.Y + convertInt2String(number-90);
		else if(number.equals(100))
			return Constants.CIEN;
		else if(number>100 && number<200)
			return Constants.CENTENA + convertInt2String(number-100);
		else if (number.equals(200))
			return Constants.DOS + Constants.CENTENA_MAYOR_199;
		else if ( (number > 200 && number <700) || (number>799 && number<900)) {
			Integer firsDigit = Integer.valueOf(number.toString().substring(0, 1));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			return convertInt2String(firsDigit)+Constants.CENTENA_MAYOR_199 + convertInt2String(restOfDigits);
		}
		else if (number.equals(700))
			return Constants.SETECIENTOS+Constants.CENTENA_MAYOR_199;
		else if (number>700 && number <800) {
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			return Constants.SETECIENTOS + Constants.CENTENA_MAYOR_199  + convertInt2String(restOfDigits);
		}
		else if (number.equals(900))
			return Constants.NOVECIENTOS+Constants.CENTENA_MAYOR_199;
		else if (number>900 && number <1000) {
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			return Constants.NOVECIENTOS + Constants.CENTENA_MAYOR_199  + convertInt2String(restOfDigits);
		}
		else if(number>=1000 && number < 2000) {
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			if (restOfDigits > 0)
				return Constants.MILLARES +Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return Constants.MILLARES;
		}
		else if(number>=2000 && number < 10000){
			Integer firsDigit = Integer.valueOf(number.toString().substring(0, 1));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			if (restOfDigits >0)
				return convertInt2String(firsDigit)+Constants.ESPACIO+Constants.MILLARES +Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return convertInt2String(firsDigit)+Constants.ESPACIO+Constants.MILLARES;
		}

		else if(number>=10000 && number < 100000){
			Integer firsDigits = Integer.valueOf(number.toString().substring(0, 2));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(2));
			if (restOfDigits >0)
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES +Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES;
		}
		else if(number>=100000 && number < 1000000){
			Integer firsDigits = Integer.valueOf(number.toString().substring(0, 3));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(3));
			if (restOfDigits >0)
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES +Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES;
		}
		else if(number>=1000000 && number < 10000000){
			Integer firsDigits = Integer.valueOf(number.toString().substring(0, 1));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(1));
			String salida ="";
			if (firsDigits.equals(1))
				salida = Constants.UN + Constants.ESPACIO+ Constants.MILLON;
			else
				salida = convertInt2String(firsDigits)+ Constants.ESPACIO+ Constants.MILLONES;

			if (restOfDigits >0)
				return salida +  Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return salida;
		}
		else if(number>=10000000 && number < 100000000){
			Integer firsDigits = Integer.valueOf(number.toString().substring(0, 5));
			Integer restOfDigits = Integer.valueOf(number.toString().substring(5));
			if (restOfDigits >0)
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES +Constants.ESPACIO+ convertInt2String(restOfDigits);
			else
				return convertInt2String(firsDigits)+Constants.ESPACIO+Constants.MILLARES;
		}
		else
			throw new Exception("No se ha encontrado conversion para el numero "+ number);
	}
}
