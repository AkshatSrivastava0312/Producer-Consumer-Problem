package Company;

public class Company {

    private int itemNumber = 0;
    private boolean isProducing = true;

    synchronized public void produce_item(int itemNumber){

        if(!isProducing) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.itemNumber = itemNumber;
        System.out.println("Producer produced Item: " + this.itemNumber);
        isProducing = false;
        notify();
    }

    synchronized public int consume_item(){

        if(isProducing){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Consumer consumed Item: " + this.itemNumber);
        isProducing = true;
        notify();
        return this.itemNumber;
    }

}
