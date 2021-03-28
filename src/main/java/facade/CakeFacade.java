package facade;

import decoratorclasses.CakeDecorator;
import entities.*;
import interfaces.Order;
import repositoryimpl.CakeRepositoryImpl;

import java.util.UUID;

public class CakeFacade {

    private Cake cake;
    private CakeRepositoryImpl cakeRepository;
    private Order cakeDecorator;

    public CakeFacade(Cake cake, CakeRepositoryImpl cakeRepository) {
        this.cake = cake;
        this.cakeRepository = cakeRepository;
        cakeDecorator = new CakeDecorator(cake);
    }
    public Object getCakeById(UUID uuid)
    {
        return cakeRepository.getCakeById(uuid);
    }
    public void addCake()
    {
        cakeRepository.addCake(cake);
    }
    public void deleteCake()
    {
        cakeRepository.removeCake(cake);
    }
    public void updateCake()
    {
        cakeRepository.updateCake(cake);
    }
    public String getCakeName()
    {
        return cake.getName();
    }
    public void setCakeName(String name)
    {
        cake.setName(name);
    }
    public Customer getCakeCustomer()
    {
        return cake.getCustomer();
    }
    public void setCakeCustomer(Customer customer)
    {
        cake.setCustomer(customer);
    }
    public Base getCakeBase()
    {
        return cake.getBase();
    }
    public void setCakeBase(Base base)
    {
        cake.setBase(base);
    }
    public Float getCakePrice()
    {
        return cake.getPrice();
    }
    public void setCakePrice(Float price)
    {
        cake.setPrice(price);
    }
    public void addDecoration(Decoration decoration)
    {
        cakeDecorator.addDecoration(decoration);
    }
    public void deleteDecoration(Decoration decoration)
    {
        cakeDecorator.deleteDecoration(decoration);
    }
    public void addCharacteristic(Characteristic characteristic)
    {
        cakeDecorator.deleteCharacteristic(characteristic);
    }
    public void deleteCharacteristic(Characteristic characteristic)
    {
        cakeDecorator.deleteCharacteristic(characteristic);
    }
}
