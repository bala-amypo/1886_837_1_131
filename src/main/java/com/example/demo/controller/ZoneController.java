@RestController
@RequestMapping("/api/zones")
@Tag(name = "Zones")
public class ZoneController {

    private final ZoneServiceImpl service;

    public ZoneController(ZoneServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Zone create(@RequestBody Zone zone) {
        return service.createZone(zone);
    }

    @GetMapping("/{id}")
    public Zone get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Zone> list() {
        return service.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public Zone deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
