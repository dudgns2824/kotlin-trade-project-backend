<<<<<<<< HEAD:user-service/src/main/kotlin/trade/backend/user/service/adapter/out/jpa/entity/MailEntity.kt
package trade.backend.user.service.adapter.out.jpa.entity
========
package trade.backend.user.service.auth.adapter.out.jpa.entity
>>>>>>>> d2886b4 (user-service gradle 설정 추가):user-service/src/main/kotlin/trade/backend/user/service/auth/adapter/out/jpa/entity/MailEntity.kt

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