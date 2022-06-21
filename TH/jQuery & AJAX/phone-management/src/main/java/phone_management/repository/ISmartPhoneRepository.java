package phone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phone_management.model.SmartPhone;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
