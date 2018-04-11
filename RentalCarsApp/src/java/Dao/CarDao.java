/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Car;
import Entities.Clientes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kasia
 */
public interface CarDao {
    public void rent(Integer idCliente, Set cars);
    public void rent1(Integer idCliente, Integer idCar);
    public void returnCar(Integer idCliente, Integer idCar);
    public ArrayList<Car> showAllClientsCars(Clientes c);
    public ArrayList<Car> showAll();
}
