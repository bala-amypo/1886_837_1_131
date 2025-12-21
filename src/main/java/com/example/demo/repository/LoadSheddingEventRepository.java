public interface LoadSheddingEventRepository extends JpaRepository<LoadSheddingEvent, Long> {
    List<LoadSheddingEvent> findByZoneIdOrderByEventStartDesc(Long zoneId);
}
