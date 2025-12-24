

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZoneRestorationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;

    private LocalDateTime restoredAt;   // ✅ ADD THIS FIELD

    private String status;
}
