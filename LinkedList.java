package source;


import java.util.Scanner;



public class Source {
    public static Scanner s = new Scanner(System.in);
   
    public static void main(String[] args) {
        
     
       // 
      // System.out.println("Podaj liczbÄÂĂÂ zestawĂÂÄšÂw danych: ");
        int z = s.nextInt();
        int n;
        String order;
        //s.nextLine();           //ĂĹĄÄšĹeby dziaĂĹĄĂÂaĂĹĄĂÂ input wewnÄÂĂÂtrz
        for(int q=0;q<z;q++)
        {
            n=s.nextInt();
            s.nextLine();
            AllTrain Train_List = new AllTrain(); //pierwszy i ostatni pociag sÄÂĂÂ tu przechowywane
            for(int i=0;i<n;i++)
            {
                order = s.nextLine();     //przyjÄÂĂÂcie wyrazu i podziaĂĹĄĂÂ 
                String part[]=order.split(" ");
                
               
                
                
               // System.out.println(order);
               // System.out.println(number);
               
                        if(part[0].equals("Display"))
                        {
                           // System.out.println("tr:"+Train_List.first);
                           Train newtrain = Train_List.first;
                           
                           while(newtrain!=null)
                            {
                                if(newtrain.name.equals(part[1]))
                                {   
                                    
                                    boolean reverse;
                                    
                                    
                                    if(newtrain.first.next == null && newtrain.first.prev != null)
                                        reverse=true;
                                    else
                                        reverse=false;
                                    
                                    Cart temp = newtrain.first;
                                    Cart prev=null;
                                   
                                    
                                    System.out.print(part[1]+":");
                                    do                      //while(temp.next!=null)
                                    {
                                        System.out.print(" ");
                                        System.out.print(temp.name);
                                        if(reverse)           //2 cart rowniez odwrocony???
                                        {
                                            if(temp.prev==prev)
                                                reverse=!reverse;
                                        }
                                        else
                                            if(temp.next==prev)
                                                reverse=!reverse;
                                        
                                        prev=temp;
                                        if(reverse)
                                            temp=temp.prev;
                                        else
                                        temp=temp.next;
                                        
                                        
                                        
                                    }while(temp!=null);
                                    System.out.println();
                                    //System.out.println(temp.name);
                                      break;
                                }
                                newtrain=newtrain.next;
                                
                            }
                        }
                        else if(part[0].equals("Reverse"))
                        {
                             //System.out.println("dziaĂĹĄĂÂaaa");
                            Train newtrain = Train_List.first;
                            while(newtrain!=null)
                            {
                                //System.out.println("dziaĂĹĄĂÂaaa");
                                if(newtrain.name.equals(part[1]))   //wybierzemy poiÄÂĂÂg do ktorego dodajemy wagon
                                {
                                   Cart temp;
                                   temp=newtrain.first;
                                   newtrain.first=newtrain.last;
                                   newtrain.last=temp;
                                  
                                 break;  
                                }
                                newtrain=newtrain.next;
                            }
                        }   
                        
                
                        else if(part[0].equals("New"))
                        {
                                      Train pociag=new Train(part[1],part[2]);

                                       if(Train_List.first==null)
                                           Train_List.first=pociag;
                                       else if(Train_List.first!=null)
                                           Train_List.last.next=pociag;
                                       Train_List.last=pociag;

                                      
                           // System.out.println("dziaĂĹĄĂÂa!!!");
                            
                        }
                        
                        
                        else if(part[0].equals("InsertFirst"))
                        {
                            Train newtrain = Train_List.first;
                            //System.out.println("uwafa!!!!");
                            while(newtrain!=null)
                            {
                                if(newtrain.name.equals(part[1]))
                                {
                                    Cart wagon = new Cart(part[2]);
                                    if(newtrain.first.next == null && newtrain.first.prev != null)
                                    {
                                        newtrain.first.next=wagon;
                                        wagon.prev=newtrain.first;
                                        wagon.next=null;
                                        newtrain.first=wagon;
                                    }
                                    else
                                    {
                                        newtrain.first.prev=wagon;
                                        wagon.prev=null;
                                        wagon.next=newtrain.first;
                                        newtrain.first=wagon;
                                        
                                    }
                                    break;
                                }
                                newtrain=newtrain.next;
                            }
                        }
                        else if(part[0].equals("InsertLast"))
                        {
                            //System.out.println("dziaĂĹĄĂÂaaa");
                            Train newtrain = Train_List.first;
                            while(newtrain!=null)
                            {
                                //System.out.println("dziaĂĹĄĂÂaaa");
                                if(newtrain.name.equals(part[1]))   //wybierzemy poiÄÂĂÂg do ktorego dodajemy wagon
                                {
                                    Cart wagon = new Cart(part[2]);
                                    if(newtrain.first.next == null && newtrain.first.prev != null)
                                    {
                                        newtrain.last.prev=wagon;//
                                        wagon.next=newtrain.last;;//
                                        wagon.prev=null;
                                        newtrain.last=wagon;
                                        //System.out.println("dziaĂĹĄĂÂa");
                                    }
                                    else
                                    {
                                        newtrain.last.next=wagon;//
                                        wagon.next=null;//
                                        wagon.prev=newtrain.last;
                                        newtrain.last=wagon;
                                        //System.out.println("dziaĂĹĄĂÂa");
                                        
                                    }
                                   
                                    break;
                                }
                                newtrain=newtrain.next;
                            }
                        }
                        else if(part[0].equals("Union"))
                        {   
                            
                            Train pociag_1=null;
                            Train pociag_2=null;
                            Train newtrain = Train_List.first;
                            
                            while(newtrain!=null)       //znalezienie obu pociagow
                            {
                                if(newtrain.name.equals(part[1]))
                                    pociag_1=newtrain;
                                newtrain=newtrain.next;
                            }
                             newtrain = Train_List.first;
                             while(newtrain!=null)       //znalezienie obu pociagow
                            {
                                if(newtrain.name.equals(part[2]))
                                    pociag_2=newtrain;
                                newtrain=newtrain.next;
                            }
                           
                            
                            if (pociag_1.last.prev == null && pociag_1.last.next != null)       //sprawdzenie czy nie sa odwrocone
                                pociag_1.last.prev=pociag_2.first;
                            else
                                 pociag_1.last.next=pociag_2.first;
                            
                            if (pociag_2.last.prev == null && pociag_2.last.next != null)
                                pociag_2.first.next=pociag_1.last;
                            else
                                pociag_2.first.prev=pociag_1.last;
                            pociag_1.last=pociag_2.last;
                            
                            ///////usuwanie pociÄÂĂÂgu///////////
                            Train temp=Train_List.first;
                            Train previous=null;
        while(temp!=null&&temp.name.equals(part[2])==false) 
        {
            previous=temp;
            temp=temp.next;
        } 
        
        if(temp!=null)
        {
            if(temp==Train_List.first)      //jesli pociÄÂĂÂg jest pierwszy na liscie to przesuwanmy 1 el o 1
            {
                Train_List.first=temp.next;
            }
            else if(temp==Train_List.last)      ////jesli jest 2 na liscie to przesuwamy pociag o 1
            {
                Train_List.last=previous;
                previous.next=null;
            }
            else
            {
                previous.next=temp.next;
            }
                
        }
        //usuwanie pociagu end////////////////
                        }
                        else if(part[0].equals("DelFirst"))
                        {
                              Train newtrain = Train_List.first;
                              Train pom = null;
                            while(newtrain!=null)
                            {
                                //System.out.println("dziaĂĹĄĂÂaaa");
                                if(newtrain.name.equals(part[1]))   //wybierzemy poiÄÂĂÂg do ktorego dodajemy wagon
                                {
                                    String temp;
                                    temp=newtrain.first.name;
                                   if(newtrain.first==newtrain.last)
                                    {
                                        if(pom!=null)
                                        {
                                               pom.next=newtrain.next;
                                                if(Train_List.last==newtrain)
                                                    Train_List.last=pom;
                                        }
                                        else 
                                        {
                                            Train_List.first=newtrain.next;
                                        }
                                            
                                    }
                                    else
                                    {
                                        
                                    
                                        
                                        if(newtrain.first.next == null && newtrain.first.prev != null)
                                        {
                                            if(newtrain.first.prev.prev==newtrain.first)
                                            {
                                                newtrain.first.prev.prev=null;
                                                        
                                            }
                                            else 
                                            {
                                                newtrain.first.prev.next=null;
                                            }
                                            newtrain.first=newtrain.first.prev;
                                        }
                                        else
                                        {
                                         if(newtrain.first.next.next==newtrain.first)
                                            {
                                                newtrain.first.next.next=null;
                                                        
                                            }
                                            else 
                                            {
                                                newtrain.first.next.prev=null;
                                            }
                                            newtrain.first=newtrain.first.next;
                                             /*newtrain.first=newtrain.first.next;
                                             newtrain.first.prev=null;*/
                                        }
                                    }
                                        
                                    
                                        
                                   // newtrain.first=newtrain.first.next;
                                    //newtrain.first.prev=null;
                                    //tworzenie nowego pociÄÂĂÂgu
                                    /////////////////
                                                          Train pociag=new Train(part[2],temp);

                                       if(Train_List.first==null)
                                           Train_List.first=pociag;
                                       else if(Train_List.first!=null)
                                           Train_List.last.next=pociag;
                                       Train_List.last=pociag;

                                      
                                    ///////////////////////////
                                    break;
                                
                               
                                }
                                pom=newtrain;
                                 newtrain=newtrain.next;
                            }
                        }
                        else if(part[0].equals("DelLast"))
                        {
                              Train pom=null;
                              Train newtrain = Train_List.first;
                            while(newtrain!=null)
                            {
                                //System.out.println("dziaĂĹĄĂÂaaa");
                                if(newtrain.name.equals(part[1]))   //wybierzemy poiÄÂĂÂg do ktorego dodajemy wagon
                                {
                                    String temp;
                                    temp=newtrain.last.name;
                                    if(newtrain.first==newtrain.last)
                                    {
                                        if(pom!=null)
                                        {
                                               pom.next=newtrain.next;
                                                if(Train_List.last==newtrain)
                                                    Train_List.last=pom;
                                        }
                                        else 
                                        {
                                            Train_List.first=newtrain.next;
                                        }
                                            
                                    }
                                    else
                                    {
                                        
                                        
                                    
                                    
                                        if(newtrain.last.next != null && newtrain.last.prev == null)
                                        {
                                            if(newtrain.last.next.prev==newtrain.last)
                                            {
                                                newtrain.last.next.prev=null;
                                                        
                                            }
                                            else 
                                            {
                                                newtrain.last.next.next=null;
                                            }
                                            newtrain.last=newtrain.last.next;
                                        }
                                        else
                                        {
                                         if(newtrain.last.prev.prev==newtrain.last)
                                            {
                                                newtrain.last.prev.prev=null;
                                                        
                                            }
                                            else 
                                            {
                                                newtrain.last.prev.next=null;
                                            }
                                            newtrain.last=newtrain.last.prev;
                                            //newtrain.last=newtrain.last.prev;
                                            //newtrain.last.next=null;
                                        }
                                    }
                                        
                                        
                                        
                                        
                                    
                                  //newtrain.last=newtrain.last.prev;
                                   //newtrain.last.next=null;
                                    //tworzenie nowego pociÄÂĂÂgu
                                    /////////////////
                                                Train pociag=new Train(part[2],temp);

                                       if(Train_List.first==null)
                                           Train_List.first=pociag;
                                       else if(Train_List.first!=null)
                                           Train_List.last.next=pociag;
                                       Train_List.last=pociag;

                                      
                                    break;
                                }
                                pom=newtrain;
                                newtrain=newtrain.next;

                            }
                        }   
                    
                }
                
            }
        }
    }

