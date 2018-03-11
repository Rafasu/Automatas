/*
    Jesus Rafael Solis Utrilla
    Matricula: A01172744
    Matematicas Computacionales
    Proyecto #1
    String Matching
    15/02/2018
 */
package Project;

import java.util.Scanner ;

public class Project {
    public static int [][] TransitionF(String P,String alf, int [][]S){           
       int m = P.length(), k = 0, q ;
       //Inicializar substrings.
       String Pq = "", Pk = "";
       //Ciclo for que va desde 0 hasta la longitud de la cadena + 1. 
       for( q = 0 ; q < m + 1; q++){ 
           //Ciclo for que va desde 0 hasta la longitud del alfabeto.
           for(int a = 0; a < alf.length(); a++){ 
               k = Math.min(m + 1, q + 2); 
               //Inicializar subcadenas vacias
               if(q == 0){ 
                       Pq = "";
               }
               else{
                       Pq = P.substring(0, q);
               }
               Pq = Pq + alf.charAt(a); 
               if(q < P.length()){ 
                       Pk = P.substring(0, q + 1) ; 
               }else{
                   Pk = P ;
               }
               k -- ;
               //Mientas Pk no sea sufijo de Pq.
               while(!(Pq.endsWith(Pk))){ 
                       k--;
                       Pk = Pk.substring(0, Pk.length()-1) ;
               }
               S[q][a] = k ;
           }	
       }
       return S ;
   }
	
    public static void SMatcher(String T,int [][]mat,int m, String alpha){
       int n = T.length(), q = 0, times = 0;
       for (int i = 0; i < n ;i++){ //hasta la longitud del texto
           q = mat[q][alpha.indexOf(T.charAt(i))]; //
              if(q == m){ 
                  times++ ;
              }	
          }
          System.out.println(times);
    }
	 
    public static void main(String[] args) {
           Scanner scan = new Scanner(System.in) ;
           String alphabet = scan.nextLine();
           String P  = scan.nextLine();
           String T = scan.nextLine();
           
           int m = P.length() ;
           int [][]S = new int[(P.length()+1)][alphabet.length()];
           int [][]SP = TransitionF(P,alphabet,S); 
           SMatcher(T,S,m,alphabet);
   }
}
