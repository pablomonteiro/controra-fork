package br.com.casamagalhaes.controra.config;

import br.com.casamagalhaes.controra.utils.CollectionsUtil;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class DBIntegration {

    @PersistenceContext
    private EntityManager entityManager;

    public void cleanTables(List<Class> entities) {
        if(!CollectionsUtil.isNullOrEmpty(entities))
            entities.forEach(entityClass -> {
                CriteriaDelete<?> criteriaDelete = entityManager.getCriteriaBuilder().createCriteriaDelete(entityClass);
                Root<?> book = criteriaDelete.from(entityClass);
                entityManager.createQuery(criteriaDelete).executeUpdate();
            });
    }

}
