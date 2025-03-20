package trade.backend.user.service.adapter.out.jpa.entity.id

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.CreationTimestamp
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable

data class MailRequestId(
    @Column(name = "mail_idx", nullable = false)
    var mailIdx: Long? = null,
    @CreationTimestamp
    @Column(name = "request_time")
    var requestTime: LocalDateTime? = LocalDateTime.now(),
) : Serializable
