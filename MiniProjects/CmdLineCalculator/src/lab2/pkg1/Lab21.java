
package lab2.pkg1;

public class Lab21 {


    public static void main(String[] args) {

    double x = Integer.parseInt(args[0]);
    double y = Integer.parseInt(args[2]);    
    
    switch(args[1])
    {
        case "+":
        
            System.out.print(x+y + "\n");
        break;        
    
        case "-":
           System.out.print(x-y + "\n");
        break;        
    
        case "x":
           System.out.print(x*y + "\n");
        break;        
    
        case "/":
           System.out.print(x/y + "\n");
        break;        
    
    }
    
    }
    
}
