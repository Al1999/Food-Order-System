// Alkhatab Alrashdi 
//  December  9th, 2019

// *************************************************************
// The purpose of this program is to assist the user to order a meal.
// The program would provide two types of different meals to the users.
// The first meal is pizza. The second one is the burgers. Each of these
// meals would have special toppings that the users can choose. The
// program would be able to save the order. Also, there would be two
// special meals of the day that the users do not have to choose toppings.
// The user will be able to save all their previous orders and display them
// if they want to order them again. Also, the program would give the users
// the estimated time for their current order.
// *************************************************************

import java.util.Random;
//ordering class
public class Order {
    protected node head [] ; //head pointer
    protected int list_size ; //the size of the array of linear linked list
    protected int c ; //
    protected int n ;
    protected int s ;
    protected int sum ;
    protected int ct ;
    protected tree tree23 ;
    protected String meal_name [] ;

    public Order( int size ) //class constructor
    {
        this . list_size = size ;
        this . head = new node [list_size] ;
        for( int i = 0; i < list_size ; ++i )
        {
            head[i] = null ;
        }
        this.c = 0 ;
        this.n = 0 ; //type of food number
        this.s = 0 ; //for the random number of the special meal
        this.sum = 0 ;
        this.ct = 0 ;
        tree23 = new tree();
        meal_name = new String [size];
    }
    public int num(int num2) //returning the number of options of toppings in each category
    {
        if( n == 1 ) //for the Burgers
        {
            if( num2 == 1 )
            {
                num2 = 3 ;
                return num2 ;
            }
            if(num2 == 2 )
            {
                num2 = 4 ;
                return num2 ;
            }
            if( num2 ==3 ) {
                num2 = 3 ;
                return num2 ;
            }
        }
        if( n == 2 ) //for the Pizza
        {
            if( num2 == 1 )
            {
                num2 = 4 ;
                return num2 ;
            }
            if(num2 == 2 )
            {
                num2 = 4 ;
                return num2 ;
            }
            if( num2 ==3 ) {
                num2 = 4 ;
                return num2 ;
            }
        }
        else
            return 0 ;
        return num2 ;
    }

    public void display_toppings(int num2 ) //displaying the toppings in each category
    {
        if( n == 1 ) //burger
        {
            if( num2 == 1 )
            {
                System.out.println("- MEAT -" + "\n(1)Chicken \n(2)beef \n(3)Ham") ;
            }
            if(num2 == 2 )
            {
                System.out.println("- VEGAN -" + "\n(1)lettuce \n(2)tomatoes \n(3)pickles \n(4)onions \n(5)enough ");
            }
            if( num2 ==3 ) {
                System.out.println("- SAUCE -" + "\n(1)ketchup \n(2)mayonnaise \n(3)yellow mustard \n(4)enough  ");
            }
        }
        if( n == 2 ) //pizza
        {
            if( num2 == 1 )
            {
                System.out.println("- MEAT -" + "\n(1)Ham \n(2)Beef \n(3)Pepperoni \n(4)Premium Chicken") ;
            }
            if(num2 == 2 )
            {
                System.out.println("- VEGAN -" + "\n(1)onions \n(2)black olives \n(3)mushrooms \n(4)green peppers \n(5)enough  ");
            }
            if( num2 ==3 ) {
                System.out.println("- SAUCE -" + "\n(1)Robust Inspired Tomato Sauce \n(2)BBQ Sauce \n(3)Garlic Parmesan White Sauce \n(4)Alfredo Sauce \n(5)enough  ");
            }
        }
    }


