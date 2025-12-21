public interface DemandReadingRepository extends JpaRepository<DemandReading, Long> {
    DemandReading findFirstByZoneIdOrderByRecordedAtDesc(Long zoneId);
    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId);
}
