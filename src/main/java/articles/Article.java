package articles;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Article {
    public double price;
    protected ArrayList<String> specialAttributes;
}
