import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;
public class horner1
{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Vnesi stopnjo polinoma:");
    int NajvecjaStopnja = sc.nextInt();
    int stopnje[][] = new int[1][NajvecjaStopnja+1];
    int koeficienti[][] = new int[1][NajvecjaStopnja+1];
    int sestevek = NajvecjaStopnja;
    for (int i = 0; i <= NajvecjaStopnja+1; i++)
    {
        if (i == 0)
        {
            stopnje[0][i] = NajvecjaStopnja;
        }
        else if(i!=0)
     {
        stopnje[0][i] = NajvecjaStopnja-1;
    }

    NajvecjaStopnja--;
    }
    
    /*int i=0;
    while(i <= NajvecjaStopnja)
    {
        if (i == 0)
        {
            stopnje[0][i] = NajvecjaStopnja;
        }
        else if(i!=0)
     {
        stopnje[0][i] = NajvecjaStopnja-1;
    }

    NajvecjaStopnja--;
    i++;
    }
    */
    for (int j=0; j <= stopnje.length; j++)
    {
          System.out.println("Kater koeficient je pri stopnji " + stopnje[0][j]);
          koeficienti[0][j] = sc.nextInt();  
          /*if(stopnje[0][j] == 0)
            break; */        
    }

    int zmnozek = 0;

   for (int k = 0; k < stopnje.length; k++)
    {
        sestevek = koeficienti[0][k] + zmnozek;
        zmnozek = sestevek;
    }
    if (sestevek == 0)
        {
            System.out.println("Ena je nicla polinoma");
        }
        
    else if (sestevek != 0)
            System.out.println("Ena ni nicla polinoma");

    } 
    
}
