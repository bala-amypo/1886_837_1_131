@RestController
@RequestMapping("/supply-forecast")
public class SupplyForecastController {

    private final SupplyForecastService service;

    public SupplyForecastController(SupplyForecastService service) {
        this.service = service;
    }
}
