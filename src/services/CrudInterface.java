/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUtilisateur.services;

import java.util.List;

/**
 *
 * @author ghanm
 */
public interface CrudInterface <T>{
    public void create(T entity);
    public void update(T entity);
    public void delete(int id);
    public T getById(int id);
    public List<T> getAll();
}
