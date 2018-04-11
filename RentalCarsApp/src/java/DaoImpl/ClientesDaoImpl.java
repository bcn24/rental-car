/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Dao.ClientesDao;
import Entities.Clientes;
import Utilities.SessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author kasia
 */
public class ClientesDaoImpl implements ClientesDao {

    SessionFactory sessionFactory; 
    Transaction t=null;   
    Session session;   
   
    
    @Override
    public void create(Clientes c) {
           try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                session.persist(c);
                t.commit();
             }
           catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
           finally{
                //session.close();
                //sessionFactory.close(); 

        }
}
    
    
    @Override
    public void update(Integer id, String name, String surname, String email, String password) {
         try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Clientes c=(Clientes) session.get(Clientes.class, id);
                c.setName(name);
                c.setSurname(surname);
                c.setEmail(email);
                c.setPassword(password);
                session.update(c);
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

    @Override
    public void delete(Integer id) {
        try{

                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                Clientes c=(Clientes) session.get(Clientes.class, id);
                session.delete(c);
                t.commit();
             }
           catch(HibernateException e){
                System.out.println(e.getMessage());
                e.getStackTrace();
            }
           finally{
                session.close();
       }
    }

    @Override
    public void showDetails(Clientes c) {
       //String[]details =c.getName(),c.g ;
        //return a;
    }

    @Override
    public ArrayList<Clientes> clientesAll() {
          List<Clientes>list = null;  
        try{
                
                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                Query query = session.createQuery("from Clientes");
                list= query.list();
//                Query consulta = session.createQuery("from Clientes where email = :code ");
//                consulta.setParameter("code", "1");
//                list= consulta.list();
             }
        catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
        finally{
                session.close();
               // sessionFactory.close(); 

       }
        return (ArrayList<Clientes>)list;
    
    }

    @Override
    public ArrayList<Clientes> showDetailsCliente(String name) {
         List<Clientes>list = null;
         try{
               
                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Query consulta = session.createQuery("from Clientes where name = :code ");
                consulta.setParameter("code", name);
                list= consulta.list();

//                Query consulta = session.createQuery("from Clientes where idClientes = :code ");
//                consulta.setParameter("code", "1");
//                list= consulta.list();
             }
        catch(HibernateException e){
                System.out.println(e.getStackTrace());
                t.rollback();
            }
        finally{
                session.close();
               // sessionFactory.close(); 

       }
         return (ArrayList<Clientes>) list;
    }

    @Override
    public boolean checkLoginFormat(String login) {
        boolean b = false;
        if(login.length()>5&&login.contains("@")){
            for(int i=0; i<login.length();i++){
                if(login.charAt(i)>='a'&&login.charAt(i)<='z'
                        ||login.charAt(i)>='A'&&login.charAt(i)<='Z'
                        ||login.charAt(i)>='0'&&login.charAt(i)<='9'){
                    b=true;
                }
            }
        }
        return b;
    }

    @Override
    public boolean checkPasswordFormat(String password) {
        boolean b = false;
        if(password.length()>=5){
                for(int i=0; i<password.length();i++){
                if(password.charAt(i)>='a'&&password.charAt(i)<='z'
                        ||password.charAt(i)>='A'&&password.charAt(i)<='Z'
                        ||password.charAt(i)>='0'&&password.charAt(i)<='9'){
                             b=true;
                        }
                    } 
                }
        return b;
    }
    
    @Override
    public boolean checkIfLoginInDB(String login) {
                List<Clientes>list = null;
                boolean b=false;
        
                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Query consulta = session.createQuery("from Clientes where email = :code ");
                consulta.setParameter("code", login);
                list= consulta.list();
                if(!list.isEmpty()){
                    b=true;
                }
        return b;
    }

    @Override
    public Clientes checkIfPasswordMatching(String login, String password) {
        
        List<Clientes>list = null;
                boolean b=false;
        
                session = SessionFactoryUtil.getSessionFactory().openSession(); 
                t =session.beginTransaction();
                
                Query consulta = session.createQuery("from Clientes where email = :code ");
                consulta.setParameter("code", login);
                list= consulta.list();
                for(Clientes c:list){
                    if(password.equals(c.getPassword())){
                        return c;
                    }
                }
        return null;
   }
    
}
