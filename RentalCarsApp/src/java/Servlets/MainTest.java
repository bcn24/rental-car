/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DaoImpl.CarDaoImpl;
import DaoImpl.ClientesDaoImpl;
import Entities.Car;
import Entities.Clientes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import static oracle.jrockit.jfr.events.Bits.charValue;

/**
 *
 * @author kasia
 */
public class MainTest {
    
    public static void main(String[] args) {
        
//        Clientes c = (Clientes) request.getSession().getAttribute("clientAccount");
//              //Integer idCar=Integer.parseInt(request.getParameter("idCar"));
//              Set cars=new HashSet(0);
//              String[] idCars=request.getParameterValues("idCar"); 
//              for(String i:idCars){
//                  Car car=new Car();
//                  car.setIdcar(Integer.parseInt(i));
//                  cars.add(car);
//              }

              
              CarDaoImpl cdi=new CarDaoImpl();
             // cdi.rent(c.getIdclientes(), cars);
        
//        ClientesDaoImpl cdi=new ClientesDaoImpl();
//        
//        
//        //cdi.update(1, "kasia", "ania", "email", "passss2");
//        cdi.delete(38);
//        System.out.print("d");
        
        
        //cdi.update(c, c. getEmail());
//        CarDaoImpl cdi=new CarDaoImpl();
//        ArrayList<Car>cars=cdi.showAll();
//        for(Car c:cars){
//            if(c.getClientes()==null ){
//            System.out.println(c.getMarca()+" "+c.getSeria()+ " "+ c.getClientes());
//            }
//        }
        
//        String email="emaiel";
//        String pass="p";
//        String res="";
//        ClientesDaoImpl cdi=new ClientesDaoImpl();
//        
//        if(!email.isEmpty()&&cdi.checkPasswordFormat(pass)){
//            if(cdi.checkIfLoginInDB(email)){
////                if(cdi.checkIfPasswordMatching(email, pass)){
////                    res=email;
////                   // request.setAttribute("name", res);
////                  //  request.getRequestDispatcher("/rental.jsp").forward(request, response);
////                }
////                else{
////                    res="Please check the password";
////                }
//            }
//            else{
//                res="email not registered";
//            }
//        }
//        else{
//            res="Please provide a valid login and password";
//        }
//        
//            
//        System.out.println(res);
//         ClientesDaoImpl cdi=new ClientesDaoImpl();
//        System.out.println(cdi.checkIfLoginInDB("emailbb")  );
        
        
//        ClientesDaoImpl cdi=new ClientesDaoImpl();
//        System.out.println(cdi.checkPasswordFormat("h1@a5466") );
        
        
//        ClientesDaoImpl cdi=new ClientesDaoImpl();
//        System.out.println(cdi.checkLoginFormat("h1@a") );
    
//        ClientesDaoImpl cdi=new ClientesDaoImpl();
//        //ArrayList<Clientes>li=cdi.clientesAll();
//        ArrayList<Clientes>li=cdi.showDetailsCliente("Bra");
//        for(Clientes a:li){
//             System.out.println(a.getName()+" "+a.getSurname() );
//        }
//        }
        
        
//         try{
//            ClientesDaoImpl cdi = new ClientesDaoImpl();
//            Clientes c1=new Clientes("kasia", "ania", "email", "pass");
//            cdi.create(c1);
//            System.out.println(c1.getPassword());
//         }
//         catch(Exception e){
//            System.out.println("Extecption: "+e.getMessage());
//        }
    }
}

