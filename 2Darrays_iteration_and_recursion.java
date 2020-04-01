package source;


import java.util.Scanner;


public class Source {
    //Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
       // System.out.println("Podaj liczbĂÂ zestawÄĹw danych: ");
        int liczbaZestawow = s.nextInt();       
        
        
        for(int q = 0;q<liczbaZestawow;q++)
        {
        	int k = -1;
        	//System.out.println("Podaj liczbĂÂ wierszy: ");
            int n = s.nextInt(); //liczba wierszy
            
          //  System.out.println("Podaj liczbĂÂ kolumn: ");
            int m = s.nextInt(); //liczba kolumn
            
            int[][] tab = new int[n][m]; //wiersz kolumna       //tu wchodzi G&G
            int[] tmp = new int[m]; //wiersz
            //boolean check_negative=false;
            //boolean check_zero=false;
            int num=0;
           // System.out.println("WprowadÄšĹ elementy tablicy: ");
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tab[i][j] = s.nextInt();
                    
                    
                }
            }
            k = s.nextInt();   //szukana liczba

            
            RekPier(tab,0,n-1,0,m-1,k);
            RekOst(tab,n-1,0,m-1,k);
            IterPier(tab,n,m,k);
            IterOst(tab,n,m,k);
            System.out.println("---");
        }
    }
    public static void IterPier(int [][] tab,int n, int m, int k){
        boolean check=false;
        boolean check_is_k=false;
        for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) 
                {
                    if(k==tab[i][j])
                    {
                        check_is_k=true;
                        System.out.println("IterPier: "+ k + " w "+ "("+(i)+","+(j)+")");
                        check=true;
                        break;
                    }
                    
                 }
                if(check==true)
                        break;
    }
    if(check_is_k==false)
            System.out.println("IterPier: nie ma "+k);
}
    
    
    public static void IterOst(int [][] tab,int n, int m, int k){
        boolean check=false;
        boolean check_is_k=false;
        for (int i = n-1; i >= 0; i--) {
                for (int j = m-1; j >= 0; j--) 
                {
                    if(k==tab[i][j])
                    {
                        check_is_k=true;
                        System.out.println("IterOst: "+ k + " w "+ "("+(i)+","+(j)+")");
                        check=true;
                        break;
                    }
                    
                 }
                if(check==true)
                        break;
    }
    if(check_is_k==false)
            System.out.println("IterOst: nie ma "+k);
}
    
    public static void RekPier(int [][] tab,int n,int max,int l, int r, int k){
       int m=r;
       if(n>=0&&k>=tab[n][0]&&k<=tab[n][tab[n].length-1]){
           //System.out.println("n="+n);
           //System.out.println("l="+l);
           //System.out.println("r="+r);
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
          //  System.out.println("mid="+mid);
            if (k==tab[n][mid]&&(mid==0||k>tab[n][mid-1]))           //&&(mid==tab[n].length-1||k<tab[n][mid+1])
            {
              System.out.println("RekPier: "+ k + " w "+ "("+(n)+","+(mid)+")");
              return;
            }
            else if(k<=tab[n][mid])
                     RekPier(tab, n, max, l, mid-1, k);
            else
                     RekPier(tab, n, max, mid+1, r, k);
            }
        else if (max>n&&k>tab[n].length-1&&k<=tab[n+1][tab[n+1].length-1])
           RekPier(tab, n+1,max, 0,tab[n].length-1, k);
        else
            {
            System.out.println("RekPier: nie ma "+k);
            return;
            }
       }
          /* else if (n>0&&k>tab[n][0]&&k<=tab[n-1][tab[n-1].length-1])
           RekPier(tab, n+1,max, 0,tab[n].length-1, k);
           else
           {
            System.out.println("RekPier: nie ma "+k);
            return;
            }*/
       
           
        else if(n<max)          //lub wiÄksze badz owne
        {//System.out.println("+");
           //System.out.println(m);
                        RekPier(tab, n+1,max,0,tab[n].length-1,k);

        }
        else 
            System.out.println("RekPier: nie ma "+k);
  
        
}
  
    public static void RekOst(int [][] tab,int n,int l, int r, int k){
   
       if(n>=0&&k>=tab[n][0]&&k<=tab[n][tab[n].length-1])           //sprawdzamy czy jest w tym wierszu
       {
           if(r>=l)
           {//System.out.println("n="+n);
               int mid=l+(r-l)/2;
                //System.out.println(tab[n][mid]);
               if(k==tab[n][mid]&&(mid==tab[n].length-1||k<tab[n][mid+1])){
                   System.out.println("RekOst: "+ k + " w "+ "("+(n)+","+(mid)+")");
               return;}
               
               else if(k<tab[n][mid])
                     RekOst(tab, n, l, mid-1, k);
               else
                     RekOst(tab, n, mid+1, r, k);
           }
           else if (n>0&&k>tab[n][0]&&k<=tab[n-1][tab[n-1].length-1])
           RekOst(tab, n-1, 0,tab[n].length-1, k);
           else
           {
            System.out.println("RekOst: nie ma "+k);
            return;
            }
       }
       else if (n>0)
           RekOst(tab, n-1, 0,tab[n].length-1, k);
       else 
       {
           System.out.println("RekOst: nie ma "+k);
           return;
       }
           
       
        
}
}

//testy 
/*
3 3
1 1 1
1 2 3
4 5 6
1
4 1
1
1
2
2
2
2 2
0 1
2 2
2
1 2
1 3
3
1 2
3 3
3
4 4
0 0 0 0
1 1 1 1
2 2 2 2
3 3 3 3
0
1 1
7
7
*/