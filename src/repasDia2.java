import java.util.Arrays;

public class repasDia2 {

    private static boolean[] initnumsB ( int nMax ){
        int leng = nMax + 1 ; // se suma un perque agafi el numero;
        boolean [] numbsB = new boolean[ leng ] ;
        for ( int i = 0 ; i < leng ; i++ ){
            numbsB[ i ] = true;
        }
        numbsB[ 0 ] = false;
        numbsB[ 1 ] = false;
        return numbsB;
    };

    private static boolean [] sedas( boolean [] numsB , int p ) {
        int leng = numsB.length;
        int multiple = p + p; // 2 + 2 --> posar false
        while ( multiple < leng ){
            numsB[ multiple ] = false;
            multiple = multiple + p;
        }
        return numsB;
    }

    private static int contarNumPrimers ( boolean  [] numsB ){
        int totalPrimers = 0;
        int leng = numsB.length;
        boolean esPrimer;
        for ( int i = 0; i < leng ; i++){
            esPrimer = numsB[i];
            if( esPrimer ){
                totalPrimers = totalPrimers + 1;
            }
        }

        return totalPrimers;
    }
    private static int [] extreurePrimers (boolean [] numsB){
        int leng = numsB.length;
        boolean esPrimer;
        int totalPrimers = contarNumPrimers( numsB );
        int [] primers = new int [ totalPrimers ];  // em de saber quants de primers hi ha;
        int indxPrimer = 0;
        for ( int i = 0; i < leng ; i++ ){
            esPrimer = numsB[i];
            if ( esPrimer ){
                primers[ indxPrimer ] = i; // 0 --> 2, 1 --> 3
                indxPrimer = indxPrimer + 1;
            }

        }
        return primers;

    }

    private static int [] factoritzar ( int num, int [] primers ){
        /*
         3- se mira si es 1
         1- comença amb el primer petit
         2- se divideix fins que no se pugui amb el primer
         3- se mira si es 1
         4- s'agafa el proxim
         */
        // cuantes em dividit
        // si en 2 em divit 4 vegades --> 2 , 4
        /*          0 , 1 , 2 , ...
        primers = [ 2 , 3 , 5 , ...,97 ] mateix longitut
        factors = [ 4 , 0          ,0 ]
         */
        int indxPrimers = 0;
        int leng = primers.length;
        int [] factors = new int [ leng ] ;

        for (int i = 0 ; i < leng ; i++){
            factors[ i ] =  0;
        }
        int primer;
        while ( ( indxPrimers < leng ) && num != 1){  // se mira si es 1
            primer = primers[ indxPrimers ]; // 1- comença amb el primer petit
            // 2- se divideix fins que no se pugui amb el primer
            while ( num % primer == 0){ // se pot dividir
                num = num / primer ; //  o dividint
                factors[ indxPrimers ] += 1; //
            }
            // 3- s'agafa el proxim
            indxPrimers++;
        }
        return factors;
    }

    // pintars
    private static void pintarResultat( boolean [] numsB ){
        int leng = numsB.length;
        int saltLinea = 0;
        boolean esPrimer;
        for( int i = 0; i < leng ; i++ ){
            esPrimer = numsB[i];
            if(saltLinea == 10 ){
                System.out.println();
                saltLinea = 0;
            }
            if( esPrimer ){
                saltLinea++;
                System.out.print( i + " , " );
            }
        }
        System.out.println();
    }
    private static  void pintarPrimers( int [] primers ){
        int leng = primers.length;
        int saltLinea = 0;
        for (int i = 0;  i < leng ; i++){
            if (saltLinea == 10){
                System.out.println();
                saltLinea = 0;
            }
            System.out.print( primers[i] +", " );
            saltLinea++;
        }
        System.out.println();
    }

    private static void pintarDescomposicio ( int num ,int [] primers, int [] factors){
        int leng = primers.length;
        int primer;
        int factor;
        System.out.println(" Factoritzacio de "+ num);
        System.out.println(" primer ---> factor ");
        for( int i = 0; i < leng ; i++){
            primer = primers[i];
            factor = factors[i]; // 2 ---> 3
            if( factor != 0 ){ // si es 0 no pinti
                System.out.println("     "+ primer +"   --->    "+ factor +"    ");
            }
        }
        System.out.println();
    }

