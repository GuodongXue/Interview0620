package PriorityQueuePreatice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);

        Random random = new Random();
        for (int i = 0; i< 7; i++){
            integerPriorityQueue.add(new Integer(random.nextInt(100)));
        }

        for(int i = 0; i< 7; i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing integers"+ in);
        }



        //
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);

    }
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return (o1.getIt()-o2.getIt());
        }
    };

    private static void addDataToQueue(Queue<Customer> customerPriorityQueue){
        Random random = new Random();
        for (int i = 0; i <7; i++){
            int id = random.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Cus"+id));
        }
    }
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue){
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null){
                break;
            }else{
                System.out.println("Processed"+ cust.getIt());
            }
        }
    }

}
