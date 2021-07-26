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

import java.util.Scanner ;
//main class
public class main {
    //main function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //input object
        Order order ; //Order class object
        int size = 30 ; //size of the array of linear linked list
        order = new Order(size); //new order
        int num = 0 ; //for user choices
        int num2 = 0 ; //for tracking the toppings
        char c ; //for the user choice
        int t = 0 ; //for ending the main loop
        int i = 0 ; // for end the insides loops
        char d  ; //for display option
        int flag = 0 ; //for entering one order in the program for now
        System.out.println("          W   E   L   C   O   M   E  ");

        while ( t == 0 ) //this loop would not stop until the user choose number 5
        {
            int f = order.is_full();
            System.out.println();
            System.out.println("Please choose one of the choices by typing the number of your choice:" + "\n(1) Build Your Own Order"
            + "\n(2) Order The Specialty of the Day " +"\n(3) Display Latest Order" + "\n(4) Display All Previous Orders "  +"\n(5) Remove All Orders"+ "\n(6) Quit" );
            c = input.next().charAt(0) ;
            input.nextLine();
            if ( c == '1' ) //building the order
            {
                num2 = 0;
                System.out.println("Type the number of your meal to order" + "\n(1) Burger \n(2) Pizza ");
                num = input.nextInt();
                input.nextLine();
                if (num != 1 && num != 2) //wrong choice
                    System.out.println("Wrong choice");
                else if (f < 30 )  //the user will have 10 orders maximum to add to their list of orders
                {

                    order.add_new(num); //adding the type of food
                    System.out.println("\n* YOU CAN ONLY ADD ONE CHOICE OF MEAT IN ONE ORDER *" + "\nType your choice of topping:");
                    while (num2 < 3) //for the three toppings
                    {
                        i = 0;
                        ++num2;
                        int p = order.num(num2); //returning the number of the available toppings in each category
                        if (num2 != 1) //for the 2nd & 3rd categories (you can add more than one )
                        {
                            while (num != 0 && i < p) {
                                order.display_toppings(num2);
                                num = input.nextInt();
                                input.nextLine();
                                if (num > p)
                                    i = 5;
                                else if (num > 0 && num <= p) {
                                    order.add_new(num, num2);
                                    ++i;
                                } else {
                                    System.out.println("Wrong choice");
                                }
                            }
                        } else // for 1st category (meet) ( the user can add one type of meat)
                        {
                            if (num > 0 && num <= p) {
                                order.display_toppings(num2);
                                num = input.nextInt();
                                input.nextLine();
                                order.add_new(num, num2);
                            } else {
                                System.out.println("Wrong choice");
                            }
                        }
                    }
                    order.insert(); //inserting the new order to the 2-3 tree
                    order.order_num(); //increasing the number of the linear linked list
                    order.raise(); //time raising
                    order.display_time(); //display the current time for the this order
                    flag = 1 ; //flag that there is an order in the list
                }
                else
                    System.out.println("Your list is full!! PLEASE Remove orders to save new ones");

            }
            if ( c == '2') //for the special orders
            {
                System.out.println("Type the number of your choice: \n(1)Special Burger \n(2)Special Pizza");
                num = input.nextInt();
                input.nextLine();
                if( num != 1 && num != 2)
                    System.out.println("Wrong choice");
                else if (flag >= 30 )
                {
                    System.out.println("Your list is full!! PLEASE Remove orders to save new ones");
                }
                else
                {
                    order.add_new(num); //adding the type of food
                    order.display_special(num); //displaying what`s the special meal of the day
                    order.add_s1(); //adding the special meal to the order
                    order.insert();
                    order.raise();
                    order.order_num();
                    order.display_time();
                }

            }
            if( c == '3') //displaying the latest order
                order.display_order1();
            if( c == '4') //display the list of orders
            {
                System.out.println("Type the number of your choice: \n(1)Display The Summery of All order \n(2)Display The Details of All orders");
                d = input.next().charAt(0) ;
                input.nextLine();
                if ( d == '1') //display the 2-3 tree
                {
                    if (flag == 1)
                        order.display_orders();
                    else
                        System.out.println("There are no orders to display!");
                }
                if( d == '2') //display the array of linear linked list
                {
                    if (flag == 1)
                        order.display_order();
                    else
                        System.out.println("There are no orders to display!");
                }
            }
            if( c == '5') //remove all the order form the list
            {
                order.removeall();
                order.remove_orders();
                num2 = 0;
                flag =0 ;

            }
            if( c == '6') { //quit the program
                t = 1;
            }
        }
        System.out.println("Thank You For using this service! Good Bye!!");
    }
}