    // segona part
    private static  int trobarIndxMin ( int p , int [] nums ){
        int leng = nums.length;
        int indxMin =  p ;
        int min = nums[ indxMin ];
        int num;
        for ( int i = p ; i < leng ; i++){
            num = nums[i];
            if( num < min ){
                min = num;
                indxMin = i;
            }
        }
        return  indxMin;
    }
    private static void ordenar( int [] nums ){
        int leng = nums.length;
        int indxMin ;
        int numTemp ;
        for ( int i = 0 ; i < leng ; i++){
            indxMin = trobarIndxMin( i , nums );
            numTemp = nums[ i ];
            nums[i] = nums[ indxMin ];
            nums[ indxMin ] = numTemp;
        }
    }
    private static boolean emTrobatNumero(int numCercam ,int [] nums){
        /*
        numMitg 2 i 16 -->
        numCercam = 11
          0 , 1 , 2,   3 ,  4
        [ 1 , 3 , 5 , 10 , 14 ]
         0 --> prin = 0, final = 4;
         1 --> ( final + prin )/2 = posMitg; ( 4 + 0)/2 --> 2
         2 --> 5 < 11 --> prin = posMitg +1 --> prin = 3
         2.1 --> prin < final ? 3 < 4 --> continuar
         3 --> ( 4 + 3 ) / 2 --> 3
         4 --> 10 < 11 ---> prin = 4 ;
         4.1 --> prin < final? NO --> 4 == 4 --> no em trobat
        prinCercam = 0;
        finalCercam = longitud - 1;
        1- s'agafa es numero de la mitat de l'array --> 5
        2- miram si es numero que cercam
            - numMitg == numCercam --> true
            - numMitg > numCercam  --> cercariem de [prin , posNumMitg - 1 ] -->  finalCercam = posNumMitg -1
            - numMitg < numCercam --> cercariem [posNumMitg+1 , leng] --> prinCercam = posNumMitg+1;
        3- repetim fins quan? prinCercam < finalCercam -->  prinCercam >= finalCercam
         */
        int prin = 0;
        int fin = nums.length;
        int posMitg;
        int numMitg;
        while( prin <= fin ){
            posMitg = ( prin + fin ) / 2;
            numMitg = nums[ posMitg ];
            if ( numMitg == numCercam ){
                return true;
            }
            else if ( numMitg > numCercam ){ // 12 > 11
                fin = posMitg - 1;
            }
            else { // numMitg < numCercam
                prin = posMitg +1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sedas
        //  ---> [true, false,false,false,false]; <---
        // ---> [ 2 , 5 , 7 , 13 ] <--- aixo es lo que tu vols
        //                 0 , 1 , 2 , ...                   , 9 , 10
        // int [] nums = { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 };
        //                       0   ,  1    ,   2  ,  3   ,  4
        // boolean [] numsB ={ false , false , true , true , false };
        /*
        1 -> inicialitzar numbsB
        2 -> recorre fins trobar un true i despres multiplicar fins al final
        3 -> pintar resultat
         */
        // init numbsB
        int numMax = 500;
        boolean [] numbsB = initnumsB( numMax ); // numB --> initnumsB ( retorna un boolean [] )
        int leng = numbsB.length;
        boolean esPrimer;
        for ( int i = 0; i < leng  ; i++ ){ // i es se posicio = numero
            // aqui em d'aplicar el sedas
            esPrimer = numbsB[i];
            if( esPrimer ){
                numbsB = sedas( numbsB , i );
            }
        }
        System.out.println("Aquest son amb booleans");
        System.out.println("longitut  --> " + numbsB.length);
        // pintarResultat( numbsB );
        int [] primers = extreurePrimers( numbsB );
        System.out.println("Aquest son amb array de primers ");
        System.out.println("longitut  --> " + primers.length);
        // pintarPrimers( primers );
        // factoritzar es numero ;
        int num = 60;
        int [] factors = factoritzar( num , primers );
        pintarDescomposicio( num , primers , factors );
        System.out.println( 2*2 * 3*1 * 5*1);

        System.out.println("---------------------------------------------");

        int [] nums = { 1 , 5 , 10 , 3 , 28 , 103 , 32 , 14 , 99 , 29 , 30 , 31 };
        ordenar( nums );
        int numCercam = 3;
        System.out.println(Arrays.toString(nums));
        boolean apareixNum = emTrobatNumero(numCercam ,nums);
        if( apareixNum ){
            System.out.println("hi ha es numero");
        }else{
            System.out.println("NO hi ha es numero");
        }


        // anirem a cercar si hi ha es 30







    }
}
