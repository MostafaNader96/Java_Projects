
package lab2.pkg2;

import java.util.StringTokenizer;

public class Lab22 {


    public static void main(String[] args) {
        
     //String[] ip="192.168.1.1".split("\\."); 
     
     String[] ip=args[0].split("\\.");
     
     
     
     if(args[0].charAt(args[0].length()-1)=='.')
     {System.out.println("you entered an invalid ip");
     }
     
     else
     {
     for(int i=0;i<ip.length;i++)
     {
     System.out.println(ip[i]);
     }
     
     
        StringTokenizer s= new StringTokenizer(args[0],".");
        while (s.hasMoreTokens()) {
         System.out.println(s.nextToken());
     }
     }
        
    }
    
}
