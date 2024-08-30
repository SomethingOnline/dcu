import java.lang.reflect.*;

class Reflection{

	public static boolean checkField(Class<?> newclass, String fieldName){
		if (newclass == null){
			return false;
		}
		Field field = null;
		try{
			field = newclass.getDeclaredField(fieldName);
		} catch(NoSuchFieldException e){
			;
		}
		if (field != null){
			return true;
		} else{
			class<?> superClass = newclass.getSuperclass();
			if (superClass != null){
				return checkField(superClass, fieldName); 
			} else{
				return false;
			}
		}
	}
}