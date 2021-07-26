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

public class tnode
{
    protected tnode left ; //left child
    protected tnode mid ; //middle child
    protected tnode right ; //right child
    protected tnode p ; //parent
    protected int i ; //number of items
    protected int s [] ; //total number of toppings in the order
    protected String meal [] ; //meal names

    public tnode() //class constructor
    {
        this.i = 0 ;
        this.s = new int [3] ; //two data items in each node
        this.meal = new String[2]; //two data items in each node
        for ( int n = 0 ; n < 2 ; ++n )
        {
            meal[n] = null ;
            s[n] = 0 ;
        }
        this.left = null ;
        this.mid = null ;
        this.right = null ;
        this.p = null ;

    }

    public tnode getLeft()//get left child function
    {
        return left ;
    }
    public tnode getMid()//get middle child function
    {
        return mid ;
    }
    public tnode getRight()//get right child function
    {
        return right ;
    }
    public tnode getP()//get parent function
    {
        return p ;
    }
    public void set_p(tnode pa ) //setting parent node function
    {
        if(pa  == null )
            p = null ;
        else
            p = pa ;
    }
    public void setLeft( tnode left1 ) //setting left child function
    {
        if(left1 == null )
            left = null ;
        else
            left = left1 ;
    }
    public void setMid( tnode mid1 ) //setting middle child function
    {
        if(mid1 == null )
            mid = null ;
        else
            mid = mid1 ;
    }
    public void setRight( tnode right1 ) //setting right child function
    {
        if( right1 == null )
            right = null ;
        else
            right = right1 ;
    }
    public int getS( int i ) //get the total toppings function
    {
        return s[i];
    }
    public String getmeal( int i ) //getting the name of the meal function
    {
        return meal[i];
    }
    public void set_s( int n, int b) //setting the total toppings data function
    {
       s[b] = n ;
    }
    public void set_meal( String name, int b ) //setting the meal name function
    {
        meal[b] = new String();
        meal[b] = name ;
    }

    public void display() //display node`s data function
    {
        for ( int j = 0 ; j < 2 ; ++j )
        {
            if(s[1] == 0 )
            {
                System.out.println("Meal Name : " + meal[j] + " , Total Number of Toppings = " + s[j]  );
                j = 3 ;
            }
            else
                System.out.println("Meal Name : " + meal[j] + " , Total Number of Toppings = " + s[j]  );
        }
        System.out.println();
    }
    public void set_i() //setting the number of data in the node function
    {
        ++i ;
    }
    public int count() //returning the number of data in the node function
    {
        if(s[1] == 0)
            return 1 ;
        else
            return 2 ;
    }
}

class tree //2-3 tree class
{
    private tnode root ; //root pointer
    public tree()
    {
        this.root = null ; //setting root to null
    }
    public void insert1(int t_sum , String name) //insert new node to the tree function (wrapper function)
    {
        if( root == null ) //if there is no nodes in the tree
        {
            root = new tnode();
            root.set_meal(name,0);
            root.set_s(t_sum,0);
            root.set_i();
            root.setLeft(null);
            root.setMid(null);
            root.setRight(null);
        }
        else //if there is a node in the tree
        {
            insert2( root , t_sum , name );
        }
    }
    private void insert2( tnode root,int t_sum , String name ) //insert new node to the tree function (recursive function)
    {
        if( root.getLeft() == null && root.getMid() == null && root.getRight() == null ) //inserting new nodes at the leaf
        {
            if (root.getS(1) == 0 ) //if the second data do not have data
            {
                if (t_sum < root.getS(0)) //if new data less than the first data
                {
                    root.set_s(root.getS(0), 1);
                    root.set_meal(root.getmeal(0), 1);
                    root.set_s(t_sum, 0);
                    root.set_meal(name, 0);
                }
                else //if new data larger than the first data
                {
                    root.set_s(t_sum, 1);
                    root.set_meal(name, 1);
                }
            }
            else //if the node is full with 2 data
            {
                split(root,t_sum,name); //split the node
                if ( root.getP() != null ) //if there is a parent for the node, push up the middle data to the parent
                    push(root, root.getP()) ;
            }
        }
        //travers to the leafs
        else if ( t_sum < root.getS(0))
            insert2(root.getLeft(),t_sum,name);
        else if ( root.getS(1) == 0 )
            insert2(root.getRight(),t_sum,name);
        else
        {
            if ( t_sum < root.getS(1))
                insert2(root.getMid(),t_sum,name);
            else
                insert2(root.getRight(),t_sum,name);
        }
    }
    private void set_leaf( tnode root, tnode current, int sum, String name, int i ) //setting a new leaf node`s data and parent function

    {
        current.set_p(root);
        current.set_i();
        current.set_s(sum, i);
        current.set_meal(name,i);
    }
    private int split(tnode root , int sum , String name ) // the first split function
    {
        if( sum < root.getS(0)) //if the new data smaller than the 1st root`s data
        {
            tnode current = new tnode();
            root.setLeft(current);
            set_leaf(root,current,sum,name,0);
            current = new tnode();
            root.setRight(current);
            set_leaf(root,current,root.getS(1),root.getmeal(1),0);
            root . set_s(0,1 );
            root.set_meal(null,1);
        }
        else //the new data is larger than 1st root`s data
        {
            if( sum < root.getS(1)) //the new data is smaller than the 2nd root`s data
            {
                tnode current = new tnode();
                root.setLeft(current);
                set_leaf(root,current,root.getS(0),root.getmeal(0),0);
                current = new tnode();
                root.setRight(current);
                set_leaf(root,current,root.getS(1),root.getmeal(1),0);
                root . set_s(sum,0 );
                root.set_meal(name,0);
                root . set_s(0,1 );
                root.set_meal(null,1);
            }
            else //the new data is larger than the 2nd root`s data
            {
                tnode current = new tnode();
                root.setLeft(current);
                set_leaf(root,current,root.getS(0),root.getmeal(0),0);
                current = new tnode();
                root.setRight(current);
                set_leaf(root,current,sum,name,0);
                root . set_s(root.getS(1),0 );
                root.set_meal(root.getmeal(1),0);
                root.set_s(0,1);
                root.set_meal(null,1);
            }
        }
        return 1 ;
    }

