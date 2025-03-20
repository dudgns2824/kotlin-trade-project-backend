package trade.backend.user.service.adapter.out.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "mail")
data class MailEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    var idx: Long? = null,
    @Column(name = "email", nullable = false)
    var email: String? = null,
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "mail_idx", insertable = false, nullable = false)
    val mailRequests: List<MailRequestEntity> = ArrayList(),
)