package source;


import java.util.Scanner;


public class Source {
    public static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        
       // System.out.println("Podaj liczbÄ zestawĂłw danych: ");
        int liczbaZestawow = s.nextInt();       
        
        
        for(int q = 0;q<liczbaZestawow;q++)
        {
        	
        	//System.out.println("Podaj liczbÄ wierszy: ");
            int n = s.nextInt(); //liczba wierszy
            
          //  System.out.println("Podaj liczbÄ kolumn: ");
            int m = s.nextInt(); //liczba kolumn
            
            int[][] tab = new int[n][m]; //wiersz kolumna       //tu wchodzi G&G
            int[] tmp = new int[m]; //wiersz
            boolean check_negative=false;
            boolean check_zero=false;
            int num=0;
           // System.out.println("WprowadĹş elementy tablicy: ");
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tab[i][j] = s.nextInt();
                    
                    if(tab[i][j]>=0)
                    check_negative=true;        //jesli false to mniejsze od zera
                    
                    if(tab[i][j]!=0)             //jesli false o wszystkie = 0
                    check_zero=true;
                    
                    if(tab[i][j]<=0)
                        num++;
                }
            }
           /* int special = 0;
            if(num==m*n)
            {loops:                                                         //sprawdzanie przypadku dla -1 0 -1 0
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                    {
                        if(tab[i][j]==0)
                        {
                            special=j;
                           break loops;
                        }
                    }
            }*/
            
            ///tutaj wartoĹci sÄ wpisane i moĹźna zaczynaÄ obliczenia
            int max1 = 0;
            int max2 = 0;
            int suma = 0;
            int left = 0; 
            int top = 0; 
            int right = 0; 
            int bottom = 0; 
            int currentSum = 0; 
            int localStart = 0;
            int start;
            int end = 0;

            //   int x=0;
            for(int i = 0;i<n;i++) //wiersze
            {
                for(int w = 0;w<m;w++) tmp[w] = 0; //czyszczenie tmp         
                for(int j=i;j<n;j++) //wiersze //sprawdza sumÄ coraz mniejszej liczby wierszy
                {

                start =0;
                end = -1;
                localStart = 0;
                    //pierwotna wersja algorytmu Kadane dla jednowymiarowej talbicy
                    max1 = 0;
                    
                    for(int k = 0;k<m;k++) //kolumny //sprawdza najwiÄksze el z danego wiersza
                    {
                        tmp[k] += tab[j][k];
                  
                        max1 =max1+tmp[k];
                         if(max1<0)
                         {  
                        
                             max1=0;
                             localStart=k+1;
                         }
                         if(max1==0)
                         {
                             localStart=k+1;
                         }
                        if(max1 > max2||tmp[k]==max2) 
                        { 
                            max2 = max1;
                            start=localStart;
                            end=k;
                           
                        }
                        
                    }
                     if(end==-1){
                            max2=0;
                            for(int k=0;k<m;k++)
                            {
                                if(tmp[k]>max2)
                                {
                                    max2=tmp[k];
                                    start=k;
                                    end=k;
                                }
                            }
                        }
                    if(suma<max2)
                   {    
                       left=i;
                        suma = max2; 
                        top = start;
                        right = j;
                        bottom =end;
                   }

                  else if(suma == max2) {
             
                     if((right - left + 1) * (bottom - top + 1) > (j-i + 1)*(end-start + 1)&&end!=-1 ) 
                     {
                         left = i;
                         top = start;
                         right = j;
                         bottom= end;
                       
                     }
                   } 
                }
            }   
            if(check_zero==false)
            { 
                System.out.println("["+ 0 + ".." + 0 + ","+ 0 +".." + 0+"]");
                System.out.println("max_sum=" + 0);
            }
            else if(check_negative==false)
            {
               System.out.println("empty");

            }
             else if(num==(n*m))        
            {
                int special_col = 99999;
                int special_row = 99999;
               // loops:                                                         //sprawdzanie przypadku dla -1 0 -1 0
                for (int j = 0; j < m; j++)
                    for (int i = 0; i < n; i++)
                    {
                        if(tab[i][j]==0&&i+j<special_col+special_row||tab[i][j]==0&&special_row>special_col&&j>=i)      //aby byĹo w porzÄdku
                        {
                            special_col=j;
                            special_row=i;
                          // break loops;
                        }
                    }
                
            System.out.println("["+special_row + ".." + special_row + ","+ special_col +".." + special_col+"]");
            System.out.println("max_sum=" + 0);
            }
            else
            {
            System.out.println("["+left + ".." + right + ","+ top +".." + bottom+"]");
            System.out.println("max_sum=" + suma);
            }
        }
    }
}

//1 3 2 -1 3 5 8 9 -2
//1 2 4 1 1 0 7 -1 -2 5 6
//1 3 2 1 2 3 1 3 4
//1 2 2 -1 1 -2 -3
//1 5 5 2 3 -50 -50 8 2 3 -50 -50 1 2 3 -50 -50 6 2 3 -50 -50 5 2 3 -50 -50 5