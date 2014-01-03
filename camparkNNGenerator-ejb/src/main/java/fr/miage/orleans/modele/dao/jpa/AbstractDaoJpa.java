package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.AbstractDao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Steve Cancès <steve.cances@gmail.com>
 * @param <T> L'entity gérée par la dao
 */
@Transactional
public abstract class AbstractDaoJpa<T> implements AbstractDao<T> {

    /**
     * Entity Manager used to talk with the database
     */
    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> domainClass;

    public AbstractDaoJpa(Class<T> entityClass) {
	this.domainClass = entityClass;
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#create(T)
     */
    @Override
    public void create(T entity) {
	this.entityManager.persist(entity);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#edit(T)
     */
    @Override
    public void edit(T entity) {
	this.entityManager.merge(entity);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#remove(T)
     */
    @Override
    public void remove(T entity) {
	this.entityManager.remove(entityManager.merge(entity));
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#find(java.lang.Object)
     */
    @Override
    @Transactional(readOnly = true)
    public T find(Object id) {
	return entityManager.find(domainClass, id);
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#findAll()
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
	CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(domainClass);
	criteria.select(criteria.from(domainClass));
	return entityManager.createQuery(criteria).getResultList();
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#findRange(int[])
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> findRange(int[] range) {
	CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(domainClass);
	cq.select(cq.from(domainClass));
	javax.persistence.Query q = entityManager.createQuery(cq);
	q.setMaxResults(range[1] - range[0]);
	q.setFirstResult(range[0]);
	return q.getResultList();
    }

    /* (non-Javadoc)
     * @see dao.AbstractDao#count()
     */
    @Override
    @Transactional(readOnly = true)
    public int count() {
	CriteriaBuilder b = entityManager.getCriteriaBuilder();
	CriteriaQuery<Long> criteria = b.createQuery(Long.class);
	criteria.select(b.count(criteria.from(domainClass)));

	return entityManager.createQuery(criteria).getSingleResult().intValue();
    }

}
