package ma.projet.graph.repositories;

import ma.projet.graph.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Recherche de toutes les transactions par compte
    List<Transaction> findByCompteId(Long compteId);

    // Recherche de toutes les transactions pour un type de transaction donné (crédit ou débit)
    List<Transaction> findByTypeTransaction(String typeTransaction);

    // Recherche des transactions d'un compte pour une période donnée
    List<Transaction> findByCompteIdAndDateTransactionBetween(Long compteId, Date startDate, Date endDate);
}
