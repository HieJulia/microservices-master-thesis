package it.valeriovaudi.emarket.factory;

import it.valeriovaudi.emarket.model.Account;
import it.valeriovaudi.emarket.model.Addrees;
import it.valeriovaudi.emarket.model.TelephoneNumber;

import java.util.Date;

/**
 * Created by mrflick72 on 03/05/17.
 */

//@Configurable
public class AccountBuilder {

    private Account account;

    private  AccountBuilder(){}

    private void setAccount(Account account) {
        this.account = account;
    }

    public static AccountBuilder newAccountBuilder(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setAccount(new Account());
        return accountBuilder;
    }

    public AccountBuilder userName(String userName){
        this.account.setUserName(userName);
        return this;
    }
    
    public AccountBuilder password(String password){
        this.account.setPassword(password);
        return this;
    }
    
    public AccountBuilder mail(String mail){
        this.account.setMail(mail);
        return this;
    }
    
    public AccountBuilder role(String role){
        this.account.setRole(role);
        return this;
    }
    
    public AccountBuilder taxCode(String taxCode){
        this.account.setTaxCode(taxCode);
        return this;
    }
    
    public AccountBuilder firsrtName(String firsrtName){
        this.account.setFirsrtName(firsrtName);
        return this;
    }
    
    public AccountBuilder lastName(String lastName){
        this.account.setLastName(lastName);
        return this;
    }
    
    public AccountBuilder birthDate(Date birthDate){
        this.account.setBirthDate(birthDate);
        return this;
    }

    public AccountBuilder withAddrees(String street, String streenNumber, String zip, String country, String region, String city){
        Addrees addrees = new Addrees();
        addrees.setStreet(street);
        addrees.setStreenNumber(streenNumber);
        addrees.setZip(zip);
        addrees.setCountry(country);
        addrees.setRegion(region);
        addrees.setCity(city);
        this.account.setAddrees(addrees);
        return this;
    }

    public AccountBuilder withTelephoneNumber(String countryPrefix, String prefix, String telephone){
        TelephoneNumber telephoneNumber = new TelephoneNumber();
        telephoneNumber.setCountryPrefix(countryPrefix);
        telephoneNumber.setPrefix(prefix);
        telephoneNumber.setTelephone(telephone);

        this.account.setTelephoneNumber(telephoneNumber);
        return this;
    }

    public Account build(){
        return this.account;
    }
}