package source;


import java.util.Scanner;


public class Source {
    public static Scanner s = new Scanner(System.in);
    public static int wynik(int n, int arr[])
    {   
        int last = arr.length-1;
        int first = 0;
        int mid;
        
        while(first<=last)
        {
            mid=(first + last)/2;
            if(arr[mid]==n)
            {
                if(mid==0)
                    return 0;
                else if(arr[mid-1]==n)
                    last=mid-1;
                else 
                return mid;
            }
             else
        {
            if(arr[mid]<n)
                first=mid+1;
            else 
                last=mid-1; 
        }         
        }
        return first;
    }
    
    public static void main(String[] args) {
        
       
        
       // System.out.println("Podaj liczbÄ zestawĂłw danych: ");
        int liczbaZestawow = s.nextInt();       
        
        
        for(int q = 0;q<liczbaZestawow;q++)
        {
        	
        	
            int n = s.nextInt(); //liczba wyrazĂłw w tablicy
            int [] tab = new int [n];
            for(int i=0;i<n;i++)    //zapeĹnienie tablicy
                tab[i]=s.nextInt();
            
            int m = s.nextInt(); //ilosc zapytan
            int [] zap = new int [m];
             for(int i=0;i<m;i++)    //zapeĹnienie tablicy
                zap[i]=s.nextInt();
            
             for(int i=0;i<m;i++)
             {  
                 int gr=wynik(zap[i],tab);
                 
                 int gr1=wynik(zap[i]+1,tab);
                 
                 int eq=gr1-gr;
                 
                
                System.out.print("(" + gr + "," + eq + ")");
                System.out.print(" ");
             }
         int j=0;    
         long [] temp = new long [n];  
         for (int i=0; i<n-1; i++) //delete duplicates
         if(tab[i]!=tab[i+1])
             temp[j++]=tab[i];
         
         
         temp[j++]=tab[n-1];
         
         System.out.println();          //przypadki
          for (int i=0; i<j&&i<200; i++) 
          {
              System.out.print(temp[i]);
              System.out.print(" ");
              if(i==49)
              System.out.println();
              else if(i==99)
              System.out.println();
              if(i==149)
              System.out.println();
              
          }
           System.out.println();
            
}
}
} 

//1 5 -1 1 3 5 6 2 1 3
//1 4 -99 0 1 2 2 -5 10
//1 4 0 0 0 0 2 0 1
//1 5 -1 0 1 1 1 2 4 2
//1 4 2 2 2 2 2 2 2
/*10
16
-8636 -7481 -7481 -3912 -3912 -2884 -635 960 983 3063 4046 7432 7432 9331 9331 9331
23
-130365 7432 7432 -156002 9331 9331 72772 -7481 -7481 -128961 -3912 -2884 12808 960 983 15438 4046 7432 -68947 9331 9331 -76080 -8636
24
-9997 -9352 -5392 -4991 -4074 -4074 -2793 -1829 -1829 -1829 -1829 -1078 -1078 -1024 -145 1439 1439 1439 2269 5278 5825 6738 7676 9334
17
-84926 -1078 -1078 100784 -145 1439 -16845 1439 2269 187656 5825 6738 9306 9334 -9997 50073 -5392
23
-9291 -9291 -9291 -9080 -7570 -6476 -6026 -4976 -3924 -2672 -1141 -831 101 1163 1163 3056 3454 3890 4023 5457 5457 6780 9500
24
190099 -831 101 -29311 1163 3056 191420 3890 4023 -25141 5457 6780 90678 -9291 -9291 124814 -9080 -7570 -6300 -6026 -4976 -16029 -2672 -1141
11
-8166 -6494 -6214 -4601 -4601 -4000 -603 -603 6775 8666 8666
11
-5896 -8166 -6494 -65857 -4601 -4601 -92280 -603 -603 49535 8666
18
-9422 -7726 -5928 -2900 -2696 403 403 403 2414 2821 4625 5256 5256 5256 6182 6182 8231 8945
29
109598 5256 5256 -9621 6182 6182 -152963 8945 -9422 1929 -5928 -2900 -134711 403 403 -175548 2414 2821 -52895 5256 5256 -15558 6182 6182 71860 8945 -9422 151586 -5928
11
-8035 -6472 -6472 -4600 -3074 -3074 -1341 -1341 -1046 664 6153
3
11014 -8035 -6472
6
-1008 3230 7019 9685 9685 9821
5
12334 9821 -1008 -43594 7019
12
-9860 -8175 -6016 -5931 -5931 -1523 -592 5183 5248 5248 7327 9152
10
-83230 9152 -9860 63657 -6016 -5931 -19698 -1523 -592 -34825
23
-5866 -2768 -2768 -2768 -2183 -2140 -2140 -2123 -2123 -1847 425 814 848 923 1775 1775 4602 4633 6590 7041 7212 9242 9242
12
-165387 814 848 141983 1775 1775 139283 4633 6590 -59707 7212 9242
300
-999 -998 -970 -962 -962 -962 -960 -960 -956 -953 -953 -944 -936 -933 -922 -922 -919 -919 -919 -917 -899 -892 -885 -871 -856 -856 -847 -846 -846 -846 -828 -814 -814 -814 -808 -803 -793 -787 -763 -762 -762 -757 -747 -747 -733 -723 -722 -702 -698 -683 -678 -678 -663 -663 -662 -644 -630 -621 -620 -614 -603 -589 -589 -585 -583 -582 -560 -560 -533 -531 -531 -531 -531 -529 -513 -499 -491 -491 -487 -487 -487 -485 -485 -480 -475 -467 -467 -466 -466 -452 -442 -435 -427 -418 -418 -418 -400 -382 -382 -382 -382 -382 -364 -363 -360 -348 -348 -347 -338 -325 -325 -322 -322 -295 -295 -281 -270 -266 -257 -248 -240 -240 -237 -219 -219 -219 -212 -212 -197 -197 -197 -197 -183 -180 -179 -178 -169 -148 -139 -137 -135 -131 -119 -119 -119 -107 -62 -53 -53 -28 -20 -20 -13 -12 -12 -11 -7 -7 -5 1 3 13 14 15 15 29 35 35 43 50 64 71 74 79 81 87 88 105 105 118 132 135 135 135 147 150 150 156 159 166 170 175 175 176 176 179 179 195 197 208 209 216 216 240 260 279 305 309 312 318 319 319 334 348 348 367 367 368 372 419 423 424 424 439 451 468 480 496 503 526 527 532 537 548 549 552 561 561 565 610 640 643 653 659 659 663 676 680 691 741 746 756 757 757 774 779 779 780 780 782 788 795 807 813 815 818 823 823 823 823 824 824 824 824 832 832 834 834 857 860 866 872 881 881 897 906 908 908 928 933 952 959 964 968 980 982 990 990 992 993
21
926 -944 -936 -143 -922 -922 -739 -919 -919 693 -899 -892 742 -871 -856 -193 -847 -846 -84 -846 -828*/