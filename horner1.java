import java.util.Scanner;

public class horner1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Asking the user to input the highest power of the polynom and saving it in
        // NajvecjaStopnja
        System.out.println("Vnesi stopnjo polinoma:");
        int NajvecjaStopnja = sc.nextInt();

        // declaring an array of all the powers the polynom has left in stopnje[] and
        // the coefficient in koeficienti[]
        int stopnje[] = new int[NajvecjaStopnja + 1];
        int koeficienti[] = new int[NajvecjaStopnja + 1];
        int vodilniKoeficient = 0;
        int prostiClen = 0;

        // filling the stopnje[] array with powers between 0 and NajvecjaStopnja
        for (int i = 0; i < NajvecjaStopnja + 1; i++)
            stopnje[i] = NajvecjaStopnja - i;

        // filling the koeficienti[] array with the coefficients of a certain power
        for (int j = 0; j < stopnje.length; j++) {
            System.out.println("Kater koeficient je pri stopnji " + stopnje[j]);
            koeficienti[j] = sc.nextInt();
            vodilniKoeficient = koeficienti[0];

            if (j == stopnje.length - 1)
                prostiClen = koeficienti[j];
        }

            for(double pc = 300; pc > -300; pc--){
                if(result(koeficienti, pc) == 0){
                    System.out.println(pc + "je nicla polinoma");
                }
            }
        
        

        sc.close();
    }

    //method to check possible zeros
        public static double result(int koef[], double possiblezero){
            double result = 0;
            for(int i = 0; i < koef.length; i++)
                result = result*possiblezero + koef[i];
            return result;
        }

}



/* 
        // finding the numbers by which the coefficient at the highest power are
        // devideable
        int deljliteljiVodilnegaClena[] = new int[vodilniKoeficient * 2];
        // the next two ints will hold the values of the highest power's coefficient
        int deljenjeZVodKoef = 0;
        // if the coefficient at the highest power is negative
        if (vodilniKoeficient < 0) {
            deljenjeZVodKoef = vodilniKoeficient * (-1);
            for(int i = deljenjeZVodKoef; i>vodilniKoeficient; i--){
                for(int j = 0; j < deljliteljiVodilnegaClena.length; j++){
                    if(vodilniKoeficient%i==0 && i != 0)
                        deljliteljiVodilnegaClena[j] = vodilniKoeficient/i;
                }
            }
        }

        // if the coefficient at the highest power is positive
        else if (vodilniKoeficient > 0) {
            deljenjeZVodKoef = vodilniKoeficient;
            for (int m = vodilniKoeficient; m >= deljenjeZVodKoef*(-1); m--) {
                for(int j=0; j < deljliteljiVodilnegaClena.length; j++){
                    if(m!=0 && deljenjeZVodKoef%m==0)
                        deljliteljiVodilnegaClena[j] = vodilniKoeficient/m;
                }
            }
        }
        // finding the numbers by which the free coefficient is devidable
        int deljiteljiProstegaClena[] = new int[prostiClen * 2];
        int stevecProstiClen = 0;
        // finding the numbers by which the free coefficient is devideable
        if (prostiClen < 0) {
            int finding = 0;
            for (int n = prostiClen; n <= prostiClen * (-1); n++) {
                if (prostiClen % n == 0 && n!=0)
                    finding = deljiteljiProstegaClena[stevecProstiClen];

                stevecProstiClen++;
            }
        }

        else if (prostiClen > 0) {
            int finding = 0;
            for (int n = prostiClen * (-1); n < prostiClen; n++){
                if (n!=0 && prostiClen % n == 0) {
                    finding=deljiteljiProstegaClena[stevecProstiClen];
                    stevecProstiClen++;
                }
        }

        int CprotiD[] = new int[300];
        // d so deljitelji vodilnega koeficienta
        // c so deljitelji prostega clena 
        // p so stevila deljiva s prostim clenom, w so stevila deljiva z vodilnimi cleni 
        int SeEnStevec = 0;
        for (int w = 0; w < deljliteljiVodilnegaClena.length; w++) {
            for (int p = 0; p < deljiteljiProstegaClena.length; p++) {
                if(deljiteljiProstegaClena[p]/deljliteljiVodilnegaClena[w] == 0)
                    break;
                CprotiD[SeEnStevec] = deljiteljiProstegaClena[p] / deljliteljiVodilnegaClena[w];
                System.out.println(CprotiD[SeEnStevec]);
                SeEnStevec++;

            }
        }

        // the sum we will need later to check if number 1 is one of the zeros of the
        // polynom
        int sestevek = vodilniKoeficient;
        // zmnozek will save the result of sums you multiply with the sum
        int zmnozek = 0;
        System.out.println("sup");
        int stevec = 0;
        for(int PotencialneNicle=0; PotencialneNicle < CprotiD.length; PotencialneNicle++){
            for(int preverjanje = 0; preverjanje < CprotiD.length; preverjanje++){
                zmnozek = CprotiD[PotencialneNicle]*sestevek;
                sestevek = koeficienti[stevec]+zmnozek;
                stevec++;
                if(sestevek == 0)
                    break;

                System.out.println("test");
            }

            if(sestevek == 0 && CprotiD[PotencialneNicle]!=0){
                
                    System.out.println(CprotiD[PotencialneNicle] + " je nicla polinoma");
            }

            else System.out.println("Broken");

        }
        // performing the actual horner's algorithm with the possible zeros of the
        // polynoM
*/