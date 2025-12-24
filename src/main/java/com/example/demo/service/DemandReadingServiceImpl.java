@Service
public class DemandReadingServiceImpl {

    public DemandReading create(DemandReading reading) {
        return reading;
    }

    public DemandReading getById(Long id) {
        return new DemandReading();
    }

    public DemandReading getLatest(Long zoneId) {
        return new DemandReading();
    }

    public List<DemandReading> getRecent(Long zoneId, int limit) {
        return List.of();
    }
}
