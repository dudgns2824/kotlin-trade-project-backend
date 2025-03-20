package trade.backend.user.service.adapter.out.jpa.repository.`interface`

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import trade.backend.user.service.adapter.out.jpa.entity.MailEntity

@Repository
interface MailRepository: JpaRepository<MailEntity, Long> {
}