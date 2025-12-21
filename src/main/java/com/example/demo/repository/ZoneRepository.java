public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Optional<Zone> findByZoneName(String name);
    List<Zone> findByActiveTrueOrderByPriorityLevelAsc();
}
