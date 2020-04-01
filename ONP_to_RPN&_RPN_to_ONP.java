package source;


import java.util.Scanner;



public class Source {
    public static Scanner s = new Scanner(System.in);
    
   
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
            
        case '=':
            return 0;
        case '>': 
        case '<': 
            return 1; 
        case '+': 
        case '-': 
            return 2;
       
        case '*': 
        case '/': 
        case '%'  :  
            return 3; 
        case '^':
            return 4;
        case '~':
            return 5;
        
        } 
        if (( 'a'<=ch && ch<='z' ))
            return 6;
        return -1; 
    } 
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) {
        
     
       // 
      // System.out.println("Podaj liczbÄ zestawĂłw danych: ");
        int liczbaZestawow = s.nextInt();
        s.nextLine();           //Ĺźeby dziaĹaĹ input wewnÄtrz
        for(int q=0;q<liczbaZestawow;q++)
        {
         
          String a = s.nextLine();//.split(" ");     //przyjÄcie wyrazu i podziaĹ na format i dziaĹanie
          String  parts[] = a.split(" ",2);
          
           // System.out.println(parts[0]);
          //  System.out.println(parts[1]);
            String error= "error";
          //infix to RPN
          if(parts[0].equals("INF:"))          
          {   int symbol=0;
              int letter=0;
              int bracket=0;
              boolean check=false;
              boolean end=false;
              char temp;
              Byte state=0;
               for (int i = 0; i < parts[1].length(); i++)
               {
                   temp=parts[1].charAt(i);
                  if(state==0)
                  {
                      if(temp=='(')
                      {
                          
                          state=0;
                          bracket++;
                          check=true;
                      }
                      else if(temp=='~')
                      {
                          state=2;
                      }
                      else if( 'a'<=temp && temp<='z' )
                      {
                          state=1;
                          letter++;
                      }
                      else if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^')
                      {
                          end=true;
                           
                      }
                      else if(temp==')')
                      {
                           end=true;
                      }
                      else
                      {
                          
                      }
                      
                  }
                  else if(state==1)
                  {
                      if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^')
                      {
                          state=0;
                          symbol++;
                      }
                      else if(temp==')')
                      {
                          if(check==true)
                          {
                          state=1;
                          bracket--;
                          if(bracket>0)
                              check=true;
                          else 
                              check=false;
                          }
                          else
                          {
                               end=true;
                          }
                              
                      }
                      else if(temp=='(')
                      {
                          end=true;
                      }
                      else if(temp=='~')
                      {
                           end=true;
                      }
                      else if('a'<=temp && temp<='z' )
                      {
                           end=true;
                      }
                      else 
                      {
                          
                      }
                  }
                  else if(state==2)
                  {
                      if(temp=='(')
                      {
                          state=0;
                          bracket++;
                          check=true;

                      }
                      else if(temp=='~')
                      {
                          state=2;
                      }
                      else if('a'<=temp && temp<='z' )
                      {
                          state=1;
                          letter++;
                      }
                      //bledy
                      else if(temp==')')
                      {
                           end=true;
                      }
                      else if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^')
                      {
                           end=true;
                      }
                      else
                      {
                         
                      }
                  }
                 
               }
              if(state!=1)
              {
                   end=true;
              }
              if(bracket!=0)
               {
                   end=true;
              }
               if(letter!=symbol+1)
               {
                   end=true;
              }
               if(end==true)
               {
                   System.out.println("ONP: error");
               }
              
               
              else
               {
              Stack newstack = new Stack();
              
              String result = "ONP: "; //tu bÄdzie wynik
              

              for (int i = 0; i < parts[1].length(); i++)         
                {
                    temp=parts[1].charAt(i); //pierwsze litera bÄdz symbol w dziaĹaniu
                    //System.out.print("+");
                    
                    
                     if ('a'<=temp && temp<='z' ) //jeĹli jest to jakaĹ litra dodajemy jÄ do wyniku
                        result += temp; 
                    else if (temp == ',');
                    else if (temp == '(')     //dodajemy nawaias na dno staka
                    newstack.push(temp);
                    else if(temp == ')') 
                        {
                         while (!newstack.isEmpty() && newstack.peek() != '(') 
                                 result += newstack.pop(); 
                         
                          if (newstack.isEmpty()) 
                          {
                            System.out.println("nieistnieje"); 
                          }
                          else
                            newstack.pop();
                     }
                    else if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^'||temp=='~') // an operator is encountered 
                    {
                        if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*')
                        {
                            while (!newstack.isEmpty() && Prec(temp) <= Prec(newstack.peek())) 
                        result += newstack.pop(); 
                         newstack.push(temp); 
                        }
                        else 
                        {
                            while (!newstack.isEmpty() && Prec(temp) < Prec(newstack.peek())) 
                        result += newstack.pop(); 
                         newstack.push(temp); 
                        }

                    } 
                    else        //jesli jest to jakiĹ znak niepotrzebny to pomin
                    {
                        
                    }

                 }

                    while (!newstack.isEmpty()) 
                    result += newstack.pop();
              
              System.out.println(result);
          }
          }
          else //dla ONP!!!!!!!!!
          {
              //sprawdzamy czy nie ma erorru
              char temp;
              int symbol=0;
              int letter=0;
              for (int i = 0; i < parts[1].length(); i++)
              {
                  temp=parts[1].charAt(i);
                  if('a'<=temp && temp<='z' )
                      letter++;
                  else if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^')
                          symbol++;
                  else
                  {
                      
                  }
              }
              if(letter!=symbol+1)
              {
                  System.out.println("INF: error");
              }
              else{
              
              String tmp="";
              int liczbaOperandow = 0, liczbaOperatorow = 0;
              StackStr newstack = new StackStr();
              stackArrayInt stosPriorytetow = new stackArrayInt();
             // Stack symbols = new Stack();
              
               for (int i = 0; i < parts[1].length(); i++)
               {
                   temp=parts[1].charAt(i);
                   if(temp!='(' && temp!=')')
                       if ('a'<=temp && temp<='z' )
                       {
                           newstack.push(""+temp);
                           stosPriorytetow.push(Prec(temp));
                           liczbaOperandow++;
                       }
                       else if(temp=='/'||temp=='+'||temp=='-'||temp=='>'||temp=='<'||temp=='*'||temp=='%'||temp=='*'||temp=='='||temp=='+'||temp=='^'||temp=='~')
                       {
                           tmp="";
                          if(temp=='='||temp=='^')
                            {
                               liczbaOperatorow++;
                               if(stosPriorytetow.top() < Prec(temp))
                                        tmp = "(" + newstack.pop() + ")";
                               else
                                tmp = newstack.pop();
                               
                               stosPriorytetow.pop();
                               
                               if(stosPriorytetow.top() < Prec(temp))
                                        tmp = "(" + newstack.pop() + ")" + temp + tmp;
                               else
                                 tmp = newstack.pop() + temp + tmp;
                               
                               stosPriorytetow.pop();  
                            }
                           else if(temp=='~')
                           {
                               if(stosPriorytetow.top() < Prec(temp))
                                    tmp = temp + "(" + newstack.pop() + ")";
                                else
                                    tmp = temp + newstack.pop();

                                stosPriorytetow.pop();
                           }
                           else
                           {
                             liczbaOperatorow++;
                               if(stosPriorytetow.top() <= Prec(temp))
                                        tmp = "(" + newstack.pop() + ")";
                               else
                                tmp = newstack.pop();
                               
                               stosPriorytetow.pop();
                               
                               if(stosPriorytetow.top() < Prec(temp))
                                        tmp = "(" + newstack.pop() + ")" + temp + tmp;
                               else
                                 tmp = newstack.pop() + temp + tmp;
                               
                               stosPriorytetow.pop();  
                           }
                           newstack.push(tmp);
                           stosPriorytetow.push(Prec(temp));
                               
                       }
                       else
                       {
                           
                       }
               }
               if(liczbaOperandow - 1 == liczbaOperatorow)
                System.out.println("INF: " + newstack.pop());
               
               
               
          // else if(format=="INF")
           
            
}
  }
}
}
}
/*
class Que
{
    int front, rear, size;
    static final int MAX=256;
    char [] que=new char[MAX];
    
    public Que()
            {
                front=0;
                rear=-1;
                size=0;
            }
    public boolean isEmpty()
    {
        return (size==0);
    }
    
    public boolean isFull()
    {
        return (size==MAX);
    }
    public void enque(char element)
    {
        if(isFull())
        {
            System.out.println("kolejka peĹna");
        }
        else
        {
            rear=(rear+1)%MAX;
            que[rear]=element;
            size++;
        }
    }
    public char deque()
    {
        char dequed='Ĺ';
        if(isEmpty())
        {
            System.out.println("kolejka pusta");
            return dequed;
        }
        else
        {
            dequed=que[front];
            
            front=(front+1)%MAX;
            size--;
            return dequed;
        }
    } 
    public void printque()
    {
        if(isEmpty())
        {
            System.out.println("kolejka pusta");
        }
        else
        {
            for(int i=front;i<front+size;i++)
            {
                System.out.print(que[i]);
            }
        }
    }
}*/

