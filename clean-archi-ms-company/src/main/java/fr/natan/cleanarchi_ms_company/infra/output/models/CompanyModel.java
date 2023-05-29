package fr.natan.cleanarchi_ms_company.infra.output.models;

import fr.natan.cleanarchi_ms_company.domain.entity.CompanyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
@AllArgsConstructor @NoArgsConstructor @Data
public class CompanyModel {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String companyID;
    private String companyName;
    private String agency;
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;
    private LocalDateTime connectedDate;
}
