
package kata5P2.main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReaderBD;

public class Kata5P2 {
    private final String fileName = "email.txt";
    private ArrayList<Mail> mailList = new ArrayList<>();
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws IOException {
        new Kata5P2().execute();
    }
    
    public void execute(){
        try {
            input();
            process();
            output();
        } catch (IOException ex) {
            Logger.getLogger(Kata5P2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void input() throws IOException{
        List<Mail> list = MailListReaderBD.read();
        for (Mail mail : list) {
            if(mail!=null)
            mailList.add(mail);
        }
    }
    
    public void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
