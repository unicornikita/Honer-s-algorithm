import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;
public class horner1
{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Vnesi stopnjo polinoma:");
    int NajvecjaStopnja = sc.nextInt();
    int sestevek = NajvecjaStopnja;
    int stopnje[][] = new int[100][NajvecjaStopnja+1];
    stopnje[0][0] = NajvecjaStopnja;
    for (int i = 1; i <= NajvecjaStopnja; i++)
    {
        stopnje[0][i] = NajvecjaStopnja-1;
        NajvecjaStopnja--;
    }
    
    for (int j=0; j< stopnje.length; j++)
    {
          System.out.println("Kater koeficient je pri stopnji " + stopnje [0][j]);
          stopnje[1][j] = sc.nextInt();  
          /*if(stopnje[0][j] == 0)
            break; */        
    int zmnozek = 0;
    int k = 0;
    do
    {
        sestevek = stopnje[1][k] + zmnozek;
        zmnozek = sestevek;

    if (k == stopnje.length && sestevek == 0)
        {
            System.out.println("Ena je nicla polinoma");
            break;
        }
        
    else if (k == stopnje.length && sestevek != 0)
            System.out.println("Ena ni nicla polinoma");
    
    k++;
    } while(sestevek != 0);

}
    }
}
