/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Dao.CarDao;
import Entities.Car;
import Entities.Clientes;
import Utilities.SessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author kasia
 */
public class CarDaoImpl implements CarDao {
    SessionFactory sessionFactory; 
    Transaction t=null;   
    Session session;   


    @Override
    public ArrayList<Car> showAll() {
        ArrayList<Car>cars=new ArrayList<Car>();
        
        try{
            session = SessionFactoryUtil.getSessionFactory().openSession();
            t =session.beginTransaction();
            Query query=session.createQuery("from Car");
            cars=(ArrayList<Car>) query.list();
            
        }
        catch(HibernateException h){
            System.out.println(h.getStackTrace());
        }
        return cars;
        
    }

    @Override
    public ArrayList<Car> showAllClientsCars(Clientes c) {
        ArrayList<Car>cars=new ArrayList<Car>();
        
        try{
            session = SessionFactoryUtil.getSessionFactory().openSession();
            t =session.beginTransaction();
            Query query = session.createQuery("from Car where idclientes = :code ");
            query.setParameter("code", c.getIdclientes());
            cars=(ArrayList<Car>) query.list();
            
        }
        catch(HibernateException h){
            System.out.println(h.getStackTrace());
        }
        return cars;
    }

    @Override
    public void rent1(Integer idCliente, Integer idCar) {
        try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Clientes c=(Clientes) session.get(Clientes.class, idCliente);
                Car car= (Car) session.get(Car.class, idCar);
                car.setClientes(c);
                session.update(car);
                t.commit();
             }
           catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
           finally{
                session.close();

        }
    }
    @Override
    public void rent(Integer idCliente, Set cars) {
        try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Clientes c=(Clientes) session.get(Clientes.class, idCliente);
                
                session.update(c);
                t.commit();
             }
           catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
           finally{
                session.close();
                sessionFactory.close(); 

        }
    }

    @Override
    public void returnCar(Integer idCliente, Integer idCar) {
        try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Clientes c=(Clientes) session.get(Clientes.class, idCliente);
                Car car= (Car) session.get(Car.class, idCar);
                car.setClientes(null);
                session.update(car);
                t.commit();
             }
           catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
           finally{
                session.close();
                //sessionFactory.close(); 

        }
    }
    
}
