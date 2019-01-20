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
        // finding the numbers by which the coefficient at the highest power are
        // devideable
        int deljliteljiVodilnegaClena[] = new int[vodilniKoeficient * 2];
        int stevecDeljitelji = 0;
        // the next two ints will hold the values of the highest power's coefficient
        int deljenjeZVodKoef = 0;
        int deljenjeSProstClen = 0;
        // if the coefficient at the highest power is negative
        if (vodilniKoeficient < 0) {
            deljenjeZVodKoef = vodilniKoeficient * (-1);
            for (int m = vodilniKoeficient; m <= deljenjeZVodKoef; m++) {
                if (vodilniKoeficient % m == 0) {
                    deljliteljiVodilnegaClena[stevecDeljitelji] = m;
                    stevecDeljitelji++;
                }
            }
        }

        // if the coefficient at the highest power is positive
        else if (vodilniKoeficient > 0) {
            deljenjeZVodKoef = vodilniKoeficient;
            for (int m = vodilniKoeficient * (-1); m <= deljenjeZVodKoef; m++) {
                if (deljenjeZVodKoef % m == 0)
                    deljliteljiVodilnegaClena[stevecDeljitelji] = m;

                stevecDeljitelji++;
            }
        }
        // finding the numbers by which the free coefficient is devidable
        int deljiteljiProstegaClena[] = new int[prostiClen * 2];
        int stevecProstiClen = 0;
        // ffinding the numbers by which the free coefficient is devideable
        if (prostiClen < 0) {
            for (int n = prostiClen; n <= prostiClen * (-1); n++) {
                if (prostiClen % n == 0)
                    deljiteljiProstegaClena[stevecProstiClen] = n;

                stevecProstiClen++;
            }
        }

        else if (prostiClen > 0) {
            for (int n = prostiClen * (-1); n < prostiClen; n++)
                if (prostiClen % n == 0)
                    deljiteljiProstegaClena[stevecProstiClen] = n;

            stevecProstiClen++;
        }

        int CprotiD[] = new int[prostiClen * vodilniKoeficient];
        // d so deljitelji vodilnega koeficienta
        // c so deljitelji prostega clena
        // p so stevila deljiva s prostim clenom, w so stevila deljiva z vodilnimi cleni
        int SeEnStevec = 0;
        for (int p = 0; p < deljiteljiProstegaClena.length; p++) {
            for (int w = 0; w < deljliteljiVodilnegaClena.length; w++) {
                CprotiD[SeEnStevec] = deljiteljiProstegaClena[p] / deljliteljiVodilnegaClena[w];
                SeEnStevec++;
            }
        }

        // the sum we will need later to check if number 1 is one of the zeros of the
        // polynom
        int sestevek = 0;
        // zmnozek will save the result of sums you multiply with 1
        int zmnozek = 0;

        // performing the actual horner's algorithm with the possible zeros of the
        // polynom
        for (int VseNajdeneNicle = 0; VseNajdeneNicle < CprotiD.length; VseNajdeneNicle++) {
            for (int VsakaNiclaPosamezno = 0; VsakaNiclaPosamezno < CprotiD.length; VsakaNiclaPosamezno++) {
                sestevek = CprotiD[VseNajdeneNicle] + zmnozek;
                zmnozek = sestevek;
            }

            if (sestevek == 0)
                System.out.println(CprotiD[VseNajdeneNicle] + " je nicla polinoma");
        }
    }
}