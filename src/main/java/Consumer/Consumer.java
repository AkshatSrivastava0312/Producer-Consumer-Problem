package Consumer;

import Company.Company;

public class Consumer extends Thread{

    private Company company;

    public Consumer(Company company){
        this.company = company;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            this.company.consume_item();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
