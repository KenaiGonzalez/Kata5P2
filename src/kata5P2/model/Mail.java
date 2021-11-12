package kata5P2.model;

public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain(){
        String[] dom = mail.split("@");
        if(dom.length ==2) return dom[1];
        return null;
    }
}
