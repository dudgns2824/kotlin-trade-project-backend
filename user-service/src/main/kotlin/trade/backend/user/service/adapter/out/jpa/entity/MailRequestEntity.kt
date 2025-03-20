package trade.backend.user.service.adapter.out.jpa.entity

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import trade.backend.user.service.adapter.out.jpa.entity.id.MailRequestId
import trade.backend.user.service.domain.user.enumeration.VerifyType

@Entity
@Table(name = "mail_request")
data class MailRequestEntity (
    @EmbeddedId
    var mailRequestId: MailRequestId? = null,
    @Column(name = "code")
    var code: String?,
    @Column(name = "type")
    var type: VerifyType? = VerifyType.REGISTER,
    @Column(name = "verified")
    var verified: Boolean? = false,
    @Column(name = "confirm")
    var confirm: Boolean? = false,
)