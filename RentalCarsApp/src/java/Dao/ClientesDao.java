/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Clientes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kasia
 */
public interface ClientesDao {
    public void create(Clientes c);
    public void update(Integer id, String name, String surname, String email, String password);
    public void delete(Integer id);
    public void showDetails(Clientes c);
    public ArrayList<Clientes>clientesAll();
    public ArrayList<Clientes> showDetailsCliente(String name);
    public boolean checkLoginFormat(String login);
    public boolean checkPasswordFormat(String password);
    public boolean checkIfLoginInDB(String login);
    public Clientes checkIfPasswordMatching(String login, String password);
}