    private void push(tnode root , tnode p ) //push the middle data to the parent function
    {
        if( p.getS(1) == 0 )//the 2nd parent`s data is available
        {
            if( p.getS(0) > root.getS(0) ) //the middle data is smaller than the 1st parent`s data
            {
                p.set_s(p.getS(0),1);
                p.set_meal(p.getmeal(0),1);
                p.set_s(root.getS(0),0);
                p.set_meal(root.getmeal(0),0);
                p.setLeft( root.getLeft() );
                p.getLeft().set_p(p);
                p.setMid( root.getRight() );
                p.getMid().set_p(p);
            }
            else ////the middle data is larger than the 1st parent`s data
            {
                p.set_s(root.getS(0),1);
                p.set_meal(root.getmeal(0),1);
                p.setRight( root.getRight() );
                p.getRight().set_p(p);
                p.setMid( root.getLeft() );
                p.getMid().set_p(p);
            }
        }
        else //the 2nd parent`s data is not available
        {
            split2( root , p ) ; //split the parent
            if( p . getP() != null ) //if there is a parent, push up the middle data to the current node`s parent
                push(p , p.getP());
        }

    }

    private void split2(tnode root, tnode p ) //2nd split  function
    {
        tnode temp = null ; //new temp node

        if (p.getS(0) > root.getS(0)) //if the middle data is smaller than the 1st parent`s data
        {
            p.setLeft(root);
            p.getLeft().set_p(root);
            temp = new tnode();
            set_leaf(root,temp,p.getS(1),p.getmeal(1),0);
            p.set_s(0,1);
            p.set_meal(null,1) ;
            temp.setLeft(p.getMid());
            temp.getLeft().set_p(temp);
            temp.setRight(p.getRight());
            temp.getRight().set_p(temp);
            p.setRight(temp);
            p.setMid(null);
        }
        else //if the middle data is larger than the 1st parent`s data
        {
            if( root .getS(0) < p. getS(1)) //if the middle data is smaller than the 2nd parent`s data
            {
                temp = new tnode();
                set_leaf(root,temp,p.getS(0),p.getmeal(0),0);
                temp.setLeft(p.getLeft());
                temp.getLeft().set_p(temp);
                temp.setRight(root.getLeft());
                temp.getRight().set_p(temp);
                p.setLeft(temp);
                temp = new tnode();
                set_leaf(root,temp,p.getS(1),p.getmeal(1),0);
                temp.setLeft(root.getRight());
                temp.getLeft().set_p(temp);
                temp.setRight(p.getRight());
                temp.getRight().set_p(temp);
                p.setRight(temp);
                p.set_s(root.getS(0),0);
                p.set_meal(root.getmeal(0),0);
                p.set_s(0,1);
                p.set_meal(null,1);
                p.setMid(null);
            }
            else //if the middle data is larger than the 2nd parent`s data
            {
                p.setRight(root);
                p.getRight().set_p(root);
                temp = new tnode();
                set_leaf(root,temp,p.getS(0),p.getmeal(0),0);
                temp.setLeft(p.getLeft());
                temp.getLeft().set_p(temp);
                temp.setRight(p.getMid());
                temp.getRight().set_p(temp);
                p.setLeft(temp);
                p.set_s(p.getS(1),0);
                p.set_meal(p.getmeal(1),0);
                p.set_s(0,1);
                p.set_meal(null,1) ;
                p.setMid(null);
            }
        }


    }
    public void display() //displaying 2-3 tree function (wrapper function)
    {
        display(root);
    }
    private void display(tnode root ) //displaying 2-3 tree function (recursive function)
    {
        if( root == null )
            return ;
        //the display of the data will be inorder( from the smaller to the larger)
        if( root.getLeft() == null && root.getMid() == null && root.getRight() == null ) //if the node is leaf
            root.display();
        else if ( root.getLeft() != null && root.getMid() == null && root.getRight() != null ) //if the node has two children
        {
            display(root.getLeft());
            root . display();
            display(root.getRight());
        }
        else if (root.getLeft() != null && root.getMid() != null && root.getRight() != null) //if the node has 3 children
        {
            display(root.getLeft());
            root . display();
            display(root.getMid());
            root . display();
            display(root.getRight());
        }
    }
    public int count() //counting the number of data in all the tree function (wrapper function)
    {
        return count(root);
    }
    private int count( tnode root ) //counting the number of data in all the tree function (recursive function)
    {
        if( root == null )
            return 0 ;
        else
            return root.count() +  count(root.getLeft()) + count(root.getMid()) + count(root.getRight());

    }
    public void remove() //removing all nodes in the tree function (wrapper function)
    {

        remove(root);
        System.gc();
        root = null ;

    }

    private tnode remove( tnode root ) //removing all nodes in the tree function (recursive function)
    {
        if(root == null )
            return root ;
        remove(root.getLeft());
        remove(root.getMid());
        remove(root.getRight());
        if(root.getLeft() == null && root.getMid() == null && root.getRight() == null)
        {
            System.gc();
            root = null ;
        }
        return root ;
    }
}
