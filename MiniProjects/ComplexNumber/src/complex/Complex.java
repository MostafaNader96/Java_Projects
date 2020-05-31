/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complex;

class Main
{
  public static void main(String[] args)
  {
  Complex c=new Complex();
  Complex c1=new Complex();
  Complex c2=new Complex();
  c.setreal(2);
  c.setimag(5);
  c.printcomplex();
  System.out.println();
  
  c1.setreal(2);
  c1.setimag(-7);
  c1.printcomplex();
  System.out.println();
  
  c2=Complex.addComplex(c,c1);
  c2.printcomplex();
  }
}
   
/**
 *
 * @author MOSTAFA
 */
class Complex {
    
    private float real;
    private float imag;
    
    public Complex()
    {
    real=0;
    imag=0;
    }
    public Complex(float real,float imag)
    {
    this.real=real;
    this.imag=imag;
    }
    public void setreal(float real)
    {
    this.real=real;
    }
    public void setimag(float imag)
    {
    this.imag=imag;
    }
    public float getreal()
    {
    return real;
    }
    public float getimag()
    {
    return imag;
    }
    public void printcomplex()
    {
    System.out.print("Complex Number= ");
    System.out.print(real);
    if(imag>0)
    {
    System.out.print("+");
    System.out.print(imag);
    System.out.print("i");
    }
    else if(imag==0)
    {
    
    }
    else
    {
    System.out.print(imag);
    System.out.print("i");
    }
    }
    public static Complex addComplex(Complex c1,Complex c2)
    {
     Complex temp = new Complex();
     temp.real=c1.real+c2.real;
     temp.imag=c1.imag+c2.imag;
     return temp;
    }
}
