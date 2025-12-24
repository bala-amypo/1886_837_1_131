
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SupplyForecast;
import com.example.demo.repository.SupplyForecastRepository;

@Service
public class SupplyForecastServiceImpl {

    @Autowired
    private SupplyForecastRepository supplyForecastRepository;

    public SupplyForecast saveSupplyForecast(SupplyForecast supplyForecast) {
        return supplyForecastRepository.save(supplyForecast);
    }

    public List<SupplyForecast> getAllSupplyForecasts() {
        return supplyForecastRepository.findAll();
    }

    public SupplyForecast getSupplyForecastById(Long id) {
        return supplyForecastRepository.findById(id).orElse(null);
    }

    public SupplyForecast updateSupplyForecast(Long id, SupplyForecast updatedForecast) {
        SupplyForecast existing = supplyForecastRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setForecastDate(updatedForecast.getForecastDate());
            existing.setExpectedSupply(updatedForecast.getExpectedSupply());
            return supplyForecastRepository.save(existing);
        }
        return null;
    }

    public void deleteSupplyForecast(Long id) {
        supplyForecastRepository.deleteById(id);
    }
}