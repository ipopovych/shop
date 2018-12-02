package flowers;


import lombok.Getter;

@Getter
public enum Odor {
    Good("good"), OK("okay"), AWFUL("awful");
    private String odor;

    Odor(String odor) {
        this.odor = odor;
    }
}