class Cart
{   
    String name;
    Cart next;
    Cart prev;
    
    Cart(String name)
    {
        this.name=name;
    }
}

class Train
{
    String name;
    Train next;
    Cart first;
    Cart last;
    Train(String name, String _cart)
    {
        this.name=name;
        Cart cart = new Cart(_cart);
        next=null;
        first=cart;
        last=cart;
    }
}

class AllTrain
{
   Train first;
   Train last;
   
  public AllTrain()
   {
       first=null;
       last=null;
   }
}


/* testy
3
11
New T1 t0
InsertFirst T1 t1
InsertFirst T1 t2
InsertFirst T1 t3
InsertFirst T1 t4
Display T1
Reverse T1
Display T1
DelLast T1 T2
Display T1
Display T2
15
New T2 W0
DelFirst T2 T1
InsertFirst T1 Z1
InsertFirst T1 Z2
InsertFirst T1 Z3
InsertFirst T1 Z5
InsertLast T1 Z6
Display T1
DelFirst T1 T2
Display T2
DelFirst T1 T3
Display T3
DelLast T1 T4
Display T4
Display T1
8
New T1 h
InsertFirst T1 Z1
InsertFirst T1 Z2
InsertFirst T1 Z3
Reverse T1
Display T1
DelFirst T1 T2
Display T1

*/