    private node traverse( node temp) //for traversing to the end of the linear linked list
    {
        if(temp.get_next() == null)
            return temp;
        else
        {
            return traverse(temp.get_next());
        }
    }
    public void display_special(int num ) //displaying the special meal
    {
        Random rand = new Random(); //random choose of the meal of the day
        if( n == 1 ) //special burgers
        {
            s = rand.nextInt((2-1) +1 ) + 1; //two meals
            if (s == 1 )
                System.out.println(" Special Burger For Today -> * DOUBLE CHEESE BURGER *") ;
            else if ( s == 2 )
            {
                System.out.println(" Special Burger For Today -> * CHICKEN BURGER *") ;
            }
        }
        else if( n == 2 )//special pizza
        {
            s = rand.nextInt((2-1) +1 ) + 1;
            if (s == 1 )
                System.out.println(" Special Pizza For Today -> * Ultimate Pepperoni *") ;
            else if ( s == 2 )
            {
                System.out.println(" Special Pizza For Today -> * Buffalo Chicken *") ;
            }
        }
    }
    public void add_s1() //adding new special meal to the order function
    {
        int i = 1 ;
        if(n == 1 ) //burgers
        {
            if(s == 1 ) //double cheese burger (special)
            {
                add_new(2, 1); //beef
                add_new(2, 1); //beef
                while (i < 4) {
                    add_new(i, 2); //all the vegan toppings
                    ++i ;
                }
                meal_name[c] = new String();
                meal_name[c] = "* DOUBLE CHEESE BURGER *" ;
                add_new(2, 3);
                sum = 7 ;
            }
            else if ( s == 2 ) //chicken burger (special)
            {
                add_new(1, 1); //chicken
                while (i < 2) {
                    add_new(i, 2); //two toppings
                    ++i;
                }
                //two sauce
                add_new(2, 3);
                add_new(3, 3);
                meal_name[c] = new String();
                meal_name[c] = "* CHICKEN BURGER *" ;
                sum = 5 ;

            }
        }
        if( n == 2 )
        {
            if(s == 1 ) //Ultimate Pepperoni(special)
            {
                meal_name[c] = new String( );
                meal_name[c] = "* Ultimate Pepperoni Pizza *" ;
                //two layers of Pepperoni
                add_new(3, 1); //Pepperoni
                add_new(3, 1);
                add_new(1, 3); //Robust Inspired Tomato Sauce
                sum = 3 ;
            }
            else if ( s == 2 ) //Buffalo Chicken
            {
                add_new(4, 1); //Chicken
                add_new(1, 2); //onion
                add_new(3, 2); //mushrooms
                add_new(4, 3); //alfredo sauce
                meal_name[c] = new String( );
                meal_name[c] = "* Buffalo Chicken *" ;
                sum = 4 ;
            }

        }

    }

    public void add_new ( int num ) // adding a new type of food to the order (overloading function)
    {
        sum = 0 ;
        if( num == 1 ) { //for the burger
            head[c] = new node();
            head[c].topping = new String();
            head[c].topping = "Meat" ;
            meal_name[c] = new String();
            meal_name[c] = "Burger" ;
            head[c].setBurger();
            head[c].set_next(null);
            n = 1 ;
        }
        if( num == 2 ) { //for the pizza
            head[c] = new node();
            head[c].topping = new String();
            head[c].topping = "Meat" ;
            meal_name[c] = new String( );
            meal_name[c] = "Pizza" ;
            head[c].setPizza();
            head[c].set_next(null);
            n = 2 ;
        }
    }

    public void order_num()
    {
        c = c + 3 ;
    }

    public void add_new(  int num , int num2 ) //building the order function (overloading function)
    {
        if( n == 1 ) //burgers
        {
            if( num2 == 1 )//meat topping
            {
                if (head[c]== null)
                    num2 = 0;
                else
                {
                    node temp = traverse(head[c]);
                    node current = new node();
                    current.setBurger();
                    current.get_meal().meat(num);
                    current.set_next(null);
                    temp.set_next(current);
                    sum = sum +1 ;
                }
            }
            if( num2 == 2 )//vegan topping
            {
                if (head[c+1] == null)
                {
                    //each category would be an element in the array and the toppings would be stored from the second node
                    head[c+1] = new node();
                    head[c+1] .topping = new String();
                    head[c+1] .topping = "Vegan" ;
                    head[c+1] .setBurger();
                    head[c+1] .set_next(null);
                    node current = new node();
                    current.setBurger();
                    current.get_meal().vegan(num);
                    current.set_next(null);
                    head[c+1].set_next(current);
                    sum = sum +1 ;
                }
                else
                    {
                    node temp = traverse(head[c+1]);
                    node current = new node();
                    current.setBurger();
                    current.get_meal().vegan(num);
                    current.set_next(null);
                    temp.set_next(current);
                    sum = sum +1 ;
                }
            }
            if( num2 == 3 )//sauce topping
            {
                if (head[c+2]  == null)
                {
                    head[c+2] = new node();
                    head[c+2].topping = new String();
                    head[c+2].topping = "Sauce" ;
                    head[c+2].setBurger();
                    head[c+2] .set_next(null);
                    node current = new node();
                    current.setBurger();
                    current.get_meal().sauce(num);
                    current.set_next(null);
                    head[c+2].set_next(current);
                    sum = sum +1 ;
                }
                else {
                    node temp = traverse(head[c+2]);
                    node current = new node();
                    current.setBurger();
                    current.get_meal().sauce(num);
                    current.set_next(null);
                    temp .set_next(current);
                    sum = sum +1 ;
                }
            }
        }
        if( n == 2 ) //pizza
            add_new3(num,num2);
    }

