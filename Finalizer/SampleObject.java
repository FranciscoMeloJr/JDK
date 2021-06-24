public class SampleObject {
 
    public String data;
     
    public SampleObject(String data) {
         
        this.data = data;
    }
         
    @Override
    public void finalize() {
     
        try {
            // Sleep for 1 minute.
            //Thread.currentThread().sleep(1 * 60 * 1000);
        } catch (Exception e) {}
    }   
     
    public static void main(String[] args) {
         
        long counter = 0;
         
        while (true) {
         
            new SampleObject("my-fun-data-" + counter);
            System.out.println("created: " + counter++);
        }
    }   
}