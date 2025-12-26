@Override
public void triggerLoadShedding(Long forecastId) {

    SupplyForecast f = forecastRepo.findById(forecastId)
            .orElseThrow(() -> new ResourceNotFoundException("Forecast not found"));

    List<Zone> zones = zoneRepo.findByActiveTrueOrderByPriorityLevelAsc();
    if (zones.isEmpty())
        throw new BadRequestException("No overload");

    Zone z = zones.get(0);

    DemandReading r = readingRepo
            .findFirstByZoneIdOrderByRecordedAtDesc(z.getId())
            .orElseThrow(() -> new BadRequestException("No overload"));

    LoadSheddingEvent e = LoadSheddingEvent.builder()
            .zone(z)
            .eventStart(Instant.now())
            .triggeredByForecastId(forecastId)
            .expectedDemandReductionMW(r.getDemandMW())
            .reason("AUTO")
            .build();

    eventRepo.save(e);
}
