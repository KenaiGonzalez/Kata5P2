package kata5P2.view;

import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build(List<Mail> list){
        Histogram<String> hist = new Histogram<String>();
        for (Mail mail : list) {
            if(mail.getDomain() == null)continue;
            hist.increment(mail.getDomain());
        }
        return hist;
    }
}
