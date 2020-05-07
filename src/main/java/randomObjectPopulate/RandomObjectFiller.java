package randomObjectPopulate;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;

class RandomObjectFiller {

	private Random random = new Random();

	public <T> T createAndFill(Class<T> clazz) throws Exception {
		T instance = clazz.newInstance();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			Object value = getRandomValueForField(field);
			field.set(instance, value);
		}
		return instance;
	}

	private Object getRandomValueForField(Field field) throws Exception {
		Class<?> type = field.getType();

		if (type.isEnum()) {
			Object[] enumValues = type.getEnumConstants();
			return enumValues[random.nextInt(enumValues.length)];
		} else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
			return java.lang.Math.abs(random.nextInt());
		} else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
			return java.lang.Math.abs(random.nextLong());
		} else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
			return random.nextDouble();
		} else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
			return random.nextFloat();
		}else if (type.equals(byte[].class)) {
			return getArray(field);
		} else if (type.equals(String.class)) {
			return getAlphaNumericString(10);
		} else if (type.equals(Byte.TYPE)) {
			byte[] myvar = getAlphaNumericString(10).getBytes();
			return myvar;
		} else if (type.equals(BigInteger.class)) {
			return BigInteger.valueOf(random.nextInt());
		} else if (type.equals(Date.class)) {
			Date randomDate = new Date();
			return randomDate;
		} else if (type.equals(Boolean.class)) {
			return true;
		}else if (type.equals(ArrayList.class)) {
			return getList(field);
		} else if (type.equals(List.class)) {
			return getList(field);
		}
		return createAndFill(type);
	}

	private Object getRandomValueForField(Class<?> type) throws Exception {


        if(type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];

        } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return java.lang.Math.abs(random.nextInt());

        } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
            return java.lang.Math.abs(random.nextLong());

        } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();

        } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();

        }else if (type.equals(Byte.TYPE)) {
        	byte[] myvar = getAlphaNumericString(10).getBytes();
        	 return myvar;
        	 
        } else if(type.equals(String.class)) {
        	return getAlphaNumericString(10);

        } else if (type.equals(Boolean.class)) {
        	return true;

        } else if(type.equals(BigInteger.class)){
            return BigInteger.valueOf(random.nextInt());
        
    	} 
//        else if (type.equals(List.class)) {
//    		return List
//    	}

        return createAndFill(type);
    }

	public List getList(Field f) throws Exception {
		List l = new ArrayList();
		Type[] genericType = ((ParameterizedType) f.getGenericType()).getActualTypeArguments();

		Object val = getRandomValueForField((Class) genericType[0]);
		l.add(val);
		return l;

	}

	public Object getArray(Field f) throws Exception {

		Class<?> type = f.getType();
		Class<?> arrayClassType = type.getComponentType();

		//Object val = getRandomValueForField(arrayClassType);
		return Array.newInstance(arrayClassType, 1);

	}

	private String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	// function to generate a random string of length n
	private int getRandomNumber() {
		Random rand = new Random(); // instance of random class
		int upperbound = 999999999;
		// generate random values from 0-24
		int int_random = rand.nextInt(upperbound);
		return int_random;
	}
}

