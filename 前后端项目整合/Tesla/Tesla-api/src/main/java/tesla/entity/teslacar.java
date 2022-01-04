package tesla.entity;

import lombok.*;

import java.util.Arrays;
import java.util.Objects;

/*
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class teslacar {
    private Integer carId;
    private String carTitle;
    private String carImgurl;
    private Arrays carConfig;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof teslacar)) return false;
        teslacar teslacar = (teslacar) o;
        return Objects.equals(carId, teslacar.carId) && Objects.equals(carTitle, teslacar.carTitle) && Objects.equals(carImgurl, teslacar.carImgurl) && Objects.equals(carConfig, teslacar.carConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carTitle, carImgurl, carConfig);
    }
}
