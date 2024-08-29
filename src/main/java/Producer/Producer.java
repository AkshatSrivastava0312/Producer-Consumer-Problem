package Producer;

import Company.Company;

public class Producer extends  Thread{

    private Company company;

    public Producer(Company company){
        this.company = company;
    }

    public void run(){
        for(int i=1;i<=5;i++){
            this.company.produce_item(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
