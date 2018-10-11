import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;
public class horner
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vodilnikoef;
        int stopnja;
        int nicla = 1;
        int zbirkaStopenj[];
        int zbirkaKoeficientov[];
        System.out.println("Vnesi polinom: ");
        String polinom =args[0];
        polinom = sc.nextLine();
        polinom[.class] = polinom.replaceAll("[^-?0-9]+", " ");
        stopnja = polinom[1];
        System.out.println("Vodilni koeficient je: " + polinom[0] + " in stopnja polinoma je: " + stopnja);
        
        for (int i=0; i<polinom.length; i++)
        {
        int j=0;
            if (i == 1 || i%2!=0)
            {
                zbirkaStopenj[j] = polinom[i];
                j++;
            }
            
            else if (i == 0 || i%2==0)
            {
                zbirkaKoeficientov[j] = polinom[i];
                j++;
            }
        }
        
        int k=0;
       int vrstica_stopenj[];
       int vrstica_keoficientov[];
       int manjkajoca_niclat[];
       int novaZbirkaStopenj[];
       vrstica_stopenj[k][k] = zbirkaStopenj[0];
       for(int n = 1; n < stopnja; n++)
       {
           if (stopnja-1 != zbirkaStopenj[n])
           {
               vrstica_stopenj[k][n] = 0;
               vrstica_stopenj[k][n+1] = zbirkaStopenj[n];
           }           
           else if (stopnja-1 == zbirkaStopenj[n])
           {
               vrstica_stopenj[k][n] = zbirkaStopenj[n];
           }
       } 

       for(int m = 0; m < zbirkaKoeficientov; m++)
       {
           vrstica_keoficientov[k+1][m] = zbirkaKoeficientov[m];
           if (zbirkaKoeficientov[m]-1 != zbirkaKoeficientov[m+1])
           {
               vrstica_keoficientov[k+1][m+1] = 0;
               zbirkaKoeficientov.length++;
           }
       }

       int[] zmnozki = new int[0][stopnja];
       int[] sestevki = new int[0][stopnja];
       for(int a = 0; a < stopnja; a++)
       {
           if(a == 0)
        {
            zmonzki[a][a] = 0;
        sestevki[a][a] = 1;
        sestevki[a][a+1] = zbirkaKoeficientov[a];
        zmonzki[a][a+1] = 0;
        
       }
       else if(a == 1)
       {
        zmonzki[0][a] = 0;
        sestevki[0][a] = zbirkaKoeficientov[0];
       }

       else if( a >= 2)
       {
           zmnozki[0][a] = sestevki[0][0] * zbirkaKoeficientov[a-1];
           sestevki[0][a] = zbirkaKoeficientov[a-1] + zmnozki[0][a]; 
       }

       if (a == stopnja)
       {
           if (sestevki[0][a] == 0)
           {System.out.println("Ena je nicla polinoma");
            break;
            }
            
            else {
                System.out.println("Ena ni nicla polinoma");
                break;
            }
    }
    }

    }
}
