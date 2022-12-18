import java.util.Arrays;

public class repasDia3 {

    // String ---> tambe es un array
    public static boolean cercar( int [] llista , int num ){
        // mirar si hi ha algo dins una llista
        // si hi ha num dins llista ?
        int leng = llista.length;
        for( int i = 0; i < leng; i++)
            if ( llista[i] == num ) return true;
        return false;
    }

    public static boolean esPalindroma( String paraula ){
        /*
        1- Que es lo que te entra :
        paraula es un string d'una paraula , ? es una paraula = hola
        2- QUe fa !
        3- Que retorna : retorna cert si es palindroma
         */
        // HOLA
        //[H,O,L,A] arra de llar
        int leng = paraula.length();
        int j = leng - 1;
        // CasasaC
        for( int i = 0 ; i < leng ; i++ , j--)
            if ( paraula.charAt( i ) != paraula.charAt( j ) ) {
                return false;
            }
        return true;
    }

    public static int abs(int num1, int num2){
        if( num1 - num2 <0 ) return  num2 - num1;
        return  num1-num2;

    }

    //iDiferencia
    public static int cercar2( int [] llista , int num ){
        // sempre una llista, els altres parametres poden ser qualsevol cosa o no tenir-ne
        int leng = llista.length;
        int iSolucio = 0; // indx i = 0;
        // diff --> se millor solucio fins aquest moment
        // max --> es mes gran fins ara
        // Aquest parametre SEMPRE se inicialitza amb el primer de se llista
        int diff = abs( llista[0] , num ); //    6-5 = 1 4-5 = 1
        // int max = llista[0];
        // int min = llista[0];
        for( int i = 0 ; i < leng ; i++ ){
            //if(max < llista[i])
            //if(min > llista[i])
            if( abs( llista[i] , num )  < diff){
                diff = abs( llista[i] ,num );
                iSolucio = i;
            }
        }
        return  iSolucio;


    }

    public static int cercarIndx( int [] llista , int num, int iInicial ){
        int leng = llista.length;
        int iSolucio = 0; // indx i = 0;

        int diff = abs( llista[0] , num ); //    6-5 = 1 4-5 = 1
        // perque cerqui de i cap envant
        for( int i = iInicial ; i < leng ; i++ ){
            if( abs( llista[i] , num )  < diff){
                diff = abs( llista[i] ,num );
                iSolucio = i;
            }
        }
        return  iSolucio;


    }

    public static void intercambiar( int pos1, int pos2 , int [] array ){
        // ...,3 , 4,...
        int temp = array[ pos1 ];  // temp = 3
        array[ pos1 ] = array[pos2]; // ..., 4, 4 ,...
        array[ pos2 ] = temp; // ...,4,3,...
    }
    public static void pintar( int [] llista ){
        int leng  = llista.length;
        System.out.print("[ ");
        for (int i = 0; i < leng-1 ; i++){
            System.out.print(llista[i]+" , ");
        }
        System.out.print(llista[leng-1]+" ]");
        System.out.println();
    }

    public static void intercambiarCercar(){
        // estructura de ordenacio clasica
        int [] llista = { 1,6,3,7,3,10,16,0,4,8,20 };
        int num = 15;
        int leng = llista.length;
        for( int i = 0; i < leng ; i++ ){
            // mirarem es primer numero 1
            int diff1 = abs( 15 , llista[i] );
            int iMin = cercarIndx( llista , num , i ); // cerca per ordenar
            if( abs( 15 , llista[iMin] ) < diff1 ){ // intercanvi
                intercambiar( iMin , i , llista ); // pot estar sense el algoritma ficat
                // ficat a dedins directament
            }
        }
        pintar(llista);

    }

    public static int  operar( int [] llista , int num ){
        // calcula algo de la llista i retorna una cosa petita
        int sumaDiff = 0;
        int leng = llista.length;
        for( int i = 0; i < leng; i++ ){
            sumaDiff = sumaDiff + abs(llista[i],num);
        }
        return  sumaDiff;
    }

    /*
    public static es[algo] conte[algo] h

     */


    public static  boolean esLletraMinuscula( char ll ){
        return 'a' <= ll  && ll <= 'z';
    }
    public static boolean esLletraMajuscula( char ll ){
        return 'A' <= ll && ll <= 'Z';
    }
    public static String operar2(String str){
        int leng = str.length();
        String novaParaula = "";
        char ll ; // un char es un numero !!
        for( int i = 0; i < leng ; i++ ){
            ll = str.charAt( i );
            if( esLletraMinuscula( ll ) ){
                novaParaula = novaParaula + ll;
            }
        }
        return  novaParaula;
    }


    public static boolean esLletra( char ll ){
        return esLletraMajuscula( ll ) || esLletraMinuscula( ll );
    }

    public static String extreureUnaParaula( String text, int iInicial ){
        // 1 - mos pasaun un text i una posicio
        int leng = text.length();
        String paraula = "";
        char ll ; // un char es un numero !!
        for( int i = iInicial ; i < leng ; i++ ){
            ll = text.charAt( i );
            if( esLletra( ll ) ){
                paraula = paraula + ll;
            } else {
                // Hola Caracola --> HolaCaracola
                break;
            }
        }
        /*
        int i = iInicial
        char ll = text.chAt(i);
        while( iInicial < leng && esLletra(i) ){
            paraula = paraula + ll;
            i++:
        }
         */
        return  paraula;
    }


    public static void recorrerDoblesArray( int[][] arrayDoble ){
        /*
        [
         0   [ 1, 2, 3,.... 4] <-- array[0]
         1   [2,3,1,2,1,.....1]
         2   [2,3,1,2,1,.....1]
         3   [2,3,1,2,1,.....1]
         4   [2,3,1,2,1,.....1]
                                ]
         La longitut del arrayDoble
        files = array.lenght;
        columnes = array[0].lenght;  totes ses files tenen ses mateixes columnes
        // se pot emplear el cer
        array[0][2]
        [ 1, 2, ! 3 !,.... 4]
         */
        int totalFiles = arrayDoble.length; // total de files
        int totalColumnes = arrayDoble[0].length; // total de columnes
        for( int f = 0 ; f < totalFiles ; f++){
            for( int c = 0 ; c < totalColumnes; c++){
                System.out.print(arrayDoble[f][c]+" ");
            }
            System.out.println();
        }
    }

    public static void barra(){
        System.out.print( "---------------------------------------------");
        System.out.println();
    }



    public static void main( String[] args ) {
        intercambiarCercar();
        barra();
        String paraula = "HolaMon";
        String novaParaula = operar2(paraula);
        System.out.println(novaParaula);
        barra();
        String paraula2 = "Hola Caracola";
        String hola = extreureUnaParaula(paraula2,2);
        System.out.println(hola);
        barra();
        int [][] arrayDoble = {
                {1,2,3},
                {3,2,1},
                {0,0,0}
        };
        recorrerDoblesArray(arrayDoble);



    }
}
