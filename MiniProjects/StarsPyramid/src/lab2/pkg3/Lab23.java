
package lab2.pkg3;

public class Lab23 {

   
    public static void main(String[] args) {

int H= Integer.parseInt(args[0]);
int sw= Integer.parseInt(args[1]);

switch(sw)
{
    case 0:
for(int i=0;i<H;i++)
{

for(int k=i;k<H;k++)
{
System.out.print(" ");
}
for(int j=0;j<(i*2)+1;j++)
{
System.out.print("*");
}
System.out.println("");

}
break;

    case 1:
for(int i=0;i<H;i++)
{


for(int j=0;j<i+1;j++)
{
System.out.print("*");
}
System.out.println("");

}
break;
}
    }
    
}
