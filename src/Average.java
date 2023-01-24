import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Average {
    /**
     * Average of GPA equivalent passed as value
     * @param map key Grade, value GPA equivalent
     * @return average of values
     */

    public double hashValuesAverage(@NotNull Map<Integer, Double> map) {
        double result = 0;

        for (double value : map.values()) {
            result += value;
        }

        return result / map.size();
    }

    /**
     * Average of grades passed as keys
     * @param map key Grade, value GPA equivalent
     * @return average of keys
     */

    public double hashKeysAverage(@NotNull Map<Integer, Double> map) {
        double result = 0;

        for (double value : map.keySet()) {
            result += value;
        }

        return result / map.size();
    }

}
