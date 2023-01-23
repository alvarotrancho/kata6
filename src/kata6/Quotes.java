package kata6;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quotes {
    public int id;
    public String quote;    
    public String author;

    
    
        @Override
    public String toString(){
        return "Quotes{ id = "+ id + ", quote = " + quote + ", author = " + author +"}";
    }
    
}