    public void add_new3( int num , int num2 ) //for the pizza building
    {
        if( num2 == 1 )//meat topping
        {
            if (head[c]== null)
                num2 = 0;
            else
            {
                node temp = traverse(head[c]);
                node current = new node();
                current.setPizza();
                current.get_meal().meat(num);
                current.set_next(null);
                temp.set_next(current);
                sum = sum +1 ;
            }
        }
        if( num2 == 2 )//vegan topping
        {
            if (head[c+1] == null)
            {
                head[c+1] = new node();
                head[c+1] .topping = new String();
                head[c+1] .topping = "Vegan" ;
                head[c+1] .setPizza();
                head[c+1] .set_next(null);
                node current = new node();
                current.setPizza();
                current.get_meal().vegan(num);
                current.set_next(null);
                head[c+1].set_next(current);
                sum = sum +1 ;
            }
            else
            {
                node temp = traverse(head[c+1]);
                node current = new node();
                current.setPizza();
                current.get_meal().vegan(num);
                current.set_next(null);
                temp.set_next(current);
                sum = sum +1 ;
            }
        }
        if( num2 == 3 )//sauce topping
        {
            if (head[c+2]  == null)
            {
                head[c+2] = new node();
                head[c+2].topping = new String();
                head[c+2] .topping = "Sauce" ;
                head[c+2].setPizza();
                head[c+2] .set_next(null);
                node current = new node();
                current.setPizza();
                current.get_meal().sauce(num);
                current.set_next(null);
                head[c+2].set_next(current);
                sum = sum +1 ;

            }
            else {
                node temp = traverse(head[c+2]);
                node current = new node();
                current.setPizza();
                current.get_meal().sauce(num);
                current.set_next(null);
                temp .set_next(current);
                sum = sum +1 ;
            }
        }

    }

    public void display_order() //display all orders function
    {
        if(head[0] == null ) //base case
            return ;
        else
        {
            int i = 0 ;
            int t = 0 ;
            int j = c  ;
            while( i < j ) //displaying the three type of toppings
            {
                if(head[i] == null ) {
                    ++i;
                    ++t ;
                }
                else
                {
                    if( t % 3 == 0 )
                        System.out.print("\n"+ " - "+ meal_name[i] + " - ") ;
                    System.out.println("\n" + "- " + head[i].topping + " -");
                    node current = head[i].get_next();
                    display_order(i, current); //displaying the topping of the category
                    ++i;
                    ++t ;
                }
            }
        }
    }
    protected int display_order1(int i, node head ) //displaying the topping of the category function
    {
        if(head == null)
            return 0 ;
        else
        {
            head.get_meal().display();
            return display_order(i, head.get_next() );
        }
    }
    public void display_order1() //display the latest order function
    {
        if(head[0] == null ) //base case
            return ;
        else
        {
            int i = c - 3 ;
            int t = 0 ;
            int j = c  ;
            while( i < c ) //displaying the three type of toppings
            {
                if(head[i] == null ) {
                    --i;
                    ++t ;
                }
                else
                {
                    if( t % 3 == 0 )
                        System.out.print("\n"+ " - "+ meal_name[i] + " - ") ;
                    System.out.println("\n" + "- " + head[i].topping + " -");
                    node current = head[i].get_next();
                    display_order(i, current); //displaying the topping of the category
                    ++i;
                    ++t ;
                }
            }
        }
    }
    protected int display_order(int i, node head ) //displaying the topping of the category function
    {
        if(head == null)
            return 0 ;
        else
        {
            head.get_meal().display();
            return display_order(i, head.get_next() );
        }
    }

    public void removeall() //remove or cancel the order function (wrapper function)
    {
        if(head[0] == null )
            return ;
        else
        {
            int i = list_size - 1    ;
            while( i > -1 ) //delete from the last category
            {
                removeall(head[i]);
                head[i]= null ;
                --i ;
            }
        }
        sum = 0 ;
    }
    private void removeall( node head ) //remove or cancel the order function (recursive function)
    {
        if(head == null )
            return ;
        removeall(head.get_next());
        System.gc();
    }
    public void remove_orders() //removing all  orders from 2-3 tree function
    {
        ct = 0 ;
        tree23.remove();

    }

    public void insert() //inserting new orders to the 2-3 tree function
    {
        tree23.insert1(sum , meal_name[c] );
    }
    public void raise() //estimating latest order`s time function
    {
        int t = tree23.count(); //getting number of orders
        System.out.println("number of orders = " + t ); //displaying the number of the previous orders
        if(t % 2 == 0 )
            ct = ct + 2 ;
        if(t % 5 == 0 )
            ct = ct - 2 ;
    }
    public void display_time() //displaying the estimated time for an order function
    {
        int t = ct ;
        int m = ct + 15 ;

        System.out.println("Your order will be ready in " + m + " minutes");

    }
    public void display_orders() //display the previous orders function
    {
        tree23.display();
    }
    public int is_full() //returning the number of saved orders function
    {
       return c ;
    }

}
