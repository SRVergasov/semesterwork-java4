package ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
