package Entities;
// Generated Mar 27, 2018 8:11:30 AM by Hibernate Tools 4.3.1



/**
 * Car generated by hbm2java
 */
public class Car  implements java.io.Serializable {


     private Integer idcar;
     private Clientes clientes;
     private String marca;
     private String seria;
     private int priceDay;
     private int maxPpl;

    public Car() {
    }

	
    public Car(String marca, String seria, int priceDay, int maxPpl) {
        this.marca = marca;
        this.seria = seria;
        this.priceDay = priceDay;
        this.maxPpl = maxPpl;
    }
    public Car(Clientes clientes, String marca, String seria, int priceDay, int maxPpl) {
       this.clientes = clientes;
       this.marca = marca;
       this.seria = seria;
       this.priceDay = priceDay;
       this.maxPpl = maxPpl;
    }
   
    public Integer getIdcar() {
        return this.idcar;
    }
    
    public void setIdcar(Integer idcar) {
        this.idcar = idcar;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getSeria() {
        return this.seria;
    }
    
    public void setSeria(String seria) {
        this.seria = seria;
    }
    public int getPriceDay() {
        return this.priceDay;
    }
    
    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }
    public int getMaxPpl() {
        return this.maxPpl;
    }
    
    public void setMaxPpl(int maxPpl) {
        this.maxPpl = maxPpl;
    }




}

