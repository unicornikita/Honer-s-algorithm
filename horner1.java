import java.util.Scanner;
public class horner1
{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Asking the user to input the highest power of the polynom and saving it in NajvecjaStopnja
    System.out.println("Vnesi stopnjo polinoma:");
    int NajvecjaStopnja = sc.nextInt();

    //declaring an array of all the powers the polynom has left in stopnje[] and the coefficient in koeficienti[]
    int stopnje[] = new int[NajvecjaStopnja+1];
    int koeficienti[] = new int[NajvecjaStopnja+1];

    //filling the stopnje[] array with powers between 0 and NajvecjaStopnja
    for(int i = 0; i < NajvecjaStopnja+1; i++)
        stopnje[i] = NajvecjaStopnja-i;

    // filling the koeficienti[] array with the coefficients of a certain power
    for (int j=0; j < stopnje.length; j++)
    {
          System.out.println("Kater koeficient je pri stopnji " + stopnje[j]);
          koeficienti[j] = sc.nextInt();         
    }

    // the sum we will need later to check if number 1 is one of the zeros of the polynom
    int sestevek = koeficienti[0];

    //  zmnozek will save the result of sums you multiply with 1
    int zmnozek = 0;

    // sestevek is saving the sum of coefficients on index k and the sum of the first multiplication, then the sum of coefficients is saved in zmnozek
   for (int k = 0; k < stopnje.length; k++)
    {
        sestevek = koeficienti[k] + zmnozek;
        zmnozek = sestevek;
    }
    // the algorithm lets you know if 1 is a zero of the polynom
    if (sestevek == 0)
            System.out.println("Ena je nicla polinoma");
        
    else if (sestevek != 0)
        System.out.println("Ena ni nicla polinoma");

    }
}