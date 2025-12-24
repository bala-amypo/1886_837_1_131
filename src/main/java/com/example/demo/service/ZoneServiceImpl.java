@Service
public class ZoneServiceImpl {

    private final ZoneRepository repo;

    public ZoneServiceImpl(ZoneRepository repo) {
        this.repo = repo;
    }

    public Zone createZone(Zone z) {
        if (repo.findByZoneName(z.getZoneName()).isPresent())
            throw new BadRequestException("unique");
        return repo.save(z);
    }

    public Zone get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<Zone> getAll() {
        return repo.findAll();
    }

    public Zone deactivate(Long id) {
        Zone z = get(id);
        z.setActive(false);
        return repo.save(z);
    }
}