class Stack 
{ 
    static final int MAX=256; 
    int top=-1; 
    char [] stack= new char[MAX]; // Maximum size of Stack 
  
 
    boolean isEmpty() 
    { 
        if(top < 0)
        {
            return true;
        }
        else 
            return false;
    } 
   
    void push(char element) 
    { 
        if (top >MAX) 
        { 
            System.out.println("Stack Overflow"); 
        } 
        else
        { 
            stack[++top] = element; 
        //   System.out.println(x + " pushed into stack"); 
        } 
    } 
  
    public char pop() 
    { 
       if(!isEmpty())
       {
           return stack[top--];
       }
       else 
           return 0;
    } 
    
    public char peek()
	{
		return stack[top];
	}
} 
//////////////////////////////////////
class StackStr
{ 
    static final int MAX=256; 
    int top=-1; 
    String [] stack= new String[MAX]; // Maximum size of Stack 
  
 
    boolean isEmpty() 
    { 
        if(top < 0)
        {
            return true;
        }
        else 
            return false;
    } 
   
    void push(String element) 
    { 
        if (top >MAX) 
        { 
            System.out.println("Stack Overflow"); 
        } 
        else
        { 
            stack[++top] = element; 
        //   System.out.println(x + " pushed into stack"); 
        } 
    } 
  
