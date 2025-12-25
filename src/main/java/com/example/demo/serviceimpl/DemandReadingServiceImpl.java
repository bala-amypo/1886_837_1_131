@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repo;
    private final ZoneRepository zoneRepo;

    public DemandReadingServiceImpl(
            DemandReadingRepository repo,
            ZoneRepository zoneRepo) {
        this.repo = repo;
        this.zoneRepo = zoneRepo;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return repo.save(reading);
    }

    @Override
    public List<DemandReading> getAll() {
        return repo.findAll();
    }

    @Override
    public DemandReading getLatestByZone(Long zoneId) {
        Zone zone = zoneRepo.findById(zoneId).orElse(null);
        if (zone == null) return null;

        return repo.findFirstByZoneOrderByRecordedAtDesc(zone).orElse(null);
    }
}
