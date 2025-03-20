package trade.backend.user.service.adapter.out.jpa.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "user")
data class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    var idx: Long? = null,
    @Column(name = "user_id", nullable = false)
    var userId: String? = null,
    @Column(name = "user_name", nullable = false, columnDefinition = "VARCHAR(64)")
    var userName: String? = null,
    @Column(name = "user_email", nullable = false, columnDefinition = "VARCHAR(128)")
    var userEmail: String? = null,
    @Column(name = "user_password", nullable = false, columnDefinition = "VARCHAR(256)")
    var userPassword: String? = null,
    @Column(name = "user_role", nullable = false)
    var userRole: String? = null,
    @Column(name = "created_dt", nullable = false, columnDefinition = "DATETIME")
    @CreationTimestamp
    private var createdDt: LocalDateTime? = null,
)