package it.valeriovaudi.emarket.endpoint.restfull;

import it.valeriovaudi.emarket.model.Account;
import it.valeriovaudi.emarket.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mrflick72 on 03/05/17.
 */

@RestController
@RequestMapping("/account")
public class AccountRestFullEndPoint {

    private final AccountService accountService;

    public AccountRestFullEndPoint(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody Account account){
        return null;
    }

    @GetMapping
    public ResponseEntity findAccountList(){
        return null;
    }

    @GetMapping("/{userName}")
    public ResponseEntity findAccount(@PathVariable String userName){
        return null;
    }

    @PutMapping("/{userName}")
    public ResponseEntity updateAccount(@PathVariable String userName, @RequestBody Account account){
        return null;
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity deleteAccount(@PathVariable String userName){
        return null;
    }

}
