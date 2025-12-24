@Service
public class LoadSheddingServiceImpl {

    public LoadShedding trigger(Long zoneId) {
        return new LoadShedding();
    }

    public LoadShedding getById(Long id) {
        return new LoadShedding();
    }

    public List<LoadShedding> getAll() {
        return List.of();
    }
}
