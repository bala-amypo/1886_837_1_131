public interface SupplyForecastRepository extends JpaRepository<SupplyForecast, Long> {
    SupplyForecast findFirstByOrderByGeneratedAtDesc();
}
