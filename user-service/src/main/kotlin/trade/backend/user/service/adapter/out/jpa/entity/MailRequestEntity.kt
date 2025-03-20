package trade.backend.user.service.adapter.out.jpa.entity

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