/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.mendrika.tpcustomermendrika.service;

import fr.mendrika.tpcustomermendrika.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Mendrika Fitahiana
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
