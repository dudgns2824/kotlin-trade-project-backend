<<<<<<<< HEAD:user-service/src/main/kotlin/trade/backend/user/service/adapter/out/jpa/entity/MailRequestEntity.kt
package trade.backend.user.service.adapter.out.jpa.entity
========
package trade.backend.user.service.auth.adapter.out.jpa.entity
>>>>>>>> d2886b4 (user-service gradle 설정 추가):user-service/src/main/kotlin/trade/backend/user/service/auth/adapter/out/jpa/entity/MailRequestEntity.kt

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
<<<<<<<< HEAD:user-service/src/main/kotlin/trade/backend/user/service/adapter/out/jpa/entity/MailRequestEntity.kt
import trade.backend.user.service.domain.user.enumeration.VerifyType
import trade.backend.user.service.adapter.out.jpa.entity.id.MailRequestId
========
import trade.backend.user.service.auth.domain.user.enumeration.VerifyType
import trade.backend.user.service.auth.adapter.out.jpa.entity.id.MailRequestId
>>>>>>>> d2886b4 (user-service gradle 설정 추가):user-service/src/main/kotlin/trade/backend/user/service/auth/adapter/out/jpa/entity/MailRequestEntity.kt

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