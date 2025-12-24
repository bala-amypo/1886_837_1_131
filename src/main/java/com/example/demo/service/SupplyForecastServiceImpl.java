@Service
public class SupplyForecastServiceImpl {

    public SupplyForecast create(SupplyForecast forecast) {
        return forecast;
    }

    public SupplyForecast update(Long id, SupplyForecast updatedForecast) {
        return updatedForecast;
    }

    public SupplyForecast getById(Long id) {
        return new SupplyForecast();
    }

    public SupplyForecast getLatest() {
        return new SupplyForecast();
    }

    public List<SupplyForecast> getAll() {
        return List.of();
    }
}