    public String pop() 
    { 
      
           return stack[top--];
      
    } 
    
    public String peek()
	{
		return stack[top];
	}
} 


class stackArrayInt
{
    static final int maxSize=256;
    private int[] Elem;
    private int top;
 
    public stackArrayInt()
    {
        
        Elem = new int[maxSize];
        top = maxSize;
    }
 
    public void push(int x)
    {
        if(!isFull())
            Elem[--top] = x;
    }
 
    public int pop()
    {
        if(isEmpty())
            return 0;
        else
            return Elem[top++];
    }
 
    public int top()
    {
        if ( isEmpty() )
            return 0;
        else
            return Elem[top];
    }
 
    public boolean isEmpty()
    {
        return (top == maxSize);
    }
 
    public boolean isFull()
    {
        return (top == 0);
    }
}
/*INF: x=a+(b-c+d)
INF: (a+b)*c+(d-a)*(f-b)
ONP: xabcde^^===
ONP: ab~c+*de-~/
ONP: a~~~
ONP: xabc-d++=
INF: x=~~~~~~a
INF: a*(~b+c)/~(d-e)
ONP: xabc**=
ONP: ab+a~a-+
INF: a+b+(~a-a)
INF: x=~~a+b*c
INF: t=~a<x<~b
INF: ( a,+ b)/..[c3
ONP: ( a,b,.).c;-,*
ONP: abc++def++g+++
INF: x=a=b=c
ONP: xabc=== 
INF: (a+b)^(c%d)
ONP: xabc^^=
*/