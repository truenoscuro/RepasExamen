import java.util.Arrays;

public class repasDia1 {


    public static boolean esDelimitador(char ll){
        //amb un charAt pots canviar
        char [] delimitadors ={' ',',',';','?','!'};
        int longDelimitadors = delimitadors.length;
        for( int i = 0; i<longDelimitadors; i++){
            if( ll == delimitadors[i] ) return true;
        }
        return false;
    };


    public static String paraula(int pActual, String text){
        // char [] ;
        String paraula = "";
        int longitutText = text.length();
        char ll;
        for( int i = pActual; i < longitutText;i++){
            /*
            S'acaba quan hi ha un delimitador:
             ,;:!)(
             si hi ha un delimitador --> sortir!
             */
            ll = text.charAt(i);
            if( esDelimitador( ll ) ) break;
            paraula = paraula + ll;
        }
        return paraula;
    }
    public static char [] paraulaToChar( String paraula ){
        int longitutParaula = paraula.length();
        char [] lletres = new char[ longitutParaula ];
        for( int i = 0 ; i < longitutParaula; i++ ){
            lletres[i] = paraula.charAt( i );
        }
        return lletres;
    }
    public static  boolean sonIguals(String p1, String p2){
        /*
        se longitut!!!!
        1-ll1.lenght != ll2.lenght --> son diferentt!
        2- QUAN ll1[i] == ll2[i]
         */
        char [] ll1 = paraulaToChar( p1 );
        char [] ll2 = paraulaToChar( p2 );
        //1-
        if( ll1.length != ll2.length ) return false;
        //2-
        int i = 0;
        // ll1.length = 3;
        while( i < ll1.length && ll1[i] == ll2[i] ){
            i++;
        }
        if( i == ll1.length ) return true;
        else{
            return  false;
        }
        // return i == ll1.length;
    }
    public static boolean esTextCreixent(String text){
        int longitutText = text.length();

        String p1 = paraula(0,text);
        int j = 0 + p1.length() + 1;;
        while( j < longitutText ){
            String p2 = paraula(j,text);
            if( p1.length() < p2.length() ){
                //moure sequent paraula
                j = j + p2.length() + 1;
                //guardam p1 a p2 porque si no mal
                p1 = p2;
            } else {
                return false;
            }
        }
        return true;
    }

    // Es de numeros

    public static int abs(int numero ){
        if(numero < 0) return -1*numero;
        else{
            return numero;
        }

    }
    public static int mesProxim( int [] llista, int numero ){
        int longitutLlista = llista.length;
        // numero mes aprop
        int proxim = llista[0];
        int diff = abs(llista[0] - numero) ;
        for( int i = 0; i < longitutLlista; i++ ){
            //es proxim mes aprop
            // 14 - 13  = 1
            // 14 - 15 = -1
            if(abs(llista[i]-numero) < diff ){
                proxim = llista[i];
                diff = abs(llista[i]-numero);
            }
        }
        return proxim;
    }


    public static  int posMaxLlista( int [] llista, int longitutLlista ){
        int pos = 0;
        for(int i = 0; i < longitutLlista; i++) {
            if (llista[i] > llista[pos]) {
                pos = i;
            }
        }
        return pos;
    }
    public  static void ordenar(int [] llista){
        /*
        1- trobar es maxim
        2- posar es maxim al final
        3- recorre se llista n-1
        */
        int longitutLlista = llista.length;
        int pMax;
        for(int i = 0; i < longitutLlista; i++){
            //1-
            pMax = posMaxLlista(llista,longitutLlista);
            /*
            Esquema per canviar coses de puesto
            int aux = llista[final]
            llista[final] = llista[pMax]
            llista[pMax] = aux;
             */
            //2-
            int aux = llista[longitutLlista-1];
            llista[longitutLlista-1] = llista[pMax];
            llista[pMax] = aux;
            //3-
            longitutLlista = longitutLlista -1;
        }

    }




    public static void main(String[] args) {
        String text = "hola som un text";
        // charAt(i) --> retorna un CHAR a se posicio i;
        int i = 0;
        //1
        String paraula = paraula(0,text);
        // Sabem index = 0 i longitut
        i = i + paraula.length()+1;
        String paraula2= paraula(i ,text);
        System.out.println(paraula);
        System.out.println(paraula2);
        System.out.println("-----------------------------------");
        System.out.println("COMENÇAM WHILE");
        int longitutText = text.length();
        int j = 0;
        while( j < longitutText ){
            String paraulaFor = paraula(j,text);
            System.out.println(paraulaFor);
            j = j + paraulaFor.length() + 1;
        }
        System.out.println("-----------------------------------");
        //1
        char [] lletres = paraulaToChar(paraula);
        System.out.println(lletres);
        System.out.println("-----------------------------------");
        String p1 = "tomatiga";
        String p2 = "tomatiga";
        // p1 == p2;
        // podem comparar chars!
        boolean iguals = sonIguals(p1,p2);
        System.out.println(iguals);
        System.out.println("-----------------------------------");
        // si un text es creixent
        /*
        un -> 2, super -> 4 ,textllarg -> +4;
         */
        String text2 = "un super textllarg";
        boolean esCreixent = esTextCreixent(text2);
        System.out.println( esCreixent );

        System.out.println("-----------------------------------");
        /*
            [1,2,35,21,13 , 19,43]
            14 --> 19!
            14 --> 13 si hi ha 13
         */
        int [] llista = { 1 , 2 , 35 , 21 , 13 , 19 , 43 };
        int numero = 14 ;
        int proxim = mesProxim(llista,numero);
        System.out.println(proxim);

        System.out.println("-----------------------------------");
        // Ordenarem  mes a mes gran  i emplearem se des maxim
        /*
        [15,21,1,3]
        1- trobar es maxim
        2- posar es maxim al final
        3- recorre se llista n-1
         */
        int [] llista2 = { 15 , 21 , 1 , 3 };
        // Per copiar una llista
        int [] llistaCopia = new int [llista2.length];
        for(int k = 0 ; k< llista2.length; k++ ){
            llistaCopia[k] = llista2[k];
        }
        //copia mal
        int [] llistaCopiaMal = llista2;
        System.out.println("Desordenat! = "+Arrays.toString(llistaCopia));
        System.out.println("Desordenat! = "+Arrays.toString(llistaCopiaMal));
        ordenar(llista2);
        System.out.println("Ordenat! = "+Arrays.toString(llista2));
        System.out.println("Desordenat! = "+Arrays.toString(llistaCopiaMal));
        System.out.println("Desordenat! = "+Arrays.toString(llistaCopia));

    }
}