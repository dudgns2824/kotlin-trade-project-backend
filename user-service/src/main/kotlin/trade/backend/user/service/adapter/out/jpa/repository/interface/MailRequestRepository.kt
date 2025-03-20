package trade.backend.user.service.adapter.out.jpa.repository.`interface`

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import trade.backend.user.service.adapter.out.jpa.entity.MailRequestEntity
import trade.backend.user.service.adapter.out.jpa.entity.id.MailRequestId

@Repository
interface MailRequestRepository: JpaRepository<MailRequestEntity, MailRequestId> {
}