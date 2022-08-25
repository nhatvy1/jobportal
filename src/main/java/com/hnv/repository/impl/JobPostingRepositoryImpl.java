package com.hnv.repository.impl;

import com.hnv.pojo.JobPosting;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hnv.repository.JobPostingRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

@Repository
@Transactional
public class JobPostingRepositoryImpl implements JobPostingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Long countPosting() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> q = builder.createQuery(Long.class);
        Root root = q.from(JobPosting.class);
        q.select(builder.count(root.get("id")));

        Query query = session.createQuery(q);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<JobPosting> getJobPosting(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<JobPosting> q = builder.createQuery(JobPosting.class);
        Root root = q.from(JobPosting.class);
        q.select(root);

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addPosting(JobPosting jobPosting) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(jobPosting);
            return true;
        } catch (Exception e) {
            System.err.println("add job posting " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
}
