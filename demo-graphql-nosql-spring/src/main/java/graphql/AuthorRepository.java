package graphql
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springgraphql.mysql.model.Author;
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
