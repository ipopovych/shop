package flowers;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Color {
    White("#fffffff"),Blue("#ffff00"), Purple("#ff00ff"), Red("#ff0000");
    private String rgb;

    Color(String rgb){this.rgb = rgb;}
}
