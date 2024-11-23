package ma.projet.graph.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compte_id", referencedColumnName = "id")
    private Compte compte;

    private double montant;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransaction;

    private String typeTransaction; // Par exemple, "Crédit" ou "Débit"

    // Getters et setters
}
