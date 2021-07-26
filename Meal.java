// Alkhatab Alrashdi 
// December  9th, 2019

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



//abstract base class Meal
abstract public class Meal {

    protected String name ;
    protected int num ;
    public Meal() //class constructor
    {
        this.name = null;
        this.num = 0;
    }
    public abstract void meat ( int num ); //meat toppings function
    public abstract void vegan( int num ); //vegan toppings function
    public abstract void sauce( int num ); //sauce toppings function
    public abstract void display(); //displaying function

}

//Burger class (derived)
class Burger extends Meal
{
    protected String name ;
    protected int num ;
    public Burger() //class constructor
    {
        this . name = null ;
        this . num = 0 ;
    }


    @Override
    public void meat(int num) { //meat topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String();
            name = "chicken";
        }
        if( num == 2 )
        {
            name = new String();
            name = "beef" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "ham";
        }
    }
    @Override
    public void vegan(int num) { //vegan topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String();
            name = "lettuce";
        }
        if( num == 2 )
        {
            name = new String();
            name = "tomatoes" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "pickles";
        }
        if( num == 4 ){
            name = new String();
            name = "onion" ;
        }
    }
    @Override
    public void sauce(int num) { //sauce topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String();
            name = "ketchup";
        }
        if( num == 2 )
        {
            name = new String();
            name = "mayonnaise" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "yellow mustard";
        }
    }

    @Override
    public void display() { //Displaying Function (Overriding)

        System.out.print("-topping name -> " + name +"\n");
    }
}
//Pizza class (derived)
class Pizza extends Meal //
{
    protected String name ;
    protected int num ;
    public Pizza ()
    {
        this . name = null ;
        this . num = 0 ;
    }

    @Override
    public void meat(int num) { //meat topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String() ;
            name = "ham" ;
        }
        if( num == 2 )
        {
            name = new String();
            name = "beef" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "pepperoni" ;
        }
        if( num == 4 )
        {
            name = new String();
            name = "premium chicken" ;
        }
    }


    @Override
    public void vegan(int num) { //vegan topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String() ;
            name = "onions" ;
        }
        if( num == 2 )
        {
            name = new String();
            name = "black olives" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "mushrooms" ;
        }
        if( num == 4 )
        {
            name = new String();
            name = "green peppers" ;
        }
    }

    @Override
    public void sauce(int num) { //sauce topping function (overriding)

        //numbers of the toppings to store the data
        if ( num == 1 )
        {
            name = new String() ;
            name = "Robust Inspired Tomato Sauce" ;
        }
        if( num == 2 )
        {
            name = new String();
            name = "BBQ Sauce" ;
        }
        if( num == 3 )
        {
            name = new String();
            name = "Garlic Parmesan White Sauce" ;
        }
        if( num == 4 )
        {
            name = new String();
            name = "Alfredo Sauce" ;
        }
    }
    public void display() {
        System.out.print("-topping name -> " + name+"\n");
    }
}
//node class
class node {
    protected node next; //next pointer
    protected Meal meal; //pointer to meal class
    protected  String topping ; //topping string
    public node()
    {
        this.topping = null ;
    } //class constructor
    public void set_next(node next1) { //setting next pointer function
        if (next1 == null) {
            next = null;
        } else {
            next = next1;
        }
    }
    public void setBurger() //setting burger
    {
        meal = new Burger() ;
    }
    public void setPizza() //setting pizza
    {
        meal = new Pizza();
    }
    public node get_next() //getting next pointer
    {
        return next ;
    }
    public Meal get_meal() //getting meal function
    {
        return meal ;
    }
}






