import java.util.*;   
import java.lang.reflect.*;   

public class Information {
	public static void main(String[] args) { 
	/*read the project prefix in 
	* This part will be hardcored after the testing is completed
	*/
	ArrayList<String> method = new ArrayList<String>(); 
	ArrayList<String> returnType = new ArrayList<String>(); 
		String name;   
		if (args.length > 0)
			name = args[0];   
		else  {   
			Scanner in = new Scanner(System.in);   
			System.out.println("Enter my.project.prefix ");   
			name = in.next();   
		}
		try {
			Class cl = Class.forName(name);  
			System.out.println("The project prefix: " + name);
			method = methodName(cl);
			for(String tmp: method) { 
				System.out.println("List of methods " + method);
			}
		}
		catch (ClassNotFoundException e)  {   
			e.printStackTrace();   
		}
		catch (Exception e) {
			e.printStackTrace();  
		}  
		System.exit(0);
	}//end main
	public static ArrayList<String> methodName(Class cl)   {  
		ArrayList<String> method = new ArrayList<String>(); 
		Method[] methods = cl.getDeclaredMethods();   
		for (Method m : methods)   {   
			Class retType = m.getReturnType();   
            String name = m.getName();   
            method.add(name);
        }   
       return method;
       } //end of method
}
