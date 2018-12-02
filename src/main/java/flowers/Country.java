package flowers;


import lombok.Getter;

@Getter
public enum Country {
    UKRAINE("Ukraine"), NETHERLANDS("Netherlands"), FRANCE("France"), POLAND("Poland");
    private String name;

    Country(String name) { this.name = name; }
}
