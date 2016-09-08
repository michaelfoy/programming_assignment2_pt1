import java.util.ArrayList;

/**
 * Class to sort Bids in ArrayList using Merge Sort algorithm
 * Bids sorted by field amountBid
 * Includes methods to print ArrayList and test algorithm
 * 
 * @author michaelfoy
 * @version 30.03.2016
 */
public class MergeSort
{
    private static ArrayList<Bid> aux = new ArrayList<Bid>();
    
    /*
     *Method to sort Bids in ArrayList using an auxiliary Arraylist containing same Bids
     *When invoked, Bids from the auxiliary are moved
     *to their appropriate position in the ArrayList for the iteration.
     *
     *@param bids   ArrayList to be sorted
     *@param lo     Int to represent the smallest value in this iteration
     *@param mid    Int to represent the mid value in this iteration
     *@param hi     Int to represent the highest value in this iteration
     */
    private static void merge(ArrayList<Bid> bids, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
        {
            aux.add(k, bids.get(k));
        }
        

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            bids.remove(k);
            if (i > mid)                                             bids.add(k, aux.get(j++));
            else if (j > hi)                                         bids.add(k, aux.get(i++));
            else if(aux.get(j).amountBid < aux.get(i).amountBid)     bids.add(k, aux.get(j++));
            else                                                     bids.add(k, aux.get(i++));
        }
    }

    /**
     * Method to iterate through and sort an ArrayList.
     * Variables are augmented for each iteration to allow 
     * for appropriate separation, then merging of sorted segments.
     * 
     * @param bids    The ArrayList to be sorted
     */
    public static void sort(ArrayList<Bid> bids)
    {
        int N = bids.size();

        for (int size = 1; size < N; size = size + size)
        {
            for (int lo = 0; lo < N - size; lo += size + size)
            {
                merge(bids, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }
        }
    }
    /**
     * Method to print contents of an ArrayList
     * 
     * @param bids    ArrayList to be printed 
     */
    public static void print(ArrayList<Bid> bids)
    {
        for (int i=0 ; i < bids.size(); i++)
        {
            System.out.print(bids.get(i).amountBid + " ");
        }
        System.out.println();
    }
    
    /**
     * Method to test MergeSort algorithm for int amountBid of Object Bid in an ArrayList.
     * ArrayList initialised with Bids containing amountBids which increment by 1000,
     * starting at 1000, finishing at 7000. Prints unsorted, then sorted contents.
     */
    public static void sortTest()
    {
        ArrayList<Bid> a = new ArrayList<Bid>();
        
        Lot lot1 = new Lot(123, "");
        Person person1 = new Person("", "", "", 123);
        Bid bid1 = new Bid(lot1, person1, 1000);
        Bid bid2 = new Bid(lot1, person1, 2000);
        Bid bid3 = new Bid(lot1, person1, 3000);
        Bid bid4 = new Bid(lot1, person1, 4000);
        Bid bid5 = new Bid(lot1, person1, 5000);
        Bid bid6 = new Bid(lot1, person1, 6000);
        Bid bid7 = new Bid(lot1, person1, 7000);
        
        a.add(bid7);
        a.add(bid2);
        a.add(bid1);
        a.add(bid3);
        a.add(bid6);
        a.add(bid4);
        a.add(bid5);
        print(a);
        sort(a);
        print(a);
    }
